package com.ashindigo.alloycraft.tileentites;

import com.ashindigo.alloycraft.blocks.ForgeBlock;
import com.ashindigo.alloycraft.lib.ForgeRecipes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.common.registry.GameRegistry;

// TODO Add rf/tesla alloy forge?
public class ForgeTileEntity extends TileEntity implements ISidedInventory, ITickable {

	private ItemStack slots[];
	
	public int dualPower;
	public int dualCookTime;
	public final int maxPower = 32000;
	public final int smeltingSpeed = 1;
	
	private final int[] slots_top = new int[] {0, 1};
	private final int[] slots_bottom = new int[] {3};
	private final int[] slots_side = new int[] {2};
	
	public ForgeTileEntity() {
		slots = new ItemStack[4];
	}

	@Override
	public int getSizeInventory() {
		return slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return slots[i];
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		slots[i] = itemstack;
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return i == 2 ? false : (i == 1 ? hasItemPower(itemstack) : true);
	}
	
	public boolean hasItemPower(ItemStack itemstack) {
		return getItemPower(itemstack) > 0;
	}
	
	private static int getItemPower(ItemStack stack) {
		return TileEntityFurnace.getItemBurnTime(stack);
	}
	
	public ItemStack decrStackSize(int i, int j) {
		if (slots[i] != null) {
			if (slots[i].stackSize <= j) {
				ItemStack itemstack = slots[i];
				slots[i] = null;
				return itemstack;
			}
			
			ItemStack itemstack1 = slots[i].splitStack(j);
			
			if (slots[i].stackSize == 0) {
				slots[i] = null;
			}
			
			return itemstack1;
		}else{
			return null;
		}
	}
	
	public void readFromNBT (NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		NBTTagList list = nbt.getTagList("Items", 10);
		slots = new ItemStack[getSizeInventory()];
		
		for (int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound nbt1 = (NBTTagCompound)list.getCompoundTagAt(i);
			byte b0 = nbt1.getByte("Slot");
			
			if (b0 >= 0 && b0 < slots.length) {
				slots[b0] = ItemStack.loadItemStackFromNBT(nbt1);
			}
		}
		
		dualPower = nbt.getShort("PowerTime");
		dualCookTime = nbt.getShort("CookTime");
	}
	
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setShort("PowerTime", (short)dualPower);
		nbt.setShort("CookTime", (short)dualCookTime);
		NBTTagList list = new NBTTagList();
		
		for (int i = 0; i < slots.length; i++) {
			if (slots[i] != null) {
				NBTTagCompound nbt1 = new NBTTagCompound();
				nbt1.setByte("Slot", (byte)i);
				slots[i].writeToNBT(nbt1);
				list.appendTag(nbt1);
			}
		}
		
		nbt.setTag("Items", list);
		return nbt;
	}
	
	public int getSmeltingProgressScaled(int i) {
		return (dualCookTime * i) / this.smeltingSpeed;
	}
	
	public int getPowerRemainingScaled(int i) {
		return (dualPower * i) / maxPower;
	}
	
	private boolean canSmelt() {
		
		if (slots[0] == null || slots[1] == null) {
			return false;
		}
		
		ItemStack itemstack = ForgeRecipes.getOutput(slots[0], slots[1]);
		
		if (itemstack == null) {
			return false;
		}
		
		if (slots[3] == null) {
			return true;
		}
		
		if (!slots[3].isItemEqual(itemstack)) {
			return false;
		}
		
		if (slots[3].stackSize < getInventoryStackLimit() && slots[3].stackSize < slots[3].getMaxStackSize()) {
			return true;
		}else{
			return slots[3].stackSize < itemstack.getMaxStackSize();
		}
	}
	
	private void smeltItem() {
		if (canSmelt()) {
			ItemStack itemstack = ForgeRecipes.getOutput(slots[0], slots[1]);
			
			if (slots[3] == null) {
				slots[3] = itemstack.copy();
			}else if (slots[3].isItemEqual(itemstack)) {
				slots[3].stackSize += itemstack.stackSize;
			}
			
			for (int i = 0; i < 2; i++) {
				if (slots[i].stackSize <= 0) {
					slots[i] = new ItemStack(slots[i].getItem().setFull3D());
				}else{
					slots[i].stackSize--;
				}
				
				if (slots[i].stackSize <= 0){
					slots[i] = null;
				}
			}
		}
	}
	
	public boolean hasPower() {
		return dualPower > 0;
	}
	
	public boolean isSmelting() {
		return this.dualCookTime > 0;
	}
	
	public void update() {
		boolean flag = this.hasPower();
		boolean flag1= false;
		
		if(hasPower() && this.isSmelting()) {
			this.dualPower--;
		}
		
		if(!worldObj.isRemote) {
			if (this.hasItemPower(this.slots[2]) && this.dualPower < (this.maxPower - this.getItemPower(this.slots[2]))) {
				this.dualPower += getItemPower(this.slots[2]);
				
				if(this.slots[2] != null) {
					flag1 = true;
					
					this.slots[2].stackSize--;
					
					if(this.slots[2].stackSize == 0) {
						this.slots[2] = this.slots[2].getItem().getContainerItem(this.slots[2]);
					}
				}
			}
			
			if (hasPower() && canSmelt()) {
				dualCookTime++;
				
				if (this.dualCookTime == this.smeltingSpeed) {
					this.dualCookTime = 0;
					this.smeltItem();
					flag1 = true;
				}
			}else{
				dualCookTime = 0;
			}
			
			if (flag != this.isSmelting()) {
				flag1 = true;
			}
		}
		
		if (flag1) {
			this.markDirty();
		}
    }

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return null;
	}

	@Override
	public void openInventory(EntityPlayer player) {
	}

	@Override
	public void closeInventory(EntityPlayer player) {
	}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		
	}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clear() {
		
	}

	@Override
	public String getName() {
		return "Alloy Furnace";
	}

	@Override
	public boolean hasCustomName() {
		return this.getName() != null && this.getName().length() > 0;
	}

	@Override
	public ITextComponent getDisplayName() {
		return null;
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return null;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStack, EnumFacing direction) {
		return this.isItemValidForSlot(index, itemStack);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		return direction != direction.DOWN || index != 1 || stack.getItem() == Items.BUCKET;
	}
	
}
