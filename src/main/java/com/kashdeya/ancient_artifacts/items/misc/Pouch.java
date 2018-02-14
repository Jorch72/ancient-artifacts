package com.kashdeya.ancient_artifacts.items.misc;

import com.kashdeya.ancient_artifacts.capabilities.StorageProvider;
import com.kashdeya.ancient_artifacts.main.ancient_artifacts;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class Pouch extends Item
{
    public Pouch()
    {
        setMaxStackSize(1);
        setCreativeTab(ancient_artifacts.tabAA);
    }
    
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt)
    {
        return new StorageProvider(String.format("%s.name", stack.getUnlocalizedName().substring(5)), 54);
    }
     
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        player.openGui(ancient_artifacts.instance, 0, world, 0, 0, 0);
        return ActionResult.newResult(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }
}
