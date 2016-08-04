package com.ashindigo.alloycraft.lib;

import com.ashindigo.alloycraft.AlloycraftItems;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;

// TODO Fix Color Textures
public class AlloyColorHandler extends ItemColors {

	public static ItemColors start() {
	ItemColors itemcolors = new ItemColors();
    itemcolors.registerItemColorHandler(new IItemColor() {
        public int getColorFromItemstack(ItemStack stack, int tintIndex) {
        	return 255;
           // return stack.getTagCompound().getInteger("Durability") + stack.getTagCompound().getInteger("Strength") + stack.getTagCompound().getInteger("Enchantability");
        }
    }, new Item[] {AlloycraftItems.alloy});
	return itemcolors;
	}
	
	public static ItemColors getItemColors() {
		ItemColors itemcolors = new ItemColors();
		return itemcolors;
	}
}
