package com.builderboy426.randomplus.utils.compat.jei.catagories.alloypress;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.builderboy426.randomplus.recipes.AlloyPressRecipes;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;

public class AlloyPressRecipeMaker {
	
	public static List<AlloyPressRecipe> getRecipes(IJeiHelpers helpers) {
		IStackHelper stackhelper = helpers.getStackHelper();
		AlloyPressRecipes instance = AlloyPressRecipes.getInstance();
		Table<ItemStack, ItemStack, ItemStack> recipes = instance.getDualSmeltingList();
		List<AlloyPressRecipe> jeiRecipes = Lists.newArrayList();
		
		for (Entry<ItemStack, Map<ItemStack, ItemStack>> entry : recipes.columnMap().entrySet()) {
			for (Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) {
				ItemStack input1 = entry.getKey();
				ItemStack input2 = ent.getKey();
				ItemStack output = ent.getValue();
				List<ItemStack> inputs = Lists.newArrayList(input1, input2);
				AlloyPressRecipe recipe = new AlloyPressRecipe(inputs, output);
				jeiRecipes.add(recipe);
			}
		}
		return jeiRecipes;
	}
}