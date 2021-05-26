package com.dishiestbrute18.subspacedoors.client.event;

import com.dishiestbrute18.subspacedoors.SubspaceDoors;
import com.dishiestbrute18.subspacedoors.core.init.ItemInit;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = SubspaceDoors.MOD_ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {

	@SubscribeEvent
	public static void renderHand(final RenderHandEvent event) {
		MatrixStack stack = event.getMatrixStack();
		if(event.getItemStack().getItem().equals(ItemInit.SPECIAL_ITEM.get())) {
			//event.setCanceled(true);
		}
	}
}
