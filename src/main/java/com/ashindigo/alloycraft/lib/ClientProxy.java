package com.ashindigo.alloycraft.lib;

import java.awt.Color;

import com.ashindigo.alloycraft.AlloycraftItems;
import com.ashindigo.alloycraft.AlloycraftMain;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

public class ClientProxy extends CommonProxy {
	
	public static void render() {
		net.minecraft.client.renderer.color.IItemColor colour = new net.minecraft.client.renderer.color.IItemColor() {
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
    net.minecraft.client.Minecraft.getMinecraft().getItemColors().registerItemColorHandler(colour, new Item[] {AlloycraftItems.alloy, AlloycraftItems.alloysword, AlloycraftItems.alloyaxe, AlloycraftItems.alloyhoe, AlloycraftItems.alloyshovel, AlloycraftItems.alloypickaxe, AlloycraftItems.alloyhelmet, AlloycraftItems.alloychestplate, AlloycraftItems.alloyleggings, AlloycraftItems.alloyboots});
		//XXX Its like a forge patch! 
		net.minecraft.client.Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(AlloycraftItems.alloy, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(AlloycraftMain.modid + ":" + "alloy", "inventory"));
		net.minecraft.client.Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(AlloycraftItems.alloysword, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(AlloycraftMain.modid + ":" + "alloysword", "inventory"));
		net.minecraft.client.Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(AlloycraftItems.alloyaxe, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(AlloycraftMain.modid + ":" + "alloyaxe", "inventory"));
		net.minecraft.client.Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(AlloycraftItems.alloyhoe, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(AlloycraftMain.modid + ":" + "alloyhoe", "inventory"));
		net.minecraft.client.Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(AlloycraftItems.alloyshovel, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(AlloycraftMain.modid + ":" + "alloyshovel", "inventory"));
		net.minecraft.client.Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(AlloycraftItems.alloypickaxe, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(AlloycraftMain.modid + ":" + "alloypickaxe", "inventory"));
		net.minecraft.client.Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(AlloycraftItems.alloyhelmet, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(AlloycraftMain.modid + ":" + "alloyhelm", "inventory"));
		net.minecraft.client.Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(AlloycraftItems.alloychestplate, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(AlloycraftMain.modid + ":" + "alloychestplate", "inventory"));
		net.minecraft.client.Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(AlloycraftItems.alloyleggings, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(AlloycraftMain.modid + ":" + "alloyleggings", "inventory"));
		net.minecraft.client.Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(AlloycraftItems.alloyboots, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(AlloycraftMain.modid + ":" + "alloyboots", "inventory"));
	}
}
	

