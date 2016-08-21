package com.ashindigo.utils.demo;

import com.ashindigo.utils.UtilsBlock;

import net.minecraft.block.material.Material;

/**
 * Block Demonstration
 * - Basic Blocks
 * - Fluids
 * - Ores
 * @author Ash Indigo
 *
 */
public class DemoBlocks {

	public static UtilsBlock testBlock1;
	public static UtilsBlock testBlock2;
	
	public static void preInitBlocks() {
		testBlock1 = new UtilsBlock(Material.ROCK, "utilsdemo", "testblock1", "Test Block 1");
		testBlock2 = new UtilsBlock(Material.ROCK, "utilsdemo", "testblock2", "Test Block 2");

	}

	public static void initBlocks() {
		// TODO Auto-generated method stub

	}

	public static void postInitBlocks() {
		// TODO Auto-generated method stub

	}

}
