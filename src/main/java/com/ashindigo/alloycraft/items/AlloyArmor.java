package com.ashindigo.alloycraft.items;

import java.awt.Color;
import java.util.List;

import com.ashindigo.alloycraft.AlloycraftMain;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

// TODO Need to modify armor points (Strength stat)
// TODO Textures for overlay
public class AlloyArmor extends ItemArmor {
	
	int strength;
	int enchantability;

	public AlloyArmor(String name, ArmorMaterial material, EntityEquipmentSlot type, String modid) {
	    super(material, 0, type);
		setCreativeTab(AlloycraftMain.alloycrafttab);
		GameRegistry.register(this, new ResourceLocation(modid, name));
		maxStackSize = 1;
	    this.setUnlocalizedName(modid + "_" + name);
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
	    strength = stack.getTagCompound().getInteger("Strength");
	    enchantability = stack.getTagCompound().getInteger("Enchantability");
	    setMaxDamage(stack.getTagCompound().getInteger("Durability") + 1);
		((ItemArmor) stack.getItem()).setColor(stack, new Color(stack.getTagCompound().getInteger("Strength"), stack.getTagCompound().getInteger("Durability"), stack.getTagCompound().getInteger("Enchantability")).getRGB());    
		if (stack.getTagCompound() == null) { 
				stack.setTagCompound(new NBTTagCompound());
				stack.getTagCompound().setInteger("Durability", 0);
				stack.getTagCompound().setInteger("Enchantability", 0);
				stack.getTagCompound().setInteger("Strength", 0);
	        }
	}
	public void addInformation(ItemStack itemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if (itemStack.getTagCompound() != null) {
		par3List.add(TextFormatting.RED + "Strength: " + TextFormatting.GRAY + Integer.toString(itemStack.getTagCompound().getInteger("Strength")));
		par3List.add(TextFormatting.GREEN + "Durability: " + TextFormatting.GRAY + Integer.toString(itemStack.getTagCompound().getInteger("Durability")));
		par3List.add(TextFormatting.BLUE + "Enchantability: " + TextFormatting.GRAY + Integer.toString(itemStack.getTagCompound().getInteger("Enchantability")));
		}
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
	    if (type == null) {
	    	return "alloycraft:textures/armor/" + "iron_layer" + "_" + (armorType.getSlotIndex() == 2 ? "2" : "1") + ".png";
	    } else {
	    	return "alloycraft:textures/armor/" + "iron_layer" + "_" + (armorType.getSlotIndex() == 2 ? "2" : "1") + "_overlay" + ".png";
	    }
	    }
	// Removes material check
	@Override
	public boolean hasOverlay(ItemStack stack) {
		return true;
	}
	
	@Override
	public int getItemEnchantability() {
		return enchantability;
	}
	
	// Removes material check
	@Override
	public boolean hasColor(ItemStack stack) {
		return true;	
	}
	
	/**
	 * Remove ArmorMaterial.LEATHER check
	 */
	@Override
	public void setColor(ItemStack stack, int color) {
		
            NBTTagCompound nbttagcompound = stack.getTagCompound();

            if (nbttagcompound == null)
            {
                nbttagcompound = new NBTTagCompound();
                stack.setTagCompound(nbttagcompound);
            }

            NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");

            if (!nbttagcompound.hasKey("display", 10))
            {
                nbttagcompound.setTag("display", nbttagcompound1);
            }

            nbttagcompound1.setInteger("color", color);
        }
	/**
	 * Eliminating the material check
	 */
	@Override
	public int getColor(ItemStack stack) {
		            NBTTagCompound nbttagcompound = stack.getTagCompound();

		            if (nbttagcompound != null)
		            {
		                NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");

		                if (nbttagcompound1 != null && nbttagcompound1.hasKey("color", 3))
		                {
		                    return nbttagcompound1.getInteger("color");
		                }
		            }

		            return 0;
		        }
	}
