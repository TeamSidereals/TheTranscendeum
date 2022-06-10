package io.github.team_lodestar.transcendeum.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import io.github.team_lodestar.transcendeum.item.EnigmaGlovePoweredItem;
import io.github.team_lodestar.transcendeum.TheTranscendeumModVariables;
import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class PoweredFlame5ConditionProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure PoweredFlame5Condition!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == EnigmaGlovePoweredItem.block
				|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == EnigmaGlovePoweredItem.block)
				&& (entity.getCapability(TheTranscendeumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheTranscendeumModVariables.PlayerVariables())).TTEnigmaCharge >= 5) {
			return true;
		}
		return false;
	}
}
