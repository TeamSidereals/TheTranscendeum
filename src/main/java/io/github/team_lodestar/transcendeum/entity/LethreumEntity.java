
package io.github.team_lodestar.transcendeum.entity;

import net.minecraft.block.material.Material;

@TheTranscendeumModElements.ModElement.Tag
public class LethreumEntity extends TheTranscendeumModElements.ModElement {

	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
			.size(8f, 1.7999999999999998f)).build("lethreum").setRegistryName("lethreum");

	public LethreumEntity(TheTranscendeumModElements instance) {
		super(instance, 300);

		FMLJavaModLoadingContext.get().getModEventBus().register(new LethreumRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());

		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);

		elements.items.add(() -> new SpawnEggItem(entity, -6710785, -26113, new Item.Properties().group(TranscendeumMobsItemGroup.tab))
				.setRegistryName("lethreum_spawn_egg"));
	}

	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {
		boolean biomeCriteria = false;
		if (new ResourceLocation("the_transcendeum:crystalia_forest").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("the_transcendeum:aurea_forest").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("the_transcendeum:aurea_plains").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("the_transcendeum:viridian_mires").equals(event.getName()))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;

		event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(entity, 100, 1, 1));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);

	}

	private static class EntityAttributesRegisterHandler {

		@SubscribeEvent
		public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.35);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 110);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 10);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 16);

			ammma = ammma.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.5);

			ammma = ammma.createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 1.5);

			event.put(entity, ammma.create());
		}

	}

	public static class CustomEntity extends MonsterEntity {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 15;
			setNoAI(false);

			enablePersistence();

		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();

			this.goalSelector.addGoal(1, new LookAtGoal(this, PlayerEntity.class, (float) 1024));
			this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(4, new RandomWalkingGoal(this, 0.8));
			this.goalSelector.addGoal(5, new LeapAtTargetGoal(this, (float) 0.5));
			this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
			this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, PlayerEntity.class, true, true));

		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof PotionEntity)
				return false;
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			if (source == DamageSource.ANVIL)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public void baseTick() {
			super.baseTick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				LethreumOnEntityTickUpdateProcedure.executeProcedure($_dependencies);
			}
		}

	}

}
