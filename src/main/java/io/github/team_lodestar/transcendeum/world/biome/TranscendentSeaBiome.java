
package io.github.team_lodestar.transcendeum.world.biome;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.Biome;
import net.minecraft.entity.EntityClassification;

import io.github.team_lodestar.transcendeum.entity.PiscesEntity;
import io.github.team_lodestar.transcendeum.entity.ArcedeonEntity;
import io.github.team_lodestar.transcendeum.block.SomberstoneBlock;
import io.github.team_lodestar.transcendeum.block.SombersoilBlock;
import io.github.team_lodestar.transcendeum.TheTranscendeumModElements;

@TheTranscendeumModElements.ModElement.Tag
public class TranscendentSeaBiome extends TheTranscendeumModElements.ModElement {
	public static Biome biome;
	public TranscendentSeaBiome(TheTranscendeumModElements instance) {
		super(instance, 24);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}
	private static class BiomeRegisterHandler {
		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(-10581628).setWaterColor(-10357817).setWaterFogColor(329011)
						.withSkyColor(-10581628).withFoliageColor(10387789).withGrassColor(-10132655).build();
				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
						.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(SombersoilBlock.block.getDefaultState(),
								SomberstoneBlock.block.getDefaultState(), SomberstoneBlock.block.getDefaultState())));
				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
				mobSpawnInfo.withSpawner(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(ArcedeonEntity.entity, 35, 1, 2));
				mobSpawnInfo.withSpawner(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(PiscesEntity.entity, 75, 3, 7));
				biome = new Biome.Builder().precipitation(Biome.RainType.NONE).category(Biome.Category.OCEAN).depth(-0.8f).scale(0.1f)
						.temperature(0.5f).downfall(0f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build()).build();
				event.getRegistry().register(biome.setRegistryName("the_transcendeum:transcendent_sea"));
			}
		}
	}
	@Override
	public void init(FMLCommonSetupEvent event) {
	}
}
