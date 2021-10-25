package io.github.team_lodestar.transcendeum.procedures;

public class RemobrenOnInitialEntitySpawnProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure RemobrenOnInitialEntitySpawn!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		entity.getPersistentData().putBoolean("Active", (false));
	}

}
