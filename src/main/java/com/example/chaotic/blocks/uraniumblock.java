package com.example.chaotic.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class uraniumblock extends Block {
    public uraniumblock(Properties properties) {
        super(properties.strength(5.0f, 6f).instrument(NoteBlockInstrument.CHIME).sound(SoundType.AMETHYST));
    }

}
