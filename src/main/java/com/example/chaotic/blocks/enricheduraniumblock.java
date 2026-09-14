package com.example.chaotic.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.EntityGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.common.extensions.IBlockExtension;

import java.util.List;

public class enricheduraniumblock extends Block implements IBlockExtension {

    public enricheduraniumblock(Properties properties) {
        super(properties.requiresCorrectToolForDrops().sound(SoundType.AMETHYST).strength(4f,20));
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {


        AABB hitbox = new AABB(pos).inflate(64.0);

        List<Player> playersFound = level.getEntitiesOfClass(Player.class, hitbox);

        for (Player player : playersFound) {
            player.addEffect(new MobEffectInstance(MobEffects.HASTE, 5, 1));
            player.addEffect(new MobEffectInstance(MobEffects.SPEED, 5, 1));
        }
        super.tick(state, level, pos, random);
    }
}
