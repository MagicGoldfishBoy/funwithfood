package com.magicgoldfishboy.funwithfood.block;

import javax.annotation.Nullable;

import com.magicgoldfishboy.funwithfood.Tools;
import com.magicgoldfishboy.funwithfood.block.entity.GrinderEntity;
import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class Grinder extends BaseEntityBlock {
    public static final MapCodec<Grinder> CODEC = simpleCodec(Grinder::new);
    public Grinder(Properties properties) {
        super(properties);
    }

    @Override
    @Nullable
    public BlockEntity newBlockEntity(BlockPos arg0, BlockState arg1) {
        return new GrinderEntity(arg0, arg1);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected RenderShape getRenderShape(BlockState arg0) {
        return RenderShape.MODEL;
    }

}
