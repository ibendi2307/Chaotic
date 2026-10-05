package com.example.chaotic.worldgen.biomes;

import com.example.chaotic.Chaotic;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

import java.util.Optional;

public class TestBiomes {
    public static final HolderGetter<Biome> strangePlain = register("strange_plain");
    public static final HolderGetter<Biome> strangeForest = register("strange_forest");

    private static HolderGetter<Biome> register(String name){
        return new HolderGetter<Biome>() {
            @Override
            public Optional<Holder.Reference<Biome>> get(ResourceKey<Biome> resourceKey) {
                return Optional.empty();
            }

            @Override
            public Optional<HolderSet.Named<Biome>> get(TagKey<Biome> tagKey) {
                return Optional.empty();
            }
        };
    }
}
