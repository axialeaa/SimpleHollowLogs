package com.axialeaa.simplehollowlogs.block;

import com.axialeaa.simplehollowlogs.SimpleHollowLogs;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block STRIPPED_HOLLOW_OAK_LOG = registerBlock("stripped_hollow_oak_log", createStrippedHollowLogBlock(Blocks.STRIPPED_OAK_LOG));
    public static final Block STRIPPED_HOLLOW_SPRUCE_LOG = registerBlock("stripped_hollow_spruce_log", createStrippedHollowLogBlock(Blocks.STRIPPED_SPRUCE_LOG));
    public static final Block STRIPPED_HOLLOW_BIRCH_LOG = registerBlock("stripped_hollow_birch_log", createStrippedHollowLogBlock(Blocks.STRIPPED_BIRCH_LOG));
    public static final Block STRIPPED_HOLLOW_JUNGLE_LOG = registerBlock("stripped_hollow_jungle_log", createStrippedHollowLogBlock(Blocks.STRIPPED_JUNGLE_LOG));
    public static final Block STRIPPED_HOLLOW_ACACIA_LOG = registerBlock("stripped_hollow_acacia_log", createStrippedHollowLogBlock(Blocks.STRIPPED_ACACIA_LOG));
    public static final Block STRIPPED_HOLLOW_DARK_OAK_LOG = registerBlock("stripped_hollow_dark_oak_log", createStrippedHollowLogBlock(Blocks.DARK_OAK_LOG));
    public static final Block STRIPPED_HOLLOW_MANGROVE_LOG = registerBlock("stripped_hollow_mangrove_log", createStrippedHollowLogBlock(Blocks.STRIPPED_MANGROVE_LOG));
    public static final Block STRIPPED_HOLLOW_CHERRY_LOG = registerBlock("stripped_hollow_cherry_log", createStrippedHollowLogBlock(Blocks.STRIPPED_CHERRY_LOG));
    public static final Block STRIPPED_HOLLOW_CRIMSON_STEM = registerBlock("stripped_hollow_crimson_stem", createStrippedHollowLogBlock(Blocks.STRIPPED_CRIMSON_STEM));
    public static final Block STRIPPED_HOLLOW_WARPED_STEM = registerBlock("stripped_hollow_warped_stem", createStrippedHollowLogBlock(Blocks.STRIPPED_WARPED_STEM));
    // the stripped ones are registered first to avoid illegal forward references
    public static final Block HOLLOW_OAK_LOG = registerBlock("hollow_oak_log", createHollowLogBlock(STRIPPED_HOLLOW_OAK_LOG, Blocks.OAK_LOG));
    public static final Block HOLLOW_SPRUCE_LOG = registerBlock("hollow_spruce_log", createHollowLogBlock(STRIPPED_HOLLOW_SPRUCE_LOG, Blocks.SPRUCE_LOG));
    public static final Block HOLLOW_BIRCH_LOG = registerBlock("hollow_birch_log", createHollowLogBlock(STRIPPED_HOLLOW_BIRCH_LOG, Blocks.BIRCH_LOG));
    public static final Block HOLLOW_JUNGLE_LOG = registerBlock("hollow_jungle_log", createHollowLogBlock(STRIPPED_HOLLOW_JUNGLE_LOG, Blocks.JUNGLE_LOG));
    public static final Block HOLLOW_ACACIA_LOG = registerBlock("hollow_acacia_log", createHollowLogBlock(STRIPPED_HOLLOW_ACACIA_LOG, Blocks.ACACIA_LOG));
    public static final Block HOLLOW_DARK_OAK_LOG = registerBlock("hollow_dark_oak_log", createHollowLogBlock(STRIPPED_HOLLOW_DARK_OAK_LOG, Blocks.DARK_OAK_LOG));
    public static final Block HOLLOW_MANGROVE_LOG = registerBlock("hollow_mangrove_log", createHollowLogBlock(STRIPPED_HOLLOW_MANGROVE_LOG, Blocks.MANGROVE_LOG));
    public static final Block HOLLOW_CHERRY_LOG = registerBlock("hollow_cherry_log", createHollowLogBlock(STRIPPED_HOLLOW_CHERRY_LOG, Blocks.CHERRY_LOG));
    public static final Block HOLLOW_CRIMSON_STEM = registerBlock("hollow_crimson_stem", createHollowLogBlock(STRIPPED_HOLLOW_CRIMSON_STEM, Blocks.CRIMSON_STEM));
    public static final Block HOLLOW_WARPED_STEM = registerBlock("hollow_warped_stem", createHollowLogBlock(STRIPPED_HOLLOW_WARPED_STEM, Blocks.WARPED_STEM));


    private static HollowLogBlock createStrippedHollowLogBlock(AbstractBlock counterpart) {
        return new HollowLogBlock(null, FabricBlockSettings.copy(counterpart));
    }
    private static HollowLogBlock createHollowLogBlock(Block strippedBlock, AbstractBlock counterpart) {
        return new HollowLogBlock(strippedBlock.getDefaultState(), FabricBlockSettings.copy(counterpart));
    }


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier("axialeaa", name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier("axialeaa", name), new BlockItem(block, new FabricItemSettings()));
    }


    public static void onClassInitialized() {
        SimpleHollowLogs.LOGGER.info("Registered " + SimpleHollowLogs.MOD_NAME + " blocks!");
    }

}
