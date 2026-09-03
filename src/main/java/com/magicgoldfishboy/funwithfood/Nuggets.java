package com.magicgoldfishboy.funwithfood;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class Nuggets {

    public static DeferredItem<Item> APPLE_NUGGET;

    public static void registerAll() {
        APPLE_NUGGET = FunWithFood.ITEMS.registerSimpleItem("apple_nugget");
    }
    
}
