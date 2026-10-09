package com.example.chaotic;

import com.example.chaotic.blocks.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Chaotic.MODID);
    public static final DeferredBlock<Block> Uraniumore = BLOCKS.registerBlock("uraniumore", uraniumore::new);
    public static final DeferredItem<BlockItem> Uraniumoreitem = ItemRegistry.ITEMS.registerSimpleBlockItem(Uraniumore);
    public static final DeferredBlock<Block> DeepslateUraniumore = BLOCKS.registerBlock("deepslate_uranium_ore", deepslateuraniumblock::new);
    public static final DeferredItem<BlockItem> DeepslateUraniumoreitem = ItemRegistry.ITEMS.registerSimpleBlockItem(DeepslateUraniumore);
    public static final DeferredBlock<Block> EnrichedUraniumBlock = BLOCKS.registerBlock("enriched_uranium_block", enricheduraniumblock::new);
    public static final DeferredItem<BlockItem> EUBItem = ItemRegistry.ITEMS.registerSimpleBlockItem(EnrichedUraniumBlock);
    public static final DeferredBlock<Block> Uranium_Block = BLOCKS.registerBlock("uranium_block", uraniumblock::new);
    public static final DeferredItem<BlockItem> UraniumBlockItem = ItemRegistry.ITEMS.registerSimpleBlockItem(Uranium_Block);
    public static final DeferredBlock<Block> Enrichment_Table = BLOCKS.registerBlock("enrichment_table_entity", enrichment_table::new);// add crafting or smelting kind of mechanic to enrich some of the items. BlockEntity
    public static final DeferredItem<BlockItem> Enrichment_TableItem = ItemRegistry.ITEMS.registerSimpleBlockItem(Enrichment_Table);
    public static final DeferredBlock<Block> Animatium_ore = BLOCKS.registerBlock("animatium_ore", Basic_Ore::new);
    public static final DeferredItem<BlockItem> Animatium_oreItem = ItemRegistry.ITEMS.registerSimpleBlockItem(Animatium_ore);
    public static final DeferredBlock<Block>  Deepslate_Animatium_ore = BLOCKS.registerBlock("deepslate_animatium_ore", Basic_Deepslate_Ore::new);
    public static final DeferredItem<BlockItem> Deepslate_Animatium_oreItem = ItemRegistry.ITEMS.registerSimpleBlockItem(Deepslate_Animatium_ore);



}
