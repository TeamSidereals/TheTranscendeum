package io.github.team_lodestar.transcendeum.procedures;

public class EnigmaGlovePoweredRangedItemUsedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure EnigmaGlovePoweredRangedItemUsed!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency itemstack for procedure EnigmaGlovePoweredRangedItemUsed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency world for procedure EnigmaGlovePoweredRangedItemUsed!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		IWorld world = (IWorld) dependencies.get("world");

		if (((!(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayerEntity) {
					return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
				} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
					NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
							.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
					return _npi != null && _npi.getGameType() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity))) || (TheTranscendeumModVariables.MapVariables.get(world).NoEnigmaCooldown == (false)))) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown(EnigmaGloveItem.block, (int) 150);
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown(EnigmaGlovePoweredItem.block, (int) 150);
		}
		{
			double _setval = (double) 0;
			entity.getCapability(TheTranscendeumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.TTEnigmaCharge = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == (itemstack)
				.getItem())) {
			entity.getPersistentData().putDouble("TT:EnigmaGloveDurability",
					((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getDamage()));
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(EnigmaGloveItem.block);
				_setstack.setCount((int) 1);
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
			(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
					.setDamage((int) (entity.getPersistentData().getDouble("TT:EnigmaGloveDurability")));
		} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == (itemstack)
				.getItem())) {
			entity.getPersistentData().putDouble("TT:EnigmaGloveDurability",
					((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)).getDamage()));
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(EnigmaGloveItem.block);
				_setstack.setCount((int) 1);
				((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
			(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY))
					.setDamage((int) (entity.getPersistentData().getDouble("TT:EnigmaGloveDurability")));
		}
	}

}