package com.ashindigo.utils;

import java.util.Set;

import com.ashindigo.alloycraft.AlloycraftMain;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;

// TODO The GUIFactory parameter on @Mod takes a unique class and institates it with a blank constructor (So it cant be used for now)
// Map for classes?
public class UtilsGuiFactory implements IModGuiFactory {
	
	Class clasz;
	
	public UtilsGuiFactory(Class<? extends GuiScreen> clazz) {
		clasz = clazz;
	}
	
    @Override
    public void initialize(Minecraft minecraftInstance) {
 
    }
 
    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass() {
        return clasz;
    }
 
    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null;
    }
 
    @Override
    public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
        return null;
    }
}