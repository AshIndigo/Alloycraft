package com.ashindigo.alloycraft;

import com.ashindigo.alloycraft.blocks.ForgeBlock;
import com.ashindigo.alloycraft.blocks.ForgeTeslaBlock;
import com.ashindigo.alloycraft.tileentites.ForgeTeslaTileEntity;
import com.ashindigo.alloycraft.tileentites.ForgeTileEntity;
import com.ashindigo.utils.UtilsItemBlockInterface;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class AlloycraftBlocks {
 
	public static Block forgeoff;
	public static Block forgeteslaoff;

	public static void preInitBlocks() {
		
		forgeoff = new ForgeBlock(AlloycraftMain.modid, "forgeoff");
		if (Loader.isModLoaded("Tesla")) {
			forgeteslaoff = new ForgeTeslaBlock(AlloycraftMain.modid, "forgeteslaoff");
		}
	}

	public static void initBlocks() {
		
		GameRegistry.register(forgeoff, new ResourceLocation(AlloycraftMain.modid, "forgeoff"));
		GameRegistry.register(new ItemBlock(forgeoff), new ResourceLocation(AlloycraftMain.modid, "forgeoff"));
		GameRegistry.registerTileEntity(ForgeTileEntity.class, "forgefurnace");
		if (Loader.isModLoaded("Tesla")) {
			GameRegistry.register(forgeteslaoff, new ResourceLocation(AlloycraftMain.modid, "forgeteslaoff"));
			GameRegistry.register(new ItemBlock(forgeteslaoff), new ResourceLocation(AlloycraftMain.modid, "forgeteslaoff"));
			GameRegistry.registerTileEntity(ForgeTeslaTileEntity.class, "forgeteslafurnace");
		}
		if(FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			ItemModelMesher itemRender = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
			itemRender.register(Item.getItemFromBlock(AlloycraftBlocks.forgeoff), 0, new ModelResourceLocation(AlloycraftMain.modid + ":" + "forgeoff", "inventory"));
			if (Loader.isModLoaded("Tesla")) {
				itemRender.register(Item.getItemFromBlock(AlloycraftBlocks.forgeteslaoff), 0, new ModelResourceLocation(AlloycraftMain.modid + ":" + "forgeoff", "inventory"));
			}	
		}
		GameRegistry.addRecipe(new ItemStack(forgeoff, 1), new Object[]{
	        	"AAA",
	        	"ABA",
	        	"DCD",
	        	'A', Items.IRON_INGOT, 'B', Blocks.IRON_BLOCK, 'C', Blocks.REDSTONE_BLOCK, 'D', Blocks.FURNACE
	    	});
		GameRegistry.addRecipe(new ItemStack(forgeteslaoff, 1), new Object[]{
	        	"AAA",
	        	"ACA",
	        	"DBD",
	        	'A', Items.IRON_INGOT, 'B', Blocks.IRON_BLOCK, 'C', Blocks.REDSTONE_BLOCK, 'D', Blocks.FURNACE
	    	});
		
	}
	
	public static void postInitBlocks() {
		
	}

}
