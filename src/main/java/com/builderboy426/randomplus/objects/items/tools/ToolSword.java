package com.builderboy426.randomplus.objects.items.tools;

import com.builderboy426.randomplus.Main;
import com.builderboy426.randomplus.init.ItemInit;

import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword {
	
	public ToolSword(String name, ToolMaterial material) {
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.RANDOM_PLUS);

	}
}
