package io.github.team_lodestar.transcendeum.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.block.Blocks;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Comparator;

import io.github.team_lodestar.transcendeum.enchantment.RefreshingEnchantment;
import io.github.team_lodestar.transcendeum.enchantment.BurstPoppingEnchantment;
import io.github.team_lodestar.transcendeum.enchantment.AquadynamicEnchantment;
import io.github.team_lodestar.transcendeum.block.BubbleBlock;
import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class BubbleHelmGiveAirProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure BubbleHelmGiveAir!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency x for procedure BubbleHelmGiveAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency y for procedure BubbleHelmGiveAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency z for procedure BubbleHelmGiveAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency world for procedure BubbleHelmGiveAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
				: ItemStack.EMPTY).getItem() == BubbleBlock.block.asItem())) {
			if (((EnchantmentHelper.getEnchantmentLevel(AquadynamicEnchantment.enchantment,
					((entity instanceof LivingEntity)
							? ((LivingEntity) entity)
									.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
							: ItemStack.EMPTY))) != 0)) {
				if ((entity.isInWater())) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 20,
								(int) (2 + (EnchantmentHelper.getEnchantmentLevel(AquadynamicEnchantment.enchantment,
										((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getItemStackFromSlot(
														EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
												: ItemStack.EMPTY)))),
								(true), (false)));
				}
			}
			if (((entity.getAir()) == 0)) {
				entity.setAir((int) 250);
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
							+ ((EnchantmentHelper.getEnchantmentLevel(RefreshingEnchantment.enchantment,
									((entity instanceof LivingEntity)
											? ((LivingEntity) entity).getItemStackFromSlot(
													EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
											: ItemStack.EMPTY)))
									* 4)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, (int) 100, (int) 0, (true), (false)));
				{
					List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(
									x - (((EnchantmentHelper.getEnchantmentLevel(BurstPoppingEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getItemStackFromSlot(
															EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
													: ItemStack.EMPTY)))
											* 3) / 2d),
									y - (((EnchantmentHelper.getEnchantmentLevel(BurstPoppingEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getItemStackFromSlot(
															EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
													: ItemStack.EMPTY)))
											* 3) / 2d),
									z - (((EnchantmentHelper.getEnchantmentLevel(BurstPoppingEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getItemStackFromSlot(
															EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
													: ItemStack.EMPTY)))
											* 3) / 2d),
									x + (((EnchantmentHelper.getEnchantmentLevel(BurstPoppingEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getItemStackFromSlot(
															EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
													: ItemStack.EMPTY)))
											* 3) / 2d),
									y + (((EnchantmentHelper.getEnchantmentLevel(BurstPoppingEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getItemStackFromSlot(
															EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
													: ItemStack.EMPTY)))
											* 3) / 2d),
									z + (((EnchantmentHelper.getEnchantmentLevel(BurstPoppingEnchantment.enchantment,
											((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getItemStackFromSlot(
															EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
													: ItemStack.EMPTY)))
											* 3) / 2d)),
							null).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if ((!(entityiterator == entity))) {
							entityiterator.attackEntityFrom(DamageSource.DROWN, (float) 4);
						}
					}
				}
				if (entity instanceof LivingEntity) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).inventory.armorInventory.set((int) 3, new ItemStack(Blocks.AIR));
					else
						((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3),
								new ItemStack(Blocks.AIR));
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			}
		}
	}
}
