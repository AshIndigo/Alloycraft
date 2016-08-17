package com.ashindigo.alloycraft.lib;

import com.ashindigo.alloycraft.AlloycraftItems;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
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
// TODO Finish recipes for armor
// TODO Dont use square root? (Divide by numb of ingots?)
public class RecipeHandler implements IRecipe {

	private ItemStack result;

	@Override
	public boolean matches(InventoryCrafting invCraft, World world) {
		try {
			// Pickaxe
			if (invCraft.getStackInSlot(0).getItem() == AlloycraftItems.alloy) {
				if (invCraft.getStackInSlot(1).getItem() == AlloycraftItems.alloy) {
					if (invCraft.getStackInSlot(2).getItem() == AlloycraftItems.alloy) {
						if (invCraft.getStackInSlot(4).getItem() == Items.STICK) {
							if (invCraft.getStackInSlot(7).getItem() == Items.STICK) {
								return true;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
		// Sword
		try {
			if (invCraft.getStackInSlot(1).getItem() == AlloycraftItems.alloy) {
				if (invCraft.getStackInSlot(4).getItem() == AlloycraftItems.alloy) {
					if (invCraft.getStackInSlot(7).getItem() == Items.STICK) {
						return true;
					}
				}
			}
		} catch (Exception e) {
		}
		// Hoe
		try {
			if (invCraft.getStackInSlot(0).getItem() == AlloycraftItems.alloy) {
				if (invCraft.getStackInSlot(1).getItem() == AlloycraftItems.alloy) {
					if (invCraft.getStackInSlot(4).getItem() == Items.STICK) {
						if (invCraft.getStackInSlot(7).getItem() == Items.STICK) {
							return true;
						}
					}
				}
			}
		} catch (Exception e) {

		}
		// Hoe
		try {
			if (invCraft.getStackInSlot(2).getItem() == AlloycraftItems.alloy) {
				if (invCraft.getStackInSlot(1).getItem() == AlloycraftItems.alloy) {
					if (invCraft.getStackInSlot(4).getItem() == Items.STICK) {
						if (invCraft.getStackInSlot(7).getItem() == Items.STICK) {
							return true;
						}
					}
				}
			}
		} catch (Exception e) {

		}
		// Shovel
		try {
			if (invCraft.getStackInSlot(1).getItem() == AlloycraftItems.alloy) {
				if (invCraft.getStackInSlot(4).getItem() == Items.STICK) {
					if (invCraft.getStackInSlot(7).getItem() == Items.STICK) {
						return true;
					}
				}
			}
		} catch (Exception e) {

		}
		// Helmet
		try {
			if (invCraft.getStackInSlot(0).getItem() == AlloycraftItems.alloy) {
				if (invCraft.getStackInSlot(1).getItem() == AlloycraftItems.alloy) {
					if (invCraft.getStackInSlot(2).getItem() == AlloycraftItems.alloy) {
						if (invCraft.getStackInSlot(3).getItem() == AlloycraftItems.alloy) {
							if (invCraft.getStackInSlot(5).getItem() == AlloycraftItems.alloy) {
								return true;
							}
						}
					}
				}
			}
		} catch (Exception e) {

		}
		// Chestplate
		try {
			if (invCraft.getStackInSlot(0).getItem() == AlloycraftItems.alloy) {
				if (invCraft.getStackInSlot(2).getItem() == AlloycraftItems.alloy) {
					if (invCraft.getStackInSlot(3).getItem() == AlloycraftItems.alloy) {
						if (invCraft.getStackInSlot(4).getItem() == AlloycraftItems.alloy) {
							if (invCraft.getStackInSlot(5).getItem() == AlloycraftItems.alloy) {
								if (invCraft.getStackInSlot(6).getItem() == AlloycraftItems.alloy) {
									if (invCraft.getStackInSlot(7).getItem() == AlloycraftItems.alloy) {
										if (invCraft.getStackInSlot(8).getItem() == AlloycraftItems.alloy) {
											return true;
										}
									}
								}
							}
						}
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
				if (invCraft.getStackInSlot(1).getItem() == AlloycraftItems.alloy) {
					if (invCraft.getStackInSlot(2).getItem() == AlloycraftItems.alloy) {
						if (invCraft.getStackInSlot(4).getItem() == Items.STICK) {
							if (invCraft.getStackInSlot(7).getItem() == Items.STICK) {
								ItemStack alloy1 = invCraft.getStackInSlot(0);
								ItemStack alloy2 = invCraft.getStackInSlot(1);
								ItemStack alloy3 = invCraft.getStackInSlot(2);
								int prop1 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Strength")
										+ alloy2.getTagCompound().getInteger("Strength")
										+ alloy3.getTagCompound().getInteger("Strength"));
								int prop2 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Durability")
										+ alloy2.getTagCompound().getInteger("Durability")
										+ alloy3.getTagCompound().getInteger("Durability"));
								int prop3 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Enchantability")
										+ alloy2.getTagCompound().getInteger("Enchantability")
										+ alloy3.getTagCompound().getInteger("Enchantability"));
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
			// e.printStackTrace();
		}
		// Sword
		try {
			if (invCraft.getStackInSlot(1).getItem() == AlloycraftItems.alloy) {
				if (invCraft.getStackInSlot(4).getItem() == AlloycraftItems.alloy) {
					if (invCraft.getStackInSlot(7).getItem() == Items.STICK) {
						ItemStack alloy1 = invCraft.getStackInSlot(1);
						ItemStack alloy2 = invCraft.getStackInSlot(4);
						int prop1 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Strength")
								+ alloy2.getTagCompound().getInteger("Strength"));
						int prop2 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Durability")
								+ alloy2.getTagCompound().getInteger("Durability"));
						int prop3 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Enchantability")
								+ alloy2.getTagCompound().getInteger("Enchantability"));
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
			// e.printStackTrace();
		}
		// Hoe
		try {
			if (invCraft.getStackInSlot(0).getItem() == AlloycraftItems.alloy) {
				if (invCraft.getStackInSlot(1).getItem() == AlloycraftItems.alloy) {
					if (invCraft.getStackInSlot(4).getItem() == Items.STICK) {
						if (invCraft.getStackInSlot(7).getItem() == Items.STICK) {
							ItemStack alloy1 = invCraft.getStackInSlot(0);
							ItemStack alloy2 = invCraft.getStackInSlot(1);
							int prop1 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Strength")
									+ alloy2.getTagCompound().getInteger("Strength"));
							int prop2 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Durability")
									+ alloy2.getTagCompound().getInteger("Durability"));
							int prop3 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Enchantability")
									+ alloy2.getTagCompound().getInteger("Enchantability"));
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
			// e.printStackTrace();
		}
		// Hoe
		try {
			if (invCraft.getStackInSlot(2).getItem() == AlloycraftItems.alloy) {
				if (invCraft.getStackInSlot(1).getItem() == AlloycraftItems.alloy) {
					if (invCraft.getStackInSlot(4).getItem() == Items.STICK) {
						if (invCraft.getStackInSlot(7).getItem() == Items.STICK) {
							ItemStack alloy1 = invCraft.getStackInSlot(1);
							ItemStack alloy2 = invCraft.getStackInSlot(2);
							int prop1 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Strength")
									+ alloy2.getTagCompound().getInteger("Strength"));
							int prop2 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Durability")
									+ alloy2.getTagCompound().getInteger("Durability"));
							int prop3 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Enchantability")
									+ alloy2.getTagCompound().getInteger("Enchantability"));
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
			// e.printStackTrace();
		}
		// Shovel
		try {
			if (invCraft.getStackInSlot(1).getItem() == AlloycraftItems.alloy) {
				if (invCraft.getStackInSlot(4).getItem() == Items.STICK) {
					if (invCraft.getStackInSlot(7).getItem() == Items.STICK) {
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
			// e.printStackTrace();
		}
		// Helmet
		try {
			if (invCraft.getStackInSlot(0).getItem() == AlloycraftItems.alloy) {
				if (invCraft.getStackInSlot(1).getItem() == AlloycraftItems.alloy) {
					if (invCraft.getStackInSlot(2).getItem() == AlloycraftItems.alloy) {
						if (invCraft.getStackInSlot(3).getItem() == AlloycraftItems.alloy) {
							if (invCraft.getStackInSlot(5).getItem() == AlloycraftItems.alloy) {
								ItemStack alloy1 = invCraft.getStackInSlot(0);
								ItemStack alloy2 = invCraft.getStackInSlot(1);
								ItemStack alloy3 = invCraft.getStackInSlot(2);
								ItemStack alloy4 = invCraft.getStackInSlot(3);
								ItemStack alloy5 = invCraft.getStackInSlot(5);
								int prop1 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Strength")
										+ alloy2.getTagCompound().getInteger("Strength")
										+ alloy3.getTagCompound().getInteger("Strength")
										+ alloy4.getTagCompound().getInteger("Strength")
										+ alloy5.getTagCompound().getInteger("Strength"));
								int prop2 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Durability")
										+ alloy2.getTagCompound().getInteger("Durability")
										+ alloy3.getTagCompound().getInteger("Durability")
										+ alloy4.getTagCompound().getInteger("Durability")
										+ alloy5.getTagCompound().getInteger("Durability"));
								int prop3 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Enchantability")
										+ alloy2.getTagCompound().getInteger("Enchantability")
										+ alloy3.getTagCompound().getInteger("Enchantability")
										+ alloy4.getTagCompound().getInteger("Enchantability")
										+ alloy5.getTagCompound().getInteger("Enchantability"));
								result = new ItemStack(AlloycraftItems.alloyhelmet, 1);
								((ItemArmor) result.getItem()).setColor(result, 25555555);    
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

		}

		// Chestplate
		try {
			if (invCraft.getStackInSlot(0).getItem() == AlloycraftItems.alloy) {
				if (invCraft.getStackInSlot(2).getItem() == AlloycraftItems.alloy) {
					if (invCraft.getStackInSlot(3).getItem() == AlloycraftItems.alloy) {
						if (invCraft.getStackInSlot(4).getItem() == AlloycraftItems.alloy) {
							if (invCraft.getStackInSlot(5).getItem() == AlloycraftItems.alloy) {
								if (invCraft.getStackInSlot(6).getItem() == AlloycraftItems.alloy) {
									if (invCraft.getStackInSlot(7).getItem() == AlloycraftItems.alloy) {
										if (invCraft.getStackInSlot(8).getItem() == AlloycraftItems.alloy) {
											ItemStack alloy1 = invCraft.getStackInSlot(0);
											ItemStack alloy2 = invCraft.getStackInSlot(2);
											ItemStack alloy3 = invCraft.getStackInSlot(3);
											ItemStack alloy4 = invCraft.getStackInSlot(4);
											ItemStack alloy5 = invCraft.getStackInSlot(5);
											ItemStack alloy6 = invCraft.getStackInSlot(6);
											ItemStack alloy7 = invCraft.getStackInSlot(7);
											ItemStack alloy8 = invCraft.getStackInSlot(8);
											int prop1 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Strength")
													+ alloy2.getTagCompound().getInteger("Strength")
													+ alloy3.getTagCompound().getInteger("Strength")
													+ alloy4.getTagCompound().getInteger("Strength")
													+ alloy5.getTagCompound().getInteger("Strength")
													+ alloy6.getTagCompound().getInteger("Strength")
													+ alloy7.getTagCompound().getInteger("Strength")
													+ alloy8.getTagCompound().getInteger("Strength"));
											int prop2 = (int) Math.sqrt(alloy1.getTagCompound().getInteger("Durability")
													+ alloy2.getTagCompound().getInteger("Durability")
													+ alloy3.getTagCompound().getInteger("Durability")
													+ alloy4.getTagCompound().getInteger("Durability")
													+ alloy5.getTagCompound().getInteger("Durability")
													+ alloy6.getTagCompound().getInteger("Durability")
													+ alloy7.getTagCompound().getInteger("Durability")
													+ alloy8.getTagCompound().getInteger("Durability"));
											int prop3 = (int) Math
													.sqrt(alloy1.getTagCompound().getInteger("Enchantability")
															+ alloy2.getTagCompound().getInteger("Enchantability")
															+ alloy3.getTagCompound().getInteger("Enchantability")
															+ alloy4.getTagCompound().getInteger("Enchantability")
															+ alloy5.getTagCompound().getInteger("Enchantability")
															+ alloy6.getTagCompound().getInteger("Enchantability")
															+ alloy7.getTagCompound().getInteger("Enchantability")
															+ alloy8.getTagCompound().getInteger("Enchantability"));
											result = new ItemStack(AlloycraftItems.alloychestplate, 1);
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
					}
				}
			}
		} catch (Exception e) {

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