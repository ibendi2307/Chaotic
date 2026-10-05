package com.example.chaotic.datagen;

import com.example.chaotic.BlockRegistry;
import com.example.chaotic.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class LootTableProviderMod extends LootTableProvider {
    public LootTableProviderMod(PackOutput output, Set<ResourceKey<LootTable>> requiredTables, List<SubProviderEntry> subProviders, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, Set.of(), List.of(
                new SubProviderEntry(provider -> new BlockLoottableSubprovider(Collections.EMPTY_SET, FeatureFlagSet.of(), provider), LootContextParamSets.BLOCK)
        ), registries);
    }



    private static final class BlockLoottableSubprovider extends BlockLootSubProvider {

        BlockLoottableSubprovider(Set<Item> explosionResistant, FeatureFlagSet enabledFeatures, HolderLookup.Provider registries) {
            super(explosionResistant, enabledFeatures, registries);
        }

        @Override
        protected void generate() {
            createOreDrop(BlockRegistry.Uraniumore.get(), ItemRegistry.Uranium.asItem());
            dropSelf(BlockRegistry.EnrichedUraniumBlock.get());
        }

    }
}
