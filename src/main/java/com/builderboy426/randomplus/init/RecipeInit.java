package com.builderboy426.randomplus.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeInit {
	
	public static void init() {
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_COPPER), new ItemStack(ItemInit.COPPER_INGOT), 0.5f);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_ALUMINIUM), new ItemStack(ItemInit.ALUMINIUM_INGOT), 0.5f);
	}
}