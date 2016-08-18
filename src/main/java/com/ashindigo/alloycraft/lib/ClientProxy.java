package com.ashindigo.alloycraft.lib;

import java.awt.Color;

import com.ashindigo.alloycraft.AlloycraftItems;
import com.ashindigo.alloycraft.AlloycraftMain;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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
    	Minecraft.getMinecraft().getItemColors().registerItemColorHandler(colour, new Item[] {AlloycraftItems.alloy, AlloycraftItems.alloysword, AlloycraftItems.alloyaxe, AlloycraftItems.alloyhoe, AlloycraftItems.alloyshovel, AlloycraftItems.alloypickaxe, AlloycraftItems.alloyhelmet, AlloycraftItems.alloychestplate, AlloycraftItems.alloyleggings, AlloycraftItems.alloyboots});
    	ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		mesher.register(AlloycraftItems.alloy, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(AlloycraftMain.modid + ":" + "alloy", "inventory"));
		mesher.register(AlloycraftItems.alloysword, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(AlloycraftMain.modid + ":" + "alloysword", "inventory"));
		mesher.register(AlloycraftItems.alloyaxe, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(AlloycraftMain.modid + ":" + "alloyaxe", "inventory"));
		mesher.register(AlloycraftItems.alloyhoe, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(AlloycraftMain.modid + ":" + "alloyhoe", "inventory"));
		mesher.register(AlloycraftItems.alloyshovel, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(AlloycraftMain.modid + ":" + "alloyshovel", "inventory"));
		mesher.register(AlloycraftItems.alloypickaxe, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(AlloycraftMain.modid + ":" + "alloypickaxe", "inventory"));
		mesher.register(AlloycraftItems.alloyhelmet, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(AlloycraftMain.modid + ":" + "alloyhelm", "inventory"));
		mesher.register(AlloycraftItems.alloychestplate, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(AlloycraftMain.modid + ":" + "alloychestplate", "inventory"));
		mesher.register(AlloycraftItems.alloyleggings, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(AlloycraftMain.modid + ":" + "alloyleggings", "inventory"));
		mesher.register(AlloycraftItems.alloyboots, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(AlloycraftMain.modid + ":" + "alloyboots", "inventory"));
	}
}
	

