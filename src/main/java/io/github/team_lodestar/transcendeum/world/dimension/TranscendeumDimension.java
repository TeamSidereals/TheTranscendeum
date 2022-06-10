
package io.github.team_lodestar.transcendeum.world.dimension;

import net.minecraft.block.material.Material;

@TheTranscendeumModElements.ModElement.Tag
public class TranscendeumDimension extends TheTranscendeumModElements.ModElement {

	@ObjectHolder("the_transcendeum:transcendeum_portal")
	public static final CustomPortalBlock portal = null;

	public TranscendeumDimension(TheTranscendeumModElements instance) {
		super(instance, 1);

		FMLJavaModLoadingContext.get().getModEventBus().register(new POIRegisterHandler());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		Set<Block> replaceableBlocks = new HashSet<>();
		replaceableBlocks.add(ExcerockBlock.block);

		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:sullen_cliffs")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:sullen_cliffs")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:aurea_forest")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:aurea_forest")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:lavender_fare")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:lavender_fare")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:viridian_mires")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:viridian_mires")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:kalaisic_wastes")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:kalaisic_wastes")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:salt_lowlands")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:salt_lowlands")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:sullen_desert")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:sullen_desert")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:transcendent_sea")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:transcendent_sea")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:transcendent_ocean")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:transcendent_ocean")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:aurea_plains")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:aurea_plains")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:crystalia_forest")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:crystalia_forest")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:sullen_canyon")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("the_transcendeum:sullen_canyon")).getGenerationSettings()
				.getSurfaceBuilder().get().getConfig().getUnder().getBlock());

		DeferredWorkQueue.runLater(() -> {
			try {
				ObfuscationReflectionHelper.setPrivateValue(WorldCarver.class, WorldCarver.CAVE, new ImmutableSet.Builder<Block>()
						.addAll((Set<Block>) ObfuscationReflectionHelper.getPrivateValue(WorldCarver.class, WorldCarver.CAVE, "field_222718_j"))
						.addAll(replaceableBlocks).build(), "field_222718_j");

				ObfuscationReflectionHelper.setPrivateValue(WorldCarver.class, WorldCarver.CANYON, new ImmutableSet.Builder<Block>()
						.addAll((Set<Block>) ObfuscationReflectionHelper.getPrivateValue(WorldCarver.class, WorldCarver.CANYON, "field_222718_j"))
						.addAll(replaceableBlocks).build(), "field_222718_j");
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		DimensionRenderInfo customEffect = new DimensionRenderInfo(128, true, DimensionRenderInfo.FogType.NORMAL, false, false) {

			@Override
			public Vector3d func_230494_a_(Vector3d color, float sunHeight) {
				return color.mul(sunHeight * 0.94 + 0.06, sunHeight * 0.94 + 0.06, sunHeight * 0.91 + 0.09);
			}

			@Override
			public boolean func_230493_a_(int x, int y) {
				return false;
			}

		};

		DeferredWorkQueue.runLater(() -> {
			try {
				Object2ObjectMap<ResourceLocation, DimensionRenderInfo> effectsRegistry = (Object2ObjectMap<ResourceLocation, DimensionRenderInfo>) ObfuscationReflectionHelper
						.getPrivateValue(DimensionRenderInfo.class, null, "field_239208_a_");
				effectsRegistry.put(new ResourceLocation("the_transcendeum:transcendeum"), customEffect);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		RenderTypeLookup.setRenderLayer(portal, RenderType.getTranslucent());
	}

	private static PointOfInterestType poi = null;
	public static final TicketType<BlockPos> CUSTOM_PORTAL = TicketType.create("transcendeum_portal", Vector3i::compareTo, 300);

	public static class POIRegisterHandler {
		@SubscribeEvent
		public void registerPointOfInterest(RegistryEvent.Register<PointOfInterestType> event) {
			poi = new PointOfInterestType("transcendeum_portal", Sets.newHashSet(ImmutableSet.copyOf(portal.getStateContainer().getValidStates())), 0,
					1).setRegistryName("transcendeum_portal");
			ForgeRegistries.POI_TYPES.register(poi);
		}
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomPortalBlock());
		elements.items.add(() -> new TranscendeumItem().setRegistryName("transcendeum"));
	}

	public static class CustomPortalBlock extends NetherPortalBlock {

		public CustomPortalBlock() {
			super(Block.Properties.create(Material.PORTAL).doesNotBlockMovement().tickRandomly().hardnessAndResistance(-1.0F).sound(SoundType.GLASS)
					.setLightLevel(s -> 15).noDrops());
			setRegistryName("transcendeum_portal");
		}

		@Override
		public void tick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		}

		@Override
		public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		}

		public void portalSpawn(World world, BlockPos pos) {
			Optional<CustomPortalSize> optional = CustomPortalSize.func_242964_a(world, pos, Direction.Axis.X);
			if (optional.isPresent()) {
				optional.get().placePortalBlocks();
			}
		}

		@Override /* failed to load code for net.minecraft.block.NetherPortalBlock */

		@OnlyIn(Dist.CLIENT)
		@Override
		public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
			for (int i = 0; i < 4; i++) {
				double px = pos.getX() + random.nextFloat();
				double py = pos.getY() + random.nextFloat();
				double pz = pos.getZ() + random.nextFloat();
				double vx = (random.nextFloat() - 0.5) / 2.;
				double vy = (random.nextFloat() - 0.5) / 2.;
				double vz = (random.nextFloat() - 0.5) / 2.;
				int j = random.nextInt(4) - 1;
				if (world.getBlockState(pos.west()).getBlock() != this && world.getBlockState(pos.east()).getBlock() != this) {
					px = pos.getX() + 0.5 + 0.25 * j;
					vx = random.nextFloat() * 2 * j;
				} else {
					pz = pos.getZ() + 0.5 + 0.25 * j;
					vz = random.nextFloat() * 2 * j;
				}
				world.addParticle(ParticleTypes.ENCHANTED_HIT, px, py, pz, vx, vy, vz);
			}

			if (random.nextInt(110) == 0)
				world.playSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(("block.portal.ambient"))),
						SoundCategory.BLOCKS, 0.5f, random.nextFloat() * 0.4F + 0.8F, false);
		}

		@Override
		public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
			if (!entity.isPassenger() && !entity.isBeingRidden() && entity.isNonBoss() && !entity.world.isRemote && true) {
				if (entity.func_242280_ah()) {
					entity.func_242279_ag();
				} else if (entity.world.getDimensionKey() != RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
						new ResourceLocation("the_transcendeum:transcendeum"))) {
					entity.func_242279_ag();
					teleportToDimension(entity, pos,
							RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("the_transcendeum:transcendeum")));
				} else {
					entity.func_242279_ag();
					teleportToDimension(entity, pos, World.OVERWORLD);
				}
			}
		}

		private void teleportToDimension(Entity entity, BlockPos pos, RegistryKey<World> destinationType) {
			entity.changeDimension(entity.getServer().getWorld(destinationType),
					new TeleporterDimensionMod(entity.getServer().getWorld(destinationType), pos));
		}

	}

public static class CustomPortalSize /* failed to load code for net.minecraft.block.CustomPortalSize */

public static class TeleporterDimensionMod implements ITeleporter {

	private final ServerWorld world;
	private final BlockPos entityEnterPos;

	public TeleporterDimensionMod(ServerWorld worldServer, BlockPos entityEnterPos) {
		this.world = worldServer;
		this.entityEnterPos = entityEnterPos;
	}

	/* failed to load code for net.minecraft.world.Teleporter */

	/* failed to load code for net.minecraft.world.Teleporter */

	/* failed to load code for net.minecraft.world.Teleporter */

	@Override
	public Entity placeEntity(Entity entity, ServerWorld serverworld, ServerWorld server, float yaw,
			Function<Boolean, Entity> repositionEntity) {
		PortalInfo portalinfo = getPortalInfo(entity, server);

		if (entity instanceof ServerPlayerEntity) {
			entity.setWorld(server);
			server.addDuringPortalTeleport((ServerPlayerEntity) entity);

			entity.rotationYaw = portalinfo.rotationYaw % 360.0F;
			entity.rotationPitch = portalinfo.rotationPitch % 360.0F;

			entity.moveForced(portalinfo.pos.x, portalinfo.pos.y, portalinfo.pos.z);

			return entity;
		} else {
			Entity entityNew = entity.getType().create(server);
			if (entityNew != null) {
				entityNew.copyDataFromOld(entity);
				entityNew.setLocationAndAngles(portalinfo.pos.x, portalinfo.pos.y, portalinfo.pos.z,
						portalinfo.rotationYaw, entityNew.rotationPitch);
				entityNew.setMotion(portalinfo.motion);
				server.addFromAnotherDimension(entityNew);
			}
			return entityNew;
		}
	}

	private PortalInfo getPortalInfo(Entity entity, ServerWorld server) {
		WorldBorder worldborder = server.getWorldBorder();
		double d0 = Math.max(-2.9999872E7D, worldborder.minX() + 16.);
		double d1 = Math.max(-2.9999872E7D, worldborder.minZ() + 16.);
		double d2 = Math.min(2.9999872E7D, worldborder.maxX() - 16.);
		double d3 = Math.min(2.9999872E7D, worldborder.maxZ() - 16.);
		double d4 = DimensionType.getCoordinateDifference(entity.world.getDimensionType(), server.getDimensionType());
		BlockPos blockpos1 = new BlockPos(MathHelper.clamp(entity.getPosX() * d4, d0, d2), entity.getPosY(),
				MathHelper.clamp(entity.getPosZ() * d4, d1, d3));
		return this.getPortalRepositioner(entity, blockpos1).map(repositioner -> {
			BlockState blockstate = entity.world.getBlockState(this.entityEnterPos);
			Direction.Axis direction$axis;
			Vector3d vector3d;

			if (blockstate.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
				direction$axis = blockstate.get(BlockStateProperties.HORIZONTAL_AXIS);
				TeleportationRepositioner.Result teleportationrepositioner$result = TeleportationRepositioner
						.findLargestRectangle(this.entityEnterPos, direction$axis, 21, Direction.Axis.Y, 21,
								pos -> entity.world.getBlockState(pos) == blockstate);
				vector3d = CustomPortalSize.func_242973_a(teleportationrepositioner$result, direction$axis, entity.getPositionVec(), entity.getSize(entity.getPose()));
			} else {
				direction$axis = Direction.Axis.X;
				vector3d = new Vector3d(0.5, 0, 0);
			}

			return CustomPortalSize.func_242963_a(server, repositioner, direction$axis, vector3d, entity.getSize(entity.getPose()),
							entity.getMotion(), entity.rotationYaw, entity.rotationPitch);
		}).orElse(new PortalInfo(entity.getPositionVec(), Vector3d.ZERO, entity.rotationYaw, entity.rotationPitch));
	}

	protected Optional<TeleportationRepositioner.Result> getPortalRepositioner(Entity entity, BlockPos pos) {
		Optional<TeleportationRepositioner.Result> optional = this.getExistingPortal(pos, false);

		if (entity instanceof ServerPlayerEntity) {
			if (optional.isPresent()) {
				return optional;
			} else {
				Direction.Axis direction$axis = entity.world.getBlockState(this.entityEnterPos).func_235903_d_(NetherPortalBlock.AXIS).orElse(Direction.Axis.X);
				return this.makePortal(pos, direction$axis);
			}
		} else {
			return optional;
		}
	}

}


}
