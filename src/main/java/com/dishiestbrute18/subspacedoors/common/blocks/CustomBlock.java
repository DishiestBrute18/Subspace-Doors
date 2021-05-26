package com.dishiestbrute18.subspacedoors.common.blocks;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import com.dishiestbrute18.subspacedoors.common.blocks.BaseHorizontalBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class CustomBlock extends BaseHorizontalBlock{


	public CustomBlock(Properties properties) {
		super(properties);
		runCalculation(Stream.of(
				Block.box(0, 0, 0, 16, 4, 16),
				Block.box(0, 8, 9, 16, 11, 16),
				Block.box(0, 4, 4, 16, 8, 16)
				).reduce((v1, v2) -> {return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get());
	}
	
	@Override
	public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
		// TODO Auto-generated method stub
		return SHAPES.get(this).get(p_220053_1_.getValue(HORIZONTAL_FACING));
	}

}
