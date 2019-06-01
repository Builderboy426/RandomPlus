package com.builderboy426.randomplus.utils.compat;

import com.builderboy426.randomplus.init.BlockInit;
import com.builderboy426.randomplus.init.ItemInit;

import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryCompat {
	
	public static void registerOres() {
		//Ores
		OreDictionary.registerOre("oreRuby", BlockInit.ORE_RUBY);
		OreDictionary.registerOre("oreSapphire", BlockInit.ORE_SAPPHIRE);
		OreDictionary.registerOre("oreAmethyst", BlockInit.ORE_AMETHYST);
		OreDictionary.registerOre("oreCopper", BlockInit.ORE_COPPER);
		OreDictionary.registerOre("oreAluminium", BlockInit.ORE_ALUMINIUM);
		OreDictionary.registerOre("oreLithium", BlockInit.ORE_LITHIUM);
		
		//Ingots
		OreDictionary.registerOre("ingotCopper", ItemInit.COPPER_INGOT);
		OreDictionary.registerOre("ingotAluminium", ItemInit.ALUMINIUM_INGOT);
		OreDictionary.registerOre("ingotSteel", ItemInit.STEEL_INGOT);
		OreDictionary.registerOre("lithium", ItemInit.LITHIUM);
		
		//Gems
		OreDictionary.registerOre("gemRuby", ItemInit.RUBY);
		OreDictionary.registerOre("gemSapphire", ItemInit.SAPPHIRE);
		OreDictionary.registerOre("gemAmethyst", ItemInit.AMETHYST);
	}
}