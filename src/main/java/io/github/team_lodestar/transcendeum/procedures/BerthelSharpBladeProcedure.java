package io.github.team_lodestar.transcendeum.procedures;

import net.minecraftforge.eventbus.api.Event;

public class BerthelSharpBladeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency world for procedure BerthelSharpBlade!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure BerthelSharpBlade!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency sourceentity for procedure BerthelSharpBlade!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency itemstack for procedure BerthelSharpBlade!");
			return;
		}

		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");

		if (EntityTypeTags.getCollection().getTagByID(new ResourceLocation("forge:transcendent_mobs")).contains(entity.getType())) {
			if (Math.random() < 0.25) {
				if (!(new Object() {
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
				}.checkGamemode(sourceentity))) {
					{
						ItemStack _ist = itemstack;
						if (_ist.attemptDamageItem((int) (20 - EnchantmentHelper.getEnchantmentLevel(Enchantments.UNBREAKING, itemstack) * 2),
								new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
					if (sourceentity instanceof LivingEntity) {
						((LivingEntity) sourceentity).attackEntityFrom(new DamageSource("berthelspiked").setDamageBypassesArmor(), (float) 2);
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null,
								new BlockPos((int) (entity.getPosX()), (int) (entity.getPosY() + 1), (int) (entity.getPosZ())),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound((entity.getPosX()), (entity.getPosY() + 1), (entity.getPosZ()),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(SharpBerthelParticle.particle, (entity.getPosX()), (entity.getPosY() + 1),
								(entity.getPosZ()), (int) 12, 0.2, 0.4, 0.2, 0.3);
					}
				}
			}
		}
	}

}
