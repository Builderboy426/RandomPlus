package com.builderboy426.randomplus.utils.compat.jei.catagories.alloypress;

import com.builderboy426.randomplus.utils.Reference;
import com.builderboy426.randomplus.utils.compat.jei.RecipeCatagories;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.ICraftingGridHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.ITickTimer;
import mezz.jei.api.gui.IDrawableAnimated.StartDirection;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.gui.GuiHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class AlloyPressCatagory extends AbstractAlloyPressCatagory<AlloyPressRecipe> {
	private IDrawable background;
	private String name;
	
	public AlloyPressCatagory(IGuiHelper helper) {
		super(helper);
		background = helper.createDrawable(TEXTURES, 34, 3, 136, 79);
		name = "Alloy Press";
	}
	
	@Override
	public IDrawable getBackground() { return background; }
	
	@Override
	public void drawExtras(Minecraft minecraft) {
		animatedArrow.draw(minecraft, 61, 29);
	}
	
	public String getTitle() { return name; }

	@Override
	public String getModName() { return Reference.NAME; }
	
	public String getUid() { return RecipeCatagories.ALLOY_PRESS; }
	
	@Override
	public void setRecipe(IRecipeLayout recipeLayout, AlloyPressRecipe recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
		stacks.init(input1, true, 34, 17);
		stacks.init(input2, true, 34, 38);
		stacks.init(output, false, 94, 28);
		stacks.set(ingredients);
	}
}