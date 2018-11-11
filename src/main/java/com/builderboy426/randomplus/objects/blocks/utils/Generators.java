package com.builderboy426.randomplus.objects.blocks.utils;

import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityAncientGenerator;

import net.minecraft.tileentity.TileEntity;

public class Generators {
	
	public static void updateGenerator(TileEntity generator, int newEnergy) {
		updateAncientGenerator(generator, newEnergy);
	}

	private static void updateAncientGenerator(TileEntity generator, int newEnergy) {
		if (generator instanceof TileEntityAncientGenerator) {
			TileEntityAncientGenerator ancient = (TileEntityAncientGenerator)generator;
			ancient.setField(0, newEnergy);
			return;
		}
	}
}