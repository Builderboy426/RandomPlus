package com.builderboy426.randomplus.objects.blocks.ores;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class OreCopper extends OreBase {
	
	public OreCopper(String name, Material materialIn, float hardness) {
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