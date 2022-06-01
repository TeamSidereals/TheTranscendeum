
package io.github.team_lodestar.transcendeum.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import io.github.team_lodestar.transcendeum.entity.EllumEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class EllumRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(EllumEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelellum(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("the_transcendeum:textures/ellum.png");
					}
				};
			});
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing,
				float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEyes(new ResourceLocation("the_transcendeum:textures/ellum_glow.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 4.0.1
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelellum extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer flower;
		private final ModelRenderer head_r1;
		private final ModelRenderer head_r2;
		private final ModelRenderer head_r3;
		private final ModelRenderer head_r4;
		private final ModelRenderer head_r5;
		private final ModelRenderer head_r6;
		private final ModelRenderer tentacle1;
		private final ModelRenderer tentacle2;
		private final ModelRenderer tentacle3;
		private final ModelRenderer tentacle4;
		private final ModelRenderer tentacle5;
		private final ModelRenderer tentacle6;

		public Modelellum() {
			textureWidth = 64;
			textureHeight = 64;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 24.0F, 0.0F);
			head.setTextureOffset(0, 19).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			flower = new ModelRenderer(this);
			flower.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.addChild(flower);
			flower.setTextureOffset(0, 0).addBox(-5.0F, -9.0F, 3.0F, 10.0F, 10.0F, 4.0F, 0.0F, false);
			head_r1 = new ModelRenderer(this);
			head_r1.setRotationPoint(0.0F, -4.0F, 0.0F);
			flower.addChild(head_r1);
			setRotationAngle(head_r1, 0.0F, 0.0F, -0.7854F);
			head_r1.setTextureOffset(24, 23).addBox(-3.0F, 12.0F, 4.0F, 6.0F, 2.0F, 2.0F, 0.0F, false);
			head_r1.setTextureOffset(28, 0).addBox(-4.0F, 1.0F, 4.0F, 8.0F, 11.0F, 2.0F, 0.0F, false);
			head_r1.setTextureOffset(28, 0).addBox(-4.0F, -12.0F, 4.0F, 8.0F, 11.0F, 2.0F, 0.0F, false);
			head_r1.setTextureOffset(24, 23).addBox(-3.0F, -14.0F, 4.0F, 6.0F, 2.0F, 2.0F, 0.0F, false);
			head_r2 = new ModelRenderer(this);
			head_r2.setRotationPoint(0.0F, -4.0F, 0.0F);
			flower.addChild(head_r2);
			setRotationAngle(head_r2, 0.0F, 0.0F, 0.7854F);
			head_r2.setTextureOffset(28, 0).addBox(-4.0F, 1.0F, 4.0F, 8.0F, 11.0F, 2.0F, 0.0F, false);
			head_r2.setTextureOffset(24, 23).addBox(-3.0F, 12.0F, 4.0F, 6.0F, 2.0F, 2.0F, 0.0F, false);
			head_r2.setTextureOffset(24, 23).addBox(-3.0F, -14.0F, 4.0F, 6.0F, 2.0F, 2.0F, 0.0F, false);
			head_r2.setTextureOffset(28, 0).addBox(-4.0F, -12.0F, 4.0F, 8.0F, 11.0F, 2.0F, 0.0F, false);
			head_r3 = new ModelRenderer(this);
			head_r3.setRotationPoint(0.0F, -4.0F, 0.0F);
			flower.addChild(head_r3);
			setRotationAngle(head_r3, 0.4363F, 0.0F, -1.5708F);
			head_r3.setTextureOffset(30, 13).addBox(-4.0F, -11.5774F, 5.9063F, 8.0F, 10.0F, 0.0F, 0.0F, false);
			head_r4 = new ModelRenderer(this);
			head_r4.setRotationPoint(0.0F, 4.0F, 0.0F);
			flower.addChild(head_r4);
			setRotationAngle(head_r4, 0.4363F, 0.0F, 1.5708F);
			head_r4.setTextureOffset(30, 13).addBox(-12.0F, -11.5774F, 4.9063F, 8.0F, 10.0F, 0.0F, 0.0F, false);
			head_r5 = new ModelRenderer(this);
			head_r5.setRotationPoint(0.0F, 4.0F, 0.0F);
			flower.addChild(head_r5);
			setRotationAngle(head_r5, 0.4363F, 0.0F, -3.1416F);
			head_r5.setTextureOffset(30, 13).addBox(-4.0F, -5.0F, 2.0F, 8.0F, 10.0F, 0.0F, 0.0F, false);
			head_r6 = new ModelRenderer(this);
			head_r6.setRotationPoint(0.0F, -4.0F, 0.0F);
			flower.addChild(head_r6);
			setRotationAngle(head_r6, 0.4363F, 0.0F, 0.0F);
			head_r6.setTextureOffset(30, 13).addBox(-4.0F, -12.0F, 5.0F, 8.0F, 10.0F, 0.0F, 0.0F, false);
			tentacle1 = new ModelRenderer(this);
			tentacle1.setRotationPoint(4.0F, 18.0F, 7.0F);
			tentacle1.setTextureOffset(0, 0).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 15.0F, 0.0F, false);
			tentacle2 = new ModelRenderer(this);
			tentacle2.setRotationPoint(3.0F, 22.0F, 7.0F);
			tentacle2.setTextureOffset(0, 0).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 15.0F, 0.0F, false);
			tentacle3 = new ModelRenderer(this);
			tentacle3.setRotationPoint(1.0F, 20.0F, 7.0F);
			tentacle3.setTextureOffset(0, 0).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 15.0F, 0.0F, false);
			tentacle4 = new ModelRenderer(this);
			tentacle4.setRotationPoint(-1.0F, 17.0F, 7.0F);
			tentacle4.setTextureOffset(0, 0).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 15.0F, 0.0F, false);
			tentacle5 = new ModelRenderer(this);
			tentacle5.setRotationPoint(-2.0F, 22.0F, 7.0F);
			tentacle5.setTextureOffset(0, 0).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 15.0F, 0.0F, false);
			tentacle6 = new ModelRenderer(this);
			tentacle6.setRotationPoint(-4.0F, 20.0F, 7.0F);
			tentacle6.setTextureOffset(0, 0).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 15.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle1.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle2.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle3.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle4.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle5.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle6.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.tentacle1.rotateAngleZ = f3 / (180F / (float) Math.PI);
			this.tentacle6.rotateAngleZ = f4 / (180F / (float) Math.PI);
			this.tentacle4.rotateAngleZ = f4 / (180F / (float) Math.PI);
			this.tentacle5.rotateAngleZ = f3 / (180F / (float) Math.PI);
			this.tentacle2.rotateAngleZ = f4 / (180F / (float) Math.PI);
			this.tentacle3.rotateAngleZ = f3 / (180F / (float) Math.PI);
		}
	}

}
