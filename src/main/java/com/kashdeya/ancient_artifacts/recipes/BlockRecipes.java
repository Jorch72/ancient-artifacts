package com.kashdeya.ancient_artifacts.recipes;

import com.kashdeya.ancient_artifacts.handlers.ConfigHandler;
import com.kashdeya.ancient_artifacts.inits.TechBlocks;
import com.kashdeya.ancient_artifacts.inits.TechItems;
import com.kashdeya.ancient_artifacts.properties.EnumDustColor;
import com.kashdeya.ancient_artifacts.properties.EnumGlowstoneColor;
import com.kashdeya.ancient_artifacts.properties.EnumLampColor;
import com.kashdeya.ancient_artifacts.registry.recipes.ShapedRecipe;
import com.kashdeya.ancient_artifacts.registry.recipes.ShapelessRecipe;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRecipes {
	public static IRecipe SOUL_SANDSTONE, SOUL_SAND;
	
	public static void init() {
		// Nether
			SOUL_SANDSTONE = new ShapedRecipe(new ItemStack(REPLACE ME), 
					"cc",
					"cc",
					'c', new ItemStack(Blocks.SOUL_SAND));
			SOUL_SAND = new ShapelessRecipe(new ItemStack(REPLACE ME), new ItemStack(REPLACE ME));
	}
}
