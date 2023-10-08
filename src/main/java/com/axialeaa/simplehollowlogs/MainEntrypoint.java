package com.axialeaa.simplehollowlogs;

import com.axialeaa.simplehollowlogs.block.ModBlocks;
import com.axialeaa.simplehollowlogs.block.ModItemGroups;
import com.axialeaa.simplehollowlogs.util.ModBlockBehaviours;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
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

		FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer ->
				ResourceManagerHelper.registerBuiltinResourcePack(new Identifier("axialeaa", "natural_gen"), modContainer, Text.of("Natural Generation"), ResourcePackActivationType.NORMAL)
		);

		LOGGER.info(MOD_NAME + " initialized. That's all you need to know. This is a hollow logger.");
	}

}