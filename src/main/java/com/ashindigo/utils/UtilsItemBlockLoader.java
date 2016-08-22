package com.ashindigo.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Manages the item and block apis for IndigoUtils
 * @author Ash Indigo
 */
public class UtilsItemBlockLoader {
	
	public static void preInitItems() {
		
	}
	/**
	* Start the auto json register
	* @author Ash Indigo
	*/
	public static void initItems() {
		try {
		int runtime = 0;
		int modRuntime = 0;
		while (modRuntime < UtilsMod.modidList.size()) {
		if (UtilsItem.modItems.size() != 0) {
		while (runtime < UtilsItem.modItems.get((String) UtilsItem.modItems.keySet().toArray()[modRuntime]).size()) {
			if(FMLCommonHandler.instance().getSide() == Side.CLIENT) {
				 Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register((Item) UtilsItem.modItems.get((String) UtilsItem.modItems.keySet().toArray()[modRuntime]).get(runtime), 0, new ModelResourceLocation(UtilsItem.modItems.keySet().toArray()[modRuntime] + ":" + UtilsItem.itemNameList.get(UtilsItem.modItems.get((String) UtilsItem.modItems.keySet().toArray()[modRuntime]).get(runtime)), "inventory"));
			}
			runtime++;
			}
		}
		modRuntime++;
		}
		}
	
	catch (IndexOutOfBoundsException e) {
		e.printStackTrace();
	}
	}
	
	/**
	 * Loads recipes
	 */
	public static void postInitItems() {
		
		UtilsToolset.registerRecipes();
		UtilsArmor.registerRecipes();
		
	}
	
	public static void preInitBlocks() {
		
	}
	
	/**
	 * Initiates the auto model loader
	 * @author Ash Indigo
	 */
	public static void initBlocks() {
		
		int runtime = 0;
		int modRuntime = 0;
		int modRuntime0 = 0;
		int runtime0 = 0;
		while (modRuntime0 < UtilsMod.modidList.size()) {
			runtime0 = 0;
		while (runtime0 < UtilsBlock.modBlocks.get((String) UtilsMod.modidList.get(modRuntime0)).size()) {
			UtilsLanguageCreator.init(UtilsBlock.modBlocks.get((String) UtilsMod.modidList.get(modRuntime0)).get(runtime0).getUnlocalizedName(), UtilsBlock.translatedNameList.get(UtilsBlock.modBlocks.get((String) UtilsMod.modidList.get(modRuntime0)).get(runtime0)), (String) UtilsMod.modidList.get(modRuntime0));
			runtime0++;
		}
		modRuntime0++;
		}
		while (modRuntime < UtilsMod.modidList.size()) {
			runtime = 0;
		while (runtime < UtilsBlock.modBlocks.get((String) UtilsMod.modidList.get(modRuntime)).size()) {
			if(FMLCommonHandler.instance().getSide() == Side.CLIENT) {
				 Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(UtilsBlock.modBlocks.get((String) UtilsMod.modidList.get(modRuntime)).get(runtime)), 0, new ModelResourceLocation(UtilsMod.modidList.get(modRuntime) + ":" + UtilsBlock.blockNameList.get(UtilsBlock.modBlocks.get((String) UtilsMod.modidList.get(modRuntime)).get(runtime).getUnlocalizedName()), "inventory"));
			}
			runtime++;
		}
		modRuntime++;
		}
	}
	
	public static void postInitBlocks() {
	   /**
		* Load the recipe handlers for ores 
		*/
		UtilsBlockOre.registerRecipes();
	}

}
