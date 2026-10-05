package com.example.chaotic;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.HashMap;
import java.util.Map;

public class Maps {

    public static final Map<String, DeferredItem<Item>> Souls = new HashMap<>();

    static {
        Souls.put("zombie", ItemRegistry.Zombie_Soul);
        Souls.put("skeleton", ItemRegistry.Skeleton_Soul);
        Souls.put("creeper", ItemRegistry.Creeper_Soul);
    }
}
