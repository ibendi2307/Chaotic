package com.example.chaotic.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class Basic_Ore extends Block {

    public Basic_Ore(Properties properties) {
        super(properties.requiresCorrectToolForDrops().sound(SoundType.STONE).strength(3f,3));
    }
}
