package com.ashindigo.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import net.minecraft.item.Item;
import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Small Forge mod to run required methods.
 */
// TODO Utils In-game config menu support
// TODO Implement PR #3154?
// TODO Use a String getter in UtilsMod to return the correct GUIFactory class in @Mod
@Mod(modid = "indigoutils", version = "1.0", name = "IndigoUtils")
public class UtilsMod implements UtilsMain {
	
	static Configuration config;
	public static ArrayList modidList = new ArrayList();
	public boolean debug = Launch.blackboard.get("fml.deobfuscatedEnvironment") != null;

	// Sorry Lex!
	@EventHandler
	public void constructing(FMLConstructionEvent event) {
		FluidRegistry.enableUniversalBucket();
	}
	
	@Override
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());
		UtilsItemBlockLoader.preInitItems();
		UtilsItemBlockLoader.preInitBlocks();
	}

	@Override
	@EventHandler
	public void init(FMLInitializationEvent event) {
		// Checks to see if debug mode is enabled and loads items/blocks
		if (debug == true) {
			debugMode();
		}
		UtilsItemBlockLoader.initItems();
		UtilsItemBlockLoader.initBlocks();
		GameRegistry.registerWorldGenerator(new UtilsWorldgen(), 1);
	}
	
	@Override
	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		UtilsItemBlockLoader.postInitItems();
		UtilsItemBlockLoader.postInitBlocks();
	}
	
	/**
	 * Debug mode for when IndigoUtils is in a development environment.
	 */
	public void debugMode() {
		int runtime = 0;
		System.out.println("Debug Mode is enabled.");
		int modRuntime0 = 0;
		int runtime0 = 0;
		while (modRuntime0 < UtilsMod.modidList.size()) {
			runtime0 = 0;
		while (runtime0 < UtilsItem.modItems.get(UtilsMod.modidList.get(modRuntime0).toString()).size()) {
			UtilsLanguageCreator.init(UtilsItem.modItems.get((String) UtilsMod.modidList.get(modRuntime0)).get(runtime0).getUnlocalizedName(), UtilsItem.translatedNameList.get(UtilsItem.modItems.get((String) UtilsMod.modidList.get(modRuntime0)).get(runtime0)), UtilsMod.modidList.get(modRuntime0).toString());
			runtime0++;
		}
		modRuntime0++;
		}
		modRuntime0 = 0;
		int runtime2;
		while (modRuntime0 < UtilsMod.modidList.size()) {
			runtime2 = 0;
		while (runtime2 < UtilsAchievement.modAch.get(UtilsMod.modidList.get(modRuntime0).toString()).size()) {
			   UtilsLanguageCreator.achInit(UtilsAchievement.achNameList.get(UtilsAchievement.modAch.get((String) UtilsMod.modidList.get(modRuntime0)).get(runtime2)), UtilsAchievement.translatedNameList.get(UtilsAchievement.modAch.get((String) UtilsMod.modidList.get(modRuntime0)).get(runtime2)), UtilsAchievement.translatedDescList.get(UtilsAchievement.modAch.get((String) UtilsMod.modidList.get(modRuntime0)).get(runtime2)), (String) UtilsMod.modidList.get(modRuntime0));
			   runtime2++;
			   //Remember to increment your values!
		}
		modRuntime0++;
		}
		while (runtime < modidList.size()) {
			UtilsJsonCreator.init((String) modidList.get(runtime));
			runtime++;
		}
	}
	
	/**
	 * Generates modid's in the IndigoUtils config file.
	 * @param modid The modid of a mod
	 * @param configFolder The config folder
	 */
	@Deprecated // This will end up breaking the config if this is called. Possibly should just scrap	
	public static void addModReg(String modid, String configFolder) {
		try {
			File modfileOld = new File(configFolder);
			File modfile = new File(modfileOld.getParent() + "/indigoutils.cfg");
			FileWriter fw = new FileWriter(modfile);
			BufferedWriter bw = new BufferedWriter(fw);
			modidList.add(modid);
			int runtime = 0;
			while (runtime  < modidList.size()) {
				bw.write((String) modidList.get(runtime));
				bw.newLine();
				runtime++;
			}
			bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
