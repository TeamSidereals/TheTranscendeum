package io.github.team_lodestar.transcendeum.procedures;

import java.util.Map;

public class LethreumNaturalEntitySpawningConditionProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (Math.random() < 0.1) {
			return true;
		}
		return false;
	}
}
