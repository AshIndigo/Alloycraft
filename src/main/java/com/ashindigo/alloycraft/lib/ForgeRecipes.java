package com.ashindigo.alloycraft.lib;

import com.ashindigo.alloycraft.AlloycraftItems;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ForgeRecipes {
	
	public ForgeRecipes() {
		
	}	
	
	public static ItemStack getOutput(ItemStack item, ItemStack item2) {
		//  TODO Mess with values
		ItemStack itemstack;
		itemstack = null;
		itemstack = new ItemStack(AlloycraftItems.alloy, 1);
		// Iron Ingot
		try {
		if (item.getItem() == Items.IRON_INGOT && item2.getItem() == AlloycraftItems.alloy || item.getItem() == AlloycraftItems.alloy && item2.getItem() == Items.IRON_INGOT) {
			if (!itemstack.hasTagCompound()) {
				   itemstack.setTagCompound(new NBTTagCompound());
			if (item.getItem() == AlloycraftItems.alloy) {
				itemstack.getTagCompound().setInteger("Strength", item.getTagCompound().getInteger("Strength"));
				itemstack.getTagCompound().setInteger("Durability", item.getTagCompound().getInteger("Durability") + 200);
				itemstack.getTagCompound().setInteger("Enchantability", item.getTagCompound().getInteger("Enchantability"));
			} else if (item2.getItem() == AlloycraftItems.alloy) {
				itemstack.getTagCompound().setInteger("Strength", item2.getTagCompound().getInteger("Strength"));
				itemstack.getTagCompound().setInteger("Durability", item2.getTagCompound().getInteger("Durability") + 200);
				itemstack.getTagCompound().setInteger("Enchantability", item2.getTagCompound().getInteger("Enchantability"));
			} 
			}
			return itemstack;
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Redstone
		try {
				if (item.getItem() == Items.REDSTONE && item2.getItem() == AlloycraftItems.alloy || item.getItem() == AlloycraftItems.alloy && item2.getItem() == Items.REDSTONE) {
					if (!itemstack.hasTagCompound()) {
						   itemstack.setTagCompound(new NBTTagCompound());
					if (item.getItem() == AlloycraftItems.alloy) {
						itemstack.getTagCompound().setInteger("Strength", item.getTagCompound().getInteger("Strength") + 200);
						itemstack.getTagCompound().setInteger("Durability", item.getTagCompound().getInteger("Durability"));
						itemstack.getTagCompound().setInteger("Enchantability", item.getTagCompound().getInteger("Enchantability"));
					} else if (item2.getItem() == AlloycraftItems.alloy) {
						itemstack.getTagCompound().setInteger("Strength", item2.getTagCompound().getInteger("Strength") + 200);
						itemstack.getTagCompound().setInteger("Durability", item2.getTagCompound().getInteger("Durability"));
						itemstack.getTagCompound().setInteger("Enchantability", item2.getTagCompound().getInteger("Enchantability"));
					} 
					}
					return itemstack;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Gold Ingot
		try {
		if (item.getItem() == Items.GOLD_INGOT && item2.getItem() == AlloycraftItems.alloy || item.getItem() == AlloycraftItems.alloy && item2.getItem() == Items.GOLD_INGOT) {
				if (!itemstack.hasTagCompound()) {
					   itemstack.setTagCompound(new NBTTagCompound());
				if (item.getItem() == AlloycraftItems.alloy) {
					itemstack.getTagCompound().setInteger("Strength", item.getTagCompound().getInteger("Strength"));
					itemstack.getTagCompound().setInteger("Durability", item.getTagCompound().getInteger("Durability"));
					itemstack.getTagCompound().setInteger("Enchantability", item.getTagCompound().getInteger("Enchantability") + 200);
				} else if (item2.getItem() == AlloycraftItems.alloy) {
					itemstack.getTagCompound().setInteger("Strength", item2.getTagCompound().getInteger("Strength"));
					itemstack.getTagCompound().setInteger("Durability", item2.getTagCompound().getInteger("Durability"));
					itemstack.getTagCompound().setInteger("Enchantability", item2.getTagCompound().getInteger("Enchantability") + 200);
				}
				}
			return itemstack;
	}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; 
	}
}
