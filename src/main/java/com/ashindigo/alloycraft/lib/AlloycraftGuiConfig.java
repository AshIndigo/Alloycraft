package com.ashindigo.alloycraft.lib;

import java.util.List;

import com.ashindigo.alloycraft.AlloycraftMain;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

// XXX There has to be way to use this without a separate class
public class AlloycraftGuiConfig extends GuiConfig {

	public AlloycraftGuiConfig(GuiScreen parentScreen, List<IConfigElement> configElements, String modID,
			boolean allRequireWorldRestart, boolean allRequireMcRestart, String title) {
		super(parentScreen, new ConfigElement(AlloycraftMain.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
		        "alloycraft", true, false, "Alloycraft Config");
	}
	
}
