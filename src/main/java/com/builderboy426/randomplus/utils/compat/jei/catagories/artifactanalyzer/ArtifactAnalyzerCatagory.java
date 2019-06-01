package com.builderboy426.randomplus.utils.compat.jei.catagories.artifactanalyzer;

import com.builderboy426.randomplus.utils.Reference;
import com.builderboy426.randomplus.utils.compat.jei.RecipeCatagories;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.client.Minecraft;

public class ArtifactAnalyzerCatagory extends AbstractArtifactAnalyzerCatagory<ArtifactAnalyzerRecipe> {
	private IDrawable background;
	private String name;
	
	public ArtifactAnalyzerCatagory(IGuiHelper helper) {
		super(helper);
		background = helper.createDrawable(TEXTURES, 34, 3, 136, 79);
		name = "Alloy Press";
	}
	
	@Override
	public IDrawable getBackground() { return background; }
	
	@Override
	public void drawExtras(Minecraft minecraft) {
		animatedArrow.draw(minecraft, 30, 29);
	}
	
	public String getTitle() { return name; }

	@Override
	public String getModName() { return Reference.NAME; }
	
	public String getUid() { return RecipeCatagories.ALLOY_PRESS; }
	
	@Override
	public void setRecipe(IRecipeLayout recipeLayout, ArtifactAnalyzerRecipe recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
		stacks.init(input1, true, 3, 17);
		stacks.init(input2, true, 3, 38);
		stacks.init(output, false, 63, 28);
		stacks.set(ingredients);
	}
}