package com.dishiestbrute18.subspacedoors.common.blocks;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;


public class BaseHorizontalBlock extends Block {

	protected static final Map<Block, Map<Direction, VoxelShape>> SHAPES = new HashMap<Block, Map<Direction, VoxelShape>>();
	public static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
	
	public BaseHorizontalBlock(Properties properties) {
		super(properties);
		
		this.registerDefaultState(this.stateDefinition.any().getBlockState().setValue(HORIZONTAL_FACING, Direction.NORTH));
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState p_185471_1_, Mirror p_185471_2_) {
		// TODO Auto-generated method stub
		return p_185471_1_.rotate(p_185471_2_.getRotation(p_185471_1_.getValue(HORIZONTAL_FACING)));
	}
	
	@Override
	public BlockState rotate(BlockState p_185499_1_, Rotation p_185499_2_) {
		// TODO Auto-generated method stub
		return p_185499_1_.setValue(HORIZONTAL_FACING, p_185499_2_.rotate(p_185499_1_.getValue(HORIZONTAL_FACING)));
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
		// TODO Auto-generated method stub
		return this.defaultBlockState().setValue(HORIZONTAL_FACING, p_196258_1_.getHorizontalDirection().getOpposite()); //.getOpposite() can be added to the last getHorizontalDirction()
	}
	
	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> p_206840_1_) {
		// TODO Auto-generated method stub
		super.createBlockStateDefinition(p_206840_1_);
		p_206840_1_.add(HORIZONTAL_FACING);
	}

	protected static VoxelShape calculateShapes(Direction to, VoxelShape shape) {
		VoxelShape[] buffer = new VoxelShape[] { shape, VoxelShapes.empty() };

		int times = (to.get2DDataValue() - Direction.NORTH.get2DDataValue() + 4) % 4;
		for (int i = 0; i < times; i++) {
			buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = VoxelShapes.or(buffer[1],
					VoxelShapes.box(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
			buffer[0] = buffer[1];
			buffer[1] = VoxelShapes.empty();
		}

		return buffer[0];
	}

	protected void runCalculation(VoxelShape shape) {
		SHAPES.put(this, new HashMap<Direction, VoxelShape>());
		Map<Direction, VoxelShape> facingMap = SHAPES.get(this);
		for (Direction direction : Direction.values()) 
	    {
			facingMap.put(direction, calculateShapes(direction, shape));
		}
	}
	
	
}
