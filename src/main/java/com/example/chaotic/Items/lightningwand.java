package com.example.chaotic.Items;


import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.extensions.IItemExtension;

public class lightningwand extends Item  implements IItemExtension {

    public lightningwand(Properties properties) {
        super(properties.durability(85));
    }


    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            Vec3 start = player.getEyePosition();
            Vec3 look = player.getViewVector(1f);
            Vec3 end = start.add(look.scale(45.0D));
            ServerLevel srvlevel = (ServerLevel) level;
            AABB hitray = new AABB(start, end);

            BlockHitResult blockhit = level.clip(new ClipContext(start, end, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));

            if (blockhit.getType() == HitResult.Type.BLOCK) {

                BlockPos hitpos = blockhit.getBlockPos();
                LightningBolt lightningBolt = EntityTypes.LIGHTNING_BOLT.create(srvlevel, EntitySpawnReason.SPAWN_ITEM_USE);
                if (lightningBolt != null) {
                    lightningBolt.setPos(hitpos.getX(), hitpos.getY(), hitpos.getZ());
                    srvlevel.addFreshEntity(lightningBolt);
                    player.getCooldowns().addCooldown(player.getItemInHand(hand), 100);
                    player.getItemInHand(hand).hurtAndBreak(5, player.getLivingEntity(), hand);
                    double len = end.subtract(start).length();
                    Vec3 step = end.subtract(start).normalize().scale(0.5);

                    for (double d = 0; d < len; d += 0.5) {
                        Vec3 pos = start.add(step.scale(d / 0.5));

                        srvlevel.sendParticles(ParticleTypes.CRIT,
                                pos.x,pos.y,pos.z,
                                1,
                                0,0,0,
                                0);
                    }
                }

            }

        }
        return super.use(level, player, hand);
    }

   /* @Override
    public InteractionResult useOn(UseOnContext context) {
        if (!context.getLevel().isClientSide() && !context.getPlayer().getCooldowns().isOnCooldown(context.getItemInHand())) {
            ServerLevel serverLevel = (ServerLevel) context.getLevel();
            LightningBolt lightningBolt = EntityTypes.LIGHTNING_BOLT.create(serverLevel, EntitySpawnReason.SPAWN_ITEM_USE);
            if (lightningBolt != null) {
                lightningBolt.setPos(context.getClickLocation());
                serverLevel.addFreshEntity(lightningBolt);
                context.getPlayer().getCooldowns().addCooldown(context.getItemInHand(), 100);
                context.getItemInHand().hurtAndBreak(5, context.getPlayer().getLivingEntity(), context.getHand());
            }
        }
        return super.useOn(context);
    }*/

    @Override
    public boolean isDamageable(ItemStack stack) {
        return true;
    }
}
