package net.saishovibes.back_in_classic;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.saishovibes.back_in_classic.registry.back_in_classic_blocks;
import net.saishovibes.back_in_classic.registry.back_in_classic_items;

public class Back_In_Classic_Client implements ClientModInitializer {
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(back_in_classic_blocks.BLUE_ROSE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(back_in_classic_blocks.RED_ROSE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(back_in_classic_blocks.PAEONIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(back_in_classic_blocks.SHRUB, RenderLayer.getCutout());
    }
}
