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

import io.github.team_lodestar.transcendeum.entity.ErellumEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class ErellumRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(ErellumEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelerellum(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("the_transcendeum:textures/erellum.png");
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
					.getBuffer(RenderType.getEyes(new ResourceLocation("the_transcendeum:textures/erellum_glow.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 4.0.1
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelerellum extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer flower;
		private final ModelRenderer cube_r1;
		private final ModelRenderer petalgroup1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer petalgroup2;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer cube_r9;
		private final ModelRenderer leafgroup1;
		private final ModelRenderer cube_r10;
		private final ModelRenderer cube_r11;
		private final ModelRenderer cube_r12;
		private final ModelRenderer cube_r13;
		private final ModelRenderer leafgroup2;
		private final ModelRenderer cube_r14;
		private final ModelRenderer cube_r15;
		private final ModelRenderer cube_r16;
		private final ModelRenderer cube_r17;
		private final ModelRenderer armR;
		private final ModelRenderer cube_r18;
		private final ModelRenderer cube_r19;
		private final ModelRenderer cube_r20;
		private final ModelRenderer armL;
		private final ModelRenderer cube_r21;
		private final ModelRenderer cube_r22;
		private final ModelRenderer cube_r23;
		private final ModelRenderer tentacle1;
		private final ModelRenderer cube_r24;
		private final ModelRenderer tentacle2;
		private final ModelRenderer cube_r25;
		private final ModelRenderer tentacle3;
		private final ModelRenderer cube_r26;
		private final ModelRenderer tentacle4;
		private final ModelRenderer cube_r27;
		private final ModelRenderer tentacle5;
		private final ModelRenderer cube_r28;
		public Modelerellum() {
			textureWidth = 128;
			textureHeight = 128;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 24.0F, 0.0F);
			head.setTextureOffset(34, 34).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 5.0F, 10.0F, 0.0F, false);
			head.setTextureOffset(0, 15).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 5.0F, 10.0F, 0.0F, false);
			flower = new ModelRenderer(this);
			flower.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.addChild(flower);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, -10.0F, 4.0F);
			flower.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(12, 50).addBox(-5.0F, 0.0F, 1.0F, 10.0F, 10.0F, 4.0F, 0.0F, false);
			petalgroup1 = new ModelRenderer(this);
			petalgroup1.setRotationPoint(0.0F, -5.0F, 6.0F);
			flower.addChild(petalgroup1);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, -5.0F, -2.0F);
			petalgroup1.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.3927F, 0.0F, -1.5708F);
			cube_r2.setTextureOffset(40, 50).addBox(-11.0F, -20.0F, 3.0F, 12.0F, 18.0F, 0.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, 13.0F, -2.0F);
			petalgroup1.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.3927F, 0.0F, 1.5708F);
			cube_r3.setTextureOffset(40, 50).addBox(-19.0F, -20.0F, 3.0F, 12.0F, 18.0F, 0.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0F, 13.0F, -2.0F);
			petalgroup1.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.3927F, 0.0F, -3.1416F);
			cube_r4.setTextureOffset(40, 50).addBox(-6.0F, -9.0F, -2.0F, 12.0F, 18.0F, 0.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(0.0F, -8.0F, -2.0F);
			petalgroup1.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.3927F, 0.0F, 0.0F);
			cube_r5.setTextureOffset(40, 50).addBox(-6.0F, -13.2284F, -0.1481F, 12.0F, 18.0F, 0.0F, 0.0F, false);
			petalgroup2 = new ModelRenderer(this);
			petalgroup2.setRotationPoint(0.0F, -5.0F, 6.0F);
			flower.addChild(petalgroup2);
			setRotationAngle(petalgroup2, 0.0F, 0.0F, -0.7854F);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.0F, -5.0F, -2.0F);
			petalgroup2.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.3927F, 0.0F, -1.5708F);
			cube_r6.setTextureOffset(40, 50).addBox(-11.0F, -20.0F, 3.0F, 12.0F, 18.0F, 0.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(0.0F, 13.0F, -2.0F);
			petalgroup2.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.3927F, 0.0F, 1.5708F);
			cube_r7.setTextureOffset(40, 50).addBox(-19.0F, -20.0F, 3.0F, 12.0F, 18.0F, 0.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(0.0F, 13.0F, -2.0F);
			petalgroup2.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.3927F, 0.0F, -3.1416F);
			cube_r8.setTextureOffset(40, 50).addBox(-6.0F, -9.0F, -2.0F, 12.0F, 18.0F, 0.0F, 0.0F, false);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(0.0F, -8.0F, -2.0F);
			petalgroup2.addChild(cube_r9);
			setRotationAngle(cube_r9, 0.3927F, 0.0F, 0.0F);
			cube_r9.setTextureOffset(40, 50).addBox(-6.0F, -13.2284F, -0.1481F, 12.0F, 18.0F, 0.0F, 0.0F, false);
			leafgroup1 = new ModelRenderer(this);
			leafgroup1.setRotationPoint(0.0F, -6.0F, 6.0F);
			flower.addChild(leafgroup1);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(1.0F, 6.0F, -2.0F);
			leafgroup1.addChild(cube_r10);
			setRotationAngle(cube_r10, 0.2182F, 0.0F, 0.7854F);
			cube_r10.setTextureOffset(12, 41).addBox(-8.0F, 16.0F, 2.0F, 8.0F, 2.0F, 3.0F, 0.0F, false);
			cube_r10.setTextureOffset(48, 0).addBox(-9.0F, -1.0F, 2.0F, 10.0F, 17.0F, 3.0F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(-1.0F, 6.0F, -2.0F);
			leafgroup1.addChild(cube_r11);
			setRotationAngle(cube_r11, 0.2182F, 0.0F, -0.7854F);
			cube_r11.setTextureOffset(48, 0).addBox(-1.0F, -1.0F, 2.0F, 10.0F, 17.0F, 3.0F, 0.0F, true);
			cube_r11.setTextureOffset(12, 41).addBox(0.0F, 16.0F, 2.0F, 8.0F, 2.0F, 3.0F, 0.0F, true);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(-1.0F, -4.0F, -2.0F);
			leafgroup1.addChild(cube_r12);
			setRotationAngle(cube_r12, -0.2182F, 0.0F, 0.7854F);
			cube_r12.setTextureOffset(12, 41).addBox(0.0F, -18.0F, 2.0F, 8.0F, 2.0F, 3.0F, 0.0F, true);
			cube_r12.setTextureOffset(48, 0).addBox(-1.0F, -16.0F, 2.0F, 10.0F, 17.0F, 3.0F, 0.0F, true);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(1.0F, -4.0F, -2.0F);
			leafgroup1.addChild(cube_r13);
			setRotationAngle(cube_r13, -0.2182F, 0.0F, -0.7854F);
			cube_r13.setTextureOffset(12, 41).addBox(-8.0F, -18.0F, 2.0F, 8.0F, 2.0F, 3.0F, 0.0F, false);
			cube_r13.setTextureOffset(48, 0).addBox(-9.0F, -16.0F, 2.0F, 10.0F, 17.0F, 3.0F, 0.0F, false);
			leafgroup2 = new ModelRenderer(this);
			leafgroup2.setRotationPoint(0.0F, -6.0F, 6.0F);
			flower.addChild(leafgroup2);
			setRotationAngle(leafgroup2, 0.0F, 0.0F, -0.7854F);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(1.0F, 6.0F, -2.0F);
			leafgroup2.addChild(cube_r14);
			setRotationAngle(cube_r14, 0.2182F, 0.0F, 0.7854F);
			cube_r14.setTextureOffset(12, 41).addBox(-8.0F, 16.0F, 2.0F, 8.0F, 2.0F, 3.0F, 0.0F, false);
			cube_r14.setTextureOffset(48, 0).addBox(-9.0F, -1.0F, 2.0F, 10.0F, 17.0F, 3.0F, 0.0F, false);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(-1.0F, 6.0F, -2.0F);
			leafgroup2.addChild(cube_r15);
			setRotationAngle(cube_r15, 0.2182F, 0.0F, -0.7854F);
			cube_r15.setTextureOffset(48, 0).addBox(-1.0F, -1.0F, 2.0F, 10.0F, 17.0F, 3.0F, 0.0F, true);
			cube_r15.setTextureOffset(12, 41).addBox(0.0F, 16.0F, 2.0F, 8.0F, 2.0F, 3.0F, 0.0F, true);
			cube_r16 = new ModelRenderer(this);
			cube_r16.setRotationPoint(-1.0F, -4.0F, -2.0F);
			leafgroup2.addChild(cube_r16);
			setRotationAngle(cube_r16, -0.2182F, 0.0F, 0.7854F);
			cube_r16.setTextureOffset(12, 41).addBox(0.0F, -18.0F, 2.0F, 8.0F, 2.0F, 3.0F, 0.0F, true);
			cube_r16.setTextureOffset(48, 0).addBox(-1.0F, -16.0F, 2.0F, 10.0F, 17.0F, 3.0F, 0.0F, true);
			cube_r17 = new ModelRenderer(this);
			cube_r17.setRotationPoint(1.0F, -4.0F, -2.0F);
			leafgroup2.addChild(cube_r17);
			setRotationAngle(cube_r17, -0.2182F, 0.0F, -0.7854F);
			cube_r17.setTextureOffset(12, 41).addBox(-8.0F, -18.0F, 2.0F, 8.0F, 2.0F, 3.0F, 0.0F, false);
			cube_r17.setTextureOffset(48, 0).addBox(-9.0F, -16.0F, 2.0F, 10.0F, 17.0F, 3.0F, 0.0F, false);
			armR = new ModelRenderer(this);
			armR.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(armR, 0.4363F, 0.0F, -0.5236F);
			cube_r18 = new ModelRenderer(this);
			cube_r18.setRotationPoint(0.0F, 0.0F, 0.0F);
			armR.addChild(cube_r18);
			setRotationAngle(cube_r18, -2.2253F, 0.0F, 0.0F);
			cube_r18.setTextureOffset(12, 19).addBox(3.0F, 3.0F, 8.0F, 0.0F, 7.0F, 15.0F, 0.0F, false);
			cube_r19 = new ModelRenderer(this);
			cube_r19.setRotationPoint(0.0F, 0.0F, 0.0F);
			armR.addChild(cube_r19);
			setRotationAngle(cube_r19, 2.5744F, 0.0F, 0.0F);
			cube_r19.setTextureOffset(26, 16).addBox(1.0F, -10.0F, -6.0F, 4.0F, 4.0F, 14.0F, 0.0F, false);
			cube_r20 = new ModelRenderer(this);
			cube_r20.setRotationPoint(3.0F, 2.0F, 0.0F);
			armR.addChild(cube_r20);
			setRotationAngle(cube_r20, 0.6545F, 0.0F, 0.0F);
			cube_r20.setTextureOffset(58, 24).addBox(-1.0F, 4.4133F, -5.7825F, 2.0F, 2.0F, 10.0F, 0.0F, false);
			armL = new ModelRenderer(this);
			armL.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(armL, 0.4363F, 0.0F, 0.5236F);
			cube_r21 = new ModelRenderer(this);
			cube_r21.setRotationPoint(0.0F, 0.0F, 0.0F);
			armL.addChild(cube_r21);
			setRotationAngle(cube_r21, -2.2253F, 0.0F, 0.0F);
			cube_r21.setTextureOffset(12, 19).addBox(-3.5F, 3.1874F, 7.1545F, 0.0F, 7.0F, 15.0F, 0.0F, true);
			cube_r22 = new ModelRenderer(this);
			cube_r22.setRotationPoint(0.0F, 0.0F, 0.0F);
			armL.addChild(cube_r22);
			setRotationAngle(cube_r22, 2.5744F, 0.0F, 0.0F);
			cube_r22.setTextureOffset(26, 16).addBox(-5.5F, -9.1414F, -5.887F, 4.0F, 4.0F, 14.0F, 0.0F, true);
			cube_r23 = new ModelRenderer(this);
			cube_r23.setRotationPoint(-3.0F, 2.0F, 0.0F);
			armL.addChild(cube_r23);
			setRotationAngle(cube_r23, 0.6545F, 0.0F, 0.0F);
			cube_r23.setTextureOffset(58, 24).addBox(-1.5F, 4.0134F, -5.0143F, 2.0F, 2.0F, 10.0F, 0.0F, true);
			tentacle1 = new ModelRenderer(this);
			tentacle1.setRotationPoint(0.0F, 22.0F, 9.0F);
			cube_r24 = new ModelRenderer(this);
			cube_r24.setRotationPoint(0.0F, 0.0F, -1.0F);
			tentacle1.addChild(cube_r24);
			setRotationAngle(cube_r24, 0.3491F, 0.0F, 0.0F);
			cube_r24.setTextureOffset(0, 24).addBox(0.0F, -1.1385F, -2.7993F, 0.0F, 35.0F, 6.0F, 0.0F, false);
			tentacle2 = new ModelRenderer(this);
			tentacle2.setRotationPoint(-4.0F, 18.0F, 9.0F);
			cube_r25 = new ModelRenderer(this);
			cube_r25.setRotationPoint(0.0F, 0.0F, -1.0F);
			tentacle2.addChild(cube_r25);
			setRotationAngle(cube_r25, 0.3491F, 0.0F, 0.0F);
			cube_r25.setTextureOffset(0, 24).addBox(0.0F, -1.1385F, -2.7993F, 0.0F, 35.0F, 6.0F, 0.0F, false);
			tentacle3 = new ModelRenderer(this);
			tentacle3.setRotationPoint(5.0F, 14.0F, 9.0F);
			cube_r26 = new ModelRenderer(this);
			cube_r26.setRotationPoint(0.0F, 0.0F, -1.0F);
			tentacle3.addChild(cube_r26);
			setRotationAngle(cube_r26, 0.3491F, 0.0F, 0.0F);
			cube_r26.setTextureOffset(0, 24).addBox(0.0F, -1.1385F, -2.7993F, 0.0F, 35.0F, 6.0F, 0.0F, false);
			tentacle4 = new ModelRenderer(this);
			tentacle4.setRotationPoint(-2.0F, 14.0F, 9.0F);
			setRotationAngle(tentacle4, 0.2182F, 0.0F, 0.0F);
			cube_r27 = new ModelRenderer(this);
			cube_r27.setRotationPoint(0.0F, 1.0F, 0.0F);
			tentacle4.addChild(cube_r27);
			setRotationAngle(cube_r27, 0.3491F, 0.0F, 0.0F);
			cube_r27.setTextureOffset(0, 24).addBox(0.0F, -2.5192F, -3.1053F, 0.0F, 35.0F, 6.0F, 0.0F, false);
			tentacle5 = new ModelRenderer(this);
			tentacle5.setRotationPoint(3.0F, 14.0F, 9.0F);
			setRotationAngle(tentacle5, 0.2182F, 0.0F, 0.0F);
			cube_r28 = new ModelRenderer(this);
			cube_r28.setRotationPoint(0.0F, 1.0F, 0.0F);
			tentacle5.addChild(cube_r28);
			setRotationAngle(cube_r28, 0.3491F, 0.0F, 0.0F);
			cube_r28.setTextureOffset(0, 24).addBox(0.0F, -2.5192F, -3.1053F, 0.0F, 35.0F, 6.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			armR.render(matrixStack, buffer, packedLight, packedOverlay);
			armL.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle1.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle2.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle3.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle4.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle5.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.armR.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.tentacle4.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.armL.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.tentacle5.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.tentacle2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.tentacle3.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.tentacle1.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
