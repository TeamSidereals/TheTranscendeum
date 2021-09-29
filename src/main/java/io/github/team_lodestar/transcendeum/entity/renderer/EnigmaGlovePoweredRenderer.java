package io.github.team_lodestar.transcendeum.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import io.github.team_lodestar.transcendeum.item.EnigmaGlovePoweredItem;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class EnigmaGlovePoweredRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(EnigmaGlovePoweredItem.arrow, renderManager -> new CustomRender(renderManager));
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class CustomRender extends EntityRenderer<EnigmaGlovePoweredItem.ArrowCustomEntity> {
		private static final ResourceLocation texture = new ResourceLocation("the_transcendeum:textures/enigma_bullet_entity_powered.png");
		public CustomRender(EntityRendererManager renderManager) {
			super(renderManager);
		}

		@Override
		public void render(EnigmaGlovePoweredItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
				IRenderTypeBuffer bufferIn, int packedLightIn) {
			IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
			matrixStackIn.push();
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
			matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
			EntityModel model = new Modelenigma_bullet_entity();
			model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
			matrixStackIn.pop();
			super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		}

		@Override
		public ResourceLocation getEntityTexture(EnigmaGlovePoweredItem.ArrowCustomEntity entity) {
			return texture;
		}
	}

	// Made with Blockbench 3.9.3
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelenigma_bullet_entity extends EntityModel<Entity> {
		private final ModelRenderer arrow;
		public Modelenigma_bullet_entity() {
			textureWidth = 64;
			textureHeight = 64;
			arrow = new ModelRenderer(this);
			arrow.setRotationPoint(2.5F, 16.0F, 0.0F);
			setRotationAngle(arrow, 0.0F, 0.0F, 1.5708F);
			arrow.setTextureOffset(0, 15).addBox(-8.0F, 0.0F, -2.5F, 16.0F, 5.0F, 0.0F, 0.0F, false);
			arrow.setTextureOffset(0, 10).addBox(-8.0F, 0.0F, 2.5F, 16.0F, 5.0F, 0.0F, 0.0F, false);
			arrow.setTextureOffset(0, 20).addBox(-8.0F, 0.0F, -2.5F, 3.0F, 5.0F, 5.0F, 0.0F, false);
			arrow.setTextureOffset(0, 5).addBox(-8.0F, 0.0F, -2.5F, 16.0F, 0.0F, 5.0F, 0.0F, false);
			arrow.setTextureOffset(0, 0).addBox(-8.0F, 5.0F, -2.5F, 16.0F, 0.0F, 5.0F, 0.0F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			arrow.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
