package com.example.chaotic;

import com.example.chaotic.blockentities.EUBentity;
import com.example.chaotic.blockentities.enrichment_table_entity;
import com.example.chaotic.entities.CaveDweller;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class Entitiesreg {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_REGISTER = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Chaotic.MODID);


    public static final Supplier<BlockEntityType<enrichment_table_entity>> ETEREG = BLOCK_ENTITY_REGISTER.register("enrichment_table_entity",
            () -> new BlockEntityType<>(enrichment_table_entity::new, BlockRegistry.Enrichment_Table.get()));

    public static final Supplier<BlockEntityType<EUBentity>> EUBEntityreg =
            BLOCK_ENTITY_REGISTER.register("eub_be",
                    () -> new BlockEntityType<>(EUBentity::new, BlockRegistry.EnrichedUraniumBlock.get()));
    public static final DeferredRegister.Entities Entitiesreg = DeferredRegister.createEntities(Chaotic.MODID);

    public static final Supplier<EntityType<CaveDweller>> CaveDwellerreg = Entitiesreg.registerEntityType("cave_dweller", CaveDweller::new, MobCategory.CREATURE);


    public static void register(IEventBus bus ) {
        BLOCK_ENTITY_REGISTER.register(bus);
        Entitiesreg.register(bus);
    }
}
