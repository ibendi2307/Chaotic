package com.example.chaotic.tags;

import com.example.chaotic.Chaotic;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Items {

        public static final TagKey<Item> Soul_Tag = createtag("soul");

        public static final TagKey<Item> Great_Soul = createtag("great_soul");

        private static TagKey<Item> createtag (String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath(Chaotic.MODID, name));
        }
    }

    public static class Blocks {



        private static TagKey<Block> createtag (String name) {
            return BlockTags.create(Identifier.fromNamespaceAndPath(Chaotic.MODID, name));
        }
    }
}
