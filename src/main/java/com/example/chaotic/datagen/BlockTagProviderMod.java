package com.example.chaotic.datagen;

import com.example.chaotic.BlockRegistry;
import com.example.chaotic.Chaotic;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class BlockTagProviderMod extends BlockTagsProvider {

    public BlockTagProviderMod(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Chaotic.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockRegistry.Uraniumore.getKey())
                .add(BlockRegistry.EnrichedUraniumBlock.getKey())
                .add(BlockRegistry.Animatium_ore.getKey())
                .add(BlockRegistry.Deepslate_Animatium_ore.getKey());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockRegistry.Uraniumore.getKey())
                .add(BlockRegistry.EnrichedUraniumBlock.getKey());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(BlockRegistry.Animatium_ore.getKey())
                .add(BlockRegistry.Deepslate_Animatium_ore.getKey());
    }
}
