package com.kashdeya.ancient_artifacts.util;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.oredict.OreDictionary;

public class OreDict {
	
	public static void init()
	{
		// Vanilla Ore Dicts
		OreDictionary.registerOre("flint", Items.FLINT);
		OreDictionary.registerOre("blockGravel", Blocks.GRAVEL);
		OreDictionary.registerOre("glassBottle", Items.GLASS_BOTTLE);
		OreDictionary.registerOre("dragonEgg", Blocks.DRAGON_EGG);
	}
}
