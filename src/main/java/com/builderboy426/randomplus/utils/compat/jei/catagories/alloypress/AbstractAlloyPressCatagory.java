package com.builderboy426.randomplus.utils.compat.jei.catagories.alloypress;

import com.builderboy426.randomplus.utils.Reference;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.util.ResourceLocation;

public abstract class AbstractAlloyPressCatagory<T extends IRecipeWrapper> implements IRecipeCategory<T>{
	
	protected static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID+":textures/gui/artifact_analyzer.png");
	
	protected static final int input1 = 0;
	protected static final int input2 = 1;
	protected static final int output = 2;
	
	protected final IDrawableAnimated animatedArrow;
	
	public AbstractAlloyPressCatagory(IGuiHelper helper) {
		IDrawableStatic staticArrow = helper.createDrawable(TEXTURES, 176, 14, 24, 17);
		animatedArrow = helper.createAnimatedDrawable(staticArrow, 200, IDrawableAnimated.StartDirection.LEFT, false);
	}
}