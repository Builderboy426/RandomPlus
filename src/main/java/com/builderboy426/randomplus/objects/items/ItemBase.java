package com.builderboy426.randomplus.objects.items;

import javax.annotation.Nullable;

import com.builderboy426.randomplus.Main;
import com.builderboy426.randomplus.init.ItemInit;
import com.builderboy426.randomplus.utils.interfaces.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {
	
	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.RANDOM_PLUS);
		
		ItemInit.ITEMS.add(this);
	}
	
	public ItemBase(String name, int stackSize) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.RANDOM_PLUS);
		
		if (stackSize <= 64) { setMaxStackSize(stackSize); } else { setMaxStackSize(64); }
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}