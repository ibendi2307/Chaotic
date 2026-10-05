package com.example.chaotic.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class Basic_Deepslate_Ore extends Block {

    public Basic_Deepslate_Ore(Properties properties) {
        super(properties.requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE).strength(4.5f,3));
    }
}
