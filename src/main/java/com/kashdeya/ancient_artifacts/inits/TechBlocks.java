package com.kashdeya.ancient_artifacts.inits;

import com.kashdeya.ancient_artifacts.blocks.ores.CorruptedBlock;

import net.minecraft.block.Block;

public class TechBlocks {
	// Corrupted Ore
	public static Block corrupted_ore;
	
    
	public static void init() {
		// Corrupted Ore
		corrupted_ore = new CorruptedBlock();
		
	}
}
