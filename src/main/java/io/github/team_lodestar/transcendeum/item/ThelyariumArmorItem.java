
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
		super(instance, 344);
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
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
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
				armorModel.bipedHead = new Modelthelyarium_armor().helmet;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "the_transcendeum:textures/thelyariumlayer_1.png";
			}
		}.setRegistryName("thelyarium_helmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(TranscendeumGearItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedBody = new Modelthelyarium_armor().chestplate;
				armorModel.bipedLeftArm = new Modelthelyarium_armor().leftarm;
				armorModel.bipedRightArm = new Modelthelyarium_armor().rightarm;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "the_transcendeum:textures/thelyariumlayer_1.png";
			}
		}.setRegistryName("thelyarium_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(TranscendeumGearItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedLeftLeg = new Modelthelyarium_armor().leftleg;
				armorModel.bipedRightLeg = new Modelthelyarium_armor().rightleg;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "the_transcendeum:textures/thelyariumlayer_1.png";
			}
		}.setRegistryName("thelyarium_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(TranscendeumGearItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedLeftLeg = new Modelthelyarium_armor().leftboot;
				armorModel.bipedRightLeg = new Modelthelyarium_armor().rightboot;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "the_transcendeum:textures/thelyariumlayer_1.png";
			}
		}.setRegistryName("thelyarium_boots"));
	}
	public static class Modelthelyarium_armor extends EntityModel<Entity> {
		private final ModelRenderer helmet;
		private final ModelRenderer righthorns;
		private final ModelRenderer horn0;
		private final ModelRenderer horn0_r1;
		private final ModelRenderer horn1;
		private final ModelRenderer horn1_r1;
		private final ModelRenderer lefthorns;
		private final ModelRenderer horn2;
		private final ModelRenderer horn1_r2;
		private final ModelRenderer horn3;
		private final ModelRenderer horn2_r1;
		private final ModelRenderer chestplate;
		private final ModelRenderer rightarm;
		private final ModelRenderer leftarm;
		private final ModelRenderer bipedLeggings;
		private final ModelRenderer rightleg;
		private final ModelRenderer leftleg;
		private final ModelRenderer rightboot;
		private final ModelRenderer RightBoot_r1;
		private final ModelRenderer leftboot;
		private final ModelRenderer RightBoot_r2;
		public Modelthelyarium_armor() {
			textureWidth = 64;
			textureHeight = 48;
			helmet = new ModelRenderer(this);
			helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
			helmet.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 1.0F, false);
			righthorns = new ModelRenderer(this);
			righthorns.setRotationPoint(-5.0F, -9.0F, 0.0F);
			helmet.addChild(righthorns);
			horn0 = new ModelRenderer(this);
			horn0.setRotationPoint(0.0F, 0.0F, 0.0F);
			righthorns.addChild(horn0);
			horn0_r1 = new ModelRenderer(this);
			horn0_r1.setRotationPoint(0.0F, 0.0F, -3.0F);
			horn0.addChild(horn0_r1);
			setRotationAngle(horn0_r1, 0.0F, 0.0F, -0.9163F);
			horn0_r1.setTextureOffset(36, 5).addBox(0.0F, -4.0F, -4.0F, 0.0F, 4.0F, 4.0F, 0.0F, false);
			horn1 = new ModelRenderer(this);
			horn1.setRotationPoint(3.0F, 0.0F, 0.0F);
			righthorns.addChild(horn1);
			horn1_r1 = new ModelRenderer(this);
			horn1_r1.setRotationPoint(-1.9319F, 0.5176F, -4.0F);
			horn1.addChild(horn1_r1);
			setRotationAngle(horn1_r1, 0.0F, 0.0F, -0.2618F);
			horn1_r1.setTextureOffset(51, 2).addBox(2.0F, -6.0F, -3.0F, 0.0F, 6.0F, 5.0F, 0.0F, false);
			lefthorns = new ModelRenderer(this);
			lefthorns.setRotationPoint(5.0F, -9.0F, 0.0F);
			helmet.addChild(lefthorns);
			horn2 = new ModelRenderer(this);
			horn2.setRotationPoint(0.0F, 0.0F, 0.0F);
			lefthorns.addChild(horn2);
			horn1_r2 = new ModelRenderer(this);
			horn1_r2.setRotationPoint(0.0F, 0.0F, -3.0F);
			horn2.addChild(horn1_r2);
			setRotationAngle(horn1_r2, 0.0F, 0.0F, 0.9163F);
			horn1_r2.setTextureOffset(36, 5).addBox(0.0F, -4.0F, -4.0F, 0.0F, 4.0F, 4.0F, 0.0F, true);
			horn3 = new ModelRenderer(this);
			horn3.setRotationPoint(-3.0F, 0.0F, 0.0F);
			lefthorns.addChild(horn3);
			horn2_r1 = new ModelRenderer(this);
			horn2_r1.setRotationPoint(1.9319F, 0.5176F, -4.0F);
			horn3.addChild(horn2_r1);
			setRotationAngle(horn2_r1, 0.0F, 0.0F, 0.2618F);
			horn2_r1.setTextureOffset(51, 2).addBox(-2.0F, -6.0F, -3.0F, 0.0F, 6.0F, 5.0F, 0.0F, true);
			chestplate = new ModelRenderer(this);
			chestplate.setRotationPoint(0.0F, 0.0F, 0.0F);
			chestplate.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 1.01F, false);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
			rightarm.setTextureOffset(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 1.0F, false);
			rightarm.setTextureOffset(40, 9).addBox(-3.0F, -6.0F, -2.0F, 4.0F, 2.0F, 4.0F, 1.0F, false);
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(5.0F, 2.0F, 0.0F);
			leftarm.setTextureOffset(40, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 1.0F, true);
			leftarm.setTextureOffset(40, 9).addBox(-1.0F, -6.0F, -2.0F, 4.0F, 2.0F, 4.0F, 1.0F, true);
			bipedLeggings = new ModelRenderer(this);
			bipedLeggings.setRotationPoint(0.0F, 24.0F, 0.0F);
			bipedLeggings.setTextureOffset(16, 39).addBox(-4.0F, -17.0F, -2.0F, 8.0F, 5.0F, 4.0F, 0.51F, false);
			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(-4.0F, 0.0F, 0.0F);
			bipedLeggings.addChild(rightleg);
			rightleg.setTextureOffset(0, 32).addBox(0.1F, -11.0F, -2.0F, 4.0F, 9.0F, 4.0F, 0.5F, false);
			leftleg = new ModelRenderer(this);
			leftleg.setRotationPoint(0.0F, 0.0F, 0.0F);
			bipedLeggings.addChild(leftleg);
			leftleg.setTextureOffset(0, 32).addBox(-0.1F, -11.0F, -2.0F, 4.0F, 9.0F, 4.0F, 0.5F, false);
			rightboot = new ModelRenderer(this);
			rightboot.setRotationPoint(-1.9F, 12.0F, 0.0F);
			rightboot.setTextureOffset(0, 22).addBox(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, 1.0F, false);
			RightBoot_r1 = new ModelRenderer(this);
			RightBoot_r1.setRotationPoint(-1.0F, 8.0F, -3.0F);
			rightboot.addChild(RightBoot_r1);
			setRotationAngle(RightBoot_r1, 0.0F, -1.2217F, 0.0F);
			RightBoot_r1.setTextureOffset(40, 32).addBox(-3.0F, -5.0F, 0.0F, 3.0F, 7.0F, 0.0F, 0.0F, false);
			leftboot = new ModelRenderer(this);
			leftboot.setRotationPoint(1.9F, 12.0F, 0.0F);
			leftboot.setTextureOffset(0, 22).addBox(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, 1.0F, true);
			RightBoot_r2 = new ModelRenderer(this);
			RightBoot_r2.setRotationPoint(1.0F, 8.0F, -3.0F);
			leftboot.addChild(RightBoot_r2);
			setRotationAngle(RightBoot_r2, 0.0F, 1.2217F, 0.0F);
			RightBoot_r2.setTextureOffset(40, 32).addBox(0.0F, -5.0F, 0.0F, 3.0F, 7.0F, 0.0F, 0.0F, true);
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
			bipedLeggings.render(matrixStack, buffer, packedLight, packedOverlay);
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
