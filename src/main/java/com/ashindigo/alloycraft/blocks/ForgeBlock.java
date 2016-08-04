package com.ashindigo.alloycraft.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.ashindigo.alloycraft.AlloycraftBlocks;
import com.ashindigo.alloycraft.AlloycraftMain;
import com.ashindigo.alloycraft.tileentites.ForgeTileEntity;
import com.ashindigo.utils.UtilsBlock;
import com.ashindigo.utils.UtilsItemBlockLoader;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ForgeBlock extends BlockContainer {

	public ForgeBlock(String modid, String name) {
		super(Material.IRON);
		setUnlocalizedName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
	}
	  public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	    {
	        if (worldIn.isRemote)
	        {
	            return true;
	        }
	        else
	        {
	            TileEntity tileentity = worldIn.getTileEntity(pos);

	            if (tileentity instanceof ForgeTileEntity)
	            {
	                FMLNetworkHandler.openGui(playerIn, AlloycraftMain.instance, AlloycraftMain.guiIDForge, worldIn, pos.getX(), pos.getY(), pos.getZ());
	            }

	            return true;
	        }
	    } 

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new ForgeTileEntity();
	}

	
	public Block getBlockDropped(int meta, Random random, int fortune) {
	    return this;
	}
	
	public Item getItemDropped(int meta, Random random, int fortune)
    {
        return Item.getItemFromBlock(AlloycraftBlocks.forgeoff);
    }
	
	public EnumBlockRenderType getRenderType(IBlockState state)
	   {
	       return EnumBlockRenderType.MODEL;
	   }
}