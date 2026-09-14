package com.example.chaotic;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
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
            })

            .build());
    public static void register (IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
