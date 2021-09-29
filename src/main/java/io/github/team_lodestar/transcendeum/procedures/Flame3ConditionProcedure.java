package io.github.team_lodestar.transcendeum.procedures;

public class Flame3ConditionProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure Flame3Condition!");
			return false;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if ((((entity.getCapability(TheTranscendeumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheTranscendeumModVariables.PlayerVariables())).TTEnigmaCharge) >= 3)) {
			return (true);
		}
		return (false);
	}

}
