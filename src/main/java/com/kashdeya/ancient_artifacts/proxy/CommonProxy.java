package com.kashdeya.ancient_artifacts.proxy;

import com.kashdeya.ancient_artifacts.handlers.FuelHandler;
import com.kashdeya.ancient_artifacts.world.WorldGen;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void onPreInitialization(FMLPreInitializationEvent event)
	{}
	
	public void onInitialization(FMLInitializationEvent event)
	{
		// FuelHandler
		GameRegistry.registerFuelHandler(new FuelHandler());

		// Load WorldGeneration
		GameRegistry.registerWorldGenerator(new WorldGen(), 0);
	}
	
	public void onPostInitialization(FMLPostInitializationEvent event)
	{}
}
