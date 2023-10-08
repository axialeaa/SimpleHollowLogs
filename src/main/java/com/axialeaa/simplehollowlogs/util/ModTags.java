package com.axialeaa.simplehollowlogs.util;

import com.axialeaa.simplehollowlogs.MainEntrypoint;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static final TagKey<Block> HOLLOW_LOGS_THAT_BURN = TagKey.of(RegistryKeys.BLOCK, new Identifier("axialeaa", "hollow_logs_that_burn"));
}