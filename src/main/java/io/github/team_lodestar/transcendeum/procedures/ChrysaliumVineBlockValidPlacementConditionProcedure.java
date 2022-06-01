package io.github.team_lodestar.transcendeum.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Map;

import io.github.team_lodestar.transcendeum.block.KelavusBlock;
import io.github.team_lodestar.transcendeum.block.ChrysaliumVineBottomBlock;
import io.github.team_lodestar.transcendeum.block.ChrysaliumVineBlock;
import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class ChrysaliumVineBlockValidPlacementConditionProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency world for procedure ChrysaliumVineBlockValidPlacementCondition!");
			return false;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency x for procedure ChrysaliumVineBlockValidPlacementCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency y for procedure ChrysaliumVineBlockValidPlacementCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency z for procedure ChrysaliumVineBlockValidPlacementCondition!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		return (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == KelavusBlock.block
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == ChrysaliumVineBlock.block
				|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == ChrysaliumVineBottomBlock.block;
	}
}
