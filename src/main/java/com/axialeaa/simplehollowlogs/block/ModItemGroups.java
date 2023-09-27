package com.axialeaa.simplehollowlogs.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

import static com.axialeaa.simplehollowlogs.block.ModBlocks.*;
import static net.minecraft.block.Blocks.*;

public class ModItemGroups {

    public static void registerItemGroups() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(OAK_LOG, HOLLOW_OAK_LOG);
            content.addAfter(STRIPPED_OAK_LOG, STRIPPED_HOLLOW_OAK_LOG);
            content.addAfter(SPRUCE_LOG, HOLLOW_SPRUCE_LOG);
            content.addAfter(STRIPPED_SPRUCE_LOG, STRIPPED_HOLLOW_SPRUCE_LOG);
            content.addAfter(BIRCH_LOG, HOLLOW_BIRCH_LOG);
            content.addAfter(STRIPPED_BIRCH_LOG, STRIPPED_HOLLOW_BIRCH_LOG);
            content.addAfter(JUNGLE_LOG, HOLLOW_JUNGLE_LOG);
            content.addAfter(STRIPPED_JUNGLE_LOG, STRIPPED_HOLLOW_JUNGLE_LOG);
            content.addAfter(ACACIA_LOG, HOLLOW_ACACIA_LOG);
            content.addAfter(STRIPPED_ACACIA_LOG, STRIPPED_HOLLOW_ACACIA_LOG);
            content.addAfter(DARK_OAK_LOG, HOLLOW_DARK_OAK_LOG);
            content.addAfter(STRIPPED_DARK_OAK_LOG, STRIPPED_HOLLOW_DARK_OAK_LOG);
            content.addAfter(MANGROVE_LOG, HOLLOW_MANGROVE_LOG);
            content.addAfter(STRIPPED_MANGROVE_LOG, STRIPPED_HOLLOW_MANGROVE_LOG);
            content.addAfter(CHERRY_LOG, HOLLOW_CHERRY_LOG);
            content.addAfter(STRIPPED_CHERRY_LOG, STRIPPED_HOLLOW_CHERRY_LOG);
            content.addAfter(CRIMSON_STEM, HOLLOW_CRIMSON_STEM);
            content.addAfter(STRIPPED_CRIMSON_STEM, STRIPPED_HOLLOW_CRIMSON_STEM);
            content.addAfter(WARPED_STEM, HOLLOW_WARPED_STEM);
            content.addAfter(STRIPPED_WARPED_STEM, STRIPPED_HOLLOW_WARPED_STEM);
            // configures the positions of the hollow log blocks in the creative inventory (always right after the non-hollow counterpart)
        });
    }

}
