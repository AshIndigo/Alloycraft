package com.ashindigo.alloycraft.lib;

import com.ashindigo.alloycraft.tileentites.ForgeTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ForgeContainer extends Container {

	private ForgeTileEntity alloyfurnace;
	private int dualCookTime;
	private int dualPower;
	
	public ForgeContainer(InventoryPlayer invPlayer, ForgeTileEntity teAlloyFurnace) {
		dualCookTime = 0;
		dualPower = 0;
		
		alloyfurnace = teAlloyFurnace;
		this.addSlotToContainer(new Slot(teAlloyFurnace, 0, 45, 17));
		this.addSlotToContainer(new Slot(teAlloyFurnace, 1, 45, 49));
		this.addSlotToContainer(new Slot(teAlloyFurnace, 2, 8, 56));
		this.addSlotToContainer(new Slot(teAlloyFurnace, 3, 113, 33));
		
		//Inventory
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		//ActionBar
		for(int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
		}
	}
	
	 public void addListener(IContainerListener listener)
	    {
	        super.addListener(listener);
	        listener.sendAllWindowProperties(this, this.alloyfurnace);
	    }

	    public void detectAndSendChanges()
	    {
	        super.detectAndSendChanges();

	        for (int i = 0; i < this.listeners.size(); ++i)
	        {
	            IContainerListener icontainerlistener = (IContainerListener)this.listeners.get(i);

	            if (this.dualCookTime != this.alloyfurnace.getField(0))
	            {
	                icontainerlistener.sendProgressBarUpdate(this, 0, this.alloyfurnace.getField(0));
	            }

	            if (this.dualPower != this.alloyfurnace.getField(1))
	            {
	                icontainerlistener.sendProgressBarUpdate(this, 1, this.alloyfurnace.getField(1));
	            }
	        }

	        this.dualCookTime = this.alloyfurnace.getField(0);
	        this.dualPower = this.alloyfurnace.getField(1);
	    }

	    @SideOnly(Side.CLIENT)
	    public void updateProgressBar(int id, int data)
	    {
	        this.alloyfurnace.setField(id, data);
	    }
	
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 != 1 && par2 != 0)
            {
                if (FurnaceRecipes.instance().getSmeltingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityFurnace.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 3 && par2 < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }	

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return alloyfurnace.isUseableByPlayer(player);
	}
}
