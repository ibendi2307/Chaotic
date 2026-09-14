package com.example.chaotic.Items;


import com.example.chaotic.ItemRegistry;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.effects.ChangeItemDamage;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredItem;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;


public class uranium_necklace extends Item implements ICurioItem{
    public uranium_necklace(Properties properties) {
        super(properties.stacksTo(1).durability(0));


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

        if (!level.isClientSide() && slotContext.entity() instanceof Player player) {
            slotContext.entity().addEffect(new MobEffectInstance(MobEffects.SPEED, 5, 1));
        }
        ICurioItem.super.curioTick(slotContext, stack);
        slotContext.entity().addEffect(new MobEffectInstance(MobEffects.SPEED, 5, 1));
        ;
    }
    @Override
    public boolean isDamageable(ItemStack stack) {
        return true;
    }
}
