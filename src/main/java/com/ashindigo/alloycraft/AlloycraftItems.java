package com.ashindigo.alloycraft;

import com.ashindigo.alloycraft.items.AlloyAxe;
import com.ashindigo.alloycraft.items.AlloyHoe;
import com.ashindigo.alloycraft.items.AlloyItem;
import com.ashindigo.alloycraft.items.AlloyPickaxe;
import com.ashindigo.alloycraft.items.AlloyShovel;
import com.ashindigo.alloycraft.items.AlloySword;
import com.ashindigo.utils.UtilsItem;
import com.ashindigo.utils.UtilsItemBlockLoader;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

// TODO Add textures for alloy furnace
// Possibly ingame generated colors for the stats?
public class AlloycraftItems {
	
	public static Item alloy;
	public static AlloySword alloysword;
	public static AlloyShovel alloyshovel;
	public static AlloyPickaxe alloypickaxe;
	public static AlloyHoe alloyhoe;
	//public static AlloyAxe alloyaxe;
	public static ToolMaterial AlloyMat = EnumHelper.addToolMaterial("AlloyMat", 0, 0, 0, 0, 0);
	
	public static void preInitItems() {
		alloy = new AlloyItem(AlloycraftMain.modid, "alloy");
		alloysword = new AlloySword(AlloyMat, "alloysword", AlloycraftMain.modid);
		alloyshovel = new AlloyShovel(AlloyMat, "alloyshovel", AlloycraftMain.modid);
		alloypickaxe = new AlloyPickaxe(AlloyMat, "alloypickaxe", AlloycraftMain.modid);
		alloyhoe = new AlloyHoe(AlloyMat, "alloyhoe", AlloycraftMain.modid);
		//alloyaxe = new AlloyAxe(AlloyMat, "alloyaxe", AlloycraftMain.modid);
	}

	public static void initItems() {
		GameRegistry.addShapelessRecipe(new ItemStack(alloy, 1), new Object[]{
	    		new ItemStack(Items.GOLD_INGOT, 1), new ItemStack(Items.IRON_INGOT, 1)
		});
		if(FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(alloy, 0, new ModelResourceLocation(AlloycraftMain.modid + ":" + "alloy", "inventory"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(alloysword, 0, new ModelResourceLocation(AlloycraftMain.modid + ":" + "alloysword", "inventory"));
		//	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(alloyaxe, 0, new ModelResourceLocation(AlloycraftMain.modid + ":" + "alloyaxe", "inventory"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(alloyhoe, 0, new ModelResourceLocation(AlloycraftMain.modid + ":" + "alloyhoe", "inventory"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(alloyshovel, 0, new ModelResourceLocation(AlloycraftMain.modid + ":" + "alloyshovel", "inventory"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(alloypickaxe, 0, new ModelResourceLocation(AlloycraftMain.modid + ":" + "alloypickaxe", "inventory"));
		}
		
	}
	
	public static void postInitItems() {

	}

}
