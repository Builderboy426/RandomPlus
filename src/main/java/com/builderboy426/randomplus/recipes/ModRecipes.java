package com.builderboy426.randomplus.recipes;

import com.builderboy426.randomplus.init.BlockInit;
import com.builderboy426.randomplus.init.ItemInit;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	
	public static void init() {
		
		//Testing Smelting Recipes
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_AMETHYST, 3), new ItemStack(ItemInit.CHAOS), 0.5f);
		
	}
	
}