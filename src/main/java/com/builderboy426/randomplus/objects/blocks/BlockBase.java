package com.builderboy426.randomplus.objects.blocks;

import com.builderboy426.randomplus.Main;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {
	
	public BlockBase(String name, Material mat, float hardness) {
		super(mat);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.RANDOM_PLUS);
		setHardness(hardness);
		setResistance(15.0f);
	}
	// For glowing blocks
	public BlockBase(String name, Material mat, float hardness, float lightLevel) {
		super(mat);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.RANDOM_PLUS);
		setHardness(hardness);
		setResistance(15.0f);
		setLightLevel(lightLevel);
	}
}