package net.darkhax.teslatest.item;

import java.util.List;

import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.api.implementation.BaseTeslaContainerProvider;
import net.darkhax.tesla.capability.TeslaCapabilities;
import net.darkhax.teslatest.TeslaTest;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

/**
 * A Item that can accept power and also have it pulled out. The goal of this Item is to have a
 * tooltip of the energy stored, and store energy. This class is also used as the default
 * example of how to write a Item that can use Tesla power.
 */
public class ItemBattery extends Item {
    
    public ItemBattery() {
        
        this.setCreativeTab(TeslaTest.tab);
        this.setUnlocalizedName("teslatest.battery");
        this.setMaxStackSize(1);
    }
    
    @Override
    public void addInformation (ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        
        super.addInformation(stack, playerIn, tooltip, advanced);
        final BaseTeslaContainer container = (BaseTeslaContainer) stack.getCapability(TeslaCapabilities.CAPABILITY_HOLDER, EnumFacing.DOWN);
        
        tooltip.add(I18n.format("tooltip.teslatest.battery.normal", container.getStoredPower(), container.getCapacity()));
    }
    
    @Override
    public ICapabilityProvider initCapabilities (ItemStack stack, NBTTagCompound nbt) {
        
        return new BaseTeslaContainerProvider(new BaseTeslaContainer());
    }
}
