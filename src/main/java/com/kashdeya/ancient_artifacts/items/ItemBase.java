package com.kashdeya.ancient_artifacts.items;

import com.kashdeya.ancient_artifacts.main.ancient_artifacts;
import com.kashdeya.ancient_artifacts.registry.utils.IOreDictEntry;

import net.minecraft.item.Item;

public class ItemBase extends Item implements IOreDictEntry{
	String oredictName;
	
	public ItemBase() {
		super();
		this.setCreativeTab(ancient_artifacts.tabAA);
	}
	
	public ItemBase setOreDictName(String oredictName)
	{
		this.oredictName = oredictName;
		return this;
	}
	
	@Override
	public String getOreDictName() {
		return oredictName;
	}
}
