package com.builderboy426.randomplus.utils.compat.jei.catagories.artifactanalyzer;

import java.util.List;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;

public class ArtifactAnalyzerRecipe implements IRecipeWrapper {
	
	private final List<ItemStack> inputs;
	private final ItemStack output;
	
	public ArtifactAnalyzerRecipe(List<ItemStack> inputs, ItemStack output) {
		this.inputs = inputs;
		this.output = output;
	}
	
	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInputs(ItemStack.class, inputs);
		ingredients.setOutput(ItemStack.class, output);
	}
	
//	@Override
//	public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
//		AlloyPressRecipes recipes = AlloyPressRecipes.getInstance();
//		float exp = recipes.getSinteringExperience(output);
//		
//		if (exp > 0) {
//			String experienceString = JEICompat.translateToLocalFormatted("gui.jei.catagory.smelting.experience", exp);
//			FontRenderer renderer = minecraft.fontRenderer;
//			int stringWidth = renderer.getStringWidth(experienceString);
//			renderer.drawString(experienceString, recipeWidth-stringWidth, 0, Color.GRAY.getRGB());
//		}
//	}
}