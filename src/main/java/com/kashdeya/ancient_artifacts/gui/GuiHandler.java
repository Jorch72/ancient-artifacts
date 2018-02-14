package com.kashdeya.ancient_artifacts.gui;

import com.kashdeya.ancient_artifacts.capabilities.InventoryStorage;
import com.kashdeya.ancient_artifacts.container.PouchContainer;
import com.kashdeya.ancient_artifacts.inits.TechItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.items.CapabilityItemHandler;

public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch(ID)
        {
        case 0:
            ItemStack item = player.getHeldItemMainhand();
     
            if(item == null)
                return null;
     
            if(item.getItem() != TechItems.pouch)
                return null;
     
            InventoryStorage storage = (InventoryStorage) item.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
     
            if(storage == null)
                return null;
     
            return new PouchContainer(storage, player);
        default:
            return null;
        }
    }
    
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch(ID)
        {
        case 0:
            ItemStack item = player.getHeldItemMainhand();
             
            if(item.isEmpty())
                return null;
     
            if(item.getItem() != TechItems.pouch)
                return null;
     
            InventoryStorage storage = (InventoryStorage) item.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
     
            if(storage == null)
                return null;
     
            return new PouchGui(storage, player);
        default:
            return null;
        }
    }
}
