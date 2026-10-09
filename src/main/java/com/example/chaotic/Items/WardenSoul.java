package com.example.chaotic.Items;

import com.example.chaotic.ModMobEffects;
import com.example.chaotic.Utils.RaycastUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.warden.SonicBoom;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class WardenSoul extends Item {
    public WardenSoul(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            if (!player.getCooldowns().isOnCooldown(player.getMainHandItem())) {
                ServerLevel srvlevel = (ServerLevel) level;
                level.playSound(null, player.blockPosition(), SoundEvents.WARDEN_ANGRY, SoundSource.PLAYERS, 2f,1);
                player.getCooldowns().addCooldown(player.getMainHandItem(), 900);
                AABB plrhitbox = new AABB(player.blockPosition()).inflate(2D);
                for (BlockPos currentpos : BlockPos.betweenClosed(plrhitbox) ) {
                    if (srvlevel.getBlockState(currentpos) != Blocks.AIR.defaultBlockState() && srvlevel.isFluidAtPosition(currentpos, fluidState -> fluidState.isEmpty())) {
                        Random rand = new Random();
                        int place = rand.nextInt(0, 2);
                        if (place == 0) {
                            srvlevel.setBlock(currentpos,Blocks.SCULK.defaultBlockState(), 2);
                            place = rand.nextInt(0,2);
                        }
                    }
                }

                Vec3 start = player.getEyePosition();
                Vec3 look = player.getViewVector(1.0f);
                Vec3 end = start.add(look.scale(70D));

                AABB hitray = new AABB(start, end).inflate(4);

                Predicate<Entity> filter = entity -> !entity.isSpectator() && entity.isPickable();

                List<EntityHitResult> allHits = RaycastUtil.getAllEntityHitResults(player, start,end, hitray, filter);

                for (EntityHitResult hitResult: allHits){
                    Entity target = hitResult.getEntity();
                    target.hurtServer(srvlevel, player.damageSources().sonicBoom(player), 15f);
                    Vec3 delta = target.position().subtract(player.position()).normalize();

                    target.push(delta.x * 1.5,0.85,delta.z * 1.5);
                }

               // EntityHitResult hit = ProjectileUtil.getEntityHitResult(
              //          player, start, end, hitray,
               //         e -> e instanceof LivingEntity && e != player && !e.isSpectator(),
               //         70D * 70D
               // );

                //if (hit != null && hit.getEntity() instanceof LivingEntity target) {
                //}
                level.playSound(null, player.blockPosition(), SoundEvents.WARDEN_SONIC_BOOM, SoundSource.PLAYERS, 2f,1);
                double len = end.subtract(start).length();
                Vec3 step = end.subtract(start).normalize().scale(5);

                for (double d = 0; d < len; d += 1) {
                    Vec3 pos = start.add(step.scale(d / 2));

                    srvlevel.sendParticles(ParticleTypes.SONIC_BOOM,
                            pos.x,pos.y,pos.z,
                            1,
                            0,0,0,
                            0);
                }
                player.forceAddEffect(new MobEffectInstance(MobEffects.STRENGTH, 600, 2, true,false), player);
                player.forceAddEffect(new MobEffectInstance(MobEffects.DARKNESS, 600, 1,true, false), player);

                return InteractionResult.SUCCESS_SERVER;
            } else {
                return InteractionResult.FAIL;
            }
        }
        return InteractionResult.FAIL;
    }
}
