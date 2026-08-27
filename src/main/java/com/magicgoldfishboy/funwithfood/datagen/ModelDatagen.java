package com.magicgoldfishboy.funwithfood.datagen;

import javax.annotation.Nonnull;

import com.magicgoldfishboy.funwithfood.FunWithFood;
import com.magicgoldfishboy.funwithfood.Mush;
import com.magicgoldfishboy.funwithfood.Tools;
import com.magicgoldfishboy.funwithfood.block.Grinder;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
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
        registerMushModels();
        registerBlockbenchModels();
    }

    protected void registerMushModels() {
        itemModels().basicItem(Mush.APPLE_MUSH.get());
    }

    protected void registerBlockbenchModels() {

        Grinder grinder = Tools.GRINDER.get();

        ResourceLocation grinderModelFile = ResourceLocation.fromNamespaceAndPath(FunWithFood.MODID, "block/grinder");
        ModelFile grinderModel = new ModelFile.UncheckedModelFile(grinderModelFile);

        ResourceLocation litGrinderModelFile = ResourceLocation.fromNamespaceAndPath(FunWithFood.MODID, "block/grinder_lit");
        ModelFile litGrinderModel = new ModelFile.UncheckedModelFile(litGrinderModelFile);

        getVariantBuilder(grinder)
            //.partialState().setModels(new ConfiguredModel(grinderModel))
            .partialState().with(Grinder.LIT, true).setModels(new ConfiguredModel(litGrinderModel))
            .partialState().with(Grinder.LIT, false).setModels(new ConfiguredModel(grinderModel))
            ;

        simpleBlockItem(grinder, grinderModel);
    }
}