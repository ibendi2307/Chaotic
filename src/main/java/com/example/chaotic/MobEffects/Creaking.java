package com.example.chaotic.MobEffects;

import com.example.chaotic.Chaotic;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.util.ArrayList;

public class Creaking extends MobEffect {

    public Creaking(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
    }


    @Override
    public void onEffectAdded(LivingEntity mob, int amplifier) {
        mob.heal(100.0f);
        super.onEffectAdded(mob, amplifier);
    }
}
