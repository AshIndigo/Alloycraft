package com.ashindigo.alloycraft.lib;

import com.ashindigo.alloycraft.AlloycraftMain;
import com.ashindigo.alloycraft.tileentites.ForgeTeslaTileEntity;
import com.ashindigo.alloycraft.tileentites.ForgeTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));
		
		if(entity != null) {
			switch(ID) {
			case AlloycraftMain.guiIDForge:
				if (entity instanceof ForgeTileEntity) {
					return new ForgeContainer(player.inventory, (ForgeTileEntity) entity);
				}
				return null;		
			case AlloycraftMain.guiIDForgeTesla:
				if (entity instanceof ForgeTeslaTileEntity) {
					return new ForgeTeslaContainer(player.inventory, (ForgeTeslaTileEntity) entity);
				}
				return null;		
		
			}
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));
		
		if(entity != null) {
			switch(ID) {
			case AlloycraftMain.guiIDForge:
				if (entity instanceof ForgeTileEntity) {
					return new ForgeGui(player.inventory, (ForgeTileEntity) entity);
				}
				return null;
			case AlloycraftMain.guiIDForgeTesla:
				if (entity instanceof ForgeTeslaTileEntity) {
					return new ForgeTeslaGui(player.inventory, (ForgeTeslaTileEntity) entity);
				}
				return null;
			}
		}
		
		return null;
	}
}
