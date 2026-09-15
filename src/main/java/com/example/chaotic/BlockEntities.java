package com.example.chaotic;

import com.example.chaotic.blocks.EUBentity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_REGISTER = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Chaotic.MODID);

    public static final Supplier<BlockEntityType<EUBentity>> EUBEntityreg =
            BLOCK_ENTITY_REGISTER.register("eub_be",
                    () -> new BlockEntityType<>(EUBentity::new, BlockRegistry.EnrichedUraniumBlock.get()));

    public static void register(IEventBus bus ) {
        BLOCK_ENTITY_REGISTER.register(bus);
    }
}
