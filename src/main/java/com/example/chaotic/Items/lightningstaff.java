package com.example.chaotic.Items;


import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class lightningstaff extends Item {

    public lightningstaff(Properties properties) {
        super(properties.durability(100));
    }


    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {

        if (!level.isClientSide()) {
            AABB hitbox = new AABB(player.blockPosition()).inflate(16);
            List<Entity> hitted = level.getEntities(player.asLivingEntity(), hitbox);
            int hitcount = hitted.size();
            for (Entity entity : hitted) {
                int cooldown = ((hitcount - 1)* 10) + 100;
                LightningBolt lightningBolt = EntityTypes.LIGHTNING_BOLT.create(level, EntitySpawnReason.SPAWN_ITEM_USE);
                if (lightningBolt != null) {
                    lightningBolt.setPos(entity.position());
                    level.addFreshEntity(lightningBolt);
                    player.getCooldowns().addCooldown(player.getMainHandItem(), cooldown);
                    player.getMainHandItem().hurtAndBreak(2, player.getLivingEntity(), hand);
                }
            }

        }

        return super.use(level, player, hand);
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return true;
    }
}
