package io.github.team_lodestar.transcendeum.procedures;

public class BerthelArmorSharpProcedure {

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
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure BerthelArmorSharp!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency sourceentity for procedure BerthelArmorSharp!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency world for procedure BerthelArmorSharp!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		IWorld world = (IWorld) dependencies.get("world");

		if ((EntityTypeTags.getCollection().getTagByID(new ResourceLocation(("forge:transcendent_mobs").toLowerCase(java.util.Locale.ENGLISH)))
				.contains(sourceentity.getType()))) {
			if ((((((entity instanceof LivingEntity)
					? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
					: ItemStack.EMPTY).getItem() == BerthelArmorItem.helmet)
					&& (((entity instanceof LivingEntity)
							? ((LivingEntity) entity)
									.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
							: ItemStack.EMPTY).getItem() == BerthelArmorItem.body))
					&& ((((entity instanceof LivingEntity)
							? ((LivingEntity) entity)
									.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
							: ItemStack.EMPTY).getItem() == BerthelArmorItem.legs)
							&& (((entity instanceof LivingEntity)
									? ((LivingEntity) entity)
											.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
									: ItemStack.EMPTY).getItem() == BerthelArmorItem.boots)))) {
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) (entity.getPosX()), (int) ((entity.getPosY()) + 1), (int) (entity.getPosZ())),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound((entity.getPosX()), ((entity.getPosY()) + 1), (entity.getPosZ()),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(SharpBerthelParticle.particle, (entity.getPosX()), ((entity.getPosY()) + 1),
							(entity.getPosZ()), (int) 12, 0.2, 0.4, 0.2, 0.3);
				}
			}
			if ((((entity instanceof LivingEntity)
					? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
					: ItemStack.EMPTY).getItem() == BerthelArmorItem.helmet)) {
				if ((Math.random() < 0.7)) {
					if (sourceentity instanceof LivingEntity) {
						((LivingEntity) sourceentity).attackEntityFrom(new DamageSource("berthelspiked").setDamageBypassesArmor(), (float) 1);
					}
				}
			}
			if ((((entity instanceof LivingEntity)
					? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
					: ItemStack.EMPTY).getItem() == BerthelArmorItem.body)) {
				if ((Math.random() < 0.7)) {
					if (sourceentity instanceof LivingEntity) {
						((LivingEntity) sourceentity).attackEntityFrom(new DamageSource("berthelspiked").setDamageBypassesArmor(), (float) 1);
					}
				}
			}
			if ((((entity instanceof LivingEntity)
					? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
					: ItemStack.EMPTY).getItem() == BerthelArmorItem.legs)) {
				if ((Math.random() < 0.7)) {
					if (sourceentity instanceof LivingEntity) {
						((LivingEntity) sourceentity).attackEntityFrom(new DamageSource("berthelspiked").setDamageBypassesArmor(), (float) 1);
					}
				}
			}
			if ((((entity instanceof LivingEntity)
					? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
					: ItemStack.EMPTY).getItem() == BerthelArmorItem.boots)) {
				if ((Math.random() < 0.7)) {
					if (sourceentity instanceof LivingEntity) {
						((LivingEntity) sourceentity).attackEntityFrom(new DamageSource("berthelspiked").setDamageBypassesArmor(), (float) 1);
					}
				}
			}
		}
	}

}
