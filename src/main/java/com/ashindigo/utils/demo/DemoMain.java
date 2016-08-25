package com.ashindigo.utils.demo;

import com.ashindigo.utils.IndigoMod;
import com.ashindigo.utils.UtilsAchievement;
import com.ashindigo.utils.UtilsCreativeTab;
import com.ashindigo.utils.UtilsMain;
import com.ashindigo.utils.UtilsMod;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * A demonstration mod for the features of IndigoApi
 * - Achievements
 * - World Gen
 * - Creative Tabs
 * @author Ash Indigo
 *
 */
@Mod(modid="utilsdemo", name="Utils Demo", version="1.0", dependencies="required-before:indigoutils")  
@IndigoMod
public class DemoMain implements UtilsMain {

	@Override
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		DemoItems.preInitItems();
		DemoBlocks.preInitBlocks();
		// Registers the mod with IndigoUtils
		UtilsMod.modidList.add("utilsdemo");

	}

	@Override
	@EventHandler
	public void init(FMLInitializationEvent event) {
		// Creative Tab
		UtilsCreativeTab demotab = new UtilsCreativeTab("Utils Demo", DemoItems.testItem1);
		// Achievements
		UtilsAchievement testach1 = new UtilsAchievement("achievement.test1", "test1", 0, 0, new ItemStack(DemoItems.testItem1), null, "Test Achievement 1", "You got one!", "utilsdemo");
		UtilsAchievement testach2 = new UtilsAchievement("achievement.test2", "test2", 0, 1, new ItemStack(DemoItems.testItem2), null, "Test Achievement 2", "You got two!", "utilsdemo");
		AchievementPage demopage = new AchievementPage("Utils Demo", new Achievement[]{testach1, testach2});

	}

	@Override
	public void postinit(FMLPostInitializationEvent event) {

	}

}
