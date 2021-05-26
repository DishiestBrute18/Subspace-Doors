package com.dishiestbrute18.subspacedoors.core.init;

import com.dishiestbrute18.subspacedoors.SubspaceDoors;
import com.dishiestbrute18.subspacedoors.common.blocks.CustomBlock;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.ToolItem;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit 
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SubspaceDoors.MOD_ID); 
	
	public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS
			.register("example_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE)
				.strength(5f, 30f)
				.harvestLevel(2)
				.harvestTool(ToolType.PICKAXE)
				.sound(SoundType.METAL)
				.requiresCorrectToolForDrops()));
	
	public static final RegistryObject<CustomBlock> CUSTOM_BLOCK = BLOCKS
			.register("custom_block", () -> new CustomBlock(AbstractBlock.Properties.of(Material.WOOD)
				.harvestTool(ToolType.AXE)
				.harvestLevel(1)
				.sound(SoundType.WOOD)
				.requiresCorrectToolForDrops()));
	
	public static final RegistryObject<Block> EXAMPLE_ORE = BLOCKS
			.register("example_ore", () -> new Block(AbstractBlock.Properties.of(Material.METAL)
				.strength(3f, 15f)
				.harvestLevel(2)
				.harvestTool(ToolType.PICKAXE)
				.sound(SoundType.METAL)
				.requiresCorrectToolForDrops()));
}
