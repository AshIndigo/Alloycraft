package com.ashindigo.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Automatic Json creator
 * @author Ash Indigo
 */
public class UtilsJsonCreator {
	
	static File configFolder =  UtilsMod.config.getConfigFile().getParentFile();
	static FileWriter fw;
	static BufferedWriter bw;
	static File mainloc = new File(configFolder.getParentFile().getParentFile() + "/src/main/resources/assets");
	static File helmItemJson;
	static File chestItemJson;
	static File legItemJson;
	static File bootItemJson;
	
	/**
	 * Starts the auto json creator
	 * @param modid The Mod's Modid
	 * @author Ash Indigo
	 */
	public static void init(String modid) {
		File modFolderItem = new File(mainloc, modid + "/models/item");
		File modFolderBlock = new File(mainloc, modid + "/models/block");
		File modFolderBlockstate = new File(mainloc, modid + "/blockstates");
		try {
			mainloc.mkdirs();
			mainloc.createNewFile();
			modFolderItem.mkdirs();
			modFolderBlock.mkdirs();
			modFolderBlockstate.mkdirs();
			int runtime1 = 0;
			int runtime2 = 0;
			int runtime3 = 0;
			int runtime4 = 0;
			int runtime5 = 0;
			int runtime6 = 0;
			int multiplier = 0;
			// Calls each method for the items and blocks.
			while (runtime1 < UtilsItem.modItems.get(modid).size()) {
				File itemJson = new File(modFolderItem, UtilsItem.itemNameList.get(UtilsItem.modItems.get(modid).get(runtime1)) + ".json");
				fw = new FileWriter(itemJson.getAbsoluteFile());
				bw = new BufferedWriter(fw);
				itemJson.createNewFile();
				itemJsonCreate(modid, UtilsItem.itemNameList.get(UtilsItem.modItems.get(modid).get(runtime1)));
				runtime1++;
			}
			while (runtime2 < UtilsBlock.modBlocks.get(modid).size()) {
				File blockJson = new File(modFolderBlock, UtilsBlock.blockNameList.get(UtilsBlock.modBlocks.get(modid).get(runtime2)) + ".json");
				fw = new FileWriter(blockJson.getAbsoluteFile());
				bw = new BufferedWriter(fw);
				blockJson.createNewFile();
				blockJsonCreate(modid, UtilsBlock.blockNameList.get(UtilsBlock.modBlocks.get(modid).get(runtime2)));
				runtime2++;
			}
			while (runtime3 < UtilsBlock.modBlocks.get(modid).size()) {
				File blockstateJson = new File(modFolderBlockstate, UtilsBlock.blockNameList.get(UtilsBlock.modBlocks.get(modid).get(runtime3)) + ".json");
				fw = new FileWriter(blockstateJson.getAbsoluteFile());
				bw = new BufferedWriter(fw);
				blockstateJson.createNewFile();
				blockstateJsonCreate(modid, UtilsBlock.blockNameList.get(UtilsBlock.modBlocks.get(modid).get(runtime3)));
				runtime3++;
			}
			while (runtime4 < UtilsBlock.modBlocks.get(modid).size()) {
				File blockItemJson = new File(modFolderItem, UtilsBlock.blockNameList.get(UtilsBlock.modBlocks.get(modid).get(runtime4)) + "itemBlock" + ".json");
				fw = new FileWriter(blockItemJson.getAbsoluteFile());
				bw = new BufferedWriter(fw);
				blockItemJson.createNewFile();
				blockItemJsonCreate(modid, UtilsBlock.blockNameList.get(UtilsBlock.modBlocks.get(modid).get(runtime4)));
				runtime4++;
			}
			while (runtime5 < UtilsToolset.toollists.get(modid).size()) {
				File toolItemJson = new File(modFolderItem, UtilsToolset.toollistsname.get(UtilsToolset.toollists.get(modid).get(runtime5)) + ".json");
				fw = new FileWriter(toolItemJson.getAbsoluteFile());
				bw = new BufferedWriter(fw);
				modFolderItem.createNewFile();
				toolItemJsonCreate(modid, (String) UtilsToolset.toollistsname.get(UtilsToolset.toollists.get(modid).get(runtime5)));
				runtime5++;
			}
			
			while (runtime6 < UtilsArmor.armorlist.get(modid).size() / 4) {
				helmItemJson = new File(modFolderItem, UtilsArmor.armorNameList.get(UtilsArmor.armorlist.get(modid).get(0 + multiplier)) + ".json");
				chestItemJson = new File(modFolderItem, UtilsArmor.armorNameList.get(UtilsArmor.armorlist.get(modid).get(1 + multiplier)) + ".json");
				legItemJson = new File(modFolderItem, UtilsArmor.armorNameList.get(UtilsArmor.armorlist.get(modid).get(2 + multiplier)) + ".json");
				bootItemJson = new File(modFolderItem, UtilsArmor.armorNameList.get(UtilsArmor.armorlist.get(modid).get(3 + multiplier))  + ".json");
				modFolderItem.createNewFile();
				armorItemJsonCreate(modid);
				runtime6++;
				multiplier = multiplier + 4;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void armorItemJsonCreate(String modid) {
		try {
			fw = new FileWriter(helmItemJson.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			bw.write("{");
			bw.newLine();
			bw.write("    \"parent\": \"builtin/generated\",");
			bw.newLine();
			bw.write("    \"textures\": {  	");
			bw.newLine();
			bw.write("        \"layer0\": \"" + modid + ":items/" + helmItemJson.getName().replaceAll(".json", "") + "\"");
			bw.newLine();
			bw.write("    },");
			bw.newLine();
			bw.write("    \"display\": {");
			bw.newLine();
			bw.write("        \"thirdperson\": {");
			bw.newLine();
			bw.write("            \"rotation\": [ -90, 0, 0 ],");
			bw.newLine();
			bw.write("            \"translation\": [ 0, 1, -2.25 ],");
			bw.newLine();
			bw.write("            \"scale\": [ 0.55, 0.55, 0.55 ]");
			bw.newLine();
			bw.write("        },");
			bw.newLine();
			bw.write("        \"firstperson\": {");
			bw.newLine();
			bw.write("            \"rotation\": [ 0, -135, 25 ],");
			bw.newLine();
			bw.write("            \"translation\": [ 0, 4, 2 ],");
			bw.newLine();
			bw.write("            \"scale\": [ 1.7, 1.7, 1.7 ]");
			bw.newLine();
			bw.write("        }");
			bw.newLine();
			bw.write("    }");
			bw.newLine();
			bw.write("}");
			bw.newLine();
			bw.close();
			fw = new FileWriter(chestItemJson.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			bw.write("{");
			bw.newLine();
			bw.write("    \"parent\": \"builtin/generated\",");
			bw.newLine();
			bw.write("    \"textures\": {  	");
			bw.newLine();
			bw.write("        \"layer0\": \"" + modid + ":items/" + chestItemJson.getName().replaceAll(".json", "") + "\"");
			bw.newLine();
			bw.write("    },");
			bw.newLine();
			bw.write("    \"display\": {");
			bw.newLine();
			bw.write("        \"thirdperson\": {");
			bw.newLine();
			bw.write("            \"rotation\": [ -90, 0, 0 ],");
			bw.newLine();
			bw.write("            \"translation\": [ 0, 1, -3 ],");
			bw.newLine();
			bw.write("            \"scale\": [ 0.55, 0.55, 0.55 ]");
			bw.newLine();
			bw.write("        },");
			bw.newLine();
			bw.write("        \"firstperson\": {");
			bw.newLine();
			bw.write("            \"rotation\": [ 0, -135, 25 ],");
			bw.newLine();
			bw.write("            \"translation\": [ 0, 4, 2 ],");
			bw.newLine();
			bw.write("            \"scale\": [ 1.7, 1.7, 1.7 ]");
			bw.newLine();
			bw.write("        }");
			bw.newLine();
			bw.write("    }");
			bw.newLine();
			bw.write("}");
			bw.newLine();
			bw.close();
			fw = new FileWriter(legItemJson.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			bw.write("{");
			bw.newLine();
			bw.write("    \"parent\": \"builtin/generated\",");
			bw.newLine();
			bw.write("    \"textures\": {  	");
			bw.newLine();
			bw.write("        \"layer0\": \"" + modid + ":items/" + legItemJson.getName().replaceAll(".json", "") + "\"");
			bw.newLine();
			bw.write("    },");
			bw.newLine();
			bw.write("    \"display\": {");
			bw.newLine();
			bw.write("        \"thirdperson\": {");
			bw.newLine();
			bw.write("            \"rotation\": [ -90, 0, 0 ],");
			bw.newLine();
			bw.write("            \"translation\": [ 0, 1, -3 ],");
			bw.newLine();
			bw.write("            \"scale\": [ 0.55, 0.55, 0.55 ]");
			bw.newLine();
			bw.write("        },");
			bw.newLine();
			bw.write("        \"firstperson\": {");
			bw.newLine();
			bw.write("            \"rotation\": [ 0, -135, 25 ],");
			bw.newLine();
			bw.write("            \"translation\": [ 0, 4, 2 ],");
			bw.newLine();
			bw.write("            \"scale\": [ 1.7, 1.7, 1.7 ]");
			bw.newLine();
			bw.write("        }");
			bw.newLine();
			bw.write("    }");
			bw.newLine();
			bw.write("}");
			bw.newLine();
			bw.close();
			fw = new FileWriter(bootItemJson.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			bw.write("{");
			bw.newLine();
			bw.write("    \"parent\": \"builtin/generated\",");
			bw.newLine();
			bw.write("    \"textures\": {  	");
			bw.newLine();
			bw.write("        \"layer0\": \"" + modid + ":items/" + bootItemJson.getName().replaceAll(".json", "") + "\"");
			bw.newLine();
			bw.write("    },");
			bw.newLine();
			bw.write("    \"display\": {");
			bw.newLine();
			bw.write("        \"thirdperson\": {");
			bw.newLine();
			bw.write("            \"rotation\": [ -90, 0, 0 ],");
			bw.newLine();
			bw.write("            \"translation\": [ 0, 1, -2.5 ],");
			bw.newLine();
			bw.write("            \"scale\": [ 0.55, 0.55, 0.55 ]");
			bw.newLine();
			bw.write("        },");
			bw.newLine();
			bw.write("        \"firstperson\": {");
			bw.newLine();
			bw.write("            \"rotation\": [ 0, -135, 25 ],");
			bw.newLine();
			bw.write("            \"translation\": [ 0, 4, 2 ],");
			bw.newLine();
			bw.write("            \"scale\": [ 1.7, 1.7, 1.7 ]");
			bw.newLine();
			bw.write("        }");
			bw.newLine();
			bw.write("    }");
			bw.newLine();
			bw.write("}");
			bw.newLine();
			bw.close();
			//runtime1++;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates Json-Files for items.
	 * @param modid The Mod's Modid
	 * @param name The block's name
	 */
	private static void itemJsonCreate(String modid, String name) {
		try {
			bw.write("{");
			bw.newLine();
			bw.write("    \"parent\": \"builtin/generated\",");
			bw.newLine();
			bw.write("    \"textures\": {  	");
			bw.newLine();
			bw.write("        \"layer0\": \"" + modid + ":items/" + name + "\"");
			bw.newLine();
			bw.write("    },");
			bw.newLine();
			bw.write("    \"display\": {");
			bw.newLine();
			bw.write("        \"thirdperson\": {");
			bw.newLine();
			bw.write("            \"rotation\": [ -90, 0, 0 ],");
			bw.newLine();
			bw.write("            \"translation\": [ 0, 1, -3 ],");
			bw.newLine();
			bw.write("            \"scale\": [ 0.55, 0.55, 0.55 ]");
			bw.newLine();
			bw.write("        },");
			bw.newLine();
			bw.write("        \"firstperson\": {");
			bw.newLine();
			bw.write("            \"rotation\": [ 0, -135, 25 ],");
			bw.newLine();
			bw.write("            \"translation\": [ 0, 4, 2 ],");
			bw.newLine();
			bw.write("            \"scale\": [ 1.7, 1.7, 1.7 ]");
			bw.newLine();
			bw.write("        }");
			bw.newLine();
			bw.write("    }");
			bw.newLine();
			bw.write("}");
			bw.newLine();
			bw.close();
			//runtime1++;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates Json-Files for blocks.
	 * @param modid The Mod's Modid
	 * @param name The block's name
	 */
	private static void blockJsonCreate(String modid, String name) {
		try {
			bw.write("{");
			bw.newLine();
			bw.write("    \"parent\": \"block/cube_all\",");
			bw.newLine();
			bw.write("    \"textures\": {");
			bw.newLine();
			bw.write("        \"all\": \"" + modid + ":blocks/" + name + "\"");
			bw.newLine();
			bw.write("    }");
			bw.newLine();
			bw.write("}");
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates Json-Files for blocks-states.
	 * @param modid The Mod's Modid
	 * @param name The block's name
	 */
	private static void blockstateJsonCreate(String modid, String name) {
		try {
			bw.write("{");
			bw.newLine();
			bw.write("    \"variants\": {");
			bw.newLine();
			bw.write("        \"normal\": { \"model\": \"" + modid + ":" + name + "\" }");
			bw.newLine();
			bw.write("    }");
			bw.newLine();
			bw.write("}");
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates Json-Files for blocks.
	 * @param modid The Mod's Modid
	 * @param name The block's name
	 */
	private static void blockItemJsonCreate(String modid, String name) {
		try {
		bw.write("{");
		bw.newLine();
		bw.write("    \"parent\": \"builtin/generated\",");
		bw.newLine();
		bw.write("    \"textures\": {  	");
		bw.newLine();
		bw.write("        \"layer0\": \"" + modid + ":blocks/" + name + "\"");
		bw.newLine();
		bw.write("    },");
		bw.newLine();
		bw.write("    \"display\": {");
		bw.newLine();
		bw.write("        \"thirdperson\": {");
		bw.newLine();
		bw.write("            \"rotation\": [ -90, 0, 0 ],");
		bw.newLine();
		bw.write("            \"translation\": [ 0, 1, -3 ],");
		bw.newLine();
		bw.write("            \"scale\": [ 0.55, 0.55, 0.55 ]");
		bw.newLine();
		bw.write("        },");
		bw.newLine();
		bw.write("        \"firstperson\": {");
		bw.newLine();
		bw.write("            \"rotation\": [ 0, -135, 25 ],");
		bw.newLine();
		bw.write("            \"translation\": [ 0, 4, 2 ],");
		bw.newLine();
		bw.write("            \"scale\": [ 1.7, 1.7, 1.7 ]");
		bw.newLine();
		bw.write("        }");
		bw.newLine();
		bw.write("    }");
		bw.newLine();
		bw.write("}");
		bw.newLine();
		bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates Json-Files for tools.
	 * @param modid The Mod's Modid
	 * @param name The item name
	 */
	private static void toolItemJsonCreate(String modid, String name) {
		try {
			bw.write("{");
			bw.newLine();
			bw.write("    \"parent\": \"builtin/generated\",");
			bw.newLine();
			bw.write("    \"textures\": {  	");
			bw.newLine();
			bw.write("        \"layer0\": \"" + modid + ":items/" + name + "\"");
			bw.newLine();
			bw.write("    },");
			bw.newLine();
			bw.write("    \"display\": {");
			bw.newLine();
			bw.write("        \"thirdperson\": {");
			bw.newLine();
			bw.write("            \"rotation\": [ 0, 90, -35 ],");
			bw.newLine();
			bw.write("            \"translation\": [ 0, 1.25, -3.5 ],");
			bw.newLine();
			bw.write("            \"scale\": [ 0.85, 0.85, 0.85 ]");
			bw.newLine();
			bw.write("        },");
			bw.newLine();
			bw.write("        \"firstperson\": {");
			bw.newLine();
			bw.write("            \"rotation\": [ 0, -135, 25 ],");
			bw.newLine();
			bw.write("            \"translation\": [ 0, 4, 2 ],");
			bw.newLine();
			bw.write("            \"scale\": [ 1.7, 1.7, 1.7 ]");
			bw.newLine();
			bw.write("        }");
			bw.newLine();
			bw.write("    }");
			bw.newLine();
			bw.write("}");
			bw.newLine();
			bw.close();
			//runtime1++;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}