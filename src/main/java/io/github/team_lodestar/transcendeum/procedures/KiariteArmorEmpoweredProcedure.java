package io.github.team_lodestar.transcendeum.procedures;

import net.minecraftforge.eventbus.api.Event;

public class KiariteArmorEmpoweredProcedure {

	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityAttacked(LivingAttackEvent event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				Entity sourceentity = event.getSource().getTrueSource();
				Entity imediatesourceentity = event.getSource().getImmediateSource();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				double amount = event.getAmount();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("amount", amount);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("sourceentity", sourceentity);
				dependencies.put("imediatesourceentity", imediatesourceentity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency world for procedure KiariteArmorEmpowered!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency x for procedure KiariteArmorEmpowered!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency y for procedure KiariteArmorEmpowered!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency z for procedure KiariteArmorEmpowered!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure KiariteArmorEmpowered!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency sourceentity for procedure KiariteArmorEmpowered!");
			return;
		}

		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");

		if (EntityTypeTags.getCollection().getTagByID(new ResourceLocation("forge:transcendent_mobs")).contains(sourceentity.getType())) {
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD) : ItemStack.EMPTY)
					.getItem() == KiariteArmorItem.helmet) {
				if (Math.random() < 0.05) {
					sourceentity.setMotion((sourceentity.getMotion().getX()), 0.55, (sourceentity.getMotion().getZ()));
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(KiariteExorcismParticle.particle, (entity.getPosX()), (entity.getPosY() + 1),
								(entity.getPosZ()), (int) 10, 0.2, 0.4, 0.2, 0.1);
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.elder_guardian.curse")),
								SoundCategory.NEUTRAL, (float) 0.5, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.elder_guardian.curse")),
								SoundCategory.NEUTRAL, (float) 0.5, (float) 1, false);
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity)
								.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 2));
					if (dependencies.get("event") != null) {
						Object _obj = dependencies.get("event");
						if (_obj instanceof Event) {
							Event _evt = (Event) _obj;
							if (_evt.isCancelable())
								_evt.setCanceled(true);
						}
					}
				}
			}
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST) : ItemStack.EMPTY)
					.getItem() == KiariteArmorItem.body) {
				if (Math.random() < 0.09) {
					sourceentity.setMotion((sourceentity.getMotion().getX()), 0.55, (sourceentity.getMotion().getZ()));
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(KiariteExorcismParticle.particle, (entity.getPosX()), (entity.getPosY() + 1),
								(entity.getPosZ()), (int) 10, 0.2, 0.4, 0.2, 0.1);
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.elder_guardian.curse")),
								SoundCategory.NEUTRAL, (float) 0.5, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.elder_guardian.curse")),
								SoundCategory.NEUTRAL, (float) 0.5, (float) 1, false);
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity)
								.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 2));
					if (dependencies.get("event") != null) {
						Object _obj = dependencies.get("event");
						if (_obj instanceof Event) {
							Event _evt = (Event) _obj;
							if (_evt.isCancelable())
								_evt.setCanceled(true);
						}
					}
				}
			}
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.LEGS) : ItemStack.EMPTY)
					.getItem() == KiariteArmorItem.legs) {
				if (Math.random() < 0.06) {
					sourceentity.setMotion((sourceentity.getMotion().getX()), 0.55, (sourceentity.getMotion().getZ()));
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(KiariteExorcismParticle.particle, (entity.getPosX()), (entity.getPosY() + 1),
								(entity.getPosZ()), (int) 10, 0.2, 0.4, 0.2, 0.1);
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.elder_guardian.curse")),
								SoundCategory.NEUTRAL, (float) 0.5, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.elder_guardian.curse")),
								SoundCategory.NEUTRAL, (float) 0.5, (float) 1, false);
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity)
								.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 2));
					if (dependencies.get("event") != null) {
						Object _obj = dependencies.get("event");
						if (_obj instanceof Event) {
							Event _evt = (Event) _obj;
							if (_evt.isCancelable())
								_evt.setCanceled(true);
						}
					}
				}
			}
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET) : ItemStack.EMPTY)
					.getItem() == KiariteArmorItem.boots) {
				if (Math.random() < 0.05) {
					sourceentity.setMotion((sourceentity.getMotion().getX()), 0.55, (sourceentity.getMotion().getZ()));
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(KiariteExorcismParticle.particle, (entity.getPosX()), (entity.getPosY() + 1),
								(entity.getPosZ()), (int) 10, 0.2, 0.4, 0.2, 0.1);
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.elder_guardian.curse")),
								SoundCategory.NEUTRAL, (float) 0.5, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.elder_guardian.curse")),
								SoundCategory.NEUTRAL, (float) 0.5, (float) 1, false);
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity)
								.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 2));
					if (dependencies.get("event") != null) {
						Object _obj = dependencies.get("event");
						if (_obj instanceof Event) {
							Event _evt = (Event) _obj;
							if (_evt.isCancelable())
								_evt.setCanceled(true);
						}
					}
				}
			}
		}
	}

}
