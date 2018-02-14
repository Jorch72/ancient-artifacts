package com.kashdeya.ancient_artifacts.inits;

import com.kashdeya.ancient_artifacts.items.ItemBase;
import com.kashdeya.ancient_artifacts.items.ItemStay;
import com.kashdeya.ancient_artifacts.items.artifacts.BreathingRing;
import com.kashdeya.ancient_artifacts.items.artifacts.FireRing;
import com.kashdeya.ancient_artifacts.items.artifacts.LeapRing;
import com.kashdeya.ancient_artifacts.items.artifacts.MasterRing;
import com.kashdeya.ancient_artifacts.items.artifacts.NauseaRing;
import com.kashdeya.ancient_artifacts.items.artifacts.PosionRing;
import com.kashdeya.ancient_artifacts.items.artifacts.RegenRing;
import com.kashdeya.ancient_artifacts.items.artifacts.WitherRing;
import com.kashdeya.ancient_artifacts.items.misc.CorruptedGem;
import com.kashdeya.ancient_artifacts.items.misc.CorruptedHexa;
import com.kashdeya.ancient_artifacts.items.misc.CorruptedShard;
import com.kashdeya.ancient_artifacts.items.misc.Pouch;

import net.minecraft.item.Item;

public class TechItems {
	// Special Rings
	public static Item wither_ring;
	public static Item posion_ring;
	public static Item nausea_ring;
	// Potion Rings
	public static Item fire_ring;
	public static Item breathing_ring;
	public static Item leap_ring;
	public static Item regen_ring;
	public static Item speed_ring;
	public static Item night_ring;
	public static Item strength_ring;
	public static Item haste_ring;
	// basic Rings
	public static Item lava_ring;
	public static Item water_ring;
	// Advanced Rings
	
	// MAYBE
	public static Item master_ring;
	public static Item starter_ring;
	
	// Pouch
	public static Item pouch;
	
	// Corrupted
	public static Item corrupted_shard;
	public static Item corrupted_hexa;
	public static Item corrupted_gem;
	
	public static Item corrutped_hammer;
		
	public static void init() {
		
		// Master Ring
		master_ring = new MasterRing().setUnlocalizedName("master_ring");
		
		// Potion Rings
		breathing_ring = new BreathingRing().setUnlocalizedName("breathing_ring");
		leap_ring = new LeapRing().setUnlocalizedName("leap_ring");
		fire_ring = new FireRing().setUnlocalizedName("fire_ring");
		regen_ring = new RegenRing().setUnlocalizedName("regen_ring");
		//speed_ring = new SpeedRing().setUnlocalizedName("speed_ring");
		//haste_ring = new HasteRing().setUnlocalizedName("haste_ring");
		//strength_ring = new StrengthRing().setUnlocalizedName("strength_ring");
		//night_ring = new NightRing().setUnlocalizedName("night_ring");
			
		// Special Rings
		nausea_ring = new NauseaRing().setUnlocalizedName("nausea_ring");
		posion_ring = new PosionRing().setUnlocalizedName("posion_ring");
		wither_ring = new WitherRing().setUnlocalizedName("wither_ring");
		
		// Basic Rings
		//lava_ring = new LavaRing().setUnlocalizedName("lava_ring");
		//water_ring = new WaterRing().setUnlocalizedName("water_ring");
		
		
		// Pouch
		pouch = new Pouch().setUnlocalizedName("pouch");
		
		corrutped_hammer = new ItemStay().setUnlocalizedName("corrutped_hammer");
	    starter_ring = new ItemBase().setUnlocalizedName("starter_ring");
	    // Corrupted
	    corrupted_shard = new CorruptedShard().setOreDictName("shardCorrupted").setUnlocalizedName("corrupted_shard");
	    corrupted_hexa = new CorruptedHexa().setOreDictName("hexaCorrupted").setUnlocalizedName("corrupted_hexa");
	    corrupted_gem = new CorruptedGem().setOreDictName("gemCorrupted").setUnlocalizedName("corrupted_gem");
	}
}
