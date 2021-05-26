package com.dishiestbrute18.subspacedoors.common.items;

import java.util.List;

import org.lwjgl.glfw.GLFW;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TieredItem;
import net.minecraft.item.ItemStack.TooltipDisplayFlags;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SpecialItem extends SwordItem{
	
	public SpecialItem(IItemTier tier, int attack, float attackSpeed, Properties properties) {

		super(tier, attack, attackSpeed, properties);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack p_77624_1_, World p_77624_2_, List<ITextComponent> p_77624_3_, ITooltipFlag p_77624_4_) {
		// TODO Auto-generated method stub
		super.appendHoverText(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);
		if(InputMappings.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), GLFW.GLFW_KEY_LEFT_SHIFT))
		{
			p_77624_3_.add(new StringTextComponent("Advanced Tooltip"));
		}
		else
		{
			p_77624_3_.add(new TranslationTextComponent("tooltip.subspacedoors.special_item.hold_shift"));
		}

	}
	
	@Override
	public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity playerIn, Hand p_77659_3_) {
		if(!playerIn.getCooldowns().isOnCooldown(this)) {
			playerIn.addEffect(new EffectInstance(Effects.REGENERATION, 200, 3));
			ZombieEntity entity = new ZombieEntity(p_77659_1_);
			entity.setPos(playerIn.getX(), playerIn.getY(), playerIn.getZ());
			p_77659_1_.addFreshEntity(entity);
			playerIn.getCooldowns().addCooldown(this, 100);
			return ActionResult.success(playerIn.getItemInHand(p_77659_3_));
		}
		return ActionResult.fail(playerIn.getItemInHand(p_77659_3_));
	}
}
