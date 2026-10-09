package com.example.chaotic;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Chaotic.MODID);
    public static final Supplier<CreativeModeTab> Chaotic_Uranium = CREATIVE_MODE_TABS.register("chaoitc_uranium", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ItemRegistry.Uranium.get()))
            .title(Component.translatable("creativetab.chaotic.uranium_tab"))
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ItemRegistry.Uranium);
                output.accept(ItemRegistry.UraniumCookie);
                output.accept(ItemRegistry.UraniumSword);
                output.accept(BlockRegistry.Uraniumoreitem);
                output.accept(BlockRegistry.EUBItem);
                output.accept(ItemRegistry.EnrichedUranium);
                output.accept(ItemRegistry.UraniumDrink);
                output.accept(ItemRegistry.UraniumNecklace);
                output.accept(ItemRegistry.UraniumRing);
                output.accept(BlockRegistry.UraniumBlockItem);
            })

            .build());
    public static final Supplier<CreativeModeTab> Chaotic_Misc = CREATIVE_MODE_TABS.register("chaoitc_misc", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ItemRegistry.LightningWand.get()))
            .title(Component.translatable("creativetab.chaotic.misc"))
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ItemRegistry.LightningWand);
                output.accept(ItemRegistry.LightningStaff);
                output.accept(ItemRegistry.EndSword);
                output.accept(ItemRegistry.Sonic_Boom_Horn);
            })



            .build());
    public static final Supplier<CreativeModeTab> Chaotic_Animatium = CREATIVE_MODE_TABS.register("chaotic_animatium", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(BlockRegistry.Animatium_oreItem.get()))
            .title(Component.translatable("creativetab.chaotic.animatium"))
            .withTabsBefore(Identifier.fromNamespaceAndPath(Chaotic.MODID, "chaoitc_uranium"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(BlockRegistry.Animatium_oreItem);
                output.accept(BlockRegistry.Deepslate_Animatium_oreItem);
                output.accept(ItemRegistry.Raw_Animatium);
                output.accept(ItemRegistry.Animatium);
                output.accept(ItemRegistry.Messor);
                output.accept(ItemRegistry.Securis);
            })

            .build());
    public static final Supplier<CreativeModeTab> Chaotic_Souls = CREATIVE_MODE_TABS.register("chaoitc_souls", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ItemRegistry.Creeper_Soul.get()))
            .title(Component.translatable("creativetab.chaotic.souls"))
            .withTabsBefore(Identifier.fromNamespaceAndPath(Chaotic.MODID, "chaotic_animatium"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ItemRegistry.Plain_Soul);
                output.accept(ItemRegistry.Sculk_Soul);
                output.accept(ItemRegistry.Creeper_Soul);
                output.accept(ItemRegistry.Zombie_Soul);
                output.accept(ItemRegistry.Skeleton_Soul);
                output.accept(ItemRegistry.Soul_Core);
                output.accept(ItemRegistry.Warden_Soul);
                output.accept(ItemRegistry.Creaking_soul);

            })



            .build());
    public static void register (IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
