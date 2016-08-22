package com.ashindigo.utils.demo;

import com.ashindigo.utils.UtilsArmor;
import com.ashindigo.utils.UtilsItem;
import com.ashindigo.utils.UtilsItemBlockInterface.IItem;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.ashindigo.utils.UtilsToolset;

/**
 * Items Demonstration
 * - Basic Items
 * - Tools
 * - Armor
 * @author Ash Indigo
 *
 */
public class DemoItems {

	public static UtilsItem testItem1;
	public static UtilsItem testItem2;
	public static UtilsItem testItem3;
	public static ArmorMaterial demoArmorMat = EnumHelper.addArmorMaterial("demoArmorMat", "demoArmorMat", 0, new int[]{0,0,0,0}, 0, null, 0);
	public static ToolMaterial demoMat = EnumHelper.addToolMaterial("demoMat", 0, 0, 0, 0, 0);
	
	public static void preInitItems() {
		testItem1 = new UtilsItem("utilsdemo", "testitem1", "Test Item 1");
		testItem2 = new UtilsItem("utilsdemo", "testitem2", "Test Item 2");
		testItem3 = new UtilsItem("utilsdemo", "testitem3", "Test Item 3");
		// Adds a toolset (The individual tool constructors can be called to if needed)
		UtilsToolset.toolsetGen(demoMat, "utilsdemo", testItem1, "demo");
		// Add an armor set (The normal constructor can be called if needed)
		UtilsArmor.armorGen(demoArmorMat, "utilsdemo", testItem2, "demo");
	}

	public static void initItems() {

	}

	public static void postInitItems() {

	}

}
