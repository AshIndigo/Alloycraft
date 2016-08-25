package com.ashindigo.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.text.WordUtils;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Class used for making armor with the added functionality of automatically registering the armor and adding recipes.
 * @author Ash Indigo
 */
public class UtilsArmor extends ItemArmor {

	public static ListMultimap<String, Item> armorlist = ArrayListMultimap.create();
	String MODID;
	String textureName;
	static Map<Item, Item> helmmap = new HashMap<Item, Item>();
	static Map<Item, Item> chestmap = new HashMap<Item, Item>();
	static Map<Item, Item> legmap = new HashMap<Item, Item>();
	static Map<Item, Item> bootmap = new HashMap<Item, Item>();
	public static Map<Item, String> armorNameList = new HashMap();
	public static ArrayList materialList = new ArrayList();
	
	/**
	 * Adds an armor set
	 * @param material ArmorMaterial for the armor
	 * @param modid The mod's modid
	 * @param mat Item used for crafting
	 * @param name The name of the armor
	 */
	public static void armorGen(ArmorMaterial material, String modid, Item mat, String name) {
		new UtilsArmor(name + "helmet", material, EntityEquipmentSlot.HEAD, modid, mat, WordUtils.capitalize(name) + " Helmet");
		new UtilsArmor(name + "chestplate", material, EntityEquipmentSlot.CHEST, modid, mat, WordUtils.capitalize(name) + " Chestplate");
		new UtilsArmor(name + "leggings", material, EntityEquipmentSlot.LEGS, modid, mat, WordUtils.capitalize(name) + " Leggings");
		new UtilsArmor(name + "boots", material, EntityEquipmentSlot.FEET, modid, mat, WordUtils.capitalize(name) + " Boots");
	}
	
	/**
	 * For auto recipe creation please add all 4 pieces of armor in order: Helmet - Chestplate - Leggings - Boots.
	 * @param unlocalizedName The name of the armor
	 * @param material The armor material for the set
	 * @param type The type of armor 
	 * @param modid The modid of your mod
	 * @param mat The item used for crafting the armor
	 * @param translatedName The In-Game name of the item
	 */
	public UtilsArmor(String name, ArmorMaterial material, EntityEquipmentSlot type, String modid, Item mat, String translatedName) {
	    super(material, 0, type);
	    GameRegistry.register(this, new ResourceLocation(modid, name));
	    textureName = name;
	    maxStackSize = 1;
	    this.setUnlocalizedName(modid + "_" + name);
	    setCreativeTab(CreativeTabs.COMBAT);
	    canRepair = true;
	    armorNameList.put(this, name);
	    armorlist.put(modid, this);
	    UtilsItem.modItems.put(modid, this);
	    UtilsItem.itemNameList.put(this, name);
	    UtilsItem.translatedNameList.put(this, translatedName);
	    materialList.add(mat);
	    MODID = modid;
	    // Switch Block for inserting correct items in maps
	    switch (type) {
	    case HEAD: helmmap.put(mat, this); break;
	    case CHEST: chestmap.put(mat, this); break;
	    case LEGS: legmap.put(mat, this); break;
	    case FEET: bootmap.put(mat, this); break;
		default:
			// For hand and offhand
			break;
	    }
	}
	
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		if (par1ItemStack.getItem() == helmmap.get(par2ItemStack.getItem())) {
	        return par2ItemStack.getItem() == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
		if (par1ItemStack.getItem() == chestmap.get(par2ItemStack.getItem())) {
	        return par2ItemStack.getItem() == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
		if (par1ItemStack.getItem() == legmap.get(par2ItemStack.getItem())) {
	        return par2ItemStack.getItem() == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
		if (par1ItemStack.getItem() == bootmap.get(par2ItemStack.getItem())) {
	        return par2ItemStack.getItem() == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
		return false;
	}

	/**
	 * Sets up recipes for armor
	 */
	public static void registerRecipes(){
		try {
		int multiplier4 = 0;
		int armorruntime = 0;
		int multiplier = 1;
		int modruntime = 0;
		while (modruntime < UtilsMod.modidList.size()) {
		while(armorruntime < armorlist.get((String) UtilsMod.modidList.get(modruntime)).size() / 4) {
		GameRegistry.addRecipe(new ItemStack((Item) armorlist.get((String) UtilsMod.modidList.get(modruntime)).get(0 + multiplier4), 1), new Object[]{
		        "AAA",
		        "A A",
		        "   ",
		        'A', (Item) materialList.get(0 + multiplier4)
		    });
		GameRegistry.addRecipe(new ItemStack((Item) armorlist.get((String) UtilsMod.modidList.get(modruntime)).get(1 + multiplier4), 1), new Object[]{
	        	"A A",
	        	"AAA",
	        	"AAA",
	        	'A', (Item) materialList.get(0 + multiplier4)
	    	});
	    	GameRegistry.addRecipe(new ItemStack((Item) armorlist.get((String) UtilsMod.modidList.get(modruntime)).get(2 + multiplier4), 1), new Object[]{
	        	"AAA",
	        	"A A",
	        	"A A",
	        	'A', (Item) materialList.get(0 + multiplier4)
	    	});
	    	GameRegistry.addRecipe(new ItemStack((Item) armorlist.get((String) UtilsMod.modidList.get(modruntime)).get(3 + multiplier4), 1), new Object[]{
		        "   ",
		        "A A",
		        "A A",
		        'A', (Item) materialList.get(0 + multiplier4)
		    });
	    	armorruntime++;
	    	multiplier++; 
	    	multiplier4 = multiplier4 + 4;
	}
		modruntime++;
		}
		} catch(IndexOutOfBoundsException e){
			e.printStackTrace();
		}
	}
	/**
	 * Armor texture method
	 */
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
	    return MODID + ":armor/" + textureName + "_" + (armorType.getSlotIndex() == 2 ? "2" : "1") + ".png";
	}
}
