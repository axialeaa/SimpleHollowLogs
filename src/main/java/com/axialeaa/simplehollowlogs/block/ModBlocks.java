package com.axialeaa.simplehollowlogs.block;

import com.axialeaa.simplehollowlogs.MainEntrypoint;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class ModBlocks {

    public static final Block STRIPPED_HOLLOW_OAK_LOG = registerBlock("stripped_hollow_oak_log", createStrippedHollowLogBlock(MapColor.OAK_TAN, BlockSoundGroup.WOOD));
    public static final Block STRIPPED_HOLLOW_SPRUCE_LOG = registerBlock("stripped_hollow_spruce_log", createStrippedHollowLogBlock(MapColor.SPRUCE_BROWN, BlockSoundGroup.WOOD));
    public static final Block STRIPPED_HOLLOW_BIRCH_LOG = registerBlock("stripped_hollow_birch_log", createStrippedHollowLogBlock(MapColor.PALE_YELLOW, BlockSoundGroup.WOOD));
    public static final Block STRIPPED_HOLLOW_JUNGLE_LOG = registerBlock("stripped_hollow_jungle_log", createStrippedHollowLogBlock(MapColor.DIRT_BROWN, BlockSoundGroup.WOOD));
    public static final Block STRIPPED_HOLLOW_ACACIA_LOG = registerBlock("stripped_hollow_acacia_log", createStrippedHollowLogBlock(MapColor.ORANGE, BlockSoundGroup.WOOD));
    public static final Block STRIPPED_HOLLOW_DARK_OAK_LOG = registerBlock("stripped_hollow_dark_oak_log", createStrippedHollowLogBlock(MapColor.BROWN, BlockSoundGroup.WOOD));
    public static final Block STRIPPED_HOLLOW_MANGROVE_LOG = registerBlock("stripped_hollow_mangrove_log", createStrippedHollowLogBlock(MapColor.RED, BlockSoundGroup.WOOD));
    public static final Block STRIPPED_HOLLOW_CHERRY_LOG = registerBlock("stripped_hollow_cherry_log", createStrippedHollowLogBlock(MapColor.TERRACOTTA_WHITE, BlockSoundGroup.CHERRY_WOOD));
    public static final Block STRIPPED_HOLLOW_CRIMSON_STEM = registerBlock("stripped_hollow_crimson_stem", createStrippedHollowLogBlock(MapColor.DULL_PINK, BlockSoundGroup.NETHER_STEM));
    public static final Block STRIPPED_HOLLOW_WARPED_STEM = registerBlock("stripped_hollow_warped_stem", createStrippedHollowLogBlock(MapColor.DARK_AQUA, BlockSoundGroup.NETHER_STEM));
    // the stripped ones are registered first to avoid illegal forward references
    public static final Block HOLLOW_OAK_LOG = registerBlock("hollow_oak_log", createHollowLogBlock(STRIPPED_HOLLOW_OAK_LOG, MapColor.OAK_TAN, MapColor.SPRUCE_BROWN, BlockSoundGroup.WOOD));
    public static final Block HOLLOW_SPRUCE_LOG = registerBlock("hollow_spruce_log", createHollowLogBlock(STRIPPED_HOLLOW_SPRUCE_LOG, MapColor.SPRUCE_BROWN, MapColor.BROWN, BlockSoundGroup.WOOD));
    public static final Block HOLLOW_BIRCH_LOG = registerBlock("hollow_birch_log", createHollowLogBlock(STRIPPED_HOLLOW_BIRCH_LOG, MapColor.PALE_YELLOW, MapColor.OFF_WHITE, BlockSoundGroup.WOOD));
    public static final Block HOLLOW_JUNGLE_LOG = registerBlock("hollow_jungle_log", createHollowLogBlock(STRIPPED_HOLLOW_JUNGLE_LOG, MapColor.DIRT_BROWN, MapColor.SPRUCE_BROWN, BlockSoundGroup.WOOD));
    public static final Block HOLLOW_ACACIA_LOG = registerBlock("hollow_acacia_log", createHollowLogBlock(STRIPPED_HOLLOW_ACACIA_LOG, MapColor.ORANGE, MapColor.STONE_GRAY, BlockSoundGroup.WOOD));
    public static final Block HOLLOW_DARK_OAK_LOG = registerBlock("hollow_dark_oak_log", createHollowLogBlock(STRIPPED_HOLLOW_DARK_OAK_LOG, MapColor.BROWN, MapColor.BROWN, BlockSoundGroup.WOOD));
    public static final Block HOLLOW_MANGROVE_LOG = registerBlock("hollow_mangrove_log", createHollowLogBlock(STRIPPED_HOLLOW_MANGROVE_LOG, MapColor.RED, MapColor.SPRUCE_BROWN, BlockSoundGroup.WOOD));
    public static final Block HOLLOW_CHERRY_LOG = registerBlock("hollow_cherry_log", createHollowLogBlock(STRIPPED_HOLLOW_CHERRY_LOG, MapColor.TERRACOTTA_WHITE, MapColor.TERRACOTTA_GRAY, BlockSoundGroup.CHERRY_WOOD));
    public static final Block HOLLOW_CRIMSON_STEM = registerBlock("hollow_crimson_stem", createHollowLogBlock(STRIPPED_HOLLOW_CRIMSON_STEM, MapColor.DULL_PINK, MapColor.DULL_PINK, BlockSoundGroup.NETHER_STEM));
    public static final Block HOLLOW_WARPED_STEM = registerBlock("hollow_warped_stem", createHollowLogBlock(STRIPPED_HOLLOW_WARPED_STEM, MapColor.DARK_AQUA, MapColor.DARK_AQUA, BlockSoundGroup.NETHER_STEM));


    private static HollowLogBlock createStrippedHollowLogBlock(MapColor mapColor, BlockSoundGroup soundGroup) { // we only need one mapColor here because stripped logs show the same colours regardless of orientation
        return new HollowLogBlock(null, AbstractBlock.Settings.create().mapColor(mapColor).instrument(Instrument.BASS).strength(1.5f).sounds(soundGroup).burnable()); // ^ 1.5f means you can instamine them with haste II and efficiency V axes :D
    } // using null here is a bit weird but like, it's not wrong; we just need to implement a nullcheck in the axe stripping method so it doesn't crash
    private static HollowLogBlock createHollowLogBlock(Block strippedBlock, MapColor topMapColor, MapColor sideMapColor, BlockSoundGroup soundGroup) {
        return new HollowLogBlock(strippedBlock.getDefaultState(), AbstractBlock.Settings.create().mapColor(state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor).instrument(Instrument.BASS).strength(1.5f).sounds(soundGroup).burnable());
    }                                   // ^ wrapped here to save repeating .getDefaultState() for every block instance
    // the strippedState parameter from the hollowlogblock class looks for a blockstate it can use for the axe stripping functionality,
    // which we have to write from scratch due to fabric api's strippable block registry looking for a block with exclusively the axis property,
    // ignoring waterlogging in this example
    // this is frustrating because it makes everything like 10x more complicated but what can ya do


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MainEntrypoint.MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(MainEntrypoint.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks() {
        MainEntrypoint.LOGGER.info(MainEntrypoint.MOD_ID + " blocks registered!");
    }

}
