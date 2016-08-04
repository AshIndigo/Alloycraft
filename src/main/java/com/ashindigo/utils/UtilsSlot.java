package com.ashindigo.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

/**
 * Pre made class for GUI Slots
 * @author Ash
 * (Honestly dont know why I left this)
 */

public class UtilsSlot extends Slot {

	public UtilsSlot(IInventory p_i1824_1_, int p_i1824_2_, int p_i1824_3_, int p_i1824_4_) {
		super(p_i1824_1_, p_i1824_2_, p_i1824_3_, p_i1824_4_);
	}
	
	public UtilsSlot(EntityPlayer player, IInventory iiventory, int i, int j, int k) {
		super(iiventory, i, j, k);
	}


}
