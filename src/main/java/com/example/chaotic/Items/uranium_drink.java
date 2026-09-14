package com.example.chaotic.Items;


import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.client.event.sound.SoundEvent;

import java.util.Random;

public class uranium_drink extends Item {

    public uranium_drink(Properties properties) {

        super(properties.component(DataComponents.CONSUMABLE, Consumables.defaultDrink().build()).food(new FoodProperties(2,4, true), Consumables.DEFAULT_DRINK));
    }                                                                                                                                                  //I DO IT HOW I WANT TO

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack itemStack) {
        return ItemUseAnimation.DRINK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity entity) {
        if (!level.isClientSide()) {
            Random rand = new Random();
            int propability = rand.nextInt(1, 12);
            if (propability > 7) {
                entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 350, 0));
            }else {
                entity.addEffect(new MobEffectInstance(MobEffects.HASTE, 400, 1));
            }
        }

        return super.finishUsingItem(itemStack, level, entity);
    }
}
