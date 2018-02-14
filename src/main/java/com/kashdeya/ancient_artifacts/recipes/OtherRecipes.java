package com.kashdeya.ancient_artifacts.recipes;

import com.kashdeya.ancient_artifacts.handlers.ConfigHandler;
import com.kashdeya.ancient_artifacts.inits.TechItems;
import com.kashdeya.ancient_artifacts.registry.recipes.ShapedRecipe;
import com.kashdeya.ancient_artifacts.registry.recipes.ShapelessRecipe;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

public class OtherRecipes
{
	public static IRecipe POUCH;
	public static IRecipe CORRUPTED_GEM, CORRUPTED_GEM_2, CORRUPTED_HEXA, CORRUPTED_HEXA_2;
	
	public static void init()
	{
		// Corruption
			CORRUPTED_HEXA = new ShapedRecipe(new ItemStack(TechItems.corrupted_hexa),
					"ccc",
					"ccc",
					"ccc",
					'c', new ItemStack(TechItems.corrupted_shard));
			CORRUPTED_HEXA_2 = new ShapelessRecipe(new ItemStack(TechItems.corrupted_shard, 9), new ItemStack(TechItems.corrupted_hexa));
			
			CORRUPTED_GEM = new ShapedRecipe(new ItemStack(TechItems.corrupted_gem),
					"ccc",
					"ccc",
					"ccc",
					'c', new ItemStack(TechItems.corrupted_hexa));
			CORRUPTED_GEM_2 = new ShapelessRecipe(new ItemStack(TechItems.corrupted_hexa, 9), new ItemStack(TechItems.corrupted_gem));
		
		// Pouch
		if (ConfigHandler.pouch) {
		    POUCH = new ShapedRecipe(new ItemStack(TechItems.pouch), 
		    		"lsl",
		    		"clc",
		    		"lsl",
		    		's', new ItemStack(Items.STRING),
		    		'l', new ItemStack(Items.LEATHER),
		    		'c', new ItemStack(Blocks.CHEST));
		}
	}
}
