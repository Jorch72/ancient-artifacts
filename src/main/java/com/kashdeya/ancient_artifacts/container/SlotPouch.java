package com.kashdeya.ancient_artifacts.container;

import com.kashdeya.ancient_artifacts.inits.TechItems;

import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotPouch extends SlotItemHandler	
{
    public SlotPouch(IItemHandler inventory, int index, int xPosition, int yPosition)
    {
        super(inventory, index, xPosition, yPosition);
    }
    
    @Override
    public boolean isItemValid(ItemStack stack)
    {
        return !stack.isEmpty() && (stack.getItem() != TechItems.pouch || !(stack.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN)) );
    }
}
