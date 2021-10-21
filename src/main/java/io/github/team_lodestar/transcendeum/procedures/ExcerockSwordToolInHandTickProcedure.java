package io.github.team_lodestar.transcendeum.procedures;

import net.minecraft.entity.Entity;

import java.util.Map;

import io.github.team_lodestar.transcendeum.TheTranscendeumModVariables;
import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class ExcerockSwordToolInHandTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure ExcerockSwordToolInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(TheTranscendeumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheTranscendeumModVariables.PlayerVariables())).DoExcerockAttack) && (!(entity.isOnGround())))) {
			if (((entity.getMotion().getY()) > 0)) {
				entity.setMotion((entity.getMotion().getX()), (-0.7), (entity.getMotion().getZ()));
			}
		}
	}
}
