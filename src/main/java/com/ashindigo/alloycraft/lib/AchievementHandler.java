package com.ashindigo.alloycraft.lib;

import com.ashindigo.alloycraft.AlloycraftBlocks;
import com.ashindigo.alloycraft.AlloycraftItems;
import com.ashindigo.alloycraft.AlloycraftMain;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class AchievementHandler {

	@SubscribeEvent
	public void onCrafted(ItemCraftedEvent event) {
		if (event.crafting.getItem() == Item.getItemFromBlock(AlloycraftBlocks.forgeoff)) {
			event.player.addStat(AlloycraftMain.alloyforge);
		}
		if (event.crafting.getItem() == AlloycraftItems.alloy) {
			event.player.addStat(AlloycraftMain.alloy);
		}
		// TODO Axe is broken for now
//		if (event.crafting.getItem() == AlloycraftItems.alloyaxe) {
//			event.player.addStat(AlloycraftMain.alloyaxe);
//		}
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
}
