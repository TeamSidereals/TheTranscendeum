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

import io.github.team_lodestar.transcendeum.entity.ArcedeonEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class ArcedeonRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(ArcedeonEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelarcedeon(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("the_transcendeum:textures/arcedeon.png");
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
					.getBuffer(RenderType.getEyes(new ResourceLocation("the_transcendeum:textures/arcedeon_glow.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.9.3
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelarcedeon extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer nose;
		private final ModelRenderer body;
		private final ModelRenderer tail;
		private final ModelRenderer tail2;
		private final ModelRenderer tail_fin;
		private final ModelRenderer right_fin;
		private final ModelRenderer left_fin_r1;
		private final ModelRenderer left_fin;
		private final ModelRenderer left_fin_r2;
		private final ModelRenderer back_fin;
		public Modelarcedeon() {
			textureWidth = 128;
			textureHeight = 128;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 20.0F, -3.0F);
			head.setTextureOffset(0, 51).addBox(-4.0F, -3.0F, -6.0F, 8.0F, 7.0F, 6.0F, 0.0F, false);
			nose = new ModelRenderer(this);
			nose.setRotationPoint(0.0F, 4.0F, 3.0F);
			head.addChild(nose);
			nose.setTextureOffset(0, 9).addBox(-1.0F, -2.0F, -13.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, -3.0F);
			body.setTextureOffset(0, 15).addBox(-4.0F, -7.0F, 0.0F, 8.0F, 7.0F, 13.0F, 0.0F, false);
			tail = new ModelRenderer(this);
			tail.setRotationPoint(0.0F, 21.5F, 10.0F);
			tail.setTextureOffset(42, 15).addBox(-3.0F, -3.5F, 0.0F, 6.0F, 5.0F, 11.0F, 0.0F, false);
			tail2 = new ModelRenderer(this);
			tail2.setRotationPoint(0.0F, 0.0F, 11.0F);
			tail.addChild(tail2);
			tail2.setTextureOffset(49, 40).addBox(-2.0F, -2.5F, 0.0F, 4.0F, 3.0F, 11.0F, 0.0F, false);
			tail_fin = new ModelRenderer(this);
			tail_fin.setRotationPoint(0.0F, 0.0F, 9.0F);
			tail2.addChild(tail_fin);
			tail_fin.setTextureOffset(0, 0).addBox(-11.0F, -0.5F, 0.0F, 22.0F, 0.0F, 15.0F, 0.0F, false);
			right_fin = new ModelRenderer(this);
			right_fin.setRotationPoint(-3.5F, 22.0F, 3.0F);
			left_fin_r1 = new ModelRenderer(this);
			left_fin_r1.setRotationPoint(3.5F, 2.0F, -3.0F);
			right_fin.addChild(left_fin_r1);
			setRotationAngle(left_fin_r1, 0.0F, 0.0F, -1.5708F);
			left_fin_r1.setTextureOffset(0, 20).addBox(2.0F, -20.0F, -2.0F, 0.0F, 16.0F, 15.0F, 0.0F, false);
			left_fin = new ModelRenderer(this);
			left_fin.setRotationPoint(3.5F, 22.0F, 3.0F);
			left_fin_r2 = new ModelRenderer(this);
			left_fin_r2.setRotationPoint(-3.5F, 2.0F, -3.0F);
			left_fin.addChild(left_fin_r2);
			setRotationAngle(left_fin_r2, 0.0F, 0.0F, 1.5708F);
			left_fin_r2.setTextureOffset(30, 20).addBox(-2.0F, -20.0F, -2.0F, 0.0F, 16.0F, 15.0F, 0.0F, false);
			back_fin = new ModelRenderer(this);
			back_fin.setRotationPoint(0.0F, 13.0F, -5.0F);
			back_fin.setTextureOffset(0, 0).addBox(-0.5F, 0.0F, 8.0F, 1.0F, 4.0F, 5.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			tail.render(matrixStack, buffer, packedLight, packedOverlay);
			right_fin.render(matrixStack, buffer, packedLight, packedOverlay);
			left_fin.render(matrixStack, buffer, packedLight, packedOverlay);
			back_fin.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.tail2.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.left_fin.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.tail.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.right_fin.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.tail_fin.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
