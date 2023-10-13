package com.axialeaa.simplehollowlogs;

import com.axialeaa.simplehollowlogs.block.ModBlocks;
import com.axialeaa.simplehollowlogs.block.ModItemGroups;
import com.axialeaa.simplehollowlogs.util.ModBlockBehaviours;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.axialeaa.simplehollowlogs.world.HollowLogPlacedFeatures.*;
import static net.minecraft.world.biome.BiomeKeys.*;

public class SimpleHollowLogs implements ModInitializer {
	public static final String MOD_ID = "simple-hollow-logs";
	public static final String MOD_NAME = "Simple Hollow Logs";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();
		ModBlockBehaviours.registerFlammables();
		ModBlocks.onClassInitialized();

		addLogFeature(FALLEN_BIRCH_FOREST_LOG, 		BIRCH_FOREST, OLD_GROWTH_BIRCH_FOREST);
		addLogFeature(FALLEN_CHERRY_GROVE_LOG, 		CHERRY_GROVE);
		addLogFeature(FALLEN_DARK_FOREST_LOG, 		DARK_FOREST);
		addLogFeature(FALLEN_FOREST_LOG, 			FOREST, FLOWER_FOREST);
		addLogFeature(FALLEN_JUNGLE_LOG, 			JUNGLE, BAMBOO_JUNGLE);
		addLogFeature(FALLEN_SPARSE_JUNGLE_LOG, 	SPARSE_JUNGLE);
		addLogFeature(FALLEN_TAIGA_LOG, 			TAIGA, SNOWY_TAIGA, GROVE, OLD_GROWTH_PINE_TAIGA, OLD_GROWTH_SPRUCE_TAIGA);
		addLogFeature(FALLEN_WINDSWEPT_FOREST_LOG, 	WINDSWEPT_FOREST);

		LOGGER.info(MOD_NAME + " initialized. That's all you need to know. This is a hollow logger.");
	}

	@SafeVarargs
	public static void addLogFeature(RegistryKey<PlacedFeature> logFeature, RegistryKey<Biome>... biomeKeys) {
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(biomeKeys), GenerationStep.Feature.VEGETAL_DECORATION, logFeature);
	}

}