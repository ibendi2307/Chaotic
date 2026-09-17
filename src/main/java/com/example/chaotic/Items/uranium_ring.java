package com.example.chaotic.Items;


import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;


public class uranium_ring extends Item implements ICurioItem{
    public uranium_ring(Properties properties) {
        super(properties.stacksTo(1).durability(1680));


    }


    @Override
    public boolean hasCurioCapability(ItemStack stack) {
        return true;
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {

        return ICurioItem.super.canEquip(slotContext, stack);
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity entity = slotContext.entity();
        Level level = entity.level();
        RandomSource randSource = level.getRandom();

        if (!level.isClientSide() && slotContext.entity() instanceof Player player && level instanceof ServerLevel serverLevel) {
            stack.hurtAndBreak(1, serverLevel.getLevel(),entity.asLivingEntity(), item -> {
                level.playLocalSound(entity.blockPosition(), SoundEvents.ANVIL_BREAK, SoundSource.AMBIENT, 1.0f,1.0f, false);
            });
            slotContext.entity().addEffect(new MobEffectInstance(MobEffects.HASTE, 5, 1));
        }
    }
    @Override
    public boolean isDamageable(ItemStack stack) {
        return true;
    }
}
