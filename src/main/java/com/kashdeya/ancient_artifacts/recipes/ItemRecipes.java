package com.kashdeya.ancient_artifacts.recipes;

import com.kashdeya.ancient_artifacts.inits.TechItems;
import com.kashdeya.ancient_artifacts.registry.recipes.ShapedRecipe;

import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.potion.PotionUtils;

public class ItemRecipes {
	
	public static IRecipe STONE_HAMMER;
	
	public static IRecipe WITHER_RING, POSION_RING, FIRE_RING, NAUSEA_RING, MASTER_RING, STARTER_RING;
	
		public static void init() {
			// Rings
				WITHER_RING = new ShapedRecipe(new ItemStack(TechItems.wither_ring), 
						"sms",
						"aha",
						"sms",
						'h', new ItemStack(TechItems.starter_ring),
						'm', new ItemStack(Items.MILK_BUCKET),
						'a', PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.LONG_INVISIBILITY),
						's', new ItemStack(TechItems.corrupted_gem));
				FIRE_RING = new ShapedRecipe(new ItemStack(TechItems.fire_ring), 
						"sms",
						"aha",
						"sms",
						'h', new ItemStack(TechItems.starter_ring),
						'm', new ItemStack(Items.MAGMA_CREAM),
						'a', PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.LONG_FIRE_RESISTANCE),
						's', new ItemStack(TechItems.corrupted_hexa));
				POSION_RING = new ShapedRecipe(new ItemStack(TechItems.posion_ring), 
						"sms",
						"aha",
						"sms",
						'h', new ItemStack(TechItems.starter_ring),
						'm', new ItemStack(Items.SPIDER_EYE),
						'a', PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.LONG_POISON),
						's', new ItemStack(TechItems.corrupted_shard));
				NAUSEA_RING = new ShapedRecipe(new ItemStack(TechItems.nausea_ring), 
						"sms",
						"aha",
						"sms",
						'h', new ItemStack(TechItems.starter_ring),
						'm', new ItemStack(Items.GHAST_TEAR),
						'a', PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.MUNDANE),
						's', new ItemStack(TechItems.corrupted_shard));
				MASTER_RING = new ShapedRecipe(new ItemStack(TechItems.master_ring), 
						"wf",
						"np",
						'w', new ItemStack(TechItems.wither_ring),
						'f', new ItemStack(TechItems.fire_ring),
						'n', new ItemStack(TechItems.nausea_ring),
						'p', new ItemStack(TechItems.posion_ring));
			// Can not be turned off.
				STONE_HAMMER = new ShapedRecipe(new ItemStack(TechItems.corrutped_hammer),					
						"cic",
						"isi",
						" s ",
						'i', Items.STRING,
						's', Items.STICK,
						'c', REPLACE ME);
				STARTER_RING = new ShapedRecipe(new ItemStack(TechItems.starter_ring),
						"sss",
						"shs",
						"sss",
						's', new ItemStack(Items.IRON_INGOT),
						'h', new ItemStack(TechItems.corrutped_hammer));
			
		}

}
