package com.builderboy426.randomplus.objects.blocks.utils;

import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityAncientGenerator;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityAncientPylon;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityArtifactAnalyzer;

import net.minecraft.tileentity.TileEntity;

public class Machines {
	
	public static void updateAnalyzer(TileEntity tileEntity, TileEntity generator, int currentEnergy, int sendEnergy) {
		if (tileEntity instanceof TileEntityArtifactAnalyzer) {
			TileEntityArtifactAnalyzer analyzer = (TileEntityArtifactAnalyzer)tileEntity;
			if (currentEnergy >= sendEnergy && analyzer.getEnergyStored() < analyzer.getMaxEnergyStored()) {
				int newEnergy = analyzer.getField(0)+sendEnergy;
				analyzer.updateEnergy(newEnergy);
				Generators.updateGenerator(generator, (currentEnergy - sendEnergy));
			}
		}
	}

	public static void updatePylon(TileEntity tileEntity, TileEntity generator, int currentEnergy, int sendEnergy) {
		if (tileEntity instanceof TileEntityAncientPylon) {
			TileEntityAncientPylon pylon = (TileEntityAncientPylon)tileEntity;
			if (currentEnergy >= sendEnergy && pylon.getEnergyStored() < pylon.getMaxEnergyStored()) {
				int newEnergy = pylon.getEnergyStored()+sendEnergy;
				pylon.setEnergy(newEnergy);
				Generators.updateGenerator(generator, (currentEnergy - sendEnergy));
			}
		} 
	}
}