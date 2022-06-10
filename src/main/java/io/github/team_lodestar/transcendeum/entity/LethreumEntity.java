
package io.github.team_lodestar.transcendeum.entity;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.block.material.Material;

@TheTranscendeumModElements.ModElement.Tag
public class LethreumEntity extends TheTranscendeumModElements.ModElement {

	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
			.size(2f, 1.7999999999999998f)).build("lethreum").setRegistryName("lethreum");

	public LethreumEntity(TheTranscendeumModElements instance) {
		super(instance, 120);

		FMLJavaModLoadingContext.get().getModEventBus().register(new LethreumRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());

	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);

		elements.items.add(() -> new SpawnEggItem(entity, -6710785, -26113, new Item.Properties().group(TranscendeumMobsItemGroup.tab))
				.setRegistryName("lethreum_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {

	}

	private static class EntityAttributesRegisterHandler {

		@SubscribeEvent
		public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25);
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

		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();

			this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.8));
			this.goalSelector.addGoal(3, new SwimGoal(this));
			this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, ArcedeonEntity.CustomEntity.class, true, true));
			this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, (float) 1024));
			this.targetSelector.addGoal(7, new HurtByTargetGoal(this));

		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.ARTHROPOD;
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

	}

}
