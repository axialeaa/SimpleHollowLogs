package com.axialeaa.simplehollowlogs;

import com.axialeaa.simplehollowlogs.block.ModBlocks;
import com.axialeaa.simplehollowlogs.block.ModItemGroups;
import com.axialeaa.simplehollowlogs.util.ModBlockBehaviours;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleHollowLogs implements ModInitializer {
	public static final String MOD_ID = "simple-hollow-logs";
	public static final String MOD_NAME = "Simple Hollow Logs";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModBlockBehaviours.registerFlammables();
		ModBlockBehaviours.placeInBiome();

		ModBlocks.onClassInitialized();

		LOGGER.info(MOD_NAME + " initialized. That's all you need to know. This is a hollow logger.");
	}

}