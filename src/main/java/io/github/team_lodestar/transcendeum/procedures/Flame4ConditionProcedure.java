package io.github.team_lodestar.transcendeum.procedures;

import net.minecraft.entity.Entity;

import java.util.Map;

import io.github.team_lodestar.transcendeum.TheTranscendeumModVariables;
import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class Flame4ConditionProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure Flame4Condition!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(TheTranscendeumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheTranscendeumModVariables.PlayerVariables())).TTEnigmaCharge >= 4) {
			return true;
		}
		return false;
	}
}
