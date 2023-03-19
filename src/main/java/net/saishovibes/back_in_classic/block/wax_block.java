package net.saishovibes.back_in_classic.block;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

/*public class wax_block extends Block {
    public wax_block(Settings settings) {
        super(settings);
    }
}*/
public class wax_block implements ModInitializer {

    /* Declare and initialize our custom block instance.
       We set our block material to `METAL`.

       `strength` sets both the hardness and the resistance of a block to the same value.
       Hardness determines how long the block takes to break, and resistance determines how strong the block is against blast damage (e.g. explosions).
       Stone has a hardness of 1.5f and a resistance of 6.0f, while Obsidian has a hardness of 50.0f and a resistance of 1200.0f.

       You can find the stats of all vanilla blocks in the class `Blocks`, where you can also reference other blocks.
    */
    public static final Block WAX_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));

    @Override
    public void onInitialize() {

    }
}