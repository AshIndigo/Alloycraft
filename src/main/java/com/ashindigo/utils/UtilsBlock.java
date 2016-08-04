package com.ashindigo.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
* An Block class which automatically registers the block that is being added.
* @author Ash Indigo
*/
public class UtilsBlock extends Block {
	
	public static Map<Block, String> blockNameList = new HashMap();
	public static ListMultimap<String, Block> modBlocks = ArrayListMultimap.create();
	public static Map<Block, String> translatedNameList = new HashMap();
	
	/**
	 * Constructor used for declaring blocks
	 * @param mat The material for the block
	 * @param modid Your mod's Mod ID
	 * @param name The name of the block
	 */
	public UtilsBlock(Material mat, String modid, String name, String translatedName) {
			super(mat);
			GameRegistry.register(this, new ResourceLocation(modid, name));
			GameRegistry.register(new ItemBlock(this), new ResourceLocation(modid, name + "itemBlock"));
			setUnlocalizedName(modid + "_" + name);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
			blockNameList.put(this, name);
			modBlocks.put(modid, this);
			translatedNameList.put(this, translatedName);
		}
	/**
	 * Default constructor for setting up a variable
	 */
	public UtilsBlock() {
		super(Material.ROCK);
	}
}