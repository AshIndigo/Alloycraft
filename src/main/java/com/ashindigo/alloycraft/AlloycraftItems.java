package com.ashindigo.alloycraft;

import java.awt.Color;

import com.ashindigo.alloycraft.items.AlloyAxe;
import com.ashindigo.alloycraft.items.AlloyHoe;
import com.ashindigo.alloycraft.items.AlloyItem;
import com.ashindigo.alloycraft.items.AlloyPickaxe;
import com.ashindigo.alloycraft.items.AlloyShovel;
import com.ashindigo.alloycraft.items.AlloySword;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

// RIP
public class AlloycraftItems {
	
	public static Item alloy;
	public static AlloySword alloysword;
	public static AlloyShovel alloyshovel;
	public static AlloyPickaxe alloypickaxe;
	public static AlloyHoe alloyhoe;
	public static AlloyAxe alloyaxe;
	public static ToolMaterial AlloyMat = EnumHelper.addToolMaterial("AlloyMat", 0, 0, 0, 0, 0);
	
	public static void preInitItems() {
		alloy = new AlloyItem(AlloycraftMain.modid, "alloy");
		alloysword = new AlloySword(AlloyMat, "alloysword", AlloycraftMain.modid);
		alloyshovel = new AlloyShovel(AlloyMat, "alloyshovel", AlloycraftMain.modid);
		alloypickaxe = new AlloyPickaxe(AlloyMat, "alloypickaxe", AlloycraftMain.modid);
		alloyhoe = new AlloyHoe(AlloyMat, "alloyhoe", AlloycraftMain.modid);
		alloyaxe = new AlloyAxe(AlloyMat, "alloyaxe", AlloycraftMain.modid);
	}

	public static void initItems() {
		// Alloy
		IItemColor colour = new IItemColor() {
            public int getColorFromItemstack(ItemStack stack, int tintIndex) {
            	if (stack.getTagCompound() != null) {
            		// Checks to make sure all stats are less than or equal too 255
            		if (stack.getTagCompound().getInteger("Strength") <= 255 && stack.getTagCompound().getInteger("Durability") <= 255 && stack.getTagCompound().getInteger("Enchantability") <= 255) {
            		return new Color(stack.getTagCompound().getInteger("Strength"), stack.getTagCompound().getInteger("Durability"), stack.getTagCompound().getInteger("Enchantability")).getRGB();
            	}
            	}
					return new Color(255,255,255).getRGB();
            	}
        };
    	Minecraft.getMinecraft().getItemColors().registerItemColorHandler(colour, new Item[] {alloy, alloysword, alloyaxe, alloyhoe, alloyshovel, alloypickaxe});
		if(FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(alloy, 0, new ModelResourceLocation(AlloycraftMain.modid + ":" + "alloy", "inventory"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(alloysword, 0, new ModelResourceLocation(AlloycraftMain.modid + ":" + "alloysword", "inventory"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(alloyaxe, 0, new ModelResourceLocation(AlloycraftMain.modid + ":" + "alloyaxe", "inventory"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(alloyhoe, 0, new ModelResourceLocation(AlloycraftMain.modid + ":" + "alloyhoe", "inventory"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(alloyshovel, 0, new ModelResourceLocation(AlloycraftMain.modid + ":" + "alloyshovel", "inventory"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(alloypickaxe, 0, new ModelResourceLocation(AlloycraftMain.modid + ":" + "alloypickaxe", "inventory"));
		}
		
	}
	
	public static void postInitItems() {

	}

}
