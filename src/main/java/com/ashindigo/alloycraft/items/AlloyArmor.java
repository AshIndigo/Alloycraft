package com.ashindigo.alloycraft.items;

import java.awt.Color;
import java.util.List;

import com.ashindigo.alloycraft.AlloycraftMain;
import com.ashindigo.utils.UtilsArmor;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

// TODO Add wearing color
// Note: Is it loading the overlay texture for iron armor which doesnt exist?
public class AlloyArmor extends ItemArmor {

	// TODO Rip material
	public AlloyArmor(String name, ArmorMaterial material, EntityEquipmentSlot type, String modid) {
	    super(ItemArmor.ArmorMaterial.LEATHER, 0, type);
		setCreativeTab(AlloycraftMain.alloycrafttab);
		GameRegistry.register(this, new ResourceLocation(modid, name));
		maxStackSize = 1;
	    this.setUnlocalizedName(modid + "_" + name);
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
        //GlStateManager.color(stack.getTagCompound().getInteger("Strength"), stack.getTagCompound().getInteger("Durability"), stack.getTagCompound().getInteger("Enchantability"), 1.0F);
		//this.setColor(stack, new Color(stack.getTagCompound().getInteger("Strength"), stack.getTagCompound().getInteger("Durability"), stack.getTagCompound().getInteger("Enchantability")).getRGB());    
		if (stack.getTagCompound() == null) {
				stack.setTagCompound(new NBTTagCompound());
				stack.getTagCompound().setInteger("Durability", 0);
				stack.getTagCompound().setInteger("Enchantability", 0);
				stack.getTagCompound().setInteger("Strength", 0);
	        }
	}
	public void addInformation(ItemStack itemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
		if (itemStack.getTagCompound() != null) {
		par3List.add("§4Strength: §7" + Integer.toString(itemStack.getTagCompound().getInteger("Strength")));
		par3List.add("§2Durability: §7" + Integer.toString(itemStack.getTagCompound().getInteger("Durability")));
		par3List.add("§1Enchantability: §7" + Integer.toString(itemStack.getTagCompound().getInteger("Enchantability")));
		}
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
	    return "textures/models/armor/" + "leather_layer" + "_" + (armorType.getSlotIndex() == 2 ? "2" : "1") + ".png";
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
		if (stack != null && stack.getTagCompound() != null && itemSlot == EntityEquipmentSlot.HEAD.getIndex()) {
			//System.out.println("How");
			this.setColor(stack, new Color(stack.getTagCompound().getInteger("Strength"), stack.getTagCompound().getInteger("Durability"), stack.getTagCompound().getInteger("Enchantability")).getRGB());
		}
		}
    }

}
