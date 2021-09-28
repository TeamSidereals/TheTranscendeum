package io.github.team_lodestar.transcendeum.procedures;

import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import io.github.team_lodestar.transcendeum.item.EnigmaGlovePoweredItem;
import io.github.team_lodestar.transcendeum.item.EnigmaGloveItem;
import io.github.team_lodestar.transcendeum.TheTranscendeumModVariables;
import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class EnigmaGloveRangedItemUsedProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure EnigmaGloveRangedItemUsed!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency itemstack for procedure EnigmaGloveRangedItemUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getCooldownTracker().setCooldown(EnigmaGloveItem.block, (int) 10);
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getCooldownTracker().setCooldown(EnigmaGlovePoweredItem.block, (int) 10);
		{
			double _setval = (double) (((entity.getCapability(TheTranscendeumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheTranscendeumModVariables.PlayerVariables())).TTEnigmaCharge) + 1);
			entity.getCapability(TheTranscendeumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.TTEnigmaCharge = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == (itemstack).getItem())
				&& (((entity.getCapability(TheTranscendeumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheTranscendeumModVariables.PlayerVariables())).TTEnigmaCharge) > 4))) {
			entity.getPersistentData().putDouble("TT:EnigmaGloveDurability",
					((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getDamage()));
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(EnigmaGlovePoweredItem.block);
				_setstack.setCount((int) 1);
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
			(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
					.setDamage((int) (entity.getPersistentData().getDouble("TT:EnigmaGloveDurability")));
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == (itemstack)
				.getItem())
				&& (((entity.getCapability(TheTranscendeumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheTranscendeumModVariables.PlayerVariables())).TTEnigmaCharge) > 4))) {
			entity.getPersistentData().putDouble("TT:EnigmaGloveDurability",
					((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)).getDamage()));
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(EnigmaGlovePoweredItem.block);
				_setstack.setCount((int) 1);
				((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
			(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY))
					.setDamage((int) (entity.getPersistentData().getDouble("TT:EnigmaGloveDurability")));
		}
	}
}
