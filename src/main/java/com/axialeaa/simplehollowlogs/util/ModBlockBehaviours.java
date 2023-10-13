package com.axialeaa.simplehollowlogs.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class ModBlockBehaviours {

    public static void registerFlammables() {
        FlammableBlockRegistry.getDefaultInstance().add(ModTags.HOLLOW_LOGS_THAT_BURN, 5, 5);
    }

}
