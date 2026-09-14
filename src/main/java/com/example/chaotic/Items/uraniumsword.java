package com.example.chaotic.Items;


import com.example.chaotic.ItemRegistry;
import net.minecraft.client.renderer.item.properties.numeric.Cooldown;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.component.Weapon;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ScheduledTickAccess;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.extensions.IItemExtension;
import net.neoforged.neoforge.event.level.ExplosionEvent;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class uraniumsword extends Item {
    public uraniumsword(Properties properties) {

        super(properties
                .durability(250)
                .sword(ToolMaterial.IRON, 3f,-2.4f)
                .repairable(ItemRegistry.Uranium.get())
                .component(DataComponents.LORE,
                        new ItemLore(List.of(Component.translatable("item.chaotic.uranium_sword.tooltip")
                                .withColor(TextColor.GREEN)))));
    }

    @Override
    public boolean canPerformAction(ItemInstance stack, ItemAbility itemAbility) {

        return itemAbility == ItemAbilities.SWORD_SWEEP;
    }

    boolean swing = false;


    @Override
    public void hurtEnemy(ItemStack itemStack, LivingEntity mob, LivingEntity attacker) {
        super.hurtEnemy(itemStack, mob, attacker);
        Level level = attacker.level();
        if (attacker instanceof Player player) {
            if (!level.isClientSide()) {
                boolean cooldown = player.getCooldowns().isOnCooldown(itemStack);
                if (!cooldown) {
                    Random rand = new Random();
                    int randintexpl = rand.nextInt(1, 5);
                    boolean explode = randintexpl == 1;
                    int infect = rand.nextInt(1, 3);
                    if (explode)  {
                        level.explode(attacker, mob.getX(), mob.getY(), mob.getZ(), 3f, Level.ExplosionInteraction.NONE);
                    }
                    if (infect == 2) {
                        mob.addEffect(new MobEffectInstance(MobEffects.WITHER, 30, 2));
                    }
                }
                player.getCooldowns().addCooldown(itemStack, 32);
            }
        }
        super.postHurtEnemy(itemStack, mob, attacker);
    }


   // @Override
   // public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
   //     builder.accept(Component.translatable("item.chaotic.uranium_sword.tooltip").withColor(TextColor.GREEN));
   //     super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
   // }
}
