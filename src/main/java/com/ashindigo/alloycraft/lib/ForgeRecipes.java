package com.ashindigo.alloycraft.lib;

import com.ashindigo.alloycraft.AlloycraftItems;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

// So well written
public class ForgeRecipes {
	
	public ForgeRecipes() {
		
	}	
	
	public static ItemStack getOutput(ItemStack item, ItemStack item2) {
		ItemStack itemstack;
		itemstack = null;
		itemstack = new ItemStack(AlloycraftItems.alloy, 1);
		// Base alloy crafting
		if (item.getItem() == Items.IRON_INGOT && item2.getItem() == Items.GOLD_INGOT || item.getItem() == Items.GOLD_INGOT && item2.getItem() == Items.IRON_INGOT) {
			itemstack.setTagCompound(new NBTTagCompound());
			return itemstack;
		}
		// Iron Ingot
		try {
		if (item.getItem() == Items.IRON_INGOT && item2.getItem() == AlloycraftItems.alloy || item.getItem() == AlloycraftItems.alloy && item2.getItem() == Items.IRON_INGOT) {
			if (!itemstack.hasTagCompound()) {
				   itemstack.setTagCompound(new NBTTagCompound());
			if (item.getItem() == AlloycraftItems.alloy) {
				if (item.getTagCompound().getInteger("Strength") != 255) {
					itemstack.getTagCompound().setInteger("Strength", item.getTagCompound().getInteger("Strength") + 15);
				} else {
					itemstack.getTagCompound().setInteger("Strength", item.getTagCompound().getInteger("Strength"));
				}
					itemstack.getTagCompound().setInteger("Durability", item.getTagCompound().getInteger("Durability"));
					itemstack.getTagCompound().setInteger("Enchantability", item.getTagCompound().getInteger("Enchantability"));
			} else if (item2.getItem() == AlloycraftItems.alloy) {
				if (item2.getTagCompound().getInteger("Strength") != 255) {
					itemstack.getTagCompound().setInteger("Strength", item2.getTagCompound().getInteger("Strength") + 15);
				} else {
					itemstack.getTagCompound().setInteger("Strength", item2.getTagCompound().getInteger("Strength"));
				}
					itemstack.getTagCompound().setInteger("Durability", item2.getTagCompound().getInteger("Durability"));
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
									itemstack.getTagCompound().setInteger("Strength", item.getTagCompound().getInteger("Strength"));
								if (item.getTagCompound().getInteger("Durability") != 255) {
									itemstack.getTagCompound().setInteger("Durability", item.getTagCompound().getInteger("Durability") + 15);
								} else {
									itemstack.getTagCompound().setInteger("Durability", item.getTagCompound().getInteger("Durability"));
								}
									itemstack.getTagCompound().setInteger("Enchantability", item.getTagCompound().getInteger("Enchantability"));
							} else if (item2.getItem() == AlloycraftItems.alloy) {
								itemstack.getTagCompound().setInteger("Strength", item2.getTagCompound().getInteger("Strength"));
								if (item2.getTagCompound().getInteger("Durability") != 255) {
									itemstack.getTagCompound().setInteger("Durability", item2.getTagCompound().getInteger("Durability") + 15);
								} else {
									itemstack.getTagCompound().setInteger("Durability", item2.getTagCompound().getInteger("Durability"));
								}
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
					if (item.getTagCompound().getInteger("Enchantability") != 255) {
						itemstack.getTagCompound().setInteger("Enchantability", item.getTagCompound().getInteger("Enchantability") + 15);
					} else {
						itemstack.getTagCompound().setInteger("Enchantability", item.getTagCompound().getInteger("Enchantability"));
					}
				} else if (item2.getItem() == AlloycraftItems.alloy) {
					itemstack.getTagCompound().setInteger("Strength", item2.getTagCompound().getInteger("Strength"));
					itemstack.getTagCompound().setInteger("Durability", item2.getTagCompound().getInteger("Durability"));
					if (item2.getTagCompound().getInteger("Enchantability") != 255) {
						itemstack.getTagCompound().setInteger("Enchantability", item2.getTagCompound().getInteger("Enchantability") + 15);
					} else {
						itemstack.getTagCompound().setInteger("Enchantability", item2.getTagCompound().getInteger("Enchantability"));
					}
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
