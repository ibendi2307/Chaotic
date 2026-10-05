package com.example.chaotic.datagen;

import com.example.chaotic.BlockRegistry;
import com.example.chaotic.Chaotic;
import com.example.chaotic.ItemRegistry;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.renderer.block.BlockModelSet;
import net.minecraft.client.renderer.block.BlockStateModelSet;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;

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
        itemModels.generateFlatItem(ItemRegistry.UraniumDrink.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.EnrichedUranium.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.LightningWand.get(),ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ItemRegistry.LightningStaff.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ItemRegistry.UraniumRing.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.EndSword.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        blockModels.createTrivialCube(BlockRegistry.Uranium_Block.get());
        blockModels.createNonTemplateHorizontalBlock(BlockRegistry.Enrichment_Table.get());
        blockModels.createTrivialCube(BlockRegistry.Animatium_ore.value());
        blockModels.createTrivialCube(BlockRegistry.Deepslate_Animatium_ore.value());
        itemModels.generateFlatItem(ItemRegistry.Raw_Animatium.get(),ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.Animatium.get(),ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.Messor.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ItemRegistry.Plain_Soul.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.Skeleton_Soul.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.Creeper_Soul.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.Zombie_Soul.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.Securis.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ItemRegistry.Soul_Core.get(), ModelTemplates.FLAT_ITEM);
    }
}
