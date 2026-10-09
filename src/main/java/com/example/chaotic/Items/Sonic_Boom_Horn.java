package com.example.chaotic.Items;

import com.example.chaotic.Utils.RaycastUtil;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.function.Predicate;

public class Sonic_Boom_Horn extends Item {

    public Sonic_Boom_Horn(Properties properties) {
        super(properties.durability(500));
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {

            player.getCooldowns().addCooldown(player.getMainHandItem(), 60);
            Vec3 start = player.getEyePosition();
            Vec3 look = player.getViewVector(1.0f);
            Vec3 end = start.add(look.scale(35D));
            ServerLevel srvlevel = (ServerLevel) level;
            player.getItemInHand(hand).hurtAndBreak(25,srvlevel,player, (item) -> {});

            AABB hitray = new AABB(start, end).inflate(4);

            Predicate<Entity> filter = entity -> !entity.isSpectator() && entity.isPickable();

            List<EntityHitResult> allHits = RaycastUtil.getAllEntityHitResults(player, start,end, hitray, filter);

            for (EntityHitResult hitResult: allHits){
                Entity target = hitResult.getEntity();
                target.hurtServer(srvlevel, player.damageSources().sonicBoom(player), 5f);
                Vec3 delta = target.position().subtract(player.position()).normalize();

                target.push(delta.x * 1.5,0.85,delta.z * 1.5);
            }
            level.playSound(null, player.blockPosition(), SoundEvents.WARDEN_SONIC_BOOM, SoundSource.PLAYERS, 2f,1);

            double len = end.subtract(start).length();
            Vec3 step = end.subtract(start).normalize().scale(5);

            for (double d = 0; d < len; d += 1) {
                Vec3 pos = start.add(step.scale(d / 5));

                srvlevel.sendParticles(ParticleTypes.SONIC_BOOM,
                        pos.x,pos.y,pos.z,
                        1,
                        0,0,0,
                        0);
            }

            return InteractionResult.SUCCESS_SERVER;
        }
        return InteractionResult.PASS;
    }
}
