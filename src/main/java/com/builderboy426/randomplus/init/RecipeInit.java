package com.builderboy426.randomplus.init;

import java.util.ArrayList;
import java.util.List;

import com.builderboy426.randomplus.recipes.AlloyPressRecipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeInit {
	
	public static void init() {
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_COPPER), new ItemStack(ItemInit.COPPER_INGOT), 0.5f);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_ALUMINIUM), new ItemStack(ItemInit.ALUMINIUM_INGOT), 0.5f);
		GameRegistry.addSmelting(new ItemStack(Items.IRON_INGOT, 4), new ItemStack(ItemInit.STEEL_INGOT), 0.5f);
	}
}