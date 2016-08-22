package com.ashindigo.utils;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
/**
 * Sub-Class dedicated to adding ores with automatic smelting and compression recipes added.
 * @author Ash Indigo
 */
public class UtilsBlockOre {

	public static ArrayList orelist = new ArrayList();
	public static ArrayList ingotlist = new ArrayList();
	private static ArrayList compressedlist = new ArrayList();

	/**
	 * Constructor for setting up the ore
	 * @param ingot The resulting item from the ore (Item)
	 * @param ore The ore block that will be smelted (Block)
	 * @param dim The dimension number 0: Overworld 1: Nether 2: End
	 * @param compressedblock The compressed version of the ingots
	 */
	public UtilsBlockOre(Item ingot, Block ore, int dim, Block compressedblock) {
		ingotlist.add(ingot);
		orelist.add(ore);
		compressedlist.add(compressedblock);
		switch (dim) {
        case 0: UtilsWorldgen.OverworldList.add(ore); break;
        case -1: UtilsWorldgen.NetherList.add(ore); break;
        case 1: UtilsWorldgen.EndList.add(ore); break;
	}
    }
	/**
	 * Method to add smelting recipes to ores and compression reipes
	 */
	public static void registerRecipes(){
		int oreruntime = 0;
		while(oreruntime < orelist.size()){
		GameRegistry.addSmelting((Block) orelist.get(oreruntime), new ItemStack ((Item) ingotlist.get(oreruntime), 1), 5);
		GameRegistry.addRecipe(new ItemStack((Block) compressedlist.get(oreruntime), 1), new Object[]{
	        	"AAA",
	        	"AAA",
	        	"AAA",
	        	'A', ingotlist.get(oreruntime)
	    	});
		GameRegistry.addShapelessRecipe(new ItemStack((Item) ingotlist.get(oreruntime), 9), new Object[]{
	    		new ItemStack((Block) compressedlist.get(oreruntime), 1)
		});
		oreruntime++;
	}
		}
	}