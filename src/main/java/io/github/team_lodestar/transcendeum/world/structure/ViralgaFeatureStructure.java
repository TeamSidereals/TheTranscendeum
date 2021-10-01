
package io.github.team_lodestar.transcendeum.world.structure;

@Mod.EventBusSubscriber
public class ViralgaFeatureStructure {

	private static Feature<NoFeatureConfig> feature = null;
	private static ConfiguredFeature<?, ?> configuredFeature = null;

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	private static class FeatureRegisterHandler {

		@SubscribeEvent
		public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
			feature = new Feature<NoFeatureConfig>(NoFeatureConfig.field_236558_a_) {
				@Override
				public boolean generate(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
					int ci = (pos.getX() >> 4) << 4;
					int ck = (pos.getZ() >> 4) << 4;

					RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
					boolean dimensionCriteria = false;

					if (dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("the_transcendeum:transcendeum")))
						dimensionCriteria = true;

					if (!dimensionCriteria)
						return false;

					if ((random.nextInt(1000000) + 1) <= 800000) {
						int count = random.nextInt(3) + 14;
						for (int a = 0; a < count; a++) {
							int i = ci + random.nextInt(16);
							int k = ck + random.nextInt(16);
							int j = world.getHeight(Heightmap.Type.WORLD_SURFACE_WG, i, k);

							j -= 1;

							BlockState blockAt = world.getBlockState(new BlockPos(i, j, k));
							boolean blockCriteria = false;
							if (blockAt.getBlock() == Blocks.WATER)
								blockCriteria = true;
							if (blockAt.getBlock() == Blocks.WATER)
								blockCriteria = true;
							if (!blockCriteria)
								continue;

							Rotation rotation = Rotation.values()[random.nextInt(3)];
							Mirror mirror = Mirror.values()[random.nextInt(2)];

							BlockPos spawnTo = new BlockPos(i + 0, j + 1, k + 0);

							int x = spawnTo.getX();
							int y = spawnTo.getY();
							int z = spawnTo.getZ();

							Template template = world.getWorld().getStructureTemplateManager()
									.getTemplateDefaulted(new ResourceLocation("the_transcendeum", "viralga"));

							if (template == null)
								return false;

							template.func_237144_a_(world, spawnTo,
									new PlacementSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
											.addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK).setChunk(null).setIgnoreEntities(false),
									random);

						}
					}

					return true;
				}
			};

			configuredFeature = feature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
					.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));

			event.getRegistry().register(feature.setRegistryName("viralga_feature"));
			Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("the_transcendeum:viralga_feature"), configuredFeature);
		}

	}

	@SubscribeEvent
	public static void addFeatureToBiomes(BiomeLoadingEvent event) {
		boolean biomeCriteria = false;
		if (new ResourceLocation("the_transcendeum:viridian_mires").equals(event.getName()))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;

		event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> configuredFeature);
	}

}
