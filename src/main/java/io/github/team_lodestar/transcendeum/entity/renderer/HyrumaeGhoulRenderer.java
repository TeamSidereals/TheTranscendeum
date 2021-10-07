package io.github.team_lodestar.transcendeum.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
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

import io.github.team_lodestar.transcendeum.entity.HyrumaeGhoulEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class HyrumaeGhoulRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(HyrumaeGhoulEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelhyrumae_ghoul(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						HyrumaeGhoulEntity.CustomEntity _ghoul = (HyrumaeGhoulEntity.CustomEntity) entity;
						return new ResourceLocation("the_transcendeum:textures/hyrumae_ghoul_" + String.valueOf(_ghoul.getVariant()) + ".png");
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
			IVertexBuilder ivertexbuilder = bufferIn
					.getBuffer(RenderType.getEyes(new ResourceLocation("the_transcendeum:textures/hyrumae_ghoul_glow.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.9.3
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelhyrumae_ghoul extends EntityModel<Entity> {
		private final ModelRenderer Head;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer Body;
		private final ModelRenderer RightArm;
		private final ModelRenderer LeftArm;
		private final ModelRenderer RightLeg;
		private final ModelRenderer LeftLeg;
		public Modelhyrumae_ghoul() {
			textureWidth = 80;
			textureHeight = 80;
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 0.0F, -1.0F);
			Head.setTextureOffset(0, 16).addBox(-4.0F, -5.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			Head.setTextureOffset(0, 0).addBox(-4.0F, -5.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			Head.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0873F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(11, 21).addBox(-0.5F, -6.0F, -6.0F, 1.0F, 1.0F, 9.0F, 0.0F, true);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
			Head.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.088F, -0.1304F, -0.0115F);
			cube_r2.setTextureOffset(11, 21).addBox(-3.0F, -6.0F, -6.0F, 1.0F, 1.0F, 9.0F, 0.0F, true);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
			Head.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.088F, 0.1304F, 0.0115F);
			cube_r3.setTextureOffset(11, 21).addBox(2.0F, -6.0F, -6.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 0.0F, 0.0F);
			Body.setTextureOffset(0, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
			Body.setTextureOffset(28, 28).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.25F, false);
			RightArm = new ModelRenderer(this);
			RightArm.setRotationPoint(-4.0F, 2.0F, 0.0F);
			setRotationAngle(RightArm, -1.5708F, 0.1745F, 0.0F);
			RightArm.setTextureOffset(56, 0).addBox(-3.9848F, -1.8264F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
			RightArm.setTextureOffset(52, 44).addBox(-3.9848F, -1.8264F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);
			LeftArm = new ModelRenderer(this);
			LeftArm.setRotationPoint(4.0F, 2.0F, 0.0F);
			setRotationAngle(LeftArm, -1.5708F, -0.1745F, 0.0F);
			LeftArm.setTextureOffset(52, 28).addBox(-0.0152F, -1.8264F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			LeftArm.setTextureOffset(0, 48).addBox(-0.0152F, -1.8264F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);
			RightLeg = new ModelRenderer(this);
			RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
			RightLeg.setTextureOffset(36, 44).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			RightLeg.setTextureOffset(20, 44).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);
			LeftLeg = new ModelRenderer(this);
			LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
			LeftLeg.setTextureOffset(44, 12).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			LeftLeg.setTextureOffset(32, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
			Body.render(matrixStack, buffer, packedLight, packedOverlay);
			RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
			LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
			RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			float a = this.swingProgress;
			float PI = (float) Math.PI;
			a = 1 - a;
			a = a * a;
			a = a * a;
			if (this.swingProgress > 0) {
				this.RightArm.rotateAngleX = -PI / 2 - MathHelper.sin(a * PI);
				this.LeftArm.rotateAngleX = -PI / 2 - MathHelper.sin(a * PI);
			}
			this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
