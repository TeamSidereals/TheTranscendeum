package io.github.team_lodestar.transcendeum.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import io.github.team_lodestar.transcendeum.TheTranscendeumModVariables;
import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class NoEnigmaGloveCooldownCommandExecutedProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure NoEnigmaGloveCooldownCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((TheTranscendeumModVariables.NoEnigmaCooldown == (false))) {
			TheTranscendeumModVariables.NoEnigmaCooldown = (boolean) (true);
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("No global Enigma glove Cooldown is now set to true."), (false));
			}
		} else if ((TheTranscendeumModVariables.NoEnigmaCooldown == (true))) {
			TheTranscendeumModVariables.NoEnigmaCooldown = (boolean) (false);
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("No global Enigma glove Cooldown is now set to false."), (false));
			}
		}
	}
}
