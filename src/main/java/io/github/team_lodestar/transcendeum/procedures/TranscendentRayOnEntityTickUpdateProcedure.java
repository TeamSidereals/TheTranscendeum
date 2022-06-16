package io.github.team_lodestar.transcendeum.procedures;

import net.minecraft.world.IWorld;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import io.github.team_lodestar.transcendeum.particle.TranscendentParticleParticle;
import io.github.team_lodestar.transcendeum.particle.TranscendentHoleParticle;
import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class TranscendentRayOnEntityTickUpdateProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency world for procedure TranscendentRayOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency x for procedure TranscendentRayOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency y for procedure TranscendentRayOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency z for procedure TranscendentRayOnEntityTickUpdate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double xRadius = 0;
		double loop = 0;
		double zRadius = 0;
		double particleAmount = 0;
		if (world.isRemote()) {// HOLE
			world.addParticle(TranscendentHoleParticle.particle, x, 230, z, 0, 0, 0);// BEAM

			TranscendentRayBeamingProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", 205),
							new AbstractMap.SimpleEntry<>("z", z))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			// RING
			loop = 0;
			particleAmount = 128;
			xRadius = 40;
			zRadius = 40;
			while (loop < particleAmount) {
				world.addParticle(TranscendentParticleParticle.particle, (x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), 230,
						(z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, 0.05, 0);
				loop = (loop + 1);
			}
		}
	}
}
