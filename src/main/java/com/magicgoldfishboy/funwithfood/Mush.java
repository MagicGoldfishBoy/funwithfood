package com.magicgoldfishboy.funwithfood;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class Mush {

    public static DeferredItem<Item> APPLE_MUSH;

    public static void registerAll() {
        APPLE_MUSH = FunWithFood.ITEMS.registerSimpleItem("apple_mush");
    }
    
}
