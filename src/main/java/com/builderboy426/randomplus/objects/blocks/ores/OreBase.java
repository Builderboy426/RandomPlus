package com.builderboy426.randomplus.objects.blocks.ores;

import java.util.Random;

import com.builderboy426.randomplus.Main;
import com.builderboy426.randomplus.init.BlockInit;
import com.builderboy426.randomplus.init.ItemInit;
import com.builderboy426.randomplus.utils.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class OreBase extends Block implements IHasModel {
	
	public OreBase(String name, Material materialIn) {
		super(materialIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.RANDOM_PLUS);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}