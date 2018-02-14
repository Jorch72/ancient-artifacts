package com.kashdeya.ancient_artifacts.main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TabAA extends CreativeTabs {

	public TabAA(String label) {
		super(label);
	}
	
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Items.NETHER_STAR);
	}

}
