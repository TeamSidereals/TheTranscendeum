package io.github.team_lodestar.transcendeum.world.gen.mixcode;

import io.github.team_lodestar.transcendeum.world.biome.AureaForestBiome;
import io.github.team_lodestar.transcendeum.world.biome.AureaPlainsBiome;
import io.github.team_lodestar.transcendeum.world.structure.mixcode.MixCodeStructureRegister;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class MixCodeStructureGeneration {

    public static void generateStructures(final BiomeLoadingEvent event) {
        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
        if (key.getLocation().equals(AureaPlainsBiome.biome.getRegistryName())){
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> MixCodeStructureRegister.BIG_KELAVE_TREE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
    }
}
