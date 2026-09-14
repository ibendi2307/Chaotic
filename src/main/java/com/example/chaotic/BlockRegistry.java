package com.example.chaotic;

import com.example.chaotic.Items.uranium;
import com.example.chaotic.blocks.uraniumore;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Chaotic.MODID);
    public static final DeferredBlock<Block> Uraniumore = BLOCKS.registerBlock("uraniumore", uraniumore::new);
    public static final DeferredItem<BlockItem> Uraniumoreitem = ItemRegistry.ITEMS.registerSimpleBlockItem(Uraniumore);
}
