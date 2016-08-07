package com.ashindigo.alloycraft;

import com.ashindigo.alloycraft.lib.AchievementHandler;
import com.ashindigo.alloycraft.lib.CommonProxy;
import com.ashindigo.alloycraft.lib.GuiHandler;
import com.ashindigo.alloycraft.lib.RecipeHandler;
import com.ashindigo.utils.UtilsAchievement;
import com.ashindigo.utils.UtilsCreativeTab;
import com.ashindigo.utils.UtilsMain;
import com.ashindigo.utils.UtilsMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

// TODO Add armor pieces
// TODO In-Game GUI Config editor?
@Mod(modid = AlloycraftMain.modid, version = "1.0", name = "Alloycraft")
public class AlloycraftMain implements UtilsMain {
	
	public static final String modid = "alloycraft";
	public final static String CLIENT_PROXY_CLASS = "com.ashindigo.alloycraft.lib.ClientProxy";
	public final static String SERVER_PROXY_CLASS = "com.ashindigo.alloycraft.lib.CommonProxy";
	// Achievements are long!
	public static UtilsAchievement alloyforge;
	public static UtilsAchievement alloy;
	public static UtilsAchievement alloyaxe;
	public static UtilsAchievement alloypick;
	public static UtilsAchievement alloyhoe;
	public static UtilsAchievement alloysword;
	public static UtilsAchievement alloyshovel;
		
		@SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = SERVER_PROXY_CLASS)
	    public static CommonProxy proxy;
		
		@Instance(modid)
		public static AlloycraftMain instance = new AlloycraftMain();

		// Can this be removed? (This feels dated)
		public static final int guiIDForge = 1;
		public static final int guiIDForgeTesla = 2;
		
		public static UtilsCreativeTab alloycrafttab;
		public static Configuration config;
		public static AchievementPage alloyCraftPage;
		public static int maxPower;
		public static int smeltingSpeed;
		
		@EventHandler
		public void preinit(FMLPreInitializationEvent event) {
			
			config = new Configuration(event.getSuggestedConfigurationFile());
			smeltingSpeed = config.getInt("Smelting Speed", "default", 50, 1, Integer.MAX_VALUE, "Controls how fast the Alloy Forge smelts");
			maxPower = config.getInt("Max Power", "default", 32000, 1, Integer.MAX_VALUE, "How much power can the Alloy Forge hold");
			config.save();
			AlloycraftItems.preInitItems();
			AlloycraftBlocks.preInitBlocks();
			UtilsMod.modidList.add(modid);
		}

		@EventHandler
		public void init(FMLInitializationEvent event) {
			
			AlloycraftBlocks.initBlocks();
			AlloycraftItems.initItems();
			alloycrafttab = new UtilsCreativeTab("alloycraft", Item.getItemFromBlock(AlloycraftBlocks.forgeoff));
	    	NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
			GameRegistry.addRecipe(new RecipeHandler());
			alloyforge = new UtilsAchievement("achievement.alloyforgemade", "alloyforgecrafted", 2, 0, new ItemStack(AlloycraftBlocks.forgeoff), null, "Alloy Forge!", "You made an Alloy Forge!", AlloycraftMain.modid);
			alloy = new UtilsAchievement("achievement.alloymade", "alloycrafted", 2, 1, new ItemStack(AlloycraftItems.alloy), alloyforge, "Alloy!", "You made your first Alloy!", AlloycraftMain.modid);
			alloyaxe = new UtilsAchievement("achievement.alloyaxemade", "alloyaxecrafted", 0, 2, new ItemStack(AlloycraftItems.alloyaxe), alloy, "Alloy Axe", "Crafted an Alloy Axe", AlloycraftMain.modid);
			alloypick = new UtilsAchievement("achievement.alloypickmade", "alloypickcrafted", 1, 2, new ItemStack(AlloycraftItems.alloypickaxe), alloy, "Alloy Pickaxe", "Crafted an Alloy Pickaxe", AlloycraftMain.modid);
			alloyhoe = new UtilsAchievement("achievement.alloyhoemade", "alloyhoecrafted", 2, 2, new ItemStack(AlloycraftItems.alloyhoe), alloy, "Alloy Hoe", "Crafted an Alloy Hoe", AlloycraftMain.modid);
			alloysword = new UtilsAchievement("achievement.alloyswordmade", "alloyswordcrafted", 3, 2, new ItemStack(AlloycraftItems.alloysword), alloy, "Alloy Sword", "Crafted an Alloy Sword", AlloycraftMain.modid);
			alloyshovel = new UtilsAchievement("achievement.alloyshovelmade", "alloyshovelcrafted", 4, 2, new ItemStack(AlloycraftItems.alloyshovel), alloy, "Alloy Shovel", "Crafted an Alloy Shovel", AlloycraftMain.modid);
			alloyCraftPage = new AchievementPage("Alloycraft" ,new Achievement[]{alloyforge, alloy, alloypick, alloyhoe, alloyaxe, alloyshovel, alloysword});
			AchievementPage.registerAchievementPage(alloyCraftPage);
			MinecraftForge.EVENT_BUS.register(new AchievementHandler());
		}

		@EventHandler
		public void postinit(FMLPostInitializationEvent event) {
			
			AlloycraftItems.postInitItems();
			AlloycraftBlocks.postInitBlocks();
		}



}
