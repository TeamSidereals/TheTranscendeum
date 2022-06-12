package io.github.team_lodestar.transcendeum.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Map;

import io.github.team_lodestar.transcendeum.particle.TranscendentParticleParticle;
import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class TranscendentRayBeamingProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency world for procedure TranscendentRayBeaming!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency x for procedure TranscendentRayBeaming!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency y for procedure TranscendentRayBeaming!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency z for procedure TranscendentRayBeaming!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double descent = 0;
		descent = 0;
		for (int index0 = 0; index0 < (int) (512); index0++) {
			descent = (descent + 0.25);
			if (!world.getBlockState(new BlockPos((int) x, (int) (y - descent), (int) z)).isSolid()) {
				world.addParticle(TranscendentParticleParticle.particle, x, (y - descent), z, 0, 0, 0);
			} else {
				break;
			}
		}
	}
}
