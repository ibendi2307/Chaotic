package com.example.chaotic.datagen;

import com.example.chaotic.BlockRegistry;
import com.example.chaotic.Chaotic;
import com.example.chaotic.ItemRegistry;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ModelProviderMod extends ModelProvider {

    public ModelProviderMod(PackOutput output) {
        super(output, Chaotic.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ItemRegistry.Uranium.get(), ModelTemplates.FLAT_ITEM);
        blockModels.createTrivialCube(BlockRegistry.Uraniumore.get());
        blockModels.createTrivialCube(BlockRegistry.EnrichedUraniumBlock.get());
        itemModels.generateFlatItem(ItemRegistry.UraniumSword.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ItemRegistry.UraniumCookie.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.UraniumNecklace.get(), ModelTemplates.FLAT_ITEM);
    }
}
