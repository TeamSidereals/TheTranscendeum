package io.github.team_lodestar.transcendeum.procedures;

public class Flame1ConditionProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure Flame1Condition!");
			return false;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if ((((entity.getCapability(TheTranscendeumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheTranscendeumModVariables.PlayerVariables())).TTEnigmaCharge) >= 1)) {
			return (true);
		}
		return (false);
	}

}
