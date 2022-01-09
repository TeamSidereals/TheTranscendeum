package io.github.team_lodestar.transcendeum.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;

import java.util.Map;

import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class BorderSpikesAdditionalGenerationConditionProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency world for procedure BorderSpikesAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency x for procedure BorderSpikesAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency y for procedure BorderSpikesAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency z for procedure BorderSpikesAdditionalGenerationCondition!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		boolean divine = false;
		boolean fervent = false;
		boolean golden = false;
		boolean preperpetual = false;
		boolean perpetual = false;
		boolean adjdivine = false;
		boolean adjfervent = false;
		boolean adjgolden = false;
		boolean adjpreperpetual = false;
		boolean adjperpetual = false;
		if (world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
				&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
						.equals(new ResourceLocation("the_transcendeum:sullen_cliffs"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
								.equals(new ResourceLocation("the_transcendeum:sullen_desert"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
								.equals(new ResourceLocation("the_transcendeum:sullen_canyon"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
								.equals(new ResourceLocation("the_transcendeum:kalaisic_wastes"))) {
			fervent = (true);
		} else if (world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
				&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
						.equals(new ResourceLocation("the_transcendeum:viridian_mires"))) {
			golden = (true);
		} else if (world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
				&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
						.equals(new ResourceLocation("the_transcendeum:lavender_fare"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
								.equals(new ResourceLocation("the_transcendeum:crystalia_forest"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
								.equals(new ResourceLocation("the_transcendeum:aurea_forest"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
								.equals(new ResourceLocation("the_transcendeum:aurea_plains"))) {
			preperpetual = (true);
		} else if (world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
				&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
						.equals(new ResourceLocation("the_transcendeum:salt_lowlands"))) {
			perpetual = (true);
		}
		if (world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x + 3), (int) y, (int) z))) != null
				&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x + 3), (int) y, (int) z)))
						.equals(new ResourceLocation("the_transcendeum:sullen_cliffs"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x - 3), (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x - 3), (int) y, (int) z)))
								.equals(new ResourceLocation("the_transcendeum:sullen_cliffs"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z + 3)))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z + 3))))
								.equals(new ResourceLocation("the_transcendeum:sullen_cliffs"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z - 3)))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z - 3))))
								.equals(new ResourceLocation("the_transcendeum:sullen_cliffs"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x + 3), (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x + 3), (int) y, (int) z)))
								.equals(new ResourceLocation("the_transcendeum:sullen_canyon"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x - 3), (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x - 3), (int) y, (int) z)))
								.equals(new ResourceLocation("the_transcendeum:sullen_canyon"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z + 3)))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z + 3))))
								.equals(new ResourceLocation("the_transcendeum:sullen_canyon"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z - 3)))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z - 3))))
								.equals(new ResourceLocation("the_transcendeum:sullen_canyon"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x + 3), (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x + 3), (int) y, (int) z)))
								.equals(new ResourceLocation("the_transcendeum:sullen_desert"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x - 3), (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x - 3), (int) y, (int) z)))
								.equals(new ResourceLocation("the_transcendeum:sullen_desert"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z + 3)))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z + 3))))
								.equals(new ResourceLocation("the_transcendeum:sullen_desert"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z - 3)))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z - 3))))
								.equals(new ResourceLocation("the_transcendeum:sullen_desert"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x + 3), (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x + 3), (int) y, (int) z)))
								.equals(new ResourceLocation("the_transcendeum:kalaisic_wastes"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x - 3), (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x - 3), (int) y, (int) z)))
								.equals(new ResourceLocation("the_transcendeum:kalaisic_wastes"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z + 3)))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z + 3))))
								.equals(new ResourceLocation("the_transcendeum:kalaisic_wastes"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z - 3)))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z - 3))))
								.equals(new ResourceLocation("the_transcendeum:kalaisic_wastes"))) {
			adjfervent = (true);
		} else if (world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x + 3), (int) y, (int) z))) != null
				&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x + 3), (int) y, (int) z)))
						.equals(new ResourceLocation("the_transcendeum:viridian_mires"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x - 3), (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x - 3), (int) y, (int) z)))
								.equals(new ResourceLocation("the_transcendeum:viridian_mires"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z + 3)))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z + 3))))
								.equals(new ResourceLocation("the_transcendeum:viridian_mires"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z - 3)))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z - 3))))
								.equals(new ResourceLocation("the_transcendeum:viridian_mires"))) {
			adjgolden = (true);
		} else if (world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x + 3), (int) y, (int) z))) != null
				&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x + 3), (int) y, (int) z)))
						.equals(new ResourceLocation("the_transcendeum:lavender_fare"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x - 3), (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x - 3), (int) y, (int) z)))
								.equals(new ResourceLocation("the_transcendeum:lavender_fare"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z + 3)))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z + 3))))
								.equals(new ResourceLocation("the_transcendeum:lavender_fare"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z - 3)))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z - 3))))
								.equals(new ResourceLocation("the_transcendeum:lavender_fare"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x + 3), (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x + 3), (int) y, (int) z)))
								.equals(new ResourceLocation("the_transcendeum:crystalia_forest"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x - 3), (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x - 3), (int) y, (int) z)))
								.equals(new ResourceLocation("the_transcendeum:crystalia_forest"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z + 3)))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z + 3))))
								.equals(new ResourceLocation("the_transcendeum:crystalia_forest"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z - 3)))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z - 3))))
								.equals(new ResourceLocation("the_transcendeum:crystalia_forest"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x + 3), (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x + 3), (int) y, (int) z)))
								.equals(new ResourceLocation("the_transcendeum:aurea_forest"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x - 3), (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x - 3), (int) y, (int) z)))
								.equals(new ResourceLocation("the_transcendeum:aurea_forest"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z + 3)))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z + 3))))
								.equals(new ResourceLocation("the_transcendeum:aurea_forest"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z - 3)))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z - 3))))
								.equals(new ResourceLocation("the_transcendeum:aurea_forest"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x + 3), (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x + 3), (int) y, (int) z)))
								.equals(new ResourceLocation("the_transcendeum:aurea_plains"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x - 3), (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x - 3), (int) y, (int) z)))
								.equals(new ResourceLocation("the_transcendeum:aurea_plains"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z + 3)))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z + 3))))
								.equals(new ResourceLocation("the_transcendeum:aurea_plains"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z - 3)))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z - 3))))
								.equals(new ResourceLocation("the_transcendeum:aurea_plains"))) {
			adjpreperpetual = (true);
		} else if (world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x + 3), (int) y, (int) z))) != null
				&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x + 3), (int) y, (int) z)))
						.equals(new ResourceLocation("the_transcendeum:salt_lowlands"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x - 3), (int) y, (int) z))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) (x - 3), (int) y, (int) z)))
								.equals(new ResourceLocation("the_transcendeum:salt_lowlands"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z + 3)))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z + 3))))
								.equals(new ResourceLocation("the_transcendeum:salt_lowlands"))
				|| world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z - 3)))) != null
						&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) (z - 3))))
								.equals(new ResourceLocation("the_transcendeum:salt_lowlands"))) {
			adjperpetual = (true);
		}
		return !(fervent == adjfervent) || !(golden == adjgolden) || !(adjpreperpetual == adjpreperpetual) || !(adjperpetual == adjperpetual);
	}
}
