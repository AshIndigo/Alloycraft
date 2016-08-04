package com.philindigo.inficraft;

import com.ashindigo.utils.UtilsArmor;
import com.ashindigo.utils.UtilsItem;
import com.ashindigo.utils.UtilsToolset;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class InfiItems {
	
	public static UtilsItem test;
	public static UtilsItem test2;
	public static UtilsItem test3;
	public static ArmorMaterial ARMORGOLDIRON = EnumHelper.addArmorMaterial("GoldIron", "GoldIron", 14, new int[] {2, 6, 4, 2}, 30, null, 0);
	public static ToolMaterial AlloyMat = EnumHelper.addToolMaterial("AlloyMat", 2, 400, 5.5F, 2.5F, 30);

	public static void init() {
		
		test = new UtilsItem(InfiCraftMain.modid, "test", "test");
		test3 = new UtilsItem(InfiCraftMain.modid, "test3", "test3");
		test2 = new UtilsItem(InfiCraftMain.modid, "test2", "test2");
		
		UtilsArmor helm = new UtilsArmor("helm", ARMORGOLDIRON, EntityEquipmentSlot.HEAD, "inficraft2", test, "helm");
		UtilsArmor chest = new UtilsArmor("chest", ARMORGOLDIRON, EntityEquipmentSlot.CHEST, "inficraft2", test, "chest");
		UtilsArmor leg = new UtilsArmor("leg", ARMORGOLDIRON, EntityEquipmentSlot.LEGS, "inficraft2", test, "leg");
		UtilsArmor boot = new UtilsArmor("boot", ARMORGOLDIRON, EntityEquipmentSlot.FEET, "inficraft2", test, "boot");
		UtilsArmor helm2 = new UtilsArmor("helm2", ARMORGOLDIRON, EntityEquipmentSlot.HEAD, "inficraft2", test2, "helm2");
		UtilsArmor chest2 = new UtilsArmor("chest2", ARMORGOLDIRON, EntityEquipmentSlot.CHEST, "inficraft2", test2, "chest2");
		UtilsArmor leg2 = new UtilsArmor("leg2", ARMORGOLDIRON, EntityEquipmentSlot.LEGS, "inficraft2", test2, "leg2");
		UtilsArmor boot2 = new UtilsArmor("boot2", ARMORGOLDIRON, EntityEquipmentSlot.FEET, "inficraft2", test2, "boot2");
		UtilsToolset.UtilsPickaxe pick = new UtilsToolset.UtilsPickaxe(AlloyMat, "pick", "inficraft2", test, "pick");
		 
	}

}
