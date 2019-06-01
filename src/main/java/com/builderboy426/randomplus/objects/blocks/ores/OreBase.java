package com.builderboy426.randomplus.objects.blocks.ores;

import com.builderboy426.randomplus.Main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class OreBase extends Block {
	
	public OreBase(String name, Material materialIn) {
		super(materialIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.RANDOM_PLUS);
	}
}