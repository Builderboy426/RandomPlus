package com.builderboy426.randomplus.objects.blocks.ores;

import java.util.Random;

import com.builderboy426.randomplus.init.BlockInit;
import com.builderboy426.randomplus.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class OreAncient extends OreBase {

	public OreAncient(String name, Material materialIn, float hardness) {
		super(name, materialIn);
		
		setHardness(hardness);
		setResistance(5.0f);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ItemInit.ANCIENT_SHARD;
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		return 1 + fortune;
	}
	
	@Override
	public int quantityDropped(Random random) {
		return 1;
	}
	
	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) {
		return new ItemStack(BlockInit.ROCK_ANCIENT);
	}
	
	@Override
	public int getHarvestLevel(IBlockState state) {
		return 4;
	}
}