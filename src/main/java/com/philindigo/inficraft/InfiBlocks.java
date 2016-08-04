package com.philindigo.inficraft;

import com.ashindigo.utils.UtilsBlock;
import com.ashindigo.utils.UtilsBlockOre;
import com.ashindigo.utils.UtilsFluid;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class InfiBlocks {
	
	public static UtilsBlock testore;
	public static UtilsBlockOre oretest;
	public static UtilsFluid fl;
	public static UtilsFluid.UtilsFluidBlock testfl;
	public static UtilsFluid fl2;
	public static UtilsFluid.UtilsFluidBlock testfl2;
	
	public static void init() {
		
		testore = new UtilsBlock(Material.ROCK, InfiCraftMain.modid, "testore", "testOre");
		//fl = new UtilsFluid("fl", new ResourceLocation("fls"), new ResourceLocation("fll"));
		//testfl = new UtilsFluid.UtilsFluidBlock(fl, Material.WATER, "fluidtest", InfiCraftMain.modid);
		//fl2 = new UtilsFluid("fl2", new ResourceLocation("fls2"), new ResourceLocation("fll2"));
		//testfl2 = new UtilsFluid.UtilsFluidBlock(fl2, Material.WATER, "fluidtest2", InfiCraftMain.modid);
		oretest = new UtilsBlockOre(InfiItems.test, testore, 0, testore, InfiCraftMain.modid);
	}
}
