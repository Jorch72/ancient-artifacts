package com.kashdeya.ancient_artifacts.main;

import org.apache.logging.log4j.Logger;

import com.kashdeya.ancient_artifacts.config.TinyConfig;
import com.kashdeya.ancient_artifacts.events.EventDrops;
import com.kashdeya.ancient_artifacts.gui.GuiHandler;
import com.kashdeya.ancient_artifacts.inits.TechBlocks;
import com.kashdeya.ancient_artifacts.inits.TechItems;
import com.kashdeya.ancient_artifacts.proxy.CommonProxy;
import com.kashdeya.ancient_artifacts.recipes.BlockRecipes;
import com.kashdeya.ancient_artifacts.recipes.ItemRecipes;
import com.kashdeya.ancient_artifacts.registry.ModRegistry;
import com.kashdeya.ancient_artifacts.util.OreDict;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.registries.IForgeRegistryModifiable;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.MINECRAFT)

public class ancient_artifacts extends ModRegistry {

	@Instance(Reference.MOD_ID)
	public static ancient_artifacts instance;
	
	@SidedProxy(clientSide = Reference.PROXY_CLIENT, serverSide = Reference.PROXY_COMMON)
	public static CommonProxy proxy;
	
	public static final CreativeTabs tabAA = new TabAA("ancient_artifacts");

	public static SimpleNetworkWrapper network;
	public static Logger logger;
	
	static { 
		FluidRegistry.enableUniversalBucket();
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		logger = e.getModLog();
		
		// Configs
		TinyConfig.initMain();
		
		TechBlocks.init();
		TechItems.init();
		register(TechBlocks.class);
		register(TechItems.class);
		
		// Events
		MinecraftForge.EVENT_BUS.register(instance);
		MinecraftForge.EVENT_BUS.register(EventDrops.class);
		
		// Setup
		proxy.onPreInitialization(e);
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.onInitialization(e);
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		OreDict.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.onPostInitialization(e);
	}

	@SubscribeEvent
	public void registerRecipes(RegistryEvent.Register<IRecipe> event) {
		BlockRecipes.init();
		ItemRecipes.init();
		register(BlockRecipes.class);
		register(ItemRecipes.class);
		
		IForgeRegistryModifiable<IRecipe> registry = (IForgeRegistryModifiable<IRecipe>) event.getRegistry();

	}

}
