package com.axialeaa.simplehollowlogs;

import com.axialeaa.simplehollowlogs.block.ModBlocks;
import com.axialeaa.simplehollowlogs.block.ModItemGroups;
import com.axialeaa.simplehollowlogs.util.ModBlockBehaviours;
import com.axialeaa.simplehollowlogs.world.HollowLogPlacedFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainEntrypoint implements ModInitializer {
	public static final String MOD_ID = "simple-hollow-logs";
	public static final String MOD_NAME = "Simple Hollow Logs";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModBlockBehaviours.setFlammability();

		BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, HollowLogPlacedFeatures.FALLEN_BIRCH_FOREST_LOG);
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.CHERRY_GROVE), GenerationStep.Feature.VEGETAL_DECORATION, HollowLogPlacedFeatures.FALLEN_CHERRY_GROVE_LOG);
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, HollowLogPlacedFeatures.FALLEN_DARK_FOREST_LOG);
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, HollowLogPlacedFeatures.FALLEN_FOREST_LOG);
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.JUNGLE, BiomeKeys.BAMBOO_JUNGLE), GenerationStep.Feature.VEGETAL_DECORATION, HollowLogPlacedFeatures.FALLEN_JUNGLE_LOG);
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SPARSE_JUNGLE), GenerationStep.Feature.VEGETAL_DECORATION, HollowLogPlacedFeatures.FALLEN_SPARSE_JUNGLE_LOG);
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.TAIGA, BiomeKeys.SNOWY_TAIGA, BiomeKeys.GROVE, BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA), GenerationStep.Feature.VEGETAL_DECORATION, HollowLogPlacedFeatures.FALLEN_TAIGA_LOG);
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.WINDSWEPT_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, HollowLogPlacedFeatures.FALLEN_WINDSWEPT_FOREST_LOG);

		LOGGER.info(MOD_NAME + " initialized. That's all you need to know. This is a hollow logger.");
	}

}