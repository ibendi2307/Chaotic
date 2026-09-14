package com.example.chaotic.datagen;

import com.example.chaotic.Chaotic;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Chaotic.MODID)
public class DataGeneratorMod {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        net.minecraft.data.DataGenerator gen = event.getGenerator();
        PackOutput packout = gen.getPackOutput();
        gen.addProvider(true, new ModelProviderMod(packout));
        CompletableFuture<HolderLookup.Provider> lookupprovider = event.getLookupProvider();
        gen.addProvider(true, new TagProviderMod(packout, lookupprovider));
        gen.addProvider(true, new LootTableProvider(packout, Collections.emptySet(),List.of(new LootTableProvider.SubProviderEntry(BlockLootTablesProvider::new, LootContextParamSets.BLOCK)), lookupprovider));
        gen.addProvider(true, new DataPackProvider(packout, lookupprovider));
        gen.addProvider(true, new CuriosGen(packout,lookupprovider));
        gen.addProvider(true, new ModRecipeProvider.Runner(packout,lookupprovider));
    }
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Server event) {
        net.minecraft.data.DataGenerator gen = event.getGenerator();
        PackOutput packout = gen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupprovider = event.getLookupProvider();
        gen.addProvider(true, new TagProviderMod(packout, lookupprovider));
    }
}
