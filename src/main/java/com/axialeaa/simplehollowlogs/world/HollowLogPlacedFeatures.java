package com.axialeaa.simplehollowlogs.world;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.PlacedFeature;

/**
 * Registry for all hollow log features.
 */
public class HollowLogPlacedFeatures {

    public static final RegistryKey<PlacedFeature> FALLEN_BIRCH_FOREST_LOG = registerKey("fallen_birch_forest_log");
    public static final RegistryKey<PlacedFeature> FALLEN_CHERRY_GROVE_LOG = registerKey("fallen_cherry_grove_log");
    public static final RegistryKey<PlacedFeature> FALLEN_DARK_FOREST_LOG = registerKey("fallen_dark_forest_log");
    public static final RegistryKey<PlacedFeature> FALLEN_FOREST_LOG = registerKey("fallen_forest_log");
    public static final RegistryKey<PlacedFeature> FALLEN_JUNGLE_LOG = registerKey("fallen_jungle_log");
    public static final RegistryKey<PlacedFeature> FALLEN_SPARSE_JUNGLE_LOG = registerKey("fallen_sparse_jungle_log");
    public static final RegistryKey<PlacedFeature> FALLEN_TAIGA_LOG = registerKey("fallen_taiga_log");
    public static final RegistryKey<PlacedFeature> FALLEN_WINDSWEPT_FOREST_LOG = registerKey("fallen_windswept_forest_log");

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("axialeaa", name));
    }

}
