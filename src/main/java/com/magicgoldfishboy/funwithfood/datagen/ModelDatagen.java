package com.magicgoldfishboy.funwithfood.datagen;

import javax.annotation.Nonnull;

import com.magicgoldfishboy.funwithfood.FunWithFood;
import com.magicgoldfishboy.funwithfood.Tools;
import com.magicgoldfishboy.funwithfood.block.Grinder;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModelDatagen extends BlockStateProvider {

    public ModelDatagen(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FunWithFood.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        registerBlockbenchModels();
    }

    protected void registerBlockbenchModels() {
        Grinder grinder = Tools.GRINDER.get();
        ResourceLocation grinderModelFile = ResourceLocation.fromNamespaceAndPath(FunWithFood.MODID, "block/grinder");
        ModelFile grinderModel = new ModelFile.UncheckedModelFile(grinderModelFile);

        getVariantBuilder(grinder).partialState()
            .setModels(new ConfiguredModel(grinderModel));
    }
}