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

import io.github.team_lodestar.transcendeum.entity.TestmobEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class TestmobRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(TestmobEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelpuffel(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("the_transcendeum:textures/arffel_texture.png");
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
					.getBuffer(RenderType.getEyes(new ResourceLocation("the_transcendeum:textures/arffel_texture_glow.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.9.3
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelpuffel extends EntityModel<Entity> {
		private final ModelRenderer puffel;
		private final ModelRenderer head;
		private final ModelRenderer head_r1;
		private final ModelRenderer head_r2;
		private final ModelRenderer head_r3;
		private final ModelRenderer head_r4;
		private final ModelRenderer tentacle;
		private final ModelRenderer tentacle2;
		public Modelpuffel() {
			textureWidth = 64;
			textureHeight = 64;
			puffel = new ModelRenderer(this);
			puffel.setRotationPoint(0.0F, 36.0F, 0.0F);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -24.0F, 0.0F);
			puffel.addChild(head);
			head.setTextureOffset(22, 22).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			head_r1 = new ModelRenderer(this);
			head_r1.setRotationPoint(0.0F, 24.0F, 0.0F);
			head.addChild(head_r1);
			setRotationAngle(head_r1, 0.0F, -1.5708F, -0.3927F);
			head_r1.setTextureOffset(0, 10).addBox(-5.0F, -29.6F, -22.0F, 10.0F, 0.0F, 10.0F, 0.0F, false);
			head_r2 = new ModelRenderer(this);
			head_r2.setRotationPoint(0.0F, 24.0F, 0.0F);
			head.addChild(head_r2);
			setRotationAngle(head_r2, 0.0F, -1.5708F, 0.3927F);
			head_r2.setTextureOffset(0, 0).addBox(-5.0F, -29.6F, 12.0F, 10.0F, 0.0F, 10.0F, 0.0F, false);
			head_r3 = new ModelRenderer(this);
			head_r3.setRotationPoint(0.0F, 24.0F, 0.0F);
			head.addChild(head_r3);
			setRotationAngle(head_r3, 0.3927F, 0.0F, 0.0F);
			head_r3.setTextureOffset(0, 20).addBox(-5.0F, -29.6F, 12.0F, 10.0F, 0.0F, 10.0F, 0.0F, false);
			head_r4 = new ModelRenderer(this);
			head_r4.setRotationPoint(0.0F, 24.0F, 0.0F);
			head.addChild(head_r4);
			setRotationAngle(head_r4, -0.3927F, 0.0F, 0.0F);
			head_r4.setTextureOffset(20, 0).addBox(-5.0F, -29.6F, -22.0F, 10.0F, 0.0F, 10.0F, 0.0F, false);
			tentacle = new ModelRenderer(this);
			tentacle.setRotationPoint(-0.1F, -24.0F, -2.0F);
			puffel.addChild(tentacle);
			tentacle.setTextureOffset(30, 10).addBox(-2.9F, 0.0F, 0.0F, 6.0F, 12.0F, 0.0F, 0.0F, false);
			tentacle2 = new ModelRenderer(this);
			tentacle2.setRotationPoint(0.0F, -24.0F, 2.0F);
			puffel.addChild(tentacle2);
			tentacle2.setTextureOffset(0, 30).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 12.0F, 0.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			puffel.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.tentacle.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.tentacle2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
