package com.example.chaotic.Items;


import com.example.chaotic.ItemRegistry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

import java.util.List;
import java.util.Random;

public class endsword extends Item {
    public endsword(Properties properties) {

        super(properties
                .durability(2031)
                .sword(ToolMaterial.NETHERITE, 8f,-2f)
                .repairable(Items.OBSIDIAN));
    }



    @Override
    public boolean canPerformAction(ItemInstance stack, ItemAbility itemAbility) {

        return itemAbility == ItemAbilities.SWORD_SWEEP;
    }



}
