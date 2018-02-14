package com.kashdeya.ancient_artifacts.items;

import java.util.stream.IntStream;

import com.kashdeya.ancient_artifacts.main.Reference;
import com.kashdeya.ancient_artifacts.main.ancient_artifacts;
import com.kashdeya.ancient_artifacts.registry.models.IModelRegistrar;
import com.kashdeya.ancient_artifacts.registry.utils.IMetadata;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBaseMeta extends ItemBase implements IModelRegistrar, IMetadata
{
	protected String[] unlocalNames;
	
	public ItemBaseMeta(String[] unlocalNames)
	{
		setHasSubtypes(true);
		this.unlocalNames = unlocalNames;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return "item." + unlocalNames[stack.getItemDamage()];
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
	{
		if (tab == ancient_artifacts.tabAA) {
			IntStream.range(0, unlocalNames.length).mapToObj(i -> new ItemStack(this, 1, i)).forEach(items::add);
		}
	}
	
	@Override
	public String[] getUnlocalizedNames() {
		return unlocalNames;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels() {
		IntStream.range(0, unlocalNames.length).forEach(i -> ModelLoader.setCustomModelResourceLocation(this, i, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, unlocalNames[i]), "inventory")));
	}
}
