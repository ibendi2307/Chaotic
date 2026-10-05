package com.example.chaotic.Items;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SculkChargeParticle;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SculkChargeParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.extensions.IItemExtension;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

public class Animatium extends Item implements IItemExtension {
    public Animatium(Properties properties) {
        super(properties);
    }


}
