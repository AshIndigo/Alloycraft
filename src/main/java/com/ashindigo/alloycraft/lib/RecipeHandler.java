package com.ashindigo.alloycraft.lib;

import com.ashindigo.alloycraft.AlloycraftItems;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

/**
 * 
 * @author Ash
 *
 */
// TODO Dont use square root?
public class RecipeHandler implements IRecipe {

	private ItemStack result;

	@Override
	public boolean matches(InventoryCrafting invCraft, World world) {
		try {
		// Pickaxe
		if (invCraft.getStackInSlot(0).getItem() == AlloycraftItems.alloy) {
			if(invCraft.getStackInSlot(1).getItem() == AlloycraftItems.alloy) {
				if(invCraft.getStackInSlot(2).getItem() == AlloycraftItems.alloy) {
					if(invCraft.getStackInSlot(4).getItem() == Items.STICK) {
						if(invCraft.getStackInSlot(7).getItem() == Items.STICK) {
							return true;
						}
					}
				}	
			}
		}
		} catch (Exception e) {
			//e.printStackTrace();
		}
		// Sword
		try {
		if(invCraft.getStackInSlot(1).getItem() == AlloycraftItems.alloy) {
			if(invCraft.getStackInSlot(4).getItem() == AlloycraftItems.alloy) {
				if(invCraft.getStackInSlot(7).getItem() == Items.STICK) {
					return true;
				}
			}
		}
		} catch (Exception e) {
		}
		// Hoe
		try {
			if(invCraft.getStackInSlot(0).getItem() == AlloycraftItems.alloy) {
			if(invCraft.getStackInSlot(1).getItem() == AlloycraftItems.alloy) {
				if(invCraft.getStackInSlot(4).getItem() == Items.STICK) {
					if(invCraft.getStackInSlot(7).getItem() == Items.STICK) {
						return true;
					}
				}
			}
			}
			} catch (Exception e) {
				
			}
		// Hoe
		try {
			if(invCraft.getStackInSlot(2).getItem() == AlloycraftItems.alloy) {
			if(invCraft.getStackInSlot(1).getItem() == AlloycraftItems.alloy) {
				if(invCraft.getStackInSlot(4).getItem() == Items.STICK) {
					if(invCraft.getStackInSlot(7).getItem() == Items.STICK) {
						return true;
					}
				}
			}
			}
			} catch (Exception e) {
				
			}
		// Shovel
		try {
			if(invCraft.getStackInSlot(1).getItem() == AlloycraftItems.alloy) {
				if(invCraft.getStackInSlot(4).getItem() == Items.STICK) {
					if(invCraft.getStackInSlot(7).getItem() == Items.STICK) {
						return true;
					}
				}
			}
			} catch (Exception e) {
				
			}
		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting invCraft) {
		try {
			// Pickaxe
			if (invCraft.getStackInSlot(0).getItem() == AlloycraftItems.alloy) {
				if(invCraft.getStackInSlot(1).getItem() == AlloycraftItems.alloy) {
					if(invCraft.getStackInSlot(2).getItem() == AlloycraftItems.alloy) {
						if(invCraft.getStackInSlot(4).getItem() == Items.STICK) {
							if(invCraft.getStackInSlot(7).getItem() == Items.STICK) {
								ItemStack alloy1 = invCraft.getStackInSlot(0);
								ItemStack alloy2 = invCraft.getStackInSlot(1);
								ItemStack alloy3 = invCraft.getStackInSlot(2);
								int prop1 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Strength") + alloy2.getTagCompound().getInteger("Strength") + alloy3.getTagCompound().getInteger("Strength"));
								int prop2 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Durability") + alloy2.getTagCompound().getInteger("Durability") + alloy3.getTagCompound().getInteger("Durability"));
								int prop3 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Enchantability") + alloy2.getTagCompound().getInteger("Enchantability") + alloy3.getTagCompound().getInteger("Enchantability"));
								result = new ItemStack(AlloycraftItems.alloypickaxe, 1);
								result.setTagCompound(new NBTTagCompound());
								result.getTagCompound().setInteger("Strength", prop1);
								result.getTagCompound().setInteger("Durability", prop2);
								result.getTagCompound().setInteger("Enchantability", prop3); 
								return result;
							}
						}
					}	
				}
			}
			} catch (Exception e) {
				//e.printStackTrace();
			}
				 //Sword
				try {
					if(invCraft.getStackInSlot(1).getItem() == AlloycraftItems.alloy) {
							if(invCraft.getStackInSlot(4).getItem() == AlloycraftItems.alloy) {
								if(invCraft.getStackInSlot(7).getItem() == Items.STICK) {
									ItemStack alloy1 = invCraft.getStackInSlot(1);
									ItemStack alloy2 = invCraft.getStackInSlot(4);
									int prop1 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Strength") + alloy2.getTagCompound().getInteger("Strength"));
									int prop2 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Durability") + alloy2.getTagCompound().getInteger("Durability"));
									int prop3 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Enchantability") + alloy2.getTagCompound().getInteger("Enchantability"));
									result = new ItemStack(AlloycraftItems.alloysword, 1);
									result.setTagCompound(new NBTTagCompound());
									result.getTagCompound().setInteger("Strength", prop1);
									result.getTagCompound().setInteger("Durability", prop2);
									result.getTagCompound().setInteger("Enchantability", prop3); 
									return result;
								}
							}
						}	
				} catch (Exception e) {
					//e.printStackTrace();
				}
				//Hoe
				try {
					if (invCraft.getStackInSlot(0).getItem() == AlloycraftItems.alloy) {
					if(invCraft.getStackInSlot(1).getItem() == AlloycraftItems.alloy) {
							if(invCraft.getStackInSlot(4).getItem() == Items.STICK) {
								if(invCraft.getStackInSlot(7).getItem() == Items.STICK) {
									ItemStack alloy1 = invCraft.getStackInSlot(0);
									ItemStack alloy2 = invCraft.getStackInSlot(1);
									int prop1 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Strength") + alloy2.getTagCompound().getInteger("Strength"));
									int prop2 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Durability") + alloy2.getTagCompound().getInteger("Durability"));
									int prop3 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Enchantability") + alloy2.getTagCompound().getInteger("Enchantability"));
									result = new ItemStack(AlloycraftItems.alloyhoe, 1);
									result.setTagCompound(new NBTTagCompound());
									result.getTagCompound().setInteger("Strength", prop1);
									result.getTagCompound().setInteger("Durability", prop2);
									result.getTagCompound().setInteger("Enchantability", prop3); 
									return result;
								}
							}
						}	
					}
				} catch (Exception e) {
					//e.printStackTrace();
				}
				//Hoe
				try {
					if (invCraft.getStackInSlot(2).getItem() == AlloycraftItems.alloy) {
					if(invCraft.getStackInSlot(1).getItem() == AlloycraftItems.alloy) {
							if(invCraft.getStackInSlot(4).getItem() == Items.STICK) {
								if(invCraft.getStackInSlot(7).getItem() == Items.STICK) {
									ItemStack alloy1 = invCraft.getStackInSlot(1);
									ItemStack alloy2 = invCraft.getStackInSlot(2);
									int prop1 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Strength") + alloy2.getTagCompound().getInteger("Strength"));
									int prop2 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Durability") + alloy2.getTagCompound().getInteger("Durability"));
									int prop3 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Enchantability") + alloy2.getTagCompound().getInteger("Enchantability"));
									result = new ItemStack(AlloycraftItems.alloyhoe, 1);
									result.setTagCompound(new NBTTagCompound());
									result.getTagCompound().setInteger("Strength", prop1);
									result.getTagCompound().setInteger("Durability", prop2);
									result.getTagCompound().setInteger("Enchantability", prop3); 
									return result;
								}
							}
						}	
					}
				} catch (Exception e) {
					//e.printStackTrace();
				}
				//Shovel
				try {
					if(invCraft.getStackInSlot(1).getItem() == AlloycraftItems.alloy) {
							if(invCraft.getStackInSlot(4).getItem() == Items.STICK) {
								if(invCraft.getStackInSlot(7).getItem() == Items.STICK) {
									ItemStack alloy1 = invCraft.getStackInSlot(1);
									int prop1 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Strength"));
									int prop2 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Durability"));
									int prop3 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Enchantability"));
									result = new ItemStack(AlloycraftItems.alloyshovel, 1);
									result.setTagCompound(new NBTTagCompound());
									result.getTagCompound().setInteger("Strength", prop1);
									result.getTagCompound().setInteger("Durability", prop2);
									result.getTagCompound().setInteger("Enchantability", prop3); 
									return result;
								}
							}
					}
				} catch (Exception e) {
					//e.printStackTrace();
				}
		return null;
		}

	@Override
	public int getRecipeSize() {
		return 9;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return null;
	}

	@Override
	public ItemStack[] getRemainingItems(InventoryCrafting inv) {
		return ForgeHooks.defaultRecipeGetRemainingItems(inv);
	}

}