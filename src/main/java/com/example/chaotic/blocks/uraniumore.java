package com.example.chaotic.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.GlowstoneFeature;

public class uraniumore extends Block {

    public uraniumore(Properties properties) {
        super(properties.requiresCorrectToolForDrops().sound(SoundType.STONE).strength(4f,5).lightLevel((statex) -> 5));
    }
}
