package io.github.team_lodestar.transcendeum.procedures;

import net.minecraft.entity.Entity;

import java.util.Map;

import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class TranscendentRayOnInitialEntitySpawnProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure TranscendentRayOnInitialEntitySpawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("Tick", 21);
	}
}
