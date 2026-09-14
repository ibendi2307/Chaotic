package com.example.chaotic.worldgen;

import com.example.chaotic.Chaotic;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;


public class ModPlaceFeature {
    public static final ResourceKey<PlacedFeature> OVERWORLD_URANIUM_ORE_PLACED_KEY = registerKey("overworld_uranium_ore_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configFeature = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, OVERWORLD_URANIUM_ORE_PLACED_KEY, configFeature.getOrThrow(ModConfigFeature.OVERWORLD_URANIUM_ORE_KEY), OrePlacements.commonOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.absolute(0),  VerticalAnchor.absolute(80))));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(Chaotic.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
