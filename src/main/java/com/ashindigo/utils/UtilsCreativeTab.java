package com.ashindigo.utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Easy way for making a creative tab
 * @author Ash Indigo
 *
 */
public class UtilsCreativeTab extends CreativeTabs {
	
	Item icon2;

	/**
	 * Default constructor
	 * @param label The name of the group
	 * @param icon The icon of the tab
	 */
	public UtilsCreativeTab(String label, Item icon) {
		super(label);
		icon2 = icon;
	}

	@Override
	public Item getTabIconItem() {
		return icon2;
	}

}
