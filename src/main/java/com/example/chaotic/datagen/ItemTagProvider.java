package com.example.chaotic.datagen;

import com.example.chaotic.Chaotic;
import com.example.chaotic.ItemRegistry;
import com.example.chaotic.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import top.theillusivec4.curios.api.CuriosTags;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends ItemTagsProvider {
    public ItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Chaotic.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.Soul_Tag)
                .add(ItemRegistry.Plain_Soul.getKey())
                .add(ItemRegistry.Skeleton_Soul.getKey())
                .add(ItemRegistry.Creeper_Soul.getKey())
                .add(ItemRegistry.Zombie_Soul.getKey())
                .add(ItemRegistry.Sculk_Soul.getKey());
        tag(ItemTags.MELEE_WEAPON_ENCHANTABLE)
                .add(ItemRegistry.Messor.getKey())
                .add(ItemRegistry.Securis.getKey())
                .add(ItemRegistry.EndSword.getKey())
                .add(ItemRegistry.UraniumSword.getKey());
        tag(ItemTags.SWORDS)
                .add(ItemRegistry.EndSword.getKey())
                .add(ItemRegistry.UraniumSword.getKey());
        tag(ModTags.Items.Great_Soul)
                .add(ItemRegistry.Warden_Soul.getKey())
                .add(ItemRegistry.Creaking_soul.getKey());
    }
}
