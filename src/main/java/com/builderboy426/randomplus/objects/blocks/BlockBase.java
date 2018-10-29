package com.builderboy426.randomplus.objects.blocks;

import com.builderboy426.randomplus.Main;
import com.builderboy426.randomplus.init.BlockInit;
import com.builderboy426.randomplus.init.ItemInit;
import com.builderboy426.randomplus.utils.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {
	
	public BlockBase(String name, Material mat, float hardness) {
		super(mat);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.RANDOM_PLUS);
		
		setHardness(hardness);
		setResistance(15.0f);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}