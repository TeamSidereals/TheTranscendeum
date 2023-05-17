package io.github.team_lodestar.transcendeum.event;

import io.github.team_lodestar.transcendeum.TheTranscendeumMod;
import io.github.team_lodestar.transcendeum.item.mixcode.MixCodeItemRegister;
import io.github.team_lodestar.transcendeum.world.biome.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = TheTranscendeumMod.MODID)
public class MixCodeSpawnMob {

    @SubscribeEvent
    public static void spawnMobAroundPlayer(TickEvent.PlayerTickEvent event){
        World world = event.player.world;
        if (!world.isRemote){
            PlayerEntity player = event.player;
            if (player.world.getDimensionKey().getLocation().toString().equals("the_transcendeum:transcendeum")){
                Random roll = new Random();
                if (roll.nextDouble() < 0.00025) {
                    if (world.getBiome(player.getPosition()).getRegistryName().equals(KalaisicWastesBiome.biome.getRegistryName())) {
                        if (player.getPosY() >= 62) {
                            for (int i = 0; i < 3; i++) {
                                double adjust = roll.nextDouble() * 1.5D - 0.75D;
                                if (adjust > -0.5D && adjust < 0.5D){
                                    adjust = 1;
                                }
                                BlazeEntity blaze = EntityType.BLAZE.create(world);
                                BlockPos pos = new BlockPos(player.getPosX() + 48D * adjust, player.getPosY(), player.getPosZ() + 48D * adjust);
                                while (world.getBlockState(pos.up()).isSolid()) {
                                    pos = pos.up();
                                }
                                blaze.setPosition(pos.getX(), pos.getY(), pos.getZ());
                                world.addEntity(blaze);
                                if (i % 2 == 0) {
                                    adjust = roll.nextDouble() * 1.5D - 0.75D;
                                    if (adjust > -0.5D && adjust < 0.5D){
                                        adjust = 1;
                                    }
                                    pos = new BlockPos(player.getPosX() + 48D * adjust, player.getPosY(), player.getPosZ() + 48D * adjust);
                                    while (world.getBlockState(pos.up()).isSolid()) {
                                        pos = pos.up();
                                    }
                                    WitherSkeletonEntity witherSkeleton = EntityType.WITHER_SKELETON.create(world);
                                    witherSkeleton.setHeldItem(Hand.MAIN_HAND,
                                            enchantMobEquipment(Items.NETHERITE_AXE.getDefaultInstance(), Enchantments.SHARPNESS, 5)
                                    );
                                    witherSkeleton.setHeldItem(Hand.OFF_HAND, Items.ANCIENT_DEBRIS.getDefaultInstance());
                                    witherSkeleton.setItemStackToSlot(EquipmentSlotType.HEAD,
                                            enchantMobEquipment(Items.NETHERITE_HELMET.getDefaultInstance(), Enchantments.PROTECTION, 3)
                                    );
                                    witherSkeleton.setItemStackToSlot(EquipmentSlotType.CHEST,
                                            enchantMobEquipment(Items.NETHERITE_CHESTPLATE.getDefaultInstance(), Enchantments.PROTECTION, 3)
                                    );
                                    witherSkeleton.setItemStackToSlot(EquipmentSlotType.LEGS,
                                            enchantMobEquipment(Items.NETHERITE_LEGGINGS.getDefaultInstance(), Enchantments.PROTECTION, 3)
                                    );
                                    witherSkeleton.setItemStackToSlot(EquipmentSlotType.FEET,
                                            enchantMobEquipment(
                                                    enchantMobEquipment(Items.NETHERITE_BOOTS.getDefaultInstance(), Enchantments.PROTECTION, 3),
                                                    Enchantments.FEATHER_FALLING, 4)
                                    );
                                    witherSkeleton.setDropChance(EquipmentSlotType.MAINHAND, 0.0f);
                                    witherSkeleton.setDropChance(EquipmentSlotType.OFFHAND, 0.1f);
                                    witherSkeleton.setDropChance(EquipmentSlotType.HEAD, 0.0f);
                                    witherSkeleton.setDropChance(EquipmentSlotType.CHEST, 0.0f);
                                    witherSkeleton.setDropChance(EquipmentSlotType.LEGS, 0.0f);
                                    witherSkeleton.setDropChance(EquipmentSlotType.FEET, 0.0f);
                                    witherSkeleton.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(0.8D);
                                    witherSkeleton.getAttribute(Attributes.MAX_HEALTH).setBaseValue(50.0D);
                                    witherSkeleton.setPosition(pos.getX(), pos.getY(), pos.getZ());
                                    world.addEntity(witherSkeleton);
                                }
                            }
                        }
                    }
                    if (world.getBiome(player.getPosition()).getRegistryName().equals(SaltLowlandsBiome.biome.getRegistryName())) {
                        if (player.getPosY() >= 62) {
                            for (int i = 0; i < 3; i++) {
                                double adjust = roll.nextDouble() * 1.5D - 0.75D;
                                if (adjust > -0.5D && adjust < 0.5D){
                                    adjust = 1;
                                }
                                BlockPos pos = new BlockPos(player.getPosX() + 48D * adjust, player.getPosY(), player.getPosZ() + 48D * adjust);
                                while (world.getBlockState(pos.up()).isSolid()) {
                                    pos = pos.up();
                                }
                                SkeletonEntity skeleton = EntityType.SKELETON.create(world);
                                if (i % 2 == 0) {
                                    skeleton.setHeldItem(Hand.MAIN_HAND,
                                            enchantMobEquipment(Items.IRON_SWORD.getDefaultInstance(), Enchantments.FIRE_ASPECT, 2)
                                    );
                                    skeleton.setHeldItem(Hand.OFF_HAND, MixCodeItemRegister.PURIFY_POWDER.get().getDefaultInstance());
                                    skeleton.setDropChance(EquipmentSlotType.OFFHAND, 1.0f);
                                } else {
                                    skeleton.setHeldItem(Hand.MAIN_HAND,
                                            enchantMobEquipment(Items.BOW.getDefaultInstance(), Enchantments.PUNCH, 2)
                                    );
                                }
                                skeleton.setDropChance(EquipmentSlotType.MAINHAND, 0.0f);
                                skeleton.setItemStackToSlot(EquipmentSlotType.HEAD,
                                        enchantMobEquipment(Items.IRON_HELMET.getDefaultInstance(), Enchantments.THORNS, 3)
                                );
                                skeleton.setItemStackToSlot(EquipmentSlotType.CHEST,
                                        enchantMobEquipment(Items.IRON_CHESTPLATE.getDefaultInstance(), Enchantments.THORNS, 3)
                                );
                                skeleton.setItemStackToSlot(EquipmentSlotType.LEGS,
                                        enchantMobEquipment(Items.IRON_LEGGINGS.getDefaultInstance(), Enchantments.THORNS, 3)
                                );
                                skeleton.setItemStackToSlot(EquipmentSlotType.FEET,
                                        enchantMobEquipment(
                                                enchantMobEquipment(Items.IRON_BOOTS.getDefaultInstance(), Enchantments.FEATHER_FALLING, 4)
                                                , Enchantments.THORNS, 3)
                                );
                                skeleton.setDropChance(EquipmentSlotType.HEAD, 0.0f);
                                skeleton.setDropChance(EquipmentSlotType.CHEST, 0.0f);
                                skeleton.setDropChance(EquipmentSlotType.LEGS, 0.0f);
                                skeleton.setDropChance(EquipmentSlotType.FEET, 0.0f);
                                skeleton.setPosition(pos.getX(), pos.getY(), pos.getZ());
                                world.addEntity(skeleton);
                            }
                        }
                    }
                    if (world.getBiome(player.getPosition()).getRegistryName().equals(LavenderfareBiome.biome.getRegistryName())) {
                        if (player.getPosY() >= 62) {
                            for (int i = 0; i < 3; i++) {
                                double adjust = roll.nextDouble() * 1.5D - 0.75D;
                                if (adjust > -0.5D && adjust < 0.5D){
                                    adjust = 1;
                                }
                                BlockPos pos = new BlockPos(player.getPosX() + 48D * adjust, player.getPosY(), player.getPosZ() + 48D * adjust);
                                while (world.getBlockState(pos.up()).isSolid()) {
                                    pos = pos.up();
                                }
                                ShulkerEntity shulker = EntityType.SHULKER.create(world);
                                shulker.setPosition(pos.getX(), pos.getY(), pos.getZ());
                                world.addEntity(shulker);
                                if (i % 2 == 0) {
                                    adjust = roll.nextDouble() * 1.5D - 0.75D;
                                    if (adjust > -0.5D && adjust < 0.5D){
                                        adjust = 1;
                                    }
                                    pos = new BlockPos(player.getPosX() + 48D * adjust, player.getPosY(), player.getPosZ() + 48D * adjust);
                                    while (world.getBlockState(pos.up()).isSolid()) {
                                        pos = pos.up();
                                    }
                                    PhantomEntity phantomEntity = EntityType.PHANTOM.create(world);
                                    phantomEntity.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 400));
                                    phantomEntity.setPosition(pos.getX(), pos.getY() + 8D, pos.getZ());
                                    world.addEntity(phantomEntity);
                                }
                            }
                        }
                    }
                    if (world.getBiome(player.getPosition()).getRegistryName().equals(SullenDesertBiome.biome.getRegistryName())
                            || world.getBiome(player.getPosition()).getRegistryName().equals(SullenCliffsBiome.biome.getRegistryName())) {
                        if (player.getPosY() >= 62) {
                            for (int i = 0; i < 3; i++) {
                                double adjust = roll.nextDouble() * 1.5D - 0.75D;
                                if (adjust > -0.5D && adjust < 0.5D){
                                    adjust = 1;
                                }
                                BlockPos pos = new BlockPos(player.getPosX() + 48D * adjust, player.getPosY(), player.getPosZ() + 48D * adjust);
                                while (world.getBlockState(pos.up()).isSolid()) {
                                    pos = pos.up();
                                }
                                HuskEntity husk = EntityType.HUSK.create(world);
                                husk.setHeldItem(Hand.MAIN_HAND,
                                        enchantMobEquipment(Items.GOLDEN_AXE.getDefaultInstance(), Enchantments.SHARPNESS, 3)
                                );
                                husk.setItemStackToSlot(EquipmentSlotType.HEAD,
                                        enchantMobEquipment(Items.GOLDEN_HELMET.getDefaultInstance(), Enchantments.PROTECTION, 3)
                                );
                                husk.setItemStackToSlot(EquipmentSlotType.CHEST,
                                        enchantMobEquipment(Items.GOLDEN_CHESTPLATE.getDefaultInstance(), Enchantments.PROTECTION, 3)
                                );
                                husk.setItemStackToSlot(EquipmentSlotType.LEGS,
                                        enchantMobEquipment(Items.GOLDEN_LEGGINGS.getDefaultInstance(), Enchantments.PROTECTION, 3)
                                );
                                husk.setItemStackToSlot(EquipmentSlotType.FEET,
                                        enchantMobEquipment(
                                                enchantMobEquipment(Items.GOLDEN_BOOTS.getDefaultInstance(), Enchantments.FEATHER_FALLING, 4),
                                                Enchantments.PROTECTION, 3)
                                );
                                husk.setDropChance(EquipmentSlotType.MAINHAND, 0.0f);
                                husk.setDropChance(EquipmentSlotType.HEAD, 0.0f);
                                husk.setDropChance(EquipmentSlotType.CHEST, 0.0f);
                                husk.setDropChance(EquipmentSlotType.LEGS, 0.0f);
                                husk.setDropChance(EquipmentSlotType.FEET, 0.0f);
                                husk.setPosition(pos.getX(), pos.getY(), pos.getZ());
                                world.addEntity(husk);
                            }
                        }
                    }
                    if (world.getBiome(player.getPosition()).getRegistryName().equals(ViridianMiresBiome.biome.getRegistryName())) {
                        if (player.getPosY() >= 62) {
                            double adjust = roll.nextDouble() * 1.5D - 0.75D;
                            if (adjust > -0.5D && adjust < 0.5D){
                                adjust = 1;
                            }
                            BlockPos pos = new BlockPos(player.getPosX() + 48D * adjust, player.getPosY(), player.getPosZ() + 48D * adjust);
                            while (world.getBlockState(pos.up()).isSolid()) {
                                pos = pos.up();
                            }
                            WitchEntity witch = EntityType.WITCH.create(world);
                            witch.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 600, 2));
                            witch.setPosition(pos.getX(), pos.getY(), pos.getZ());
                            world.addEntity(witch);
                            adjust = roll.nextDouble() * 1.5D - 0.75D;
                            if (adjust > -0.5D && adjust < 0.5D){
                                adjust = 1;
                            }
                            pos = new BlockPos(player.getPosX() + 48D * adjust, player.getPosY(), player.getPosZ() + 48D * adjust);
                            while (world.getBlockState(pos.up()).isSolid()) {
                                pos = pos.up();
                            }
                            CaveSpiderEntity caveSpider = EntityType.CAVE_SPIDER.create(world);
                            caveSpider.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 600, 2));
                            caveSpider.setPosition(pos.getX(), pos.getY(), pos.getZ());
                            world.addEntity(caveSpider);
                        }
                    }
                }
            }
        }
    }

    public static ItemStack enchantMobEquipment(ItemStack stack, Enchantment enchantment, int level){
        stack.addEnchantment(enchantment, level);
        return  stack;
    }
}
