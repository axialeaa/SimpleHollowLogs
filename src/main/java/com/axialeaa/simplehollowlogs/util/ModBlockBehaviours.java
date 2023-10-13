package com.axialeaa.simplehollowlogs.util;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import static com.axialeaa.simplehollowlogs.world.HollowLogPlacedFeatures.*;
import static com.axialeaa.simplehollowlogs.world.HollowLogPlacedFeatures.FALLEN_WINDSWEPT_FOREST_LOG;
import static net.minecraft.world.biome.BiomeKeys.*;

public class ModBlockBehaviours {

    public static void registerFlammables() {
        FlammableBlockRegistry.getDefaultInstance().add(ModTags.HOLLOW_LOGS_THAT_BURN, 5, 5);
    }

    public static void placeInBiome() {
        createLogFeature(FALLEN_BIRCH_FOREST_LOG, 		BIRCH_FOREST, OLD_GROWTH_BIRCH_FOREST);
        createLogFeature(FALLEN_CHERRY_GROVE_LOG, 		CHERRY_GROVE);
        createLogFeature(FALLEN_DARK_FOREST_LOG, 		DARK_FOREST);
        createLogFeature(FALLEN_FOREST_LOG, 			FOREST, FLOWER_FOREST);
        createLogFeature(FALLEN_JUNGLE_LOG, 			JUNGLE, BAMBOO_JUNGLE);
        createLogFeature(FALLEN_SPARSE_JUNGLE_LOG, 	    SPARSE_JUNGLE);
        createLogFeature(FALLEN_TAIGA_LOG, 			    TAIGA, SNOWY_TAIGA, GROVE, OLD_GROWTH_PINE_TAIGA, OLD_GROWTH_SPRUCE_TAIGA);
        createLogFeature(FALLEN_WINDSWEPT_FOREST_LOG, 	WINDSWEPT_FOREST);
    }

    @SafeVarargs
    public static void createLogFeature(RegistryKey<PlacedFeature> logFeature, RegistryKey<Biome>... biomeKeys) {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(biomeKeys), GenerationStep.Feature.VEGETAL_DECORATION, logFeature);
    }

}
