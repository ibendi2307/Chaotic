package com.example.chaotic.datagen;

import com.example.chaotic.Chaotic;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import top.theillusivec4.curios.api.CuriosDataProvider;

import java.util.concurrent.CompletableFuture;

public class CuriosGen extends CuriosDataProvider {
    public CuriosGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(Chaotic.MODID, output, registries);
    }

    @Override
    public void generate(HolderLookup.Provider provider) {
        this.createEntities("basicplayer").addAllPresetSlots().addPlayer();
    }
}
