package com.builderboy426.randomplus.objects.blocks.ores;

import java.util.Random;

import com.builderboy426.randomplus.init.BlockInit;
import com.builderboy426.randomplus.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class OreTin extends OreBase {
	
	public OreTin(String name, Material materialIn, float hardness) {
		super(name, materialIn);
		
		setHardness(hardness);
		setResistance(10.0f);
	}
	
	@Override
	public int quantityDropped(Random random) {
		return 1;
	}
	
	@Override
	public int getHarvestLevel(IBlockState state) {
		return 2;
	}
}