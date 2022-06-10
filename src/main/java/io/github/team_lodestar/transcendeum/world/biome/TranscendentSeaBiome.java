
package io.github.team_lodestar.transcendeum.world.biome;

import net.minecraftforge.common.BiomeManager;
import net.minecraft.block.material.Material;
import java.util.ArrayList;
import java.util.HashMap;

@TheTranscendeumModElements.ModElement.Tag
public class TranscendentSeaBiome extends TheTranscendeumModElements.ModElement {

	public static Biome biome;

	public TranscendentSeaBiome(TheTranscendeumModElements instance) {
		super(instance, 171);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}

	private static class BiomeRegisterHandler {

		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(-10581628).setWaterColor(-10357817).setWaterFogColor(329011)
						.withSkyColor(-10581628).withFoliageColor(10387789).withGrassColor(-10132655).build();

				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(
						SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(SullenSandstoneBlock.block.getDefaultState(),
								SomberstoneBlock.block.getDefaultState(), SomberstoneBlock.block.getDefaultState())));

				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();

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
