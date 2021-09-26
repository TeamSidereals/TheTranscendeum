package io.github.team_lodestar.transcendeum.procedures;

import net.minecraft.entity.Entity;

import java.util.Map;

import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class BubbleTouchGiveAirProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure BubbleTouchGiveAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getAir()) < 251)) {
			entity.setAir((int) ((entity.getAir()) + 2));
		}
	}
}
