package com.ashindigo.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
* An Item class which automatically registers the item that is being added.
* @author Ash Indigo
*/
public class UtilsItem extends Item {
	
	public static Map<Item, String> itemNameList = new HashMap();
	public static ListMultimap<String, Item> modItems = ArrayListMultimap.create();
	public static Map<Item, String> translatedNameList = new HashMap();
	
	/**
	 * Default constructor to add a item
	 * @param modid Mod's MODID
	 * @param name Item Name
	 * @param translatedName The Item's In-game name
	 */
	public UtilsItem(String modid, String name, String translatedName){
		
		GameRegistry.register(this, new ResourceLocation(modid, name));
		setUnlocalizedName(modid + "_" + name);
		setCreativeTab(CreativeTabs.MISC);
		itemNameList.put(this, name);
		translatedNameList.put(this, translatedName);
		modItems.put(modid, this);
		
	}
}
