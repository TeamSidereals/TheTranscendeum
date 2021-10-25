package io.github.team_lodestar.transcendeum.procedures;

import java.util.Map;

import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class RemobrenNaturalEntitySpawningConditionProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency y for procedure RemobrenNaturalEntitySpawningCondition!");
			return false;
		}
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		return (y > 100);
	}
}
