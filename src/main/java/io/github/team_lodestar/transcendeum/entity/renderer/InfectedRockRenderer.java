package io.github.team_lodestar.transcendeum.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.Minecraft;

import io.github.team_lodestar.transcendeum.entity.InfectedRockEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class InfectedRockRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(InfectedRockEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelinfested_rock(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("the_transcendeum:textures/infectedrock2.png");
					}
				};
			});
			RenderingRegistry.registerEntityRenderingHandler(InfectedRockEntity.arrow,
					renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));
		}
	}

	// Made with Blockbench 4.1.4
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelinfested_rock extends EntityModel<Entity> {
		private final ModelRenderer bb_main;

		public Modelinfested_rock() {
			textureWidth = 64;
			textureHeight = 64;
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.setTextureOffset(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, 0.0F, false);
			bb_main.setTextureOffset(18, 18).addBox(-7.0F, -5.0F, -3.0F, 3.0F, 5.0F, 4.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 18).addBox(4.0F, -6.0F, -2.0F, 4.0F, 6.0F, 5.0F, 0.0F, false);
			bb_main.setTextureOffset(16, 27).addBox(-1.0F, -3.0F, -6.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
			bb_main.setTextureOffset(24, 0).addBox(-2.0F, -3.0F, 4.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}

}
