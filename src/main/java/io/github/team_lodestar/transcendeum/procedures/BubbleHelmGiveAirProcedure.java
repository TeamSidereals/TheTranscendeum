package io.github.team_lodestar.transcendeum.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
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

import java.util.Map;
import java.util.HashMap;

import io.github.team_lodestar.transcendeum.enchantment.RefreshingEnchantment;
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
		Entity entity = (Entity) dependencies.get("entity");
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
								(int) (1 + (EnchantmentHelper.getEnchantmentLevel(AquadynamicEnchantment.enchantment,
										((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getItemStackFromSlot(
														EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
												: ItemStack.EMPTY)))),
								(false), (false)));
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
