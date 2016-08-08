package com.ashindigo.alloycraft.lib;

import com.ashindigo.alloycraft.AlloycraftBlocks;
import com.ashindigo.alloycraft.AlloycraftItems;
import com.ashindigo.alloycraft.AlloycraftMain;

import net.minecraft.item.Item;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class EventHandler {
	
	public EventHandler() {
		super();
	}

	@SubscribeEvent
	public void onCrafted(ItemCraftedEvent event) {
		if (event.crafting.getItem() == Item.getItemFromBlock(AlloycraftBlocks.forgeoff)) {
			event.player.addStat(AlloycraftMain.alloyforge);
		}
		if (event.crafting.getItem() == AlloycraftItems.alloy) {
			event.player.addStat(AlloycraftMain.alloy);
		}
		if (event.crafting.getItem() == AlloycraftItems.alloyaxe) {
			event.player.addStat(AlloycraftMain.alloyaxe);
		}
		if (event.crafting.getItem() == AlloycraftItems.alloysword) {
			event.player.addStat(AlloycraftMain.alloysword);
		}
		if (event.crafting.getItem() == AlloycraftItems.alloypickaxe) {
			event.player.addStat(AlloycraftMain.alloypick);
		}
		if (event.crafting.getItem() == AlloycraftItems.alloyshovel) {
			event.player.addStat(AlloycraftMain.alloyshovel);
		}
		if (event.crafting.getItem() == AlloycraftItems.alloyhoe) {
			event.player.addStat(AlloycraftMain.alloyhoe);
		}
	}
	
	  @SubscribeEvent
	  public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
	    if(eventArgs.getModID().equals("alloycraft"))
	     AlloycraftMain.syncConfig();
	  }
}
