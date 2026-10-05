package com.example.chaotic.Items;

import com.example.chaotic.Chaotic;
import com.example.chaotic.ItemRegistry;
import com.example.chaotic.Maps;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemLore;

import java.util.List;
import java.util.Locale;

public class Messor extends Item {
    public Messor(Properties properties) {
        super(properties.durability(500)
                .sword(ToolMaterial.NETHERITE,1,-2f)
                .component(DataComponents.LORE, new ItemLore(List.of(Component.translatable("item.chaotic.messor.tooltip").withColor(TextColor.AQUA)))));
    }

    @Override
    public void hurtEnemy(ItemStack itemStack, LivingEntity mob, LivingEntity attacker) {

        if (mob.level().isClientSide()) {
            return ;
        }


        if (mob.getHealth() <= 0.0) {
            String killname = mob.getPlainTextName();
            if (Maps.Souls.containsKey(killname.toLowerCase())) {
                ItemStack stack = new ItemStack(Maps.Souls.get(killname.toLowerCase()).get());
                ItemEntity entity = new ItemEntity(mob.level(), mob.getX(), mob.getY(), mob.getZ(), stack);

                entity.setDefaultPickUpDelay();

                mob.level().addFreshEntity(entity);
            } else {
                ItemStack stack = new ItemStack(ItemRegistry.Plain_Soul.get());
                ItemEntity entity = new ItemEntity(mob.level(), mob.getX(), mob.getY(), mob.getZ(), stack);

                entity.setDefaultPickUpDelay();

                mob.level().addFreshEntity(entity);
            }
        }
        super.hurtEnemy(itemStack, mob, attacker);
    }
}
