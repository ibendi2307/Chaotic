package com.example.chaotic.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class deepslateuraniumblock extends Block {
    public deepslateuraniumblock(Properties properties) {
        super(properties.strength(5.0f, 6f).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DEEPSLATE));
    }

}
