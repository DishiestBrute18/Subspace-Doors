package com.dishiestbrute18.subspacedoors.core.init;

import com.dishiestbrute18.subspacedoors.SubspaceDoors;
import com.dishiestbrute18.subspacedoors.common.items.SpecialItem;

import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item.Properties;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SubspaceDoors.MOD_ID);
	
	
	
	public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties().tab(SubspaceDoors.SUBSPACE_DOORS)));
	
	public static final RegistryObject<SpecialItem> SPECIAL_ITEM = ITEMS.register("special_item", () -> new SpecialItem(ItemTier.WOOD,30, 2f,  new Item.Properties().tab(SubspaceDoors.SUBSPACE_DOORS).stacksTo(1).defaultDurability(4000)));
	
	public static final RegistryObject<Item> EXAMPLE_FOOD = ITEMS.register("example_food", () -> new Item(new Item.Properties().tab(SubspaceDoors.SUBSPACE_DOORS).food(new Food.Builder()
			.effect(()->new EffectInstance(Effects.REGENERATION, 200, 3), 0.5f)
			.fast()
			.nutrition(6)
			.meat()
			.alwaysEat().build())));
	
	
	//Block Items
	public static final RegistryObject<BlockItem> EXAMPLE_BLOCK = ITEMS.register("example_block", () -> new BlockItem(BlockInit.EXAMPLE_BLOCK.get(), new Item.Properties().tab(SubspaceDoors.SUBSPACE_DOORS)));
	
	public static final RegistryObject<BlockItem> CUSTOME_BLOCK = ITEMS.register("custom_block", () -> new BlockItem(BlockInit.CUSTOM_BLOCK.get(), new Item.Properties().tab(SubspaceDoors.SUBSPACE_DOORS)));
	
	public static final RegistryObject<BlockItem> EXAMPLE_ORE = ITEMS.register("example_ore", () -> new BlockItem(BlockInit.EXAMPLE_ORE.get(), new Item.Properties().tab(SubspaceDoors.SUBSPACE_DOORS)));
	
}
