package com.builderboy426.randomplus.recipes;

import java.util.ArrayList;
import java.util.List;

import com.builderboy426.randomplus.init.ItemInit;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AlloyPressRecipes {
	
	public static final List<AlloyPressRecipes> RECIPES = new ArrayList<AlloyPressRecipes>();
	
	public static final AlloyPressRecipes STEEL = new AlloyPressRecipes(new ItemStack(Items.IRON_INGOT), new ItemStack(Items.COAL), new ItemStack(ItemInit.STEEL_INGOT), 1510);;
	
	private ItemStack[] recipe;
	private int temperature;
	
	public AlloyPressRecipes(ItemStack input1, ItemStack input2, ItemStack output, int temp) {
		this.recipe = new ItemStack[3];
		this.recipe[0] = input1;
		this.recipe[1] = input2;
		this.recipe[2] = output;
		this.temperature = temp;
	}
	
	public static void init() {
		registerRecipe(STEEL);
	}
	
	public ItemStack getOutputFromRecipe(ItemStack[] recipe) {
		return recipe[2] != null ? recipe[2] : new ItemStack((Item)null);
	}
	
	public ItemStack[] getInputs(ItemStack[] recipe) {
		ItemStack[] inputs = new ItemStack[2];
		for (int i = 0; i < recipe.length; i++) {
			if (i < 2) {
				inputs[i] = recipe[i];
			}
		}
		return inputs;
	}
	
	public ItemStack[] getRecipe() { return recipe; }
	public int getTemperature() { return temperature; }
	
	private static void registerRecipes(AlloyPressRecipes... recipes) {
		for (AlloyPressRecipes recipe : recipes) {
			registerRecipe(recipe);
		}
	}

	private static void registerRecipe(AlloyPressRecipes recipe) {
		RECIPES.add(recipe);
	}
}