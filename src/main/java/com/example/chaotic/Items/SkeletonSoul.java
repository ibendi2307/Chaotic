package com.example.chaotic.Items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.Arrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class SkeletonSoul extends Item {
    public SkeletonSoul(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            for(int i = 0; i < 4; i++) {
                Arrow arrow = new Arrow(level, player.getX(), player.getY()+ 1.5D, player.getZ(), new ItemStack(Items.ARROW),  null);
                arrow.setBaseDamage(5.0D);
                arrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0, 5f , 1f);
                level.addFreshEntity(arrow);
            }
            player.getMainHandItem().shrink(1);
            return InteractionResult.CONSUME;
        }
        return InteractionResult.FAIL;
    }
}
