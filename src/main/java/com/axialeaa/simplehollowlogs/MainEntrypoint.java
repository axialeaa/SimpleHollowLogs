package com.axialeaa.simplehollowlogs;

import com.axialeaa.simplehollowlogs.block.ModBlocks;
import com.axialeaa.simplehollowlogs.block.ModItemGroups;
import com.axialeaa.simplehollowlogs.util.ModBlockBehaviours;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainEntrypoint implements ModInitializer {

	public static final String MOD_ID = "simple-hollow-logs";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModBlockBehaviours.setFlammability();

		LOGGER.info(MOD_ID + " initialized!");
	}

}