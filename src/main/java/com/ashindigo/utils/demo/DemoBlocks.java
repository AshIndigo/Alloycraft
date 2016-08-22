package com.ashindigo.utils.demo;

import com.ashindigo.utils.UtilsBlock;
import com.ashindigo.utils.UtilsBlockOre;
import com.ashindigo.utils.UtilsFluid;

import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

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
	public static UtilsFluid testFluid1;
	public static UtilsFluid.UtilsFluidBlock testFluidBlock1;
	public static UtilsBlockOre testOre1;
	
	public static void preInitBlocks() {
		testBlock1 = new UtilsBlock(Material.ROCK, "utilsdemo", "testblock1", "Test Block 1");
		testBlock2 = new UtilsBlock(Material.ROCK, "utilsdemo", "testblock2", "Test Block 2");
		// Fluids
		testFluid1 = new UtilsFluid("demofluid", new ResourceLocation("utilsdemo:demoflow"), new ResourceLocation("utilsdemo:demostill"));
		testFluidBlock1 = new UtilsFluid.UtilsFluidBlock(testFluid1, Material.WATER, "demofluid", "utilsdemo");
		// An Ore
		testOre1 = new UtilsBlockOre(DemoItems.testItem3, testBlock1, 0, testBlock2);
		
		

	}

	public static void initBlocks() {

	}

	public static void postInitBlocks() {

	}

}
