package com.example.chaotic.Items;


import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.context.UseOnContext;
import net.neoforged.neoforge.common.extensions.IItemExtension;

public class lightningwand extends Item  implements IItemExtension {

    public lightningwand(Properties properties) {
        super(properties.durability(85));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (!context.getLevel().isClientSide() && !context.getPlayer().getCooldowns().isOnCooldown(context.getItemInHand())) {
            ServerLevel serverLevel = (ServerLevel) context.getLevel();
            LightningBolt lightningBolt = EntityTypes.LIGHTNING_BOLT.create(serverLevel, EntitySpawnReason.SPAWN_ITEM_USE);
            if (lightningBolt != null) {
                lightningBolt.setPos(context.getClickLocation());
                serverLevel.addFreshEntity(lightningBolt);
                context.getPlayer().getCooldowns().addCooldown(context.getItemInHand(), 100);
                context.getItemInHand().hurtAndBreak(5, context.getPlayer().getLivingEntity(), context.getHand());
            }
        }
        return super.useOn(context);
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return true;
    }
}
