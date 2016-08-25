package com.ashindigo.alloycraft;

import com.ashindigo.alloycraft.items.AlloyArmor;
import com.ashindigo.alloycraft.items.AlloyAxe;
import com.ashindigo.alloycraft.items.AlloyHoe;
import com.ashindigo.alloycraft.items.AlloyItem;
import com.ashindigo.alloycraft.items.AlloyPickaxe;
import com.ashindigo.alloycraft.items.AlloyShovel;
import com.ashindigo.alloycraft.items.AlloySword;
import com.ashindigo.alloycraft.lib.ClientProxy;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

// TODO Make recipes show up in JEI
public class AlloycraftItems {
	
	public static Item alloy;
	public static Item alloysword;
	public static Item alloyshovel;
	public static Item alloypickaxe;
	public static Item alloyhoe;
	public static Item alloyaxe;
	public static Item alloyhelmet;
	public static Item alloychestplate;
	public static Item alloyleggings;
	public static Item alloyboots;
	public static ToolMaterial AlloyMat = EnumHelper.addToolMaterial("AlloyMat", 0, 0, 0, 0, 0);
	public static ArmorMaterial AlloyMatArmor = EnumHelper.addArmorMaterial("AlloyArmorMat", "alloyarmor", 0, new int[]{0,0,0,0}, 0, null, 0);
	
	public static void preInitItems() {
		alloy = new AlloyItem(AlloycraftMain.modid, "alloy");
		alloysword = new AlloySword(AlloyMat, "alloysword", AlloycraftMain.modid);
		alloyshovel = new AlloyShovel(AlloyMat, "alloyshovel", AlloycraftMain.modid);
		alloypickaxe = new AlloyPickaxe(AlloyMat, "alloypickaxe", AlloycraftMain.modid);
		alloyhoe = new AlloyHoe(AlloyMat, "alloyhoe", AlloycraftMain.modid);
		alloyaxe = new AlloyAxe(AlloyMat, "alloyaxe", AlloycraftMain.modid);
		alloyhelmet = new AlloyArmor("alloyhelm", AlloyMatArmor, EntityEquipmentSlot.HEAD, AlloycraftMain.modid);
		alloychestplate = new AlloyArmor("alloychestplate", AlloyMatArmor,  EntityEquipmentSlot.CHEST, AlloycraftMain.modid);
		alloyleggings = new AlloyArmor("alloyleggings", AlloyMatArmor,  EntityEquipmentSlot.LEGS, AlloycraftMain.modid);
		alloyboots = new AlloyArmor("alloyboots", AlloyMatArmor,  EntityEquipmentSlot.FEET, AlloycraftMain.modid);
		
	}

	public static void initItems() {
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			ClientProxy.render();
		}
		GameRegistry.addShapelessRecipe(new ItemStack(alloyhelmet), new Object[] {Items.APPLE});
		GameRegistry.addShapelessRecipe(new ItemStack(alloychestplate), new Object[] {Blocks.DIRT});
		GameRegistry.addShapelessRecipe(new ItemStack(alloyleggings), new Object[] {Items.ARROW});
		GameRegistry.addShapelessRecipe(new ItemStack(alloyboots), new Object[] {Blocks.CACTUS});
	}
	
	public static void postInitItems() {

	}

}
