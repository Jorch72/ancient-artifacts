package com.kashdeya.ancient_artifacts.handlers;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MaterialHandler {

	// Tools
	public static final Item.ToolMaterial BONE = EnumHelper.addToolMaterial("boneToolMaterial", 0, 49, 1.0F, 1.5F, 15);
	public static final Item.ToolMaterial FLINT = EnumHelper.addToolMaterial("flintToolMaterial", 0, 89, 3.0F, 2.5F, 15);
	public static final Item.ToolMaterial BIRTHDAY = EnumHelper.addToolMaterial("birthdayToolMaterial", 4, 3061, 100.0F, 10.0F, 22);
	public static final Item.ToolMaterial OBSIDIAN = EnumHelper.addToolMaterial("obsidianToolMaterial", 4, 1961, 10.0F, 15.0F, 10);
	public static final Item.ToolMaterial EMERALD = EnumHelper.addToolMaterial("emeraldToolMaterial", 4, 2961, 20.0F, 20.0F, 22);
	public static final Item.ToolMaterial KAPPA = EnumHelper.addToolMaterial("kappaToolMaterial", 1, 31513, 5.0F, 2.0F, 22);
	public static final Item.ToolMaterial BSCIRON = EnumHelper.addToolMaterial("bscIronToolMaterial", 3, 2750, 12.0F, 8.0F, 14);
	public static final Item.ToolMaterial BSCDIAMOND = EnumHelper.addToolMaterial("bscDiamondToolMaterial", 3, 4549, 16.0F, 5.0F, 10);
	public static final Item.ToolMaterial BSCGOLD = EnumHelper.addToolMaterial("bscGoldToolMaterial", 0, 788, 16.0F, 2.0F, 22);
	// Paxels
	public static final Item.ToolMaterial PWOOD = EnumHelper.addToolMaterial("pwoodToolMaterial", 0, 59, 2.0F, 5.0F, 15);
	public static final Item.ToolMaterial PSTONE = EnumHelper.addToolMaterial("pstoneToolMaterial", 1, 131, 4.0F, 7.0F, 5);
	public static final Item.ToolMaterial PIRON = EnumHelper.addToolMaterial("pironToolMaterial", 2, 250, 6.0F, 8.0F, 14);
	public static final Item.ToolMaterial PDIAMOND = EnumHelper.addToolMaterial("pdiamondToolMaterial", 3, 1561, 8.0F, 10.0F, 10);
	public static final Item.ToolMaterial PGOLD = EnumHelper.addToolMaterial("pgoldToolMaterial", 0, 32, 100.0F, 0.0F, 22);
	public static final Item.ToolMaterial POBSIDIAN = EnumHelper.addToolMaterial("pobsidianToolMaterial", 4, 3000, 10.0F, 15.0F, 10);
	public static final Item.ToolMaterial PEMERALD = EnumHelper.addToolMaterial("pemeraldToolMaterial", 4, 4000, 20.0F, 20.0F, 22);
	// SeaAxe
	public static final Item.ToolMaterial SEAIRON = EnumHelper.addToolMaterial("seaIronToolMaterial", 3, 2750, 10.0F, 10.0F, 22);
	// Armor
	public static final ArmorMaterial stoneArmourMaterial = EnumHelper.addArmorMaterial("stoneArmourMaterial", "tp:stone", 15, new int[]{1, 3, 3, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.05F);
	public static final ArmorMaterial flintArmourMaterial = EnumHelper.addArmorMaterial("flintArmourMaterial", "tp:flint", 12, new int[]{1, 3, 3, 1}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.01F);
	public static final ArmorMaterial boneArmourMaterial = EnumHelper.addArmorMaterial("boneArmourMaterial", "tp:bone", 8, new int[]{1, 3, 2, 1}, 8, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.02F);
	public static final ArmorMaterial woodArmourMaterial = EnumHelper.addArmorMaterial("woodArmourMaterial", "tp:wood", 5, new int[]{1, 2, 1, 1}, 5, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.01F);
	public static final ArmorMaterial lavaArmorMaterial = EnumHelper.addArmorMaterial("lavaArmorMaterial", "tp:lava", 50, new int[] {5, 8, 10, 5}, 35, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0F);
	public static final ArmorMaterial witherArmorMaterial = EnumHelper.addArmorMaterial("witherArmorMaterial", "tp:wither", 100, new int[]{6, 9, 11, 6}, 40, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 15.0F);
	public static final ArmorMaterial dragonArmorMaterial = EnumHelper.addArmorMaterial("dragonArmorMaterial", "tp:dragon", 200, new int[]{7, 10, 12, 7}, 75, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 20.0F);
	public static final ArmorMaterial obsidianArmorMaterial = EnumHelper.addArmorMaterial("obsidianArmorMaterial", "tp:obsidian", 33, new int[] {3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.0F);
	public static final ArmorMaterial redstoneArmourMaterial = EnumHelper.addArmorMaterial("redstoneArmourMaterial", "tp:redstone", 20, new int[]{1, 4, 5, 1}, 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.25F);
	public static final ArmorMaterial lapisArmourMaterial = EnumHelper.addArmorMaterial("lapisArmourMaterial", "tp:lapis", 20, new int[]{1, 4, 5, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.5F);
	public static final ArmorMaterial quartzArmourMaterial = EnumHelper.addArmorMaterial("quartzArmourMaterial", "tp:quartz", 20, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.2F);
	public static final ArmorMaterial emeraldArmourMaterial = EnumHelper.addArmorMaterial("emeraldArmourMaterial", "tp:emerald", 43, new int[]{4, 7, 9, 4}, 25, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F);
	public static final ArmorMaterial bamArmourMaterial = EnumHelper.addArmorMaterial("bamArmourMaterial", "tp:bam_tshirt", 43, new int[]{4, 7, 9, 4}, 25, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.5F);
	public static final ArmorMaterial bucketArmourMaterial = EnumHelper.addArmorMaterial("stoneArmourMaterial", "tp:bucket", 15, new int[]{1, 3, 4, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.05F);
	// Fluids
	public static Material VASHOLINE = new MaterialLiquid(MapColor.COLORS[14]);
}
