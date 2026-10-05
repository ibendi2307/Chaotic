package com.example.chaotic.datagen;

import com.example.chaotic.Chaotic;
import com.example.chaotic.ItemRegistry;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.common.data.internal.NeoForgeAdvancementProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class AdvancementsGenerator extends AdvancementProvider {
    public AdvancementsGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, List.of(new AdvancementsSubprovider()));
    }

    public static class AdvancementsSubprovider implements AdvancementSubProvider {

        @Override
        public void generate(HolderLookup.Provider provider, Consumer<AdvancementHolder> consumer) {
            var items = provider.lookupOrThrow(Registries.ITEM);

            AdvancementHolder uranium_root = Advancement.Builder.advancement()
                    .display(
                            ItemRegistry.Uranium,
                            Component.translatable("advancement.chaotic.uranium_root.title"),
                            Component.translatable("advancement.chaotic.uranium_root.description"),
                            Identifier.withDefaultNamespace("gui/advancements/backgrounds/stone"),
                            AdvancementType.TASK,
                            false,
                            false,
                            false
                    )
                    .requirements(AdvancementRequirements.Strategy.OR)
                    .addCriterion("has_uranium", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, ItemRegistry.Uranium)))
                    .save(consumer, Identifier.fromNamespaceAndPath(Chaotic.MODID, "chaotic/uranium_root"));


            AdvancementHolder enrich_uranium = Advancement.Builder.advancement()
                    .parent(uranium_root)
                    .display(
                            ItemRegistry.EnrichedUranium,
                            Component.translatable("advancement.chaotic.uranium_enrich.title"),
                            Component.translatable("advancement.chaotic.uranium_enrich.description"),
                            null,
                            AdvancementType.TASK,
                            false,
                            true,
                            false
                    )
                    .requirements(AdvancementRequirements.Strategy.OR)
                    .addCriterion("has_enriched_uranium", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, ItemRegistry.EnrichedUranium)))
                    .save(consumer, Identifier.fromNamespaceAndPath(Chaotic.MODID, "chaotic/uranium_enrich"));
        }
    }
}
