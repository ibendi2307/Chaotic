package com.example.chaotic;

import com.example.chaotic.Items.*;
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
    public static final DeferredItem<Item> UraniumDrink = ITEMS.registerItem("uranium_drink", uranium_drink::new);
    public static final DeferredItem<Item> EnrichedUranium = ITEMS.registerItem("enriched_uranium", uranium::new);
    public static final DeferredItem<Item> LightningWand = ITEMS.registerItem("lightning_wand", lightningwand::new);
    public static final DeferredItem<Item> LightningStaff = ITEMS.registerItem("lightning_staff", lightningstaff::new);
    public static final DeferredItem<Item> UraniumRing = ITEMS.registerItem("uranium_ring", uranium_ring::new);
    public static final DeferredItem<Item> EndSword = ITEMS.registerItem("end_sword", endsword::new);
    public static final DeferredItem<Item> Raw_Animatium = ITEMS.registerSimpleItem("raw_animatium");
    public static final DeferredItem<Item> Animatium = ITEMS.registerItem("animatium", Animatium::new);
    public static final DeferredItem<Item> Messor = ITEMS.registerItem("messor", Messor::new);
    public static final DeferredItem<Item> Plain_Soul = ITEMS.registerSimpleItem("plain_soul");
    public static final DeferredItem<Item> Skeleton_Soul = ITEMS.registerItem("skeleton_soul", SkeletonSoul::new);
    public static final DeferredItem<Item> Creeper_Soul = ITEMS.registerItem("creeper_soul", CreeperSoul::new);
    public static final DeferredItem<Item> Zombie_Soul = ITEMS.registerItem("zombie_soul", ZombieSoul::new);
    public static final DeferredItem<Item> Securis = ITEMS.registerItem("securis", Securis::new);
    public static final DeferredItem<Item> Soul_Core = ITEMS.registerSimpleItem("soul_core");
    public static final DeferredItem<Item> Creaking_soul = ITEMS.registerItem("creaking_soul", CreakingSoul::new);
    public static final DeferredItem<Item> Warden_Soul = ITEMS.registerItem("warden_soul", WardenSoul::new);
    public static final DeferredItem<Item> Sculk_Soul = ITEMS.registerSimpleItem("sculk_soul");
    public static final DeferredItem<Item> Sonic_Boom_Horn = ITEMS.registerItem("sonic_boom_horn", com.example.chaotic.Items.Sonic_Boom_Horn::new);
}
