package io.github.team_lodestar.transcendeum.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;

import java.util.Map;

import io.github.team_lodestar.transcendeum.particle.ViridInfectionParticle;
import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class ViridianBushEntityIsHurtProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency world for procedure ViridianBushEntityIsHurt!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency x for procedure ViridianBushEntityIsHurt!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency y for procedure ViridianBushEntityIsHurt!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency z for procedure ViridianBushEntityIsHurt!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ViridInfectionParticle.particle, x, y, z, (int) 5, 1, 1, 1, 0.2);
		}
	}
}
