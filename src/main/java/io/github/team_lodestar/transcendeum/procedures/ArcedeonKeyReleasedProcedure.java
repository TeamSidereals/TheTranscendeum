package io.github.team_lodestar.transcendeum.procedures;

public class ArcedeonKeyReleasedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure ArcedeonKeyReleased!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if ((((entity.getRidingEntity()) instanceof ArcedeonEntity.CustomEntity) == (true))) {
			(entity.getRidingEntity()).getPersistentData().putDouble("TT:ArcedeonVerticalMovement", 0);
		}
	}

}
