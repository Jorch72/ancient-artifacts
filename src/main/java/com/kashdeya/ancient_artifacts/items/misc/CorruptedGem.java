package com.kashdeya.ancient_artifacts.items.misc;

import java.util.List;

import com.kashdeya.ancient_artifacts.items.ItemBase;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CorruptedGem extends ItemBase {
	
	public CorruptedGem() {
		setMaxStackSize(1);
	}
	
	public void onUpdate(ItemStack stack, World worldIn, Entity player, int itemSlot, boolean isSelected) {
		if(player instanceof EntityPlayer)
			((EntityPlayer) player).addPotionEffect(new PotionEffect(MobEffects.POISON, 30 * 20, 0, true, true));
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced)
	{
		tooltip.add(TextFormatting.YELLOW + new TextComponentTranslation("tooltip.warning_1").getFormattedText());
		tooltip.add(TextFormatting.YELLOW + new TextComponentTranslation("tooltip.gem_1").getFormattedText());
	}
}
