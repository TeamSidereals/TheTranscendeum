package io.github.team_lodestar.transcendeum.procedures;

public class EnigmagloveoverlayDisplayOverlayIngameProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure EnigmagloveoverlayDisplayOverlayIngame!");
			return false;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if ((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == EnigmaGloveItem.block)
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == EnigmaGloveItem.block))
				|| ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == EnigmaGlovePoweredItem.block)
						|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem() == EnigmaGlovePoweredItem.block)))) {
			return (true);
		}
		return (false);
	}

}
