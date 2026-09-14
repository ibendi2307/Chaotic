package com.example.chaotic.datagen;

import com.example.chaotic.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;

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
        shaped(RecipeCategory.COMBAT, ItemRegistry.UraniumSword.get())
                .pattern("DUD")
                .pattern("DUD")
                .pattern(" B ")
                .define('B', Items.BREEZE_ROD)
                .define('D', Items.GOLD_INGOT)
                .define('U', ItemRegistry.Uranium)
                .unlockedBy("uranium_sword",has(ItemRegistry.Uranium))
                .group("Uranium")
                .save(output, "chaotic:uranium_sword_recipe");
        shaped(RecipeCategory.FOOD, ItemRegistry.UraniumCookie.get())
                .pattern("   ")
                .pattern("DUD")
                .pattern("   ")
                .define('D', Items.WHEAT)
                .define('U', ItemRegistry.Uranium.get())
                .group("Uranium")
                .unlockedBy("uranium_cookie", has(ItemRegistry.Uranium))
                .save(output, "chaotic:uranium_cookie_recipe");
    }
}
