package com.kashdeya.ancient_artifacts.blocks.ores;

import java.util.Random;

import com.google.common.base.Predicate;
import com.kashdeya.ancient_artifacts.inits.TechItems;
import com.kashdeya.ancient_artifacts.main.ancient_artifacts;
import com.kashdeya.ancient_artifacts.registry.utils.IOreDictEntry;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CorruptedBlock extends Block implements IOreDictEntry {
	
    public CorruptedBlock()
    {
        super(Material.ROCK);
        this.setHardness(8.0F);
        this.setResistance(10.0F);
        this.setHarvestLevel("pickaxe", 1);
        this.setSoundType(SoundType.STONE);
        this.setCreativeTab(ancient_artifacts.tabAA);
        this.setUnlocalizedName("corrupted_ore");
    }
    
	@Override
	public String getOreDictName() {
		return "oreCorrupted";
	}
    
    @Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return false;
    }
	
    @Override
    public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state) {
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            Random rand = new Random();

            if (rand.nextFloat() <= 0.1F) {
                Entity entity = new EntitySilverfish(world);
                if (!world.isRemote) {
                    entity.setLocationAndAngles(x + (0.5), y + (1), z + (0.5), world.rand.nextFloat() * 360F, 0.0F);
                    world.spawnEntity(entity);
                    ((EntityLiving) entity).playLivingSound();
                }
            }
    }
    
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
		for (int i = 0; i < 4; ++i)
        {
            double d0 = (double)((float)pos.getX() + rand.nextFloat());
            double d1 = (double)((float)pos.getY() + rand.nextFloat());
            double d2 = (double)((float)pos.getZ() + rand.nextFloat());
            double d3 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            double d4 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            double d5 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            int j = rand.nextInt(2) * 2 - 1;

            if (worldIn.getBlockState(pos.west()).getBlock() != this && worldIn.getBlockState(pos.east()).getBlock() != this)
            {
                d0 = (double)pos.getX() + 0.5D + 0.25D * (double)j;
                d3 = (double)(rand.nextFloat() * 2.0F * (float)j);
            }
            else
            {
                d2 = (double)pos.getZ() + 0.5D + 0.25D * (double)j;
                d5 = (double)(rand.nextFloat() * 2.0F * (float)j);
            }

            worldIn.spawnParticle(EnumParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5);
        }
    }
    
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}
    
    @Override
    public int quantityDropped(Random rand) {
        return 1 + rand.nextInt(3);
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return TechItems.corrupted_shard;
    }
    
    @Override
    public int quantityDroppedWithBonus(int fortune, Random rand) {
    	return MathHelper.clamp(this.quantityDropped(rand) + rand.nextInt(fortune + 1), 1, 6);
    }
    

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        return (this.getItemDropped(state, RANDOM, fortune) != Item.getItemFromBlock(this)) ? (1 + RANDOM.nextInt(5)) : 0;
    }
    
    @Override
    public boolean isReplaceableOreGen(IBlockState state, IBlockAccess world, BlockPos pos, Predicate<IBlockState> target)
    {
        return false;
    }
}
