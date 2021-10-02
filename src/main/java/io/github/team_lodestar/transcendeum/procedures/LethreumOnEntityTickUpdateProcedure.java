package io.github.team_lodestar.transcendeum.procedures;

import net.minecraft.entity.Entity;

import java.util.Map;

import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class LethreumOnEntityTickUpdateProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure LethreumOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.isInWater())) {
			entity.setMotion((Math.sin(Math.toRadians(((entity.rotationYaw) + 180))) - 1),
					(Math.sin(Math.toRadians((0 - (entity.rotationPitch)))) + 0.4), (Math.cos(Math.toRadians((entity.rotationYaw))) - 1));
		}
	}
}
