package com.magicgoldfishboy.funwithfood;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class Ingots {

    public static DeferredItem<Item> APPLE_INGOT;

    public static void registerAll() {
        APPLE_INGOT = FunWithFood.ITEMS.registerSimpleItem("apple_ingot");
    }
    
}
