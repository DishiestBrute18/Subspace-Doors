package com.dishiestbrute18.subspacedoors.core.event;

import java.util.Random;

import com.dishiestbrute18.subspacedoors.SubspaceDoors;
import com.dishiestbrute18.subspacedoors.common.blocks.CustomBlock;
import com.dishiestbrute18.subspacedoors.core.init.BlockInit;

import net.minecraft.block.AnvilBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;;

@EventBusSubscriber(modid = SubspaceDoors.MOD_ID, bus = Bus.FORGE)
public class EventHandler {

	
	@SubscribeEvent
	public static void onBlockBreak(final BlockEvent.BreakEvent event) {
		IWorld world = event.getWorld();
		BlockPos pos = event.getPos();
		if(event.getState().getBlock() instanceof AnvilBlock) {
			EventHandler.setBlocks(world, pos, world.getRandom());
		}
		else if(event.getPlayer().hasItemInSlot(EquipmentSlotType.HEAD) && world instanceof World) {
			ArmorStandEntity armorStand = new ArmorStandEntity(EntityType.ARMOR_STAND, (World) world);
			armorStand.setPos(pos.getX(), pos.getY(), pos.getZ());
			event.getWorld().addFreshEntity(armorStand);
		}
	}
	
	private static void setBlocks(IWorld world, BlockPos pos, Random rand) {
		for(int i = -5; i < 5; i++)
		{
			for(int j = -5; j < 5; j++)
			{
				for(int k = -5; k < 5; k++)
				{
					world.setBlock(pos.offset(i, j, k), BlockInit.CUSTOM_BLOCK.get().defaultBlockState().setValue(CustomBlock.HORIZONTAL_FACING,
							Direction.Plane.HORIZONTAL.getRandomDirection(rand)), 
							Constants.BlockFlags.BLOCK_UPDATE);
					
					
				}
			}
		}
	}
}
