package com.ashindigo.alloycraft.items;

import java.awt.Color;
import java.util.List;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class AlloyItem extends Item {
	
	public AlloyItem(String modid, String name){
		super();
		setUnlocalizedName(modid + "_" + name);
		setCreativeTab(CreativeTabs.MISC);
		GameRegistry.register(this, new ResourceLocation(modid, name));
		maxStackSize = 1;
}
	@Override
	public void onCreated(ItemStack itemstack, World world, EntityPlayer player) {
		GL11.glColor3d(255, 255, 255);
	        if (itemstack.getTagCompound() == null)
	        {
	            itemstack.setTagCompound(new NBTTagCompound());
	            itemstack.getTagCompound().setInteger("Durability", 0);
	            itemstack.getTagCompound().setInteger("Enchantability", 0);
	            itemstack.getTagCompound().setInteger("Strength", 0);
	        }
	}
	public void addInformation(ItemStack itemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
		if (itemStack.getTagCompound() != null) {
		par3List.add("§4Strength: §7" + Integer.toString(itemStack.getTagCompound().getInteger("Strength")));
		par3List.add("§2Durability: §7" + Integer.toString(itemStack.getTagCompound().getInteger("Durability")));
		par3List.add("§1Enchantability: §7" + Integer.toString(itemStack.getTagCompound().getInteger("Enchantability")));
		}
	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
		//GL11.glBegin(0); 
		GL11.glColor3d(255, 255, 255);
		//GL11.glEnd();
		}
	}
}
	