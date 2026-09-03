package com.magicgoldfishboy.funwithfood.datagen;

import java.util.concurrent.CompletableFuture;

import com.magicgoldfishboy.funwithfood.Ingots;
import com.magicgoldfishboy.funwithfood.Mush;
import com.magicgoldfishboy.funwithfood.Nuggets;
import com.magicgoldfishboy.funwithfood.SimpleBlocks;
import com.magicgoldfishboy.funwithfood.Tools;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class RecipeDatagen extends RecipeProvider {
    
    public RecipeDatagen(PackOutput output, CompletableFuture<Provider> registries) {
        super(output, registries);
    }

    @SuppressWarnings("null")
    @Override
    protected void buildRecipes(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, Tools.GRINDER_ITEM.get())
            .pattern("$#$")
            .pattern("#%#")
            .pattern("$#$")
            .define('#', Items.IRON_INGOT)
            .define('$', Items.REDSTONE)
            .define('%', Items.SHEARS)
            .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
            .unlockedBy("has_redstone", has(Items.REDSTONE))
            .save(output);

        buildIngotRecipes(output);
        buildNuggetRecipes(output);
        buildSimpleBlockRecipes(output);

    }

    @SuppressWarnings("null")
    protected void buildIngotRecipes(RecipeOutput output) {

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Mush.APPLE_MUSH.get()),
            RecipeCategory.MISC, Ingots.APPLE_INGOT.get(),
            1.0f, 200)
            .unlockedBy("has_apple_mush", has(Mush.APPLE_MUSH.get()))
            .save(output, "apple_ingot_from_smelting");

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(Mush.APPLE_MUSH.get()), 
        RecipeCategory.MISC, Ingots.APPLE_INGOT.get(), 1.0f, 100)
            .unlockedBy("has_apple_mush", has(Mush.APPLE_MUSH.get()))
            .save(output, "apple_ingot_from_smoking");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Ingots.APPLE_INGOT.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', Nuggets.APPLE_NUGGET.get())
            .unlockedBy("has_apple_nugget", has(Nuggets.APPLE_NUGGET.get()))
            .save(output, "apple_ingot_from_crafting");
    }

    @SuppressWarnings("null")
    protected void buildNuggetRecipes(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Nuggets.APPLE_NUGGET.get(), 9)
            .pattern("#")
            .define('#', Ingots.APPLE_INGOT.get())
            .unlockedBy("has_apple_ingot", has(Ingots.APPLE_INGOT.get()))
            .save(output, "apple_nugget_from_crafting");
    }

    @SuppressWarnings("null")
    protected void buildSimpleBlockRecipes(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SimpleBlocks.APPLE_BLOCK.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', Ingots.APPLE_INGOT.get())
            .unlockedBy("has_apple_ingot", has(Ingots.APPLE_INGOT.get()))
            .save(output, "apple_block_from_crafting");
        // ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SimpleBlocks.APPLE_BLOCK.get())
        //     .pattern("###")
        //     .pattern("###")
        //     .pattern("###")
        //     .define('#', Ingots.APPLE_INGOT.get())
        //     .unlockedBy("has_apple_ingot", has(Ingots.APPLE_INGOT.get()))
        //     .save(output, "apple_block_from_crafting");
    }
}
