package com.example.chaotic.datagen;

import com.example.chaotic.Chaotic;
import com.example.chaotic.ItemRegistry;
import com.example.chaotic.tags.ModTags;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.advancements.triggers.PlayerTrigger;
import net.minecraft.advancements.triggers.SimpleCriterionTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.common.data.internal.NeoForgeAdvancementProvider;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

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

            AdvancementHolder soul_root = Advancement.Builder.advancement()
                    .display(
                            ItemRegistry.Creeper_Soul,
                            Component.translatable("advancement.chaotic.soul_root.title"),
                            Component.translatable("advancement.chaotic.soul_root.description"),
                            Identifier.withDefaultNamespace("gui/advancements/backgrounds/stone"),
                            AdvancementType.TASK,
                            false,
                            false,
                            false
                    ).requirements(AdvancementRequirements.Strategy.OR)
                    .addCriterion("joined", PlayerTrigger.TriggerInstance.tick())
                    .save(consumer, Identifier.fromNamespaceAndPath(Chaotic.MODID, "chaotic/soul_root"));

            AdvancementHolder animatium = Advancement.Builder.advancement()
                    .parent(soul_root)
                    .display(
                            ItemRegistry.Animatium,
                            Component.translatable("advancement.chaotic.animatium.title"),
                            Component.translatable("advancement.chaotic.animatium.description"),
                            null,
                            AdvancementType.TASK,
                            false,
                            true,
                            false
                            )
                    .requirements(AdvancementRequirements.Strategy.OR)
                    .addCriterion("has_animatium", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.Animatium))
                    .save(consumer,Identifier.fromNamespaceAndPath(Chaotic.MODID, "chaotic/animatium"));

            AdvancementHolder messor = Advancement.Builder.advancement()
                    .parent(soul_root)
                    .display(
                            ItemRegistry.Messor,
                            Component.translatable("advancement.chaotic.messor.title"),
                            Component.translatable("advancement.chaotic.messor.description"),
                            null,
                            AdvancementType.TASK,
                            false,
                            false,
                            false
                    )
                    .requirements(AdvancementRequirements.Strategy.OR)
                    .addCriterion("has_Messor", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.Messor))
                    .save(consumer,Identifier.fromNamespaceAndPath(Chaotic.MODID, "chaotic/messor"));

            AdvancementHolder securis = Advancement.Builder.advancement()
                    .parent(messor)
                    .display(
                            ItemRegistry.Securis,
                            Component.translatable("advancement.chaotic.securis.title"),
                            Component.translatable("advancement.chaotic.securis.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .requirements(AdvancementRequirements.Strategy.OR)
                    .addCriterion("has_securis", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.Securis))
                    .save(consumer,Identifier.fromNamespaceAndPath(Chaotic.MODID, "chaotic/securis"));

            AdvancementHolder soul_gain = Advancement.Builder.advancement()
                    .parent(soul_root)
                    .display(
                            ItemRegistry.Plain_Soul,
                            Component.translatable("advancement.chaotic.soul_gain.title"),
                            Component.translatable("advancement.chaotic.soul_gain.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .requirements(AdvancementRequirements.Strategy.OR)
                    .addCriterion("has_soul_gain", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemPredicate.Builder().of(items, ModTags.Items.Soul_Tag)))
                    .save(consumer,Identifier.fromNamespaceAndPath(Chaotic.MODID, "chaotic/soul_gain"));

            AdvancementHolder Great_Soul = Advancement.Builder.advancement()
                    .parent(soul_gain)
                    .display(
                            ItemRegistry.Creaking_soul,
                            Component.translatable("advancement.chaotic.great_soul.title"),
                            Component.translatable("advancement.chaotic.great_soul.description"),
                            null,
                            AdvancementType.CHALLENGE,
                            true,
                            true,
                            false
                    )
                    .requirements(AdvancementRequirements.Strategy.OR)
                    .addCriterion("has_great_soul", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemPredicate.Builder().of(items, ModTags.Items.Great_Soul)))
                    .save(consumer,Identifier.fromNamespaceAndPath(Chaotic.MODID, "chaotic/great_soul"));

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
