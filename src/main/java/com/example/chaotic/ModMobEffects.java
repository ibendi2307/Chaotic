package com.example.chaotic;

import com.example.chaotic.MobEffects.Creaking;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMobEffects {
    public final static DeferredRegister<MobEffect> Mob_Effets = DeferredRegister.create(Registries.MOB_EFFECT, Chaotic.MODID);
    public final static Holder<MobEffect> Creaking = Mob_Effets.register("creaking", () -> new Creaking(5004380)
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, Identifier.fromNamespaceAndPath(Chaotic.MODID, "effect.speed"), -1.0D, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
            .addAttributeModifier(Attributes.ATTACK_DAMAGE, Identifier.fromNamespaceAndPath(Chaotic.MODID, "creaking.attack"), 5.0D, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
            .addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, Identifier.fromNamespaceAndPath(Chaotic.MODID, "creaking.defense"), 40.0D, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
            .addAttributeModifier(Attributes.MAX_HEALTH, Identifier.fromNamespaceAndPath(Chaotic.MODID, "creaking.health"), 2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
    public  static void register(IEventBus eventBus) {
        Mob_Effets.register(eventBus);
    }
}
