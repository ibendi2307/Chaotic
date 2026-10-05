package com.example.chaotic.worldgen.biomes;

import com.example.chaotic.Chaotic;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModBiomes {
    public static DeferredRegister<Biome> Biome_Registry = DeferredRegister.create(Registries.BIOME, Chaotic.MODID);

    public static void registerBiomes(){

    }


    public static DeferredHolder<Biome,Biome> register(ResourceKey<Biome> key, Supplier<Biome> biomeSupplier)
    {
        return Biome_Registry.register(key.toString(), biomeSupplier);
    }

}
