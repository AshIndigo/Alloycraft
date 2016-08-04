package com.ashindigo.alloycraft.lib;

import org.lwjgl.opengl.GL11;

import com.ashindigo.alloycraft.AlloycraftMain;
import com.ashindigo.alloycraft.tileentites.ForgeTileEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class ForgeGui extends GuiContainer {
	
	public ResourceLocation texture = new ResourceLocation(AlloycraftMain.modid + ":" + "textures/gui/GuiAlloyFurnace.png");
	public ForgeTileEntity AlloyFurnace;

	public ForgeGui(InventoryPlayer invPlayer, ForgeTileEntity teAlloyFurnace) {
		super(new ForgeContainer(invPlayer, teAlloyFurnace));
		AlloyFurnace = teAlloyFurnace;
		
		this.xSize = 176;
		this.ySize = 166;
	}
	
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		String name = this.AlloyFurnace.hasCustomName() ? this.AlloyFurnace.getName() : I18n.format(this.AlloyFurnace.getName());
		
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("Inventory"), 8, this.ySize - 96 + 5, 4210752);
	}

	@Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        
        if (AlloyFurnace.hasPower())
        {
            int i1 = AlloyFurnace.getPowerRemainingScaled(45);
            drawTexturedModalRect(guiLeft + 8, guiTop + 53 - i1, 176, 62 - i1, 16, i1);
        }

        int i1 = AlloyFurnace.getSmeltingProgressScaled(24);
        drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 0, i1 + 1, 16);
    }

}
