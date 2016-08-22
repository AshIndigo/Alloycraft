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
 * This is a class used for making various fluid needs.
 * @author Ash Indigo
 * 
 */
// TODO Remove need for UtilsFluidBlock constructor?
public class UtilsFluid extends Fluid {

	public UtilsFluid(String fluidName, ResourceLocation still, ResourceLocation flowing) {
		super(fluidName, still, flowing);
		FluidRegistry.registerFluid(this);
		FluidRegistry.addBucketForFluid(this);
		setUnlocalizedName(fluidName);
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
