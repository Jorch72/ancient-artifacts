package com.kashdeya.ancient_artifacts.items.artifacts;

import java.util.List;

import com.kashdeya.ancient_artifacts.inits.TechItems;
import com.kashdeya.ancient_artifacts.main.ancient_artifacts;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class WitherRing extends Item {
	
	public WitherRing() {
		super();
		this.setCreativeTab(ancient_artifacts.tabAA);
	}
	
	
	public void onUpdate(ItemStack stack, World worldIn, Entity player, int itemSlot, boolean isSelected) {
		if(player instanceof EntityLivingBase && worldIn.isRemote)
			if(((EntityLivingBase) player).isPotionActive(MobEffects.WITHER))
				((EntityLivingBase) player).removePotionEffect(MobEffects.WITHER);
	}
	
	@SubscribeEvent
	public static void noMore(LivingAttackEvent event){
		if(event.getEntity() instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.getEntity();
			
			if(event.getSource() == DamageSource.WITHER) {
				if(player.inventory.hasItemStack(new ItemStack(TechItems.wither_ring))) {
					event.setCanceled(true);
				}
			}
		}
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.EPIC;
	}
	
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack){
        return true;
    }
    
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced)
	{
		tooltip.add(TextFormatting.YELLOW + new TextComponentTranslation("tooltip.witherring_1").getFormattedText());
	}
}
