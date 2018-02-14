package com.kashdeya.ancient_artifacts.registry;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kashdeya.ancient_artifacts.main.Reference;
import com.kashdeya.ancient_artifacts.registry.models.IModelRegistrar;
import com.kashdeya.ancient_artifacts.registry.models.IRuntimeModel;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.StringUtils;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class InternalRegistry
{
	private static Map<ResourceLocation, Block> blocks = Maps.newHashMap();
	private static Map<ResourceLocation, Item> items = Maps.newHashMap();
	private static Map<ResourceLocation, IRecipe> recipes = Maps.newHashMap();
	private static Map<ResourceLocation, SoundEvent> sounds = Maps.newHashMap();
	
	private static Map<ResourceLocation, Class<? extends TileEntity>> tiles = Maps.newHashMap();
	
	private static Map<ModelResourceLocation, IRuntimeModel> models = Maps.newHashMap();
	private static Map<String, List<Object>> oredict = Maps.newHashMap();
	
	public static void registerBlock(Block block, String name)
	{
		if(block == null)
		{
			System.err.println(String.format("Unable to register Block with name '%s' as it is null!", name));
			return;
		}
		
		block.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		
		if(blocks.containsKey(block.getRegistryName()))
		{
			System.err.println(String.format("Unable to register Block with name '%s' as an entry already exists with this name!\nOriginal: %s\nFailed: %s", name, blocks.get(block.getRegistryName()).toString(), block.toString()));
			return;
		}
		
		blocks.put(block.getRegistryName(), block);
	}
	
	public static void registerItem(Item item, String name)
	{
		if(item == null)
		{
			System.err.println(String.format("Unable to register Item with name '%s' as it is null!", name));
			return;
		}
		
		item.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));		
		
		if(items.containsKey(item.getRegistryName()))
		{
			System.err.println(String.format("Unable to register Item with name '%s' as an entry already exists with this name!\nOriginal: %s\nFailed: %s", name, items.get(item.getRegistryName()).toString(), item.toString()));
			return;
		}
		
		items.put(item.getRegistryName(), item);
	}
	
	public static void registerOreDictionary(Object entry, String name)
	{
		if(entry == null)
		{
			System.err.println(String.format("Unable to register OreDictEntry with name '%s' as it is null!", name));
			return;
		}
		
		List<Object> entries;
		
		if(oredict.containsKey(name))
			entries = oredict.get(name);
		else
			entries = Lists.newArrayList();
		
		entries.add(entry);
		oredict.put(name, entries);
	}
	
	public static void registerTileEntity(TileEntity tile, String name)
	{
		if(tile == null)
		{
			System.err.println(String.format("Unable to register TileEntity with name '%s' as it is null!", name));
			return;
		}
		
		Class<? extends TileEntity> clazz = tile.getClass();
		ResourceLocation resource = new ResourceLocation(Reference.MOD_ID, name);
		
		if(tiles.containsKey(resource))
		{
			System.err.println(String.format("Unable to register TileEntity with name '%s' as an entry already exists with this name!\nOriginal: %s\nFailed: %s", name, tiles.get(resource).toString(), tile.toString()));
			return;
		}
		
		tiles.put(resource, clazz);
	}
	
	public static void registerRecipe(IRecipe recipe, String name)
	{
		if(recipe == null)
		{
			System.err.println(String.format("Unable to register IRecipe with name '%s' as it is null!", name));
			return;
		}
		
		recipe.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		
		if(recipes.containsKey(recipe.getRegistryName()))
		{
			System.err.println(String.format("Unable to register IRecipe with name '%s' as an entry already exists with this name!\nOriginal: %s\nFailed: %s", name, recipes.get(recipe.getRegistryName()).toString(), recipe.toString()));
			return;
		}
		
		recipes.put(recipe.getRegistryName(), recipe);
	}
	
	public static void registerSound(SoundEvent sound, String name)
	{
		if(sound == null)
		{
			System.err.println(String.format("Unable to register SoundEvent with name '%s' as it is null!", name));
			return;
		}
		
		sound.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		
		if(sounds.containsKey(sound.getRegistryName()))
		{
			System.err.println(String.format("Unable to register SoundEvent with name '%s' as an entry already exists with this name!\nOriginal: %s\nFailed: %s", name, sounds.get(sound.getRegistryName()).toString(), sound.toString()));
			return;
		}
		
		sounds.put(sound.getRegistryName(), sound);
	}
	
	public static void registerModel(IRuntimeModel model, String name, String variant)
	{
		if(model == null)
		{
			System.err.println(String.format("Unable to register IRuntimeModel with name '%s' as it is null!", name));
			return;
		}
		
		ModelResourceLocation resource = new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, name), variant);
		
		if(models.containsKey(resource))
		{
			System.err.println(String.format("Unable to register IRuntimeModel with name '%s' as an entry already exists with this name!\nOriginal: %s\nFailed: %s", name, models.get(resource).toString(), model.toString()));
			return;
		}
		
		models.put(resource, model);
	}
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void onRegisterBlock(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(blocks.values().toArray(new Block[blocks.size()]));

		tiles.forEach((key, value) -> GameRegistry.registerTileEntity(value, key.toString()));
	}
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void onRegisterItem(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(items.values().toArray(new Item[items.size()]));

		oredict.forEach((key, value) -> {
			for (Object obj : value) {
				ItemStack itemstack = ItemStack.EMPTY;

				if (obj instanceof Block)
					itemstack = new ItemStack((Block) obj);

				if (obj instanceof Item)
					itemstack = new ItemStack((Item) obj);

				if (obj instanceof ItemStack)
					itemstack = (ItemStack) obj;

				if (!itemstack.isEmpty() && !StringUtils.isNullOrEmpty(key))
					OreDictionary.registerOre(key, itemstack);
			}
		});
	}
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void onRegisterRecipe(RegistryEvent.Register<IRecipe> event)
	{
		event.getRegistry().registerAll(recipes.values().toArray(new IRecipe[recipes.size()]));
	}
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void onRegisterSound(RegistryEvent.Register<SoundEvent> event)
	{
		event.getRegistry().registerAll(sounds.values().toArray(new SoundEvent[sounds.size()]));
	}
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	@SideOnly(Side.CLIENT)
	public static void onRegisterModel(ModelRegistryEvent event)
	{
		items.forEach((key, item) -> {
			if (item instanceof IModelRegistrar) {
				((IModelRegistrar) item).registerModels();
				return;
			}
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, key.getResourcePath()), "inventory"));
		});

		blocks.forEach((key, block) -> {
			if (block instanceof IModelRegistrar) {
				((IModelRegistrar) block).registerModels();
				return;
			}
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, key.getResourcePath()), "inventory"));
			if (block instanceof BlockFluidClassic)
				ModelLoader.setCustomStateMapper(block, new StateMap.Builder().ignore(new IProperty[]{BlockFluidClassic.LEVEL}).build());
		});
	}
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	@SideOnly(Side.CLIENT)
	public static void onBakeModel(ModelBakeEvent event)
	{
		models.forEach((key, value) -> {
			Object existing = event.getModelRegistry().getObject(key);
			if (existing == null)
				return;
			event.getModelRegistry().putObject(key, value.createModel((IBakedModel) existing));
		});
	}
}
