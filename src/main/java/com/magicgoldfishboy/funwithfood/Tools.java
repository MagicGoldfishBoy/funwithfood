package com.magicgoldfishboy.funwithfood;

import java.util.function.Supplier;

import com.magicgoldfishboy.funwithfood.block.Grinder;
import com.magicgoldfishboy.funwithfood.block.entity.GrinderEntity;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;

public class Tools {

    public static DeferredBlock<Grinder> GRINDER;

    public static DeferredHolder<BlockEntityType<?>, BlockEntityType<GrinderEntity>> GRINDER_ENTITY;

    public static Supplier<BlockItem> GRINDER_ITEM;

    public static void registerAll() {
        GRINDER = FunWithFood.BLOCKS.register("grinder", () -> new Grinder(BlockBehaviour.Properties.of()
            .strength(1, 1)
            .sound(SoundType.STONE)
        ));

        GRINDER_ENTITY = FunWithFood.BLOCK_ENTITIES.register("grinder_entity",
            () -> BlockEntityType.Builder.of(GrinderEntity::new, GRINDER.get()).build(null));

        GRINDER_ITEM = FunWithFood.ITEMS.registerSimpleBlockItem(Tools.GRINDER);
    }


    
}
