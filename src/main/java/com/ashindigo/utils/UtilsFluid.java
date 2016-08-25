package com.ashindigo.utils;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * This is a class used for making a fluid.
 * @author Ash Indigo
 * 
 */
// XXX Or possibly add a method to make fluids and let the constructors remain separate
public class UtilsFluid extends Fluid {

	public UtilsFluid(String fluidName, ResourceLocation still, ResourceLocation flowing, String fluidBlockName, Material material, String modid) {
		super(fluidName, still, flowing);
		FluidRegistry.registerFluid(this);
		FluidRegistry.addBucketForFluid(this);
		setUnlocalizedName(fluidName);
		new UtilsFluidBlock(this, material, fluidBlockName, modid);
	}
	public static class UtilsFluidBlock extends BlockFluidClassic {

		public UtilsFluidBlock(Fluid fluid, Material material, String name, String modid) {
			super(fluid, material);
			setUnlocalizedName(name);
			GameRegistry.register(this, new ResourceLocation(modid, name));
			GameRegistry.register(new ItemBlock(this), new ResourceLocation(modid, name + "itemBlock"));
		}

	}
}
