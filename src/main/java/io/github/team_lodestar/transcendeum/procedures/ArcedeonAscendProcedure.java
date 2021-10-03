package io.github.team_lodestar.transcendeum.procedures;

import net.minecraft.entity.Entity;

import java.util.Map;

import io.github.team_lodestar.transcendeum.entity.ArcedeonEntity;
import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class ArcedeonAscendProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure ArcedeonAscend!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getRidingEntity()) instanceof ArcedeonEntity.CustomEntity) == (true))) {
			(entity.getRidingEntity()).getPersistentData().putDouble("TT:ArcedeonVerticalMovement", 1);
		}
	}
}
