package com.example.chaotic.Items;


import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.client.event.sound.SoundEvent;
import net.neoforged.neoforge.common.extensions.IItemExtension;
import org.jspecify.annotations.Nullable;

import java.util.Random;

public class uranium_cookie extends Item implements IItemExtension {

    public uranium_cookie(Properties properties) {

        super(properties.component(DataComponents.CONSUMABLE, Consumable.builder().build()).food(new FoodProperties(2,4, true)));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity entity) {
        if (!level.isClientSide()) {
            Random rand = new Random();
            int propability = rand.nextInt(1, 11);
            if (propability > 5) {
                entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 80, 0));
            }
            entity.addEffect(new MobEffectInstance(MobEffects.SPEED, 200, 2));
        }

        return super.finishUsingItem(itemStack, level, entity);
    }
}
