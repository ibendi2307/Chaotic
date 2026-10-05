package com.example.chaotic.worldgen.biomes;

import com.example.chaotic.BlockRegistry;
import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class TestSurfaceRules {

    private static final SurfaceRules.RuleSource Dirt = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource UraniumBlock = makeStateRule(BlockRegistry.Uranium_Block.value());



    protected static SurfaceRules.RuleSource makeRules()
    {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), Dirt);

        return SurfaceRules.sequence(
                // SurfaceRules.ifTrue(SurfaceRules.isBiome(TestBiomes.strangePlain))
        );
    }


    private static SurfaceRules.RuleSource makeStateRule(Block block)
    {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
