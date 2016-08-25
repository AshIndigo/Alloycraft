package com.ashindigo.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.text.WordUtils;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
/**
 * A class dedicated to making tool sets.
 * <p>
 * Example: {@link UtilsToolset.UtilsPickaxe}
 * </p>
 * Will automatically registers recipes for each tool
 * @author Ash Indigo
 */ 
public class UtilsToolset {
	
	public static Map<Item, String> toollistsname = new HashMap();
	public static ListMultimap<String, Item> toollists = ArrayListMultimap.create();
	public static ListMultimap<Item, Item> craftingmap = ArrayListMultimap.create();
	public static ArrayList matlist = new ArrayList();
	
	/**
	 * Adds a toolset
	 * @param material The Tool material
	 * @param modid The Mod's modid
	 * @param toolmat Item used in creation of the tool
	 * @param name The name of the tool
	 */
	public static void toolsetGen(ToolMaterial material, String modid, Item toolmat, String name) {
		new UtilsPickaxe(material, name + "pickaxe", modid, toolmat, WordUtils.capitalize(name) + " Pickaxe");
		new UtilsAxe(material, name + "axe", modid, toolmat, WordUtils.capitalize(name) + " Axe");
		new UtilsSword(material, name + "sword", modid, toolmat, WordUtils.capitalize(name) + " Sword");
		new UtilsHoe(material, name + "hoe", modid, toolmat, WordUtils.capitalize(name) + " Hoe");
		new UtilsShovel(material, name + "shovel", modid, toolmat, WordUtils.capitalize(name) + " Shovel");
	}
	
	public static class UtilsPickaxe extends ItemPickaxe {
		
		public UtilsPickaxe(ToolMaterial material, String name, String modid, Item toolmat, String translatedName) {
			super(material);
			GameRegistry.register(this, new ResourceLocation(modid, name));
			this.setUnlocalizedName(modid + "_" + name);
		    setCreativeTab(CreativeTabs.COMBAT);
		    matlist.add(toolmat);
		    craftingmap.put(toolmat, this);
		    if (this != null){
			    toollists.put(modid, this);
			    toollistsname.put(this, name);
			    UtilsItem.modItems.put(modid, this);
			    UtilsItem.itemNameList.put(this, name);
			    UtilsItem.translatedNameList.put(this, translatedName);
			    }
		}
	}
	
	public static class UtilsAxe extends ItemAxe {
		
		public UtilsAxe(ToolMaterial material, String name, String modid, Item toolmat, String translatedName) {
			super(material, material.getDamageVsEntity(), material.getEfficiencyOnProperMaterial());
			GameRegistry.register(this, new ResourceLocation(modid, name));
			this.setUnlocalizedName(modid + "_" + name);
		    setCreativeTab(CreativeTabs.COMBAT);
		    matlist.add(toolmat);
		    craftingmap.put(toolmat, this);
		    if (this != null){
		    	toollists.put(modid, this);
				toollistsname.put(this, name);
			    UtilsItem.modItems.put(modid, this);
			    UtilsItem.itemNameList.put(this, name);
			    UtilsItem.translatedNameList.put(this, translatedName);
			    }
		}
	}
	
	public static class UtilsSword extends ItemSword {
		
		public UtilsSword(ToolMaterial material, String name, String modid, Item toolmat, String translatedName) {
			super(material);
			GameRegistry.register(this, new ResourceLocation(modid, name));
			this.setUnlocalizedName(modid + "_" + name);
		    setCreativeTab(CreativeTabs.COMBAT);
		    matlist.add(toolmat);
		    craftingmap.put(toolmat, this);
		    if (this != null){
		    	toollists.put(modid, this);
				toollistsname.put(this, name);
			    UtilsItem.modItems.put(modid, this);
			    UtilsItem.itemNameList.put(this, name);
			    UtilsItem.translatedNameList.put(this, translatedName);
			    }
		}
	}
	
	public static class UtilsHoe extends ItemHoe {
		
		public UtilsHoe(ToolMaterial material, String name, String modid, Item toolmat, String translatedName) {
			super(material);
			GameRegistry.register(this, new ResourceLocation(modid, name));
			this.setUnlocalizedName(modid + "_" + name);
		    setCreativeTab(CreativeTabs.COMBAT);
		    matlist.add(toolmat);
		    craftingmap.put(toolmat, this);
		    if (this != null){
		    	toollists.put(modid, this);
				toollistsname.put(this, name);
			    UtilsItem.modItems.put(modid, this);
			    UtilsItem.itemNameList.put(this, name);
			    UtilsItem.translatedNameList.put(this, translatedName);
			    }
		}
	}
	
	public static class UtilsShovel extends ItemSpade {
		
		public UtilsShovel(ToolMaterial material, String name, String modid, Item toolmat, String translatedName) {
			super(material);
			GameRegistry.register(this, new ResourceLocation(modid, name));
			this.setUnlocalizedName(modid + "_" + name);
		    setCreativeTab(CreativeTabs.COMBAT);
		    matlist.add(toolmat);
		    craftingmap.put(toolmat, this);
		    if (this != null){
		    	toollists.put(modid, this);
				toollistsname.put(this, name);
			    UtilsItem.modItems.put(modid, this);
			    UtilsItem.itemNameList.put(this, name);
			    UtilsItem.translatedNameList.put(this, translatedName);
			    }
		}
	}
	
	/**
	 * Method that automatically add recipes for tools
	 */
	// I forgot how to code it seems
	public static void registerRecipes() {
		try {
		int runtime0 = 0;
		int runtime = 0;
		int runtime2 = 0;
		// Matlist contains the materials used for crafting tools
		while (matlist.size() > runtime0) {
			System.out.println(runtime0);
			System.out.println(runtime);
			System.out.println(runtime2);
			// crafting map is a multimap that has the key of the material to get to get a list of tools
		while (craftingmap.get((Item) matlist.get(runtime0)).size() < runtime) {
			GameRegistry.addRecipe(new ItemStack(craftingmap.get((Item) matlist.get(runtime0)).get(runtime2), 1), new Object[]{
		        	"AAA",
		        	" B ",
		        	" B ",
		        	'A', matlist.get(runtime0), 'B', Items.STICK
		    	});
			runtime2++;
			GameRegistry.addRecipe(new ItemStack(craftingmap.get((Item) matlist.get(runtime0)).get(runtime2), 1), new Object[]{
		        	"AA ",
		        	"AB ",
		        	" B ",
		        	'A', matlist.get(runtime0), 'B', Items.STICK
		    	});
		    	GameRegistry.addRecipe(new ItemStack(craftingmap.get((Item) matlist.get(runtime0)).get(runtime2), 1), new Object[]{
		        	" AA",
		        	" BA",
		        	" B ",
		        	'A', matlist.get(runtime0), 'B', Items.STICK
		    	});
				runtime2++;
		GameRegistry.addRecipe(new ItemStack(craftingmap.get((Item) matlist.get(runtime0)).get(runtime2), 1), new Object[]{
	        	" A ",
	        	" A ",
	        	" B ",
	        	'A', matlist.get(runtime0), 'B', Items.STICK
	    	});
		runtime2++;
	    	GameRegistry.addRecipe(new ItemStack(craftingmap.get((Item) matlist.get(runtime0)).get(runtime2), 1), new Object[]{
	        	"AA ",
	        	" B ",
	        	" B ",
	        	'A', matlist.get(runtime0), 'B', Items.STICK
	    	});
	    	GameRegistry.addRecipe(new ItemStack(craftingmap.get((Item) matlist.get(runtime0)).get(runtime2), 1), new Object[]{
	        	" AA",
	        	" B ",
	        	" B ",
	        	'A', matlist.get(runtime0), 'B', Items.STICK
	    	});
			runtime2++;
	    	GameRegistry.addRecipe(new ItemStack(craftingmap.get((Item) matlist.get(runtime0)).get(runtime2), 1), new Object[]{
		        	" A ",
		        	" B ",
		        	" B ",
		        	'A', matlist.get(runtime0), 'B', Items.STICK
		    	});
	    	System.out.println(runtime0);
			System.out.println(runtime);
			System.out.println(runtime2);
			runtime2 = 0;
			runtime0++;
	    	}
		runtime++;
	}
} catch (IndexOutOfBoundsException e) {
	e.printStackTrace();
}
	}
}