package com.example.chaotic.Items;

import com.example.chaotic.ModMobEffects;
import net.minecraft.client.renderer.fog.environment.MobEffectFogEnvironment;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class CreakingSoul extends Item {
    public CreakingSoul(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            if (!player.getCooldowns().isOnCooldown(player.getMainHandItem())) {
                ServerLevel srvlevel = (ServerLevel) level;
                level.playSound(null, player.blockPosition(), SoundEvents.CREAKING_ACTIVATE, SoundSource.PLAYERS, 2f,1);
                player.getCooldowns().addCooldown(player.getMainHandItem(), 600);
                player.forceAddEffect(new MobEffectInstance(new MobEffectInstance(ModMobEffects.Creaking, 100, 0, true,  true, true)), player);
                player.setHealth(player.getMaxHealth());
                return InteractionResult.SUCCESS_SERVER;
            } else {
                return InteractionResult.FAIL;
            }
        }
        return InteractionResult.FAIL;
    }
}
