package com.builderboy426.randomplus.recipes;

import com.builderboy426.randomplus.init.BlockInit;
import com.builderboy426.randomplus.init.ItemInit;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	
	public static void init() {
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_COPPER, 3), new ItemStack(ItemInit.COPPER_INGOT), 0.5f);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_ALUMINIUM, 3), new ItemStack(ItemInit.ALUMINIUM_INGOT), 0.5f);
		
		
	}
}