package com.philindigo.inficraft;

import com.ashindigo.utils.UtilsItemBlockLoader;
import com.ashindigo.utils.UtilsJson;
import com.ashindigo.utils.UtilsMain;
import com.ashindigo.utils.UtilsMod;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@UtilsJson
//@Mod(modid = InfiCraftMain.modid, version = "1.0", name = "InfiCraft")

public class InfiCraftMain implements UtilsMain {
	
	public final static String modid = "inficraft2";
	Configuration config;

	@Override
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		
		config = new Configuration(event.getSuggestedConfigurationFile());
		UtilsMod.modidList.add(modid);
		
		InfiItems.init();
		InfiBlocks.init();
	}

	@Override
	@EventHandler
	public void init(FMLInitializationEvent event) {
	
	}

	@Override
	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		
	}

}
