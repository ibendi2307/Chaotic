package com.example.chaotic.blocks;

import com.example.chaotic.BlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class EUBentity extends BlockEntity{

    public EUBentity( BlockPos worldPosition, BlockState blockState) {
        super(BlockEntities.EUBEntityreg.get(), worldPosition, blockState);
    }



    public static void tick(Level level, BlockPos blockPos, BlockState blockState, BlockEntity blockEntity) {
        AABB hitbox = new AABB(blockPos).inflate(32.0);

        List<ServerPlayer> playersFound = level.getEntitiesOfClass(ServerPlayer.class, hitbox);
        for (ServerPlayer player : playersFound) {
            player.addEffect(new MobEffectInstance(MobEffects.HASTE, 5, 1));
            player.addEffect(new MobEffectInstance(MobEffects.SPEED, 5, 1));
        }
    }

}
