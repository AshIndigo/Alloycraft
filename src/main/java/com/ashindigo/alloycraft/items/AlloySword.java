package com.ashindigo.alloycraft.items;

import java.util.List;

import com.ashindigo.alloycraft.AlloycraftMain;
import com.ashindigo.utils.UtilsItem;
import com.ashindigo.utils.UtilsToolset;
import com.google.common.collect.Multimap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AlloySword extends ItemSword {

	public AlloySword(ToolMaterial material, String name, String modid) {
		super(material);
		this.setUnlocalizedName(modid + "_" + name);
	    setCreativeTab(AlloycraftMain.alloycrafttab);
		GameRegistry.register(this, new ResourceLocation(modid, name));
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        target.setHealth(target.getHealth() - stack.getTagCompound().getInteger("Strength"));
        return true;
    }
	
	@Override
	public int getMaxDamage(ItemStack itemstack) {
		if (itemstack.getTagCompound() != null) {
			return itemstack.getTagCompound().getInteger("Durability");
		} else {
			return 0;
		}
	}
	// TODO Need an ItemStack parameter for this to work
	/*
	@Override
	public float getDamageVsEntity () {
		return itemstack.getTagCompound().getInteger("Strength");
	}
	*/
	@Override
	public int getItemEnchantability(ItemStack itemstack) {
		if (itemstack.getTagCompound() != null) {
			return itemstack.getTagCompound().getInteger("Enchantability");
		} else {
			return 0;
		}
	}
	
	@Override
	public void onCreated(ItemStack itemstack, World world, EntityPlayer player) {
	        if (itemstack.getTagCompound() == null) {
	            itemstack.setTagCompound(new NBTTagCompound());
	            itemstack.getTagCompound().setInteger("Durability", 0);
	            itemstack.getTagCompound().setInteger("Enchantability", 0);
	            itemstack.getTagCompound().setInteger("Strength", 0);
	        }
	}
	public void addInformation(ItemStack itemstack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if (itemstack.getTagCompound() != null) {
			par3List.add("§4Strength: §7" + Integer.toString(itemstack.getTagCompound().getInteger("Strength")));
			par3List.add("§2Durability: §7" + Integer.toString(itemstack.getTagCompound().getInteger("Durability")));
			par3List.add("§1Enchantability: §7" + Integer.toString(itemstack.getTagCompound().getInteger("Enchantability")));
		} else {
			par3List.add("This weapon is missing it's NBT data please delete this or bad things can possibly happen!");
		}
		}
	}