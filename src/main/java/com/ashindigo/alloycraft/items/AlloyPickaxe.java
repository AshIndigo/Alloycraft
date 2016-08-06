package com.ashindigo.alloycraft.items;

import java.util.List;

import com.ashindigo.alloycraft.AlloycraftMain;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AlloyPickaxe extends ItemPickaxe {

	public AlloyPickaxe(ToolMaterial material, String name, String modid) {
		super(material);
		this.setUnlocalizedName(modid + "_" + name);
	    setCreativeTab(AlloycraftMain.alloycrafttab);
	    GameRegistry.register(this, new ResourceLocation(modid, name));
	}
	@Override
	public void onCreated(ItemStack itemstack, World world, EntityPlayer player){
	{
	        if (itemstack.getTagCompound() == null) {
	            itemstack.setTagCompound(new NBTTagCompound());
	            itemstack.getTagCompound().setInteger("Durability", 0);
	            itemstack.getTagCompound().setInteger("Enchantability", 0);
	            itemstack.getTagCompound().setInteger("Strength", 0);
	        }
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

}
