
package io.github.team_lodestar.transcendeum.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

import io.github.team_lodestar.transcendeum.itemgroup.TranscendeumGearItemGroup;
import io.github.team_lodestar.transcendeum.TheTranscendeumModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@TheTranscendeumModElements.ModElement.Tag
public class ThelyariumArmorItem extends TheTranscendeumModElements.ModElement {
	@ObjectHolder("the_transcendeum:thelyarium_helmet")
	public static final Item helmet = null;
	@ObjectHolder("the_transcendeum:thelyarium_chestplate")
	public static final Item body = null;
	@ObjectHolder("the_transcendeum:thelyarium_leggings")
	public static final Item legs = null;
	@ObjectHolder("the_transcendeum:thelyarium_boots")
	public static final Item boots = null;

	public ThelyariumArmorItem(TheTranscendeumModElements instance) {
		super(instance, 135);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 31;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{3, 5, 7, 3}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 11;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(ThelyariumIngotItem.block));
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "thelyarium";
			}

			@Override
			public float getToughness() {
				return 0.4f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(TranscendeumGearItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedHead = new Modelthelyarium_layer_1().helmet;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "the_transcendeum:textures/thelyarium_layer_1.png";
			}
		}.setRegistryName("thelyarium_helmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(TranscendeumGearItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedBody = new Modelthelyarium_layer_1().chestplate;
				armorModel.bipedLeftArm = new Modelthelyarium_layer_1().leftarm;
				armorModel.bipedRightArm = new Modelthelyarium_layer_1().rightarm;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "the_transcendeum:textures/thelyarium_layer_1.png";
			}
		}.setRegistryName("thelyarium_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(TranscendeumGearItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedLeftLeg = new Modelthelyarium_layer_2().leftleg;
				armorModel.bipedRightLeg = new Modelthelyarium_layer_2().rightleg;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "the_transcendeum:textures/thelyarium_layer_2.png";
			}
		}.setRegistryName("thelyarium_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(TranscendeumGearItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedLeftLeg = new Modelthelyarium_layer_1().leftboot;
				armorModel.bipedRightLeg = new Modelthelyarium_layer_1().rightboot;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "the_transcendeum:textures/thelyarium_layer_1.png";
			}
		}.setRegistryName("thelyarium_boots"));
	}

	public static class Modelthelyarium_layer_2 extends EntityModel<Entity> {
		private final ModelRenderer body;
		private final ModelRenderer rightleg;
		private final ModelRenderer leftleg;

		public Modelthelyarium_layer_2() {
			textureWidth = 64;
			textureHeight = 32;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, 0.0F);
			body.setTextureOffset(16, 16).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.3F, false);
			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(-1.9F, 12.0F, 0.0F);
			rightleg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.5F, false);
			leftleg = new ModelRenderer(this);
			leftleg.setRotationPoint(1.9F, 12.0F, 0.0F);
			leftleg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.5F, true);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
			leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}

	public static class Modelthelyarium_layer_1 extends EntityModel<Entity> {
		private final ModelRenderer helmet;
		private final ModelRenderer righthorns;
		private final ModelRenderer horn0;
		private final ModelRenderer horn0_r1;
		private final ModelRenderer horn1;
		private final ModelRenderer horn1_r1;
		private final ModelRenderer lefthorns;
		private final ModelRenderer horn2;
		private final ModelRenderer horn2_r1;
		private final ModelRenderer horn3;
		private final ModelRenderer horn3_r1;
		private final ModelRenderer chestplate;
		private final ModelRenderer rightarm;
		private final ModelRenderer leftarm;
		private final ModelRenderer rightboot;
		private final ModelRenderer rightboot_r1;
		private final ModelRenderer leftboot;
		private final ModelRenderer leftboot_r1;

		public Modelthelyarium_layer_1() {
			textureWidth = 80;
			textureHeight = 32;
			helmet = new ModelRenderer(this);
			helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
			helmet.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 1.0F, false);
			righthorns = new ModelRenderer(this);
			righthorns.setRotationPoint(-5.0F, -9.0F, 0.0F);
			helmet.addChild(righthorns);
			horn0 = new ModelRenderer(this);
			horn0.setRotationPoint(3.0F, 4.0F, 0.0F);
			righthorns.addChild(horn0);
			horn0_r1 = new ModelRenderer(this);
			horn0_r1.setRotationPoint(-2.2191F, -2.2851F, -5.4193F);
			horn0.addChild(horn0_r1);
			setRotationAngle(horn0_r1, 0.1582F, 0.4084F, 0.3819F);
			horn0_r1.setTextureOffset(70, 20).addBox(-4.0F, -0.5F, 1.0F, 3.0F, 2.0F, 2.0F, 0.95F, false);
			horn1 = new ModelRenderer(this);
			horn1.setRotationPoint(4.0F, 0.0F, 0.0F);
			righthorns.addChild(horn1);
			horn1_r1 = new ModelRenderer(this);
			horn1_r1.setRotationPoint(-2.5F, 0.0F, -5.0F);
			horn1.addChild(horn1_r1);
			setRotationAngle(horn1_r1, -0.4363F, 0.0F, 0.0F);
			horn1_r1.setTextureOffset(62, 16).addBox(-0.5F, -7.0F, 1.0F, 2.0F, 6.0F, 2.0F, 0.95F, false);
			lefthorns = new ModelRenderer(this);
			lefthorns.setRotationPoint(5.0F, -9.0F, 0.0F);
			helmet.addChild(lefthorns);
			horn2 = new ModelRenderer(this);
			horn2.setRotationPoint(-3.0F, 4.0F, 0.0F);
			lefthorns.addChild(horn2);
			horn2_r1 = new ModelRenderer(this);
			horn2_r1.setRotationPoint(2.2191F, -2.2851F, -5.4193F);
			horn2.addChild(horn2_r1);
			setRotationAngle(horn2_r1, 0.1582F, -0.4084F, -0.3819F);
			horn2_r1.setTextureOffset(70, 20).addBox(1.0F, -0.5F, 1.0F, 3.0F, 2.0F, 2.0F, 0.95F, true);
			horn3 = new ModelRenderer(this);
			horn3.setRotationPoint(-4.0F, 0.0F, 0.0F);
			lefthorns.addChild(horn3);
			horn3_r1 = new ModelRenderer(this);
			horn3_r1.setRotationPoint(2.5F, 0.0F, -5.0F);
			horn3.addChild(horn3_r1);
			setRotationAngle(horn3_r1, -0.4363F, 0.0F, 0.0F);
			horn3_r1.setTextureOffset(62, 16).addBox(-1.5F, -7.0F, 1.0F, 2.0F, 6.0F, 2.0F, 0.95F, true);
			chestplate = new ModelRenderer(this);
			chestplate.setRotationPoint(0.0F, 0.0F, 0.0F);
			chestplate.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 1.01F, false);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
			rightarm.setTextureOffset(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 1.0F, false);
			rightarm.setTextureOffset(56, 26).addBox(-3.0F, -6.0F, -2.0F, 4.0F, 2.0F, 4.0F, 1.0F, false);
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(5.0F, 2.0F, 0.0F);
			leftarm.setTextureOffset(40, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 1.0F, true);
			leftarm.setTextureOffset(56, 26).addBox(-1.0F, -6.0F, -2.0F, 4.0F, 2.0F, 4.0F, 1.0F, true);
			rightboot = new ModelRenderer(this);
			rightboot.setRotationPoint(-1.9F, 12.0F, 0.0F);
			rightboot.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 1.0F, false);
			rightboot_r1 = new ModelRenderer(this);
			rightboot_r1.setRotationPoint(-1.0F, 8.0F, -2.0F);
			rightboot.addChild(rightboot_r1);
			setRotationAngle(rightboot_r1, 0.0F, -1.2217F, 0.0F);
			rightboot_r1.setTextureOffset(72, 24).addBox(-2.0F, -5.0F, -1.0F, 2.0F, 7.0F, 1.0F, 0.4F, false);
			leftboot = new ModelRenderer(this);
			leftboot.setRotationPoint(1.9F, 12.0F, 0.0F);
			leftboot.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 1.0F, true);
			leftboot_r1 = new ModelRenderer(this);
			leftboot_r1.setRotationPoint(1.0F, 8.0F, -2.0F);
			leftboot.addChild(leftboot_r1);
			setRotationAngle(leftboot_r1, 0.0F, 1.2217F, 0.0F);
			leftboot_r1.setTextureOffset(72, 24).addBox(0.0F, -5.0F, -1.0F, 2.0F, 7.0F, 1.0F, 0.4F, true);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			helmet.render(matrixStack, buffer, packedLight, packedOverlay);
			chestplate.render(matrixStack, buffer, packedLight, packedOverlay);
			rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
			leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
			rightboot.render(matrixStack, buffer, packedLight, packedOverlay);
			leftboot.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}

}
