package net.saishovibes.back_in_classic.events;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.CauldronBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.saishovibes.back_in_classic.registry.back_in_classic_blocks;
public class cauldron_brewing {
    private static final Item MY_CUSTOM_ITEM = Items.NETHER_WART;

    public static void initialize() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (hitResult.getType() == HitResult.Type.BLOCK) {
                BlockPos pos = ((BlockHitResult) hitResult).getBlockPos(); // cast HitResult to BlockHitResult to get the block position
                BlockState state = world.getBlockState(pos);
                ItemStack item = player.getStackInHand(hand);

                // Check if the clicked block is a cauldron and the player is holding the custom item
                if (state.getBlock() instanceof CauldronBlock && item.getItem() == MY_CUSTOM_ITEM) {
                    // Replace the cauldron with your custom block
                    world.setBlockState(pos, back_in_classic_blocks.AWKWARD_CAULDRON.getDefaultState(), 3); // 3 is a flag for triggering block update

                    // Consume the item used to interact with the block
                    item.decrement(1);

                    // Play a sound and particles to indicate successful interaction
                    world.playSound(null, pos, SoundEvents.BLOCK_METAL_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);

                    return ActionResult.SUCCESS;
                }
            }

            return ActionResult.PASS;
        });
    }
}