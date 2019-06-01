package com.builderboy426.randomplus.utils.compat.jei.catagories.artifactanalyzer;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.builderboy426.randomplus.recipes.AlloyPressRecipes;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;

public class ArtifactAnalyzerRecipeMaker {
	
	public static List<ArtifactAnalyzerRecipe> getRecipes(IJeiHelpers helpers) {
		IStackHelper stackhelper = helpers.getStackHelper();
		AlloyPressRecipes instance = AlloyPressRecipes.getInstance();
		Table<ItemStack, ItemStack, ItemStack> recipes = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
		List<ArtifactAnalyzerRecipe> jeiRecipes = Lists.newArrayList();
		
		for (Entry<ItemStack, Map<ItemStack, ItemStack>> entry : recipes.columnMap().entrySet()) {
			for (Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) {
				ItemStack input1 = entry.getKey();
				ItemStack input2 = ent.getKey();
				ItemStack output = ent.getValue();
				List<ItemStack> inputs = Lists.newArrayList(input1, input2);
				ArtifactAnalyzerRecipe recipe = new ArtifactAnalyzerRecipe(inputs, output);
				jeiRecipes.add(recipe);
			}
		}
		return jeiRecipes;
	}
}