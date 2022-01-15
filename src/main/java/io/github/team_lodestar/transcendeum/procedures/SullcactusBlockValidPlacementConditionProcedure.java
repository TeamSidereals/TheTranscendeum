package io.github.team_lodestar.transcendeum.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Map;

import io.github.team_lodestar.transcendeum.block.SullenSandBlock;
import io.github.team_lodestar.transcendeum.block.SullcactusBlock;
import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class SullcactusBlockValidPlacementConditionProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency world for procedure SullcactusBlockValidPlacementCondition!");
			return false;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency x for procedure SullcactusBlockValidPlacementCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency y for procedure SullcactusBlockValidPlacementCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency z for procedure SullcactusBlockValidPlacementCondition!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		return (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == SullenSandBlock.block
				|| (world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == SullcactusBlock.block
				|| (world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == SullcactusBlock.block
				|| (world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == SullcactusBlock.block
				|| (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == SullcactusBlock.block
				|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == SullcactusBlock.block
				|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == SullcactusBlock.block;
	}
}
