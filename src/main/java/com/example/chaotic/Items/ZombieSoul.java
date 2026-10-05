package com.example.chaotic.Items;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class ZombieSoul extends Item {
    public ZombieSoul(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            ServerLevel srvlevel = (ServerLevel) level;
            level.playSound(null, player.blockPosition(), SoundEvents.ZOMBIE_AMBIENT, SoundSource.PLAYERS, 1.5f,1);
            player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 1200, 2, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.STRENGTH, 1200, 1, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 1200, 0, true, false));
            player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() - 6);
            player.getMainHandItem().shrink(1);
            return InteractionResult.CONSUME;
        }
        return InteractionResult.FAIL;
    }
}
