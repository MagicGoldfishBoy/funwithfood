package com.magicgoldfishboy.funwithfood.datagen;

import java.util.Set;
import java.util.stream.Collectors;

import com.magicgoldfishboy.funwithfood.FunWithFood;
import com.magicgoldfishboy.funwithfood.SimpleBlocks;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

public class DropTableDatagen extends BlockLootSubProvider {
    public DropTableDatagen(HolderLookup.Provider lookupProvider) {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS, lookupProvider);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return FunWithFood.BLOCKS.getEntries()
                .stream()
                .map(entry -> entry.get())
                .collect(Collectors.toList());
    }

    @SuppressWarnings("null")
    @Override
    protected void generate() {
     FunWithFood.BLOCKS.getEntries().forEach((a) -> {if (a.get().getName().toString().matches(".*slab.*")) {this.add(a.get(), this::createSlabItemTable);}
     else if (a.get().getName().toString().matches(".*door.*") && (!a.get().getName().toString().matches(".*trap.*"))) {this.add(a.get(), this::createDoorTable);} 
     else {dropSelf(a.get());} });
     }
    
}
