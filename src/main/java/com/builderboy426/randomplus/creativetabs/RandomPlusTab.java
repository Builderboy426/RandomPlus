package com.builderboy426.randomplus.creativetabs;

import com.builderboy426.randomplus.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class RandomPlusTab extends CreativeTabs {

	public RandomPlusTab(String label) {
		super("randomplustab");
		setBackgroundImageName("item_search.png");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemInit.FIRE_ARTIFACT);
	}
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}
}