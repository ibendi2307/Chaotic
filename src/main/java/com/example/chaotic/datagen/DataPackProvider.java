package com.example.chaotic.datagen;

import com.example.chaotic.Chaotic;
import com.example.chaotic.worldgen.ModBiomeModif;
import com.example.chaotic.worldgen.ModConfigFeature;
import com.example.chaotic.worldgen.ModPlaceFeature;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DataPackProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfigFeature::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlaceFeature::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModif::bootstrap);

    public DataPackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Chaotic.MODID));
    }
}
