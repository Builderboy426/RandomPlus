package com.builderboy426.randomplus.objects.blocks.utils;

import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityAncientGenerator;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityArtifactAnalyzer;

import net.minecraft.tileentity.TileEntity;

public class Machines {
	
	public static void updateAnalyzer(TileEntity machine, TileEntity generator, int currentEnergy, int sendEnergy) {
		if (machine instanceof TileEntityArtifactAnalyzer) {
			TileEntityArtifactAnalyzer analyzer = (TileEntityArtifactAnalyzer)machine;
			if (currentEnergy >= sendEnergy && analyzer.getEnergyStored() < analyzer.getMaxEnergyStored()) {
				int newEnergy = analyzer.getField(0)+sendEnergy;
				analyzer.updateEnergy(newEnergy);
				Generators.updateGenerator(generator, (currentEnergy - sendEnergy));
			}
		}
	}

	public static void updatePylon(TileEntity tileEntity, int maxEnergy, int sendEnergy) {
		
	}
}