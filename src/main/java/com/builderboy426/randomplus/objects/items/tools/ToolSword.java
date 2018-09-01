package com.builderboy426.randomplus.objects.items.tools;

import com.builderboy426.randomplus.Main;
import com.builderboy426.randomplus.init.ItemInit;
import com.builderboy426.randomplus.utils.interfaces.IHasModel;

import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword implements IHasModel {
	
	public ToolSword(String name, ToolMaterial material) {
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.RANDOM_PLUS);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
