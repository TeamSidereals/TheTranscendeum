package io.github.team_lodestar.transcendeum.procedures;

public class KiariteToolLivingEntityIsHitWithToolProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure KiariteToolLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency world for procedure KiariteToolLivingEntityIsHitWithTool!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");

		if ((EntityTypeTags.getCollection().getTagByID(new ResourceLocation(("forge:transcendent_mobs").toLowerCase(java.util.Locale.ENGLISH)))
				.contains(entity.getType()))) {
			entity.setMotion((entity.getMotion().getX()), 0.75, (entity.getMotion().getZ()));
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(KiariteExorcismParticle.particle, (entity.getPosX()), ((entity.getPosY()) + 1),
						(entity.getPosZ()), (int) 10, 0.2, 0.4, 0.2, 0.1);
			}
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 4);
		}
	}

}
