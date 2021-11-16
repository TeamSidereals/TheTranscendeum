package io.github.team_lodestar.transcendeum.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import io.github.team_lodestar.transcendeum.entity.RemobrenEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class RemobrenRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(RemobrenEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelremobren(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("the_transcendeum:textures/remobren.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.0.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelremobren extends EntityModel<Entity> {
		private final ModelRenderer remobren;
		private final ModelRenderer body;
		private final ModelRenderer neck;
		private final ModelRenderer head;
		private final ModelRenderer head_main;
		private final ModelRenderer righthorn;
		private final ModelRenderer righthorn_r1;
		private final ModelRenderer righthorn_r2;
		private final ModelRenderer lefthorn;
		private final ModelRenderer lefthorn_r1;
		private final ModelRenderer lefthorn_r2;
		private final ModelRenderer bone2;
		private final ModelRenderer bone;
		private final ModelRenderer rightleg;
		private final ModelRenderer rightleg_r1;
		private final ModelRenderer rightleg_r2;
		private final ModelRenderer leftleg;
		private final ModelRenderer rightleg_r3;
		private final ModelRenderer rightleg_r4;
		private final ModelRenderer right_wing;
		private final ModelRenderer right_wing_r1;
		private final ModelRenderer right_wing_1;
		private final ModelRenderer right_wing_1_r1;
		private final ModelRenderer left_wing;
		private final ModelRenderer right_wing_r2;
		private final ModelRenderer left_wing_;
		private final ModelRenderer right_wing_2_r1;
		private final ModelRenderer tail;
		private final ModelRenderer tail2;
		public Modelremobren() {
			textureWidth = 64;
			textureHeight = 64;
			remobren = new ModelRenderer(this);
			remobren.setRotationPoint(0.0F, 24.0F, 0.0F);
			body = new ModelRenderer(this);
			body.setRotationPoint(-0.5F, -5.0F, 0.0F);
			remobren.addChild(body);
			body.setTextureOffset(22, 17).addBox(-2.0F, -3.0921F, -7.6994F, 5.0F, 5.0F, 13.0F, 0.0F, false);
			body.setTextureOffset(0, 8).addBox(0.5F, -8.0921F, -9.6994F, 0.0F, 6.0F, 16.0F, 0.0F, false);
			neck = new ModelRenderer(this);
			neck.setRotationPoint(0.5F, -5.0F, 1.0F);
			remobren.addChild(neck);
			neck.setTextureOffset(35, 6).addBox(-2.0F, -2.0921F, -15.6994F, 3.0F, 3.0F, 7.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(-2.5F, -5.75F, -14.0F);
			remobren.addChild(head);
			head_main = new ModelRenderer(this);
			head_main.setRotationPoint(0.0F, 4.0F, -2.0F);
			head.addChild(head_main);
			setRotationAngle(head_main, 0.2618F, 0.0F, 0.0F);
			head_main.setTextureOffset(17, 35).addBox(0.0F, -5.6668F, -2.1716F, 5.0F, 4.0F, 5.0F, 0.0F, false);
			righthorn = new ModelRenderer(this);
			righthorn.setRotationPoint(0.5F, 3.75F, 8.0F);
			head_main.addChild(righthorn);
			righthorn_r1 = new ModelRenderer(this);
			righthorn_r1.setRotationPoint(2.0F, -2.6668F, 2.8284F);
			righthorn.addChild(righthorn_r1);
			setRotationAngle(righthorn_r1, 0.589F, -0.4253F, -0.1006F);
			righthorn_r1.setTextureOffset(0, 0).addBox(-5.0F, -9.75F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
			righthorn_r2 = new ModelRenderer(this);
			righthorn_r2.setRotationPoint(2.0F, -2.6668F, 2.8284F);
			righthorn.addChild(righthorn_r2);
			setRotationAngle(righthorn_r2, 0.3708F, -0.4253F, -0.1006F);
			righthorn_r2.setTextureOffset(0, 17).addBox(-5.5F, -9.75F, -6.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
			lefthorn = new ModelRenderer(this);
			lefthorn.setRotationPoint(0.5F, 3.75F, 8.0F);
			head_main.addChild(lefthorn);
			lefthorn_r1 = new ModelRenderer(this);
			lefthorn_r1.setRotationPoint(2.0F, -2.6668F, 2.8284F);
			lefthorn.addChild(lefthorn_r1);
			setRotationAngle(lefthorn_r1, 0.589F, 0.4253F, 0.1006F);
			lefthorn_r1.setTextureOffset(0, 0).addBox(4.0F, -9.75F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
			lefthorn_r2 = new ModelRenderer(this);
			lefthorn_r2.setRotationPoint(2.0F, -2.6668F, 2.8284F);
			lefthorn.addChild(lefthorn_r2);
			setRotationAngle(lefthorn_r2, 0.3708F, 0.4253F, 0.1006F);
			lefthorn_r2.setTextureOffset(0, 17).addBox(3.5F, -9.75F, -6.0F, 2.0F, 2.0F, 3.0F, 0.0F, true);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(2.0F, -7.4168F, -10.1716F);
			lefthorn.addChild(bone2);
			bone2.setTextureOffset(0, 48).addBox(-2.0F, -2.0F, -5.0F, 2.0F, 4.0F, 5.0F, 0.0F, true);
			bone = new ModelRenderer(this);
			bone.setRotationPoint(2.0F, -7.4168F, -10.1716F);
			lefthorn.addChild(bone);
			bone.setTextureOffset(0, 48).addBox(0.0F, -2.0F, -5.0F, 2.0F, 4.0F, 5.0F, 0.0F, false);
			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(0.0F, 1.0F, 6.0F);
			remobren.addChild(rightleg);
			rightleg_r1 = new ModelRenderer(this);
			rightleg_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			rightleg.addChild(rightleg_r1);
			setRotationAngle(rightleg_r1, 1.2654F, 0.0F, 0.0F);
			rightleg_r1.setTextureOffset(20, 60).addBox(-4.5F, 3.0F, 2.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			rightleg_r1.setTextureOffset(12, 57).addBox(-3.5F, -2.0F, 3.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
			rightleg_r2 = new ModelRenderer(this);
			rightleg_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
			rightleg.addChild(rightleg_r2);
			setRotationAngle(rightleg_r2, 0.7854F, 0.0F, 0.0F);
			rightleg_r2.setTextureOffset(0, 57).addBox(-4.5F, -6.0F, 1.0F, 3.0F, 4.0F, 3.0F, 0.0F, false);
			leftleg = new ModelRenderer(this);
			leftleg.setRotationPoint(0.0F, 1.0F, 6.0F);
			remobren.addChild(leftleg);
			rightleg_r3 = new ModelRenderer(this);
			rightleg_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
			leftleg.addChild(rightleg_r3);
			setRotationAngle(rightleg_r3, 1.2654F, 0.0F, 0.0F);
			rightleg_r3.setTextureOffset(20, 60).addBox(1.5F, 3.0F, 2.0F, 3.0F, 1.0F, 3.0F, 0.0F, true);
			rightleg_r3.setTextureOffset(12, 57).addBox(1.5F, -2.0F, 3.0F, 2.0F, 5.0F, 2.0F, 0.0F, true);
			rightleg_r4 = new ModelRenderer(this);
			rightleg_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
			leftleg.addChild(rightleg_r4);
			setRotationAngle(rightleg_r4, 0.7854F, 0.0F, 0.0F);
			rightleg_r4.setTextureOffset(0, 57).addBox(1.5F, -6.0F, 1.0F, 3.0F, 4.0F, 3.0F, 0.0F, true);
			right_wing = new ModelRenderer(this);
			right_wing.setRotationPoint(-2.5F, -7.0F, -2.0F);
			remobren.addChild(right_wing);
			right_wing_r1 = new ModelRenderer(this);
			right_wing_r1.setRotationPoint(4.0F, 4.4089F, 2.8006F);
			right_wing.addChild(right_wing_r1);
			setRotationAngle(right_wing_r1, 0.0F, -1.5708F, 0.0F);
			right_wing_r1.setTextureOffset(0, 13).addBox(-8.5F, -5.5F, 4.0F, 12.0F, 0.0F, 11.0F, 0.0F, false);
			right_wing_1 = new ModelRenderer(this);
			right_wing_1.setRotationPoint(-11.0F, 4.4089F, 0.8006F);
			right_wing.addChild(right_wing_1);
			right_wing_1_r1 = new ModelRenderer(this);
			right_wing_1_r1.setRotationPoint(15.0F, 0.0F, 2.0F);
			right_wing_1.addChild(right_wing_1_r1);
			setRotationAngle(right_wing_1_r1, 0.0F, -1.5708F, 0.0F);
			right_wing_1_r1.setTextureOffset(0, 0).addBox(-8.5F, -5.5F, 15.0F, 11.0F, 0.0F, 13.0F, 0.0F, false);
			left_wing = new ModelRenderer(this);
			left_wing.setRotationPoint(2.5F, -7.0F, -2.0F);
			remobren.addChild(left_wing);
			right_wing_r2 = new ModelRenderer(this);
			right_wing_r2.setRotationPoint(-4.0F, 4.4089F, 2.8006F);
			left_wing.addChild(right_wing_r2);
			setRotationAngle(right_wing_r2, 0.0F, 1.5708F, 0.0F);
			right_wing_r2.setTextureOffset(0, 13).addBox(-3.5F, -5.5F, 4.0F, 12.0F, 0.0F, 11.0F, 0.0F, true);
			left_wing_ = new ModelRenderer(this);
			left_wing_.setRotationPoint(11.0F, 4.4089F, 0.8006F);
			left_wing.addChild(left_wing_);
			right_wing_2_r1 = new ModelRenderer(this);
			right_wing_2_r1.setRotationPoint(-15.0F, 0.0F, 2.0F);
			left_wing_.addChild(right_wing_2_r1);
			setRotationAngle(right_wing_2_r1, 0.0F, 1.5708F, 0.0F);
			right_wing_2_r1.setTextureOffset(0, 0).addBox(-2.5F, -5.5F, 15.0F, 11.0F, 0.0F, 13.0F, 0.0F, true);
			tail = new ModelRenderer(this);
			tail.setRotationPoint(0.0F, -6.0F, 5.25F);
			remobren.addChild(tail);
			tail.setTextureOffset(30, 45).addBox(-2.5F, -2.0921F, 0.0506F, 5.0F, 3.0F, 12.0F, 0.0F, false);
			tail2 = new ModelRenderer(this);
			tail2.setRotationPoint(0.0F, 0.5F, 11.75F);
			tail.addChild(tail2);
			tail2.setTextureOffset(14, 45).addBox(-1.5F, -2.5921F, 0.3006F, 3.0F, 2.0F, 10.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			remobren.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.right_wing.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.left_wing.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
			this.tail.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.tail2.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}
}
