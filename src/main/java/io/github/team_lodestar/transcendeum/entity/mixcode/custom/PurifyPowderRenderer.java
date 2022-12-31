package io.github.team_lodestar.transcendeum.entity.mixcode.custom;

import io.github.team_lodestar.transcendeum.entity.mixcode.MixCodeEntityType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class PurifyPowderRenderer {
    public static void registerEntityRenders(){
        ItemRenderer renderer = Minecraft.getInstance().getItemRenderer();

        RenderingRegistry.registerEntityRenderingHandler(MixCodeEntityType.PURIFY_POWDER_PROJECTILE.get(), (rendererManager) ->
                new SpriteRenderer<>(rendererManager, renderer));
    }
}
