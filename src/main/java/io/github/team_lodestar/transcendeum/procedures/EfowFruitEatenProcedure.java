package io.github.team_lodestar.transcendeum.procedures;

import net.minecraft.entity.Entity;

import java.util.Map;

import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class EfowFruitEatenProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure EfowFruitEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.extinguish();
		entity.setAir((int) (entity.getAir() + 100));
		if (entity.getAir() > 250) {
			entity.setAir((int) 250);
		}
	}
}
