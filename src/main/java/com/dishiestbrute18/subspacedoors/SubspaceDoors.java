package com.dishiestbrute18.subspacedoors;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dishiestbrute18.subspacedoors.core.init.BlockInit;
import com.dishiestbrute18.subspacedoors.core.init.ItemInit;
import com.dishiestbrute18.subspacedoors.world.OreGeneration;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SubspaceDoors.MOD_ID)
public class SubspaceDoors
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "subspacedoors";
    public static final ItemGroup SUBSPACE_DOORS = new SubspaceDoorsGroup("Subspace_Doors");
    
    public SubspaceDoors() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    	bus.addListener(this::setup);
    	
    	ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);
        MinecraftForge.EVENT_BUS.register(this);
   
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    
    }

    public static class SubspaceDoorsGroup extends ItemGroup{

		public SubspaceDoorsGroup(String label) {
			super(label);
		}

		@Override
		public ItemStack makeIcon() {
			//return ItemInit.EXAMPLE_ITEM.get().getDefaultInstance();
			return Items.OAK_DOOR.getDefaultInstance();
		}
    	
		@Override
		public void fillItemList(NonNullList<ItemStack> p_78018_1_) {
			p_78018_1_.add(Items.ACACIA_BOAT.getDefaultInstance());
			super.fillItemList(p_78018_1_);
		}
		
    }
    
}
