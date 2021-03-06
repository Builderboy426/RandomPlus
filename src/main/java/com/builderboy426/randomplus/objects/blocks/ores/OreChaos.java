package com.builderboy426.randomplus.objects.blocks.ores;

import java.util.Random;

import com.builderboy426.randomplus.init.BlockInit;
import com.builderboy426.randomplus.init.ItemInit;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class OreChaos extends OreBase {

	public OreChaos(String name, Material materialIn, float hardness) {
		super(name, materialIn);
		
		setHardness(hardness);
		setResistance(20.0f);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ItemInit.CHAOS;
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		return fortune >= 3 ? 2 : 1;
	}
	
	@Override
	public int quantityDropped(Random random) {
		return 1;
	}
	
	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) {
		return new ItemStack(BlockInit.ORE_CHAOS);
	}
	
	@Override
	public int getHarvestLevel(IBlockState state) {
		return 3;
	}
}
