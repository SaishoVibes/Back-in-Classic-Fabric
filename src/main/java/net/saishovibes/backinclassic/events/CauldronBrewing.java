package net.saishovibes.backinclassic.events;

import net.minecraft.block.Blocks;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.saishovibes.backinclassic.blocks.PotionCauldronBlock;

public class CauldronBrewing {
    public static ActionResult interact(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult) {
        if (hand == Hand.MAIN_HAND && hitResult.getType() == HitResult.Type.BLOCK) {
            var blockPos = hitResult.getBlockPos();
            var state = world.getBlockState(blockPos);
            var block = state.getBlock();
            var itemStack = player.getMainHandStack();
            var item = itemStack.getItem();
            if (item == Items.GLASS_BOTTLE) {
                if (block instanceof PotionCauldronBlock cauldron) {
                    world.setBlockState(blockPos, Blocks.CAULDRON.getDefaultState());
                    if (!player.isCreative()) {
                        itemStack.decrement(1);
                    }
                    world.playSound(null, blockPos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 1.0f);
                    world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                    var awkwardPotion = new ItemStack(Items.POTION);
                    PotionUtil.setPotion(awkwardPotion, cauldron.potion);
                    var itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                    itemEntity.setToDefaultPickupDelay();
                    world.spawnEntity(itemEntity);
                    return ActionResult.SUCCESS;
                }
            }
            if (BrewingRecipeRegistry.isValidIngredient(itemStack)) {
                var input = block instanceof PotionCauldronBlock cauldron ? cauldron.potion : (block == Blocks.WATER_CAULDRON && state.get(LeveledCauldronBlock.LEVEL) == 3 ? Potions.WATER : Potions.EMPTY);
                for (var recipe : BrewingRecipeRegistry.POTION_RECIPES) {
                    if (recipe.input == input && recipe.ingredient.test(itemStack)) {
                        if (PotionCauldronBlock.CAULDRONS.containsKey(recipe.output)) {
                            world.setBlockState(blockPos, PotionCauldronBlock.CAULDRONS.get(recipe.output).getDefaultState());
                            if (!player.isCreative()) {
                                itemStack.decrement(1);
                            }
                            world.playSound(null, blockPos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 1.0f);
                            world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                            if (world instanceof ServerWorld serverWorld) {
                                serverWorld.spawnParticles(ParticleTypes.ENCHANT, blockPos.getX() + 0.5, blockPos.getY() + 0.5, blockPos.getZ() + 0.5, 50, 0.5, 0.5, 0.5, 0.1);
                            }
                            return ActionResult.SUCCESS;
                        }
                    }
                }
            }
        }
        return ActionResult.PASS;
    }
}