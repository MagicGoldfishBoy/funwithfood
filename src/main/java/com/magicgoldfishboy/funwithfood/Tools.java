package com.magicgoldfishboy.funwithfood;

import java.util.function.Supplier;

import com.magicgoldfishboy.funwithfood.block.Grinder;
import com.magicgoldfishboy.funwithfood.block.entity.GrinderEntity;
import com.magicgoldfishboy.funwithfood.screen.GrinderMenu;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;

public class Tools {

    public static DeferredBlock<Grinder> GRINDER;

    public static Supplier<BlockEntityType<GrinderEntity>> GRINDER_ENTITY;

    public static Supplier<BlockItem> GRINDER_ITEM;

    public static DeferredHolder<MenuType<?>, MenuType<GrinderMenu>> GRINDER_MENU;

    private static <I extends AbstractContainerMenu>DeferredHolder<MenuType<?>, MenuType<I>> registerMenuType(String name,
        IContainerFactory<I> factory) {
            return FunWithFood.MENUS.register(name, () -> IMenuTypeExtension.create(factory));
        }

    public static void registerAll() {
        GRINDER = FunWithFood.BLOCKS.register("grinder", () -> new Grinder(BlockBehaviour.Properties.of()
            .strength(1, 1)
            .sound(SoundType.STONE)
        ));

        GRINDER_ENTITY = FunWithFood.BLOCK_ENTITIES.register("grinder_entity",
            () -> BlockEntityType.Builder.of(GrinderEntity::new, GRINDER.get()).build(null));

        GRINDER_ITEM = FunWithFood.ITEMS.registerSimpleBlockItem(Tools.GRINDER);

        GRINDER_MENU = registerMenuType("grinder_menu", GrinderMenu::new);
    }


    
}
