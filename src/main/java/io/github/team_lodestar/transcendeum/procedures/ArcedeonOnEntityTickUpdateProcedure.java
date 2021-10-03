package io.github.team_lodestar.transcendeum.procedures;

import net.minecraft.entity.Entity;

import java.util.Map;

import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class ArcedeonOnEntityTickUpdateProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure ArcedeonOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getPersistentData().getDouble("TT:ArcedeonVerticalMovement")) == 1) && (entity.isInWater()))) {
			entity.setMotion((entity.getMotion().getX()), 0.3, (entity.getMotion().getZ()));
		} else if (((entity.getPersistentData().getDouble("TT:ArcedeonVerticalMovement")) == (-1))) {
			entity.setMotion((entity.getMotion().getX()), (-0.3), (entity.getMotion().getZ()));
		}
	}
}
