package io.github.team_lodestar.transcendeum.procedures;

public class ExcerockSwordToolInHandTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure ExcerockSwordToolInHandTick!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if ((((entity.getCapability(TheTranscendeumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheTranscendeumModVariables.PlayerVariables())).DoExcerockAttack)
				&& ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false))) {
			if ((((PlayerEntity) entity).abilities.isFlying)) {
				(((PlayerEntity) entity).abilities.isFlying) = false;
			}
		}
	}

}
