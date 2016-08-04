package com.ashindigo.alloycraft;

import com.ashindigo.alloycraft.blocks.ForgeBlock;
import com.ashindigo.alloycraft.tileentites.ForgeTileEntity;
import com.ashindigo.utils.UtilsBlock;
import com.ashindigo.utils.UtilsItemBlockLoader;
import com.ashindigo.utils.UtilsMod;

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
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class AlloycraftBlocks extends UtilsItemBlockLoader {

	public static Block forgeoff;

	public static void preInitBlocks() {
		
		forgeoff = new ForgeBlock(AlloycraftMain.modid, "forgeoff");
	}

	public static void initBlocks() {
		
		GameRegistry.register(forgeoff, new ResourceLocation(AlloycraftMain.modid, "forgeoff"));
		GameRegistry.register(new ItemBlock(forgeoff), new ResourceLocation(AlloycraftMain.modid, "forgeoff"));
		GameRegistry.registerTileEntity(ForgeTileEntity.class, "forgefurnace");
		if(FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			ItemModelMesher itemRender = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
			itemRender.register(Item.getItemFromBlock(AlloycraftBlocks.forgeoff), 0, new ModelResourceLocation(AlloycraftMain.modid + ":" + "forgeoff", "inventory"));
		}
		GameRegistry.addRecipe(new ItemStack(forgeoff, 1), new Object[]{
	        	"AAA",
	        	"ABA",
	        	"DCD",
	        	'A', Items.IRON_INGOT, 'B', Blocks.IRON_BLOCK, 'C', Blocks.REDSTONE_BLOCK, 'D', Blocks.FURNACE
	    	});
	}
	
	public static void postInitBlocks() {
		
	}

}
