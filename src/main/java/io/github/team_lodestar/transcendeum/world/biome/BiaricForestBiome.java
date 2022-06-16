
package io.github.team_lodestar.transcendeum.world.biome;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.gen.trunkplacer.ForkyTrunkPlacer;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.ParticleEffectAmbience;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.Biome;

import io.github.team_lodestar.transcendeum.particle.ViridLightsParticle;
import io.github.team_lodestar.transcendeum.block.ViridwoodLeavesBlock;
import io.github.team_lodestar.transcendeum.block.VerdureBlockBlock;
import io.github.team_lodestar.transcendeum.block.KelaveLogBlock;
import io.github.team_lodestar.transcendeum.block.ExcsoilBlock;
import io.github.team_lodestar.transcendeum.TheTranscendeumModElements;

@TheTranscendeumModElements.ModElement.Tag
public class BiaricForestBiome extends TheTranscendeumModElements.ModElement {
	public static Biome biome;

	public BiaricForestBiome(TheTranscendeumModElements instance) {
		super(instance, 474);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}

	private static class BiomeRegisterHandler {
		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(-10956839).setWaterColor(4159204).setWaterFogColor(329011)
						.withSkyColor(-10956839).withFoliageColor(10387789).withGrassColor(9470285)
						.setParticle(new ParticleEffectAmbience(ViridLightsParticle.particle, 0.006f)).build();
				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
						.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(VerdureBlockBlock.block.getDefaultState(),
								ExcsoilBlock.block.getDefaultState(), ExcsoilBlock.block.getDefaultState())));
				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.TREE
						.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(KelaveLogBlock.block.getDefaultState()),
								new SimpleBlockStateProvider(ViridwoodLeavesBlock.block.getDefaultState()),
								new AcaciaFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0)),
								new ForkyTrunkPlacer(10, 2, 2), new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build())
						.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
						.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(5, 0.1F, 1))));
				DefaultBiomeFeatures.withCavesAndCanyons(biomeGenerationSettings);
				DefaultBiomeFeatures.withLavaAndWaterLakes(biomeGenerationSettings);
				DefaultBiomeFeatures.withForestRocks(biomeGenerationSettings);
				DefaultBiomeFeatures.withForestRocks(biomeGenerationSettings);
				DefaultBiomeFeatures.withForestRocks(biomeGenerationSettings);
				DefaultBiomeFeatures.withForestRocks(biomeGenerationSettings);
				DefaultBiomeFeatures.withForestRocks(biomeGenerationSettings);
				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
				biome = new Biome.Builder().precipitation(Biome.RainType.NONE).category(Biome.Category.FOREST).depth(0.9f).scale(0.1f)
						.temperature(1.6f).downfall(0f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build()).build();
				event.getRegistry().register(biome.setRegistryName("the_transcendeum:biaric_forest"));
			}
		}
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}
}
