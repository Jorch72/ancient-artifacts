package com.kashdeya.ancient_artifacts.items;

import java.util.List;

import com.kashdeya.ancient_artifacts.main.ancient_artifacts;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemStay extends Item {
	
	public ItemStay() {
		super();
		super.setMaxStackSize(1);
		super.setContainerItem(this);
		this.setCreativeTab(ancient_artifacts.tabAA);
	}
	
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack)
	{
			return false;
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack itemStack)
	{
		ItemStack stack = itemStack.copy();
		stack.setCount(1);

		return stack;
	}
	
    @Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced)
    {
    	tooltip.add(TextFormatting.YELLOW + new TextComponentTranslation("tooltip.stay_1").getFormattedText());
    }
}