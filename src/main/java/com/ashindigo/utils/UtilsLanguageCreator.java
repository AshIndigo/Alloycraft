package com.ashindigo.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.item.Item;

/**
 * Automatically generates a en_US.lang file for items and blocks
 * @author 19jasonides_a
 *
 */
public class UtilsLanguageCreator {
	
	static ArrayList namesArray = new ArrayList();
	
	/**
	 * Starts the method to add names to the language file
	 * @param unlocalizedName The items/blocks unlocalized name
	 * @param translatedName The name the item/block will have in-game.
	 * @param modid The Mod's modid
	 */
	public static void init(String unlocalizedName, String translatedName, String modid) {
		try {
		namesArray.clear();
		File folder = new File(UtilsMod.config.getConfigFile().getParentFile().getParentFile().getParentFile() + "/src/main/resources/assets//");
		File langFile = new File(folder + "/" + modid + "/lang/en_US.lang");
		langFile.getParentFile().mkdirs();
		langFile.createNewFile();
		FileWriter fw = new FileWriter(langFile, true);
		BufferedWriter bw = new BufferedWriter(fw);
		FileReader fr = new FileReader(langFile);
		BufferedReader br = new BufferedReader(fr);
		String line = unlocalizedName + ".name=" + translatedName;
		String line2 = br.readLine();
		  while (line2 != null) {
			  namesArray.add(line2);
			  line2 = br.readLine();
		  }
		if (namesArray.contains(line) == false) {
			bw.append(line);
			bw.newLine();
		}

		bw.close();
		br.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Starts the method to add Achievement descriptions and names
	 * @param unlocalizedName Achievement's unlocalized name
	 * @param translatedName The translated title
	 * @param translatedDesc The translated description
	 * @param modid The modid of the mod
	 */
	public static void achInit(String unlocalizedName, String translatedName, String translatedDesc, String modid) {
		try {
		namesArray.clear();
		File folder = new File(UtilsMod.config.getConfigFile().getParentFile().getParentFile().getParentFile() + "/src/main/resources/assets//");
		File langFile = new File(folder + "/" + modid + "/lang/en_US.lang");
		langFile.getParentFile().mkdirs();
		langFile.createNewFile();
		FileWriter fw = new FileWriter(langFile, true);
		BufferedWriter bw = new BufferedWriter(fw);
		FileReader fr = new FileReader(langFile);
		BufferedReader br = new BufferedReader(fr);
		String line = "achievement." + unlocalizedName + "=" + translatedName;
		String line2 = br.readLine();
		String line3 = "achievement." + unlocalizedName + ".desc=" + translatedDesc;
		  while (line2 != null) {
			  namesArray.add(line2);
			  line2 = br.readLine();
		  }
		if (namesArray.contains(line) == false && namesArray.contains(line3) == false) {
			bw.append(line);
			bw.newLine();
			bw.append(line3);
			bw.newLine();
		}

		bw.close();
		br.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
