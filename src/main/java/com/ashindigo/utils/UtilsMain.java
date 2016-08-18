package com.ashindigo.utils;

import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
* An interface dedicated to making an easy base mod file
* @author Ash Indigo
*/
public interface UtilsMain {

	/**
	* The preinit event for Forge
	* Make sure to add @EventHandler
	*/
	@EventHandler
	public void preinit(FMLPreInitializationEvent event);
	
	/**
	* The init event for Forge
	* Make sure to add @EventHandler
	*/
	@EventHandler
	public void init(FMLInitializationEvent event);
	
	/**
	* The postinit event for Forge
	* Make sure to add @EventHandler
	*/
	@EventHandler
	public void postinit(FMLPostInitializationEvent event);

}
