package com.ashindigo.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.text.WordUtils;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
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
	public static Item Material;
	public static Item pickaxe;
	public static Item axe;
	public static Item sword;
	public static Item hoe;
	public static Item shovel;
	
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
		    Material = toolmat;
		    pickaxe = this;
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
		// TODO Fix Axe
		public UtilsAxe(ToolMaterial material, String name, String modid, Item toolmat, String translatedName) {
			super(material, 0, 0);
			GameRegistry.register(this, new ResourceLocation(modid, name));
			this.setUnlocalizedName(modid + "_" + name);
		    setCreativeTab(CreativeTabs.COMBAT);
		    Material = toolmat;
		    axe = this;
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
		    Material = toolmat;
		    sword = this;
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
		    Material = toolmat;
		    hoe = this;
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
		    Material = toolmat;
		    shovel = this;
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
	public static void registerRecipes(){
			if(sword != null){
		GameRegistry.addRecipe(new ItemStack(sword, 1), new Object[]{
	        	" A ",
	        	" A ",
	        	" B ",
	        	'A', Material, 'B', Items.STICK
	    	});
			}
			if(pickaxe != null){
	    	GameRegistry.addRecipe(new ItemStack(pickaxe, 1), new Object[]{
	        	"AAA",
	        	" B ",
	        	" B ",
	        	'A', Material, 'B', Items.STICK
	    	});
			}
			if(shovel != null){
	    	GameRegistry.addRecipe(new ItemStack(shovel, 1), new Object[]{
	        	" A ",
	        	" B ",
	        	" B ",
	        	'A', Material, 'B', Items.STICK
	    	});
			}
			if(hoe != null){
	    	GameRegistry.addRecipe(new ItemStack(hoe, 1), new Object[]{
	        	"AA ",
	        	" B ",
	        	" B ",
	        	'A', Material, 'B', Items.STICK
	    	});
			}
	    	if(hoe != null){
	    	GameRegistry.addRecipe(new ItemStack(hoe, 1), new Object[]{
	        	" AA",
	        	" B ",
	        	" B ",
	        	'A', Material, 'B', Items.STICK
	    	});
	    	}
	    	if(axe != null){
	    	GameRegistry.addRecipe(new ItemStack(axe, 1), new Object[]{
	        	"AA ",
	        	"AB ",
	        	" B ",
	        	'A', Material, 'B', Items.STICK
	    	});
	    	}
	    	if(axe != null){
	    	GameRegistry.addRecipe(new ItemStack(axe, 1), new Object[]{
	        	" AA",
	        	" BA",
	        	" B ",
	        	'A', Material, 'B', Items.STICK
	    	});
	    	}
	}
}