package com.builderboy426.randomplus.objects.items.tools;

import com.builderboy426.randomplus.Main;
import com.builderboy426.randomplus.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class ToolShovel extends ItemSpade {

	public ToolShovel(String name, ToolMaterial material) {
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.RANDOM_PLUS);
	}
}