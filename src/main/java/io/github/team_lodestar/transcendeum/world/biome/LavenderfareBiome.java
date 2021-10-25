
package io.github.team_lodestar.transcendeum.world.biome;

import net.minecraft.block.material.Material;
import java.util.ArrayList;
import java.util.HashMap;

@TheTranscendeumModElements.ModElement.Tag
public class LavenderfareBiome extends TheTranscendeumModElements.ModElement {

	public static Biome biome;

	public LavenderfareBiome(TheTranscendeumModElements instance) {
		super(instance, 407);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}

	private static class BiomeRegisterHandler {

		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(12638463).setWaterColor(-10066177).setWaterFogColor(-6710785)
						.withSkyColor(7972607).withFoliageColor(10387789).withGrassColor(9470285)
						.setParticle(new ParticleEffectAmbience(EfflyParticle.particle, 0.005f)).build();

				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(
						SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(PurpureanGrassBlockBlock.block.getDefaultState(),
								SombersoilBlock.block.getDefaultState(), SombersoilBlock.block.getDefaultState())));

				DefaultBiomeFeatures.withCavesAndCanyons(biomeGenerationSettings);
				DefaultBiomeFeatures.withOverworldOres(biomeGenerationSettings);
				DefaultBiomeFeatures.withFrozenTopLayer(biomeGenerationSettings);

				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
				mobSpawnInfo.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(HyrumaeGhoulEntity.entity, 20, 4, 4));

				biome = new Biome.Builder().precipitation(Biome.RainType.NONE).category(Biome.Category.FOREST).depth(0.1f).scale(0.2f).temperature(1f)
						.downfall(0f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build()).build();

				event.getRegistry().register(biome.setRegistryName("the_transcendeum:lavenderfare"));
			}
		}

	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeDictionary.addTypes(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(biome)), BiomeDictionary.Type.FOREST);
		BiomeManager.addBiome(BiomeManager.BiomeType.COOL,
				new BiomeManager.BiomeEntry(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(biome)), 100));
	}

}
