package com.magicgoldfishboy.funwithfood;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class SimpleBlocks {

    public static DeferredBlock<Block> APPLE_BLOCK;
    public static DeferredItem<BlockItem> APPLE_BLOCK_ITEM;

    @SuppressWarnings("null")
    public static void registerAll() {

        APPLE_BLOCK = FunWithFood.BLOCKS.register("apple_block", () -> new Block(BlockBehaviour.Properties.of()
            .strength(1, 1)
            .sound(SoundType.PACKED_MUD)
        ));

        APPLE_BLOCK_ITEM = FunWithFood.ITEMS.registerSimpleBlockItem(SimpleBlocks.APPLE_BLOCK);
    }
    
}
