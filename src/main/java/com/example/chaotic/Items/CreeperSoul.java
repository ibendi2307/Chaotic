package com.example.chaotic.Items;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.Arrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

public class CreeperSoul extends Item {
    public CreeperSoul(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            ServerLevel srvlevel = (ServerLevel) level;
            level.playSound(null, player.blockPosition(), SoundEvents.CREEPER_HURT, SoundSource.PLAYERS, 2f,1);
            level.explode(player, player.getX(),player.getY(),player.getZ(), 3, Level.ExplosionInteraction.MOB);
            player.hurtServer(srvlevel, player.damageSources().generic(), player.getHealth() / 3);
            player.getMainHandItem().shrink(1);
            return InteractionResult.CONSUME;
        }
        return InteractionResult.FAIL;
    }
}
