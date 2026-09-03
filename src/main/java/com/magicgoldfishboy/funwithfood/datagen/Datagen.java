package com.magicgoldfishboy.funwithfood.datagen;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class Datagen {
    @SuppressWarnings("null")
    public void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(
            event.includeClient(),
            new ModelDatagen(output, existingFileHelper)
        );
        generator.addProvider(
            event.includeClient(),
            new RecipeDatagen(output, lookupProvider)
        );
        event.createProvider((packOutput, lootLookupProvider) -> new LootTableProvider(
            packOutput,
            Set.of(),
            List.of(
                new LootTableProvider.SubProviderEntry(
                    DropTableDatagen::new,
                    LootContextParamSets.BLOCK
                )
            ),
            lootLookupProvider
        ));
    }
}