package com.example.chaotic;

import com.example.chaotic.Items.uranium;
import com.example.chaotic.Items.uranium_cookie;
import com.example.chaotic.Items.uranium_necklace;
import com.example.chaotic.Items.uraniumsword;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

import javax.swing.*;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Chaotic.MODID);
    public static final DeferredItem<Item> Uranium = ITEMS.registerItem("uranium", uranium::new);
    public static final DeferredItem<Item> UraniumSword = ITEMS.registerItem("uranium_sword", uraniumsword::new);
    public static final DeferredItem<Item> UraniumCookie = ITEMS.registerItem("uranium_cookie", uranium_cookie::new);
    public static final DeferredItem<Item> UraniumNecklace = ITEMS.registerItem("uranium_necklace", uranium_necklace::new);
}
