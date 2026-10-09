package com.example.chaotic.datagen;

import com.example.chaotic.BlockRegistry;
import com.example.chaotic.ItemRegistry;
import com.example.chaotic.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    protected ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "Chaotic Recipies";
        }
    }

    @Override
    protected void buildRecipes() {
        smeltingResultFromBase(ItemRegistry.Animatium.asItem(), ItemRegistry.Raw_Animatium.asItem());
        shaped(RecipeCategory.COMBAT, ItemRegistry.Messor.asItem())
                .pattern("  A")
                .pattern("AAA")
                .pattern("S  ")
                .define('A', ItemRegistry.Animatium)
                .define('S', Items.STICK)
                .unlockedBy("animatium", has(ItemRegistry.Animatium))
                .group("Animatium")
                .save(output, "chaotic:messor_recipe");
        shapeless(RecipeCategory.BUILDING_BLOCKS, BlockRegistry.Uranium_Block.asItem(), 9);
        shaped(RecipeCategory.MISC, ItemRegistry.Soul_Core.asItem())
                .pattern("IGI")
                .pattern("GSG")
                .pattern("IGI")
                .define('I', Items.IRON_INGOT)
                .define('G', Items.GLASS_PANE)
                .define('S', ModTags.Items.Soul_Tag)
                .unlockedBy("soul_core", has(ModTags.Items.Soul_Tag))
                .group("Soul")
                .save(output, "chaotic:soul_core_recipe");
        shaped(RecipeCategory.COMBAT, ItemRegistry.Securis.asItem())
                .pattern("ACA")
                .pattern("AS ")
                .pattern(" S ")
                .define('A', ItemRegistry.Animatium)
                .define('C', ItemRegistry.Soul_Core)
                .define('S', Items.STICK)
                .unlockedBy("securis", has(ItemRegistry.Animatium))
                .group("Animatium")
                .save(output, "chaotic:securis_recipe");
        shaped(RecipeCategory.COMBAT, ItemRegistry.UraniumSword.get())
                .pattern("DUD")
                .pattern("DUD")
                .pattern(" B ")
                .define('B', Items.BREEZE_ROD)
                .define('D', Items.GOLD_INGOT)
                .define('U', ItemRegistry.Uranium)
                .unlockedBy("uranium_sword",has(ItemRegistry.Uranium))
                .save(output, "chaotic:uranium_sword_recipe");
        shaped(RecipeCategory.FOOD, ItemRegistry.UraniumCookie.get())
                .pattern("   ")
                .pattern("DUD")
                .pattern("   ")
                .define('D', Items.WHEAT)
                .define('U', ItemRegistry.Uranium.get())
                .group("uranium_food")
                .unlockedBy("uranium_cookie", has(ItemRegistry.Uranium))
                .save(output, "chaotic:uranium_cookie_recipe");
        shaped(RecipeCategory.MISC, ItemRegistry.UraniumNecklace.get())
                .pattern("NNN")
                .pattern("GUG")
                .pattern(" G ")
                .group("uranium_curios")
                .define('N', Items.GOLD_NUGGET)
                .define('G', Items.GOLD_INGOT)
                .define('U', ItemRegistry.Uranium)
                .unlockedBy("uranium_necklace", has(ItemRegistry.Uranium))
                .save(output, "chaotic:uranium_necklace_recipe");
        shaped(RecipeCategory.MISC, ItemRegistry.EnrichedUranium.get())
                .pattern("GGG")
                .pattern("GUG")
                .pattern("GGG")
                .define('G', Items.GLOWSTONE_DUST)
                .define('U', ItemRegistry.Uranium)
                .unlockedBy("enriched_uranium", has(ItemRegistry.Uranium))
                .save(output, "chaotic:enrichment_uranium");
        shaped(RecipeCategory.MISC, BlockRegistry.EUBItem)
                .pattern("EGE")
                .pattern("GEG")
                .pattern("EGE")
                .define('E', ItemRegistry.EnrichedUranium)
                .define('G', Items.GLOWSTONE_DUST)
                .unlockedBy("enriched_uranium_block", has(ItemRegistry.EnrichedUranium))
                .save(output, "chaotic:enriched_uranium_block_recipe");
        shaped(RecipeCategory.FOOD, ItemRegistry.UraniumDrink)
                .pattern(" U ")
                .pattern(" B ")
                .pattern("   ")
                .group("uranium_food")
                .define('U', ItemRegistry.Uranium)
                .define('B', Items.GLASS_BOTTLE)
                .unlockedBy("uranium_drink", has(ItemRegistry.Uranium))
                .save(output, "chaotic:uranium_drink_recipe");
        shaped(RecipeCategory.COMBAT, ItemRegistry.LightningWand)
                .pattern(" R ")
                .pattern(" SR")
                .pattern("S  ")
                .define('R', Items.COPPER_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("lightning_wand", has(Items.COPPER_INGOT))
                .save(output, "chaotic:lightning_wand_recipe");
        shaped(RecipeCategory.COMBAT, ItemRegistry.LightningStaff)
                .pattern("  C")
                .pattern(" B ")
                .pattern("B  ")
                .define('B', Items.BREEZE_ROD)
                .define('C', Items.COPPER_BLOCK.asList().get(0))
                .unlockedBy("lightning_staff", has(ItemRegistry.LightningWand))
                .save(output, "chaotic:lighting_staff_recipe");
        shaped(RecipeCategory.MISC, ItemRegistry.UraniumRing)
                .pattern(" G ")
                .pattern("U G")
                .pattern(" G ")
                .group("uranium_curios")
                .define('G',Items.GOLD_INGOT)
                .define('U', ItemRegistry.Uranium)
                .unlockedBy("uranium_ring", has(ItemRegistry.Uranium))
                .save(output, "chaotic:uranium_ring_recipe");
        shaped(RecipeCategory.COMBAT, ItemRegistry.EndSword)
                .pattern(" O ")
                .pattern(" O ")
                .pattern(" P ")
                .define('O', Items.OBSIDIAN)
                .define('P', Items.PURPUR_BLOCK)
                .unlockedBy("end_sword", has(Items.PURPUR_BLOCK))
                .save(output, "chaotic:end_sword_recipe");
        shaped(RecipeCategory.MISC, ItemRegistry.Creaking_soul)
                .pattern("PRP")
                .pattern("RSR")
                .pattern("PRP")
                .define('R', Items.RESIN_CLUMP)
                .define('S', ItemRegistry.Soul_Core)
                .define('P', Blocks.PALE_OAK_LOG)
                .unlockedBy("creaking_soul", has(ItemRegistry.Soul_Core))
                .save(output, "chaotic:creaking_soul_recipe");
        shaped(RecipeCategory.MISC, ItemRegistry.Sculk_Soul)
                .pattern("SSS")
                .pattern("SPS")
                .pattern("SSS")
                .define('S', Blocks.SCULK)
                .define('P', ModTags.Items.Soul_Tag)
                .unlockedBy("sculk_soul", has(ItemRegistry.Plain_Soul))
                .save(output, "chaotic:soul_corruption");
        shaped(RecipeCategory.MISC, ItemRegistry.Warden_Soul)
                .pattern("SSS")
                .pattern("SCS")
                .pattern("SRS")
                .define('S', ItemRegistry.Sculk_Soul)
                .define('C', ItemRegistry.Soul_Core)
                .define('R', Blocks.SCULK_CATALYST)
                .unlockedBy("warden_soul", has(ItemRegistry.Sculk_Soul))
                .save(output, "chaotic:warden_soul_craft");
        shapeless(RecipeCategory.COMBAT, ItemRegistry.Sonic_Boom_Horn)
                .requires(Items.GOAT_HORN)
                .requires(ItemRegistry.Sculk_Soul)
                .unlockedBy("sonic_boom_horn", has(ItemRegistry.Sculk_Soul))
                .save(output,"chaotic:sonic_boom_horn_craft");
    }
}
