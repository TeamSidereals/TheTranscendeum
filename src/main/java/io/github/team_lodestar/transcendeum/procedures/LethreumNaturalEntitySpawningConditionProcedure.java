package io.github.team_lodestar.transcendeum.procedures;

public class LethreumNaturalEntitySpawningConditionProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {

		if ((Math.random() < 0.02)) {
			return (true);
		}
		return (false);
	}

}
