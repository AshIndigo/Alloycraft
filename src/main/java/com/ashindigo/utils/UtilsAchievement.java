package com.ashindigo.utils;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

/**
 * For making a achievements a little easier.
 * @author Ash
 * 
 */
public class UtilsAchievement extends Achievement {
	
	public static Map<Achievement, String> achNameList = new HashMap();
	public static ListMultimap<String, Achievement> modAch = ArrayListMultimap.create();
	public static Map<Achievement, String> translatedNameList = new HashMap();
	public static Map<Achievement, String> translatedDescList = new HashMap();

	/**
	 * Default Constructor for making an Achievement
	 * @param statIdIn The stat ID
	 * @param name Name used for lang file
	 * @param column The column the Achievement is on
	 * @param row The row the Achievement is on
	 * @param stack The Block or Item used as an Icon.
	 * @param parent The parent achievement can be null
	 * @param translatedName The In-game name of the Achievement
	 * @param translatedDesc The description of the Achievement
	 * @param modid Your mod's modid
	 */
	// This is so long!
	// Should I seperate into 2 different constructors for Blocks and Items?
	public UtilsAchievement(String statIdIn, String name, int column, int row, ItemStack stack, Achievement parent, String translatedName, String translatedDesc, String modid) {
		super(statIdIn, name, column, row, stack, parent);
		this.registerStat();
		modAch.put(modid, this);
		achNameList.put(this, name);
		translatedNameList.put(this, translatedName);
		translatedDescList.put(this, translatedDesc);
	}
}
