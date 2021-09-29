package io.github.team_lodestar.transcendeum.procedures;

public class NoEnigmaGloveCooldownCommandExecutedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure NoEnigmaGloveCooldownCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency world for procedure NoEnigmaGloveCooldownCommandExecuted!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");

		if ((TheTranscendeumModVariables.MapVariables.get(world).NoEnigmaCooldown == (false))) {
			TheTranscendeumModVariables.MapVariables.get(world).NoEnigmaCooldown = (boolean) (true);
			TheTranscendeumModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("No global Enigma glove Cooldown is now set to true."), (false));
			}
		} else if ((TheTranscendeumModVariables.MapVariables.get(world).NoEnigmaCooldown == (true))) {
			TheTranscendeumModVariables.MapVariables.get(world).NoEnigmaCooldown = (boolean) (false);
			TheTranscendeumModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("No global Enigma glove Cooldown is now set to false."), (false));
			}
		}
	}

}
