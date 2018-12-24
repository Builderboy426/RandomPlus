package com.builderboy426.randomplus.utils.misc;

import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityAncientGenerator;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityArtifactAnalyzer;

import net.minecraft.tileentity.TileEntity;

public class Machines {
	
	public static TileEntityArtifactAnalyzer getAnalyzer(TileEntity tileEntity) {
		try { return (TileEntityArtifactAnalyzer)tileEntity; } catch (ClassCastException e) { return null; }
	}
	
	public static void sendEnergyAnalyzer(TileEntityArtifactAnalyzer analyzer, int currentEnergy, int sendEnergy, TileEntity generatorTile) {
		TileEntityAncientGenerator generator = (TileEntityAncientGenerator)generatorTile;
		if (analyzer != null) {
			int checkEnergy = analyzer.getMaxEnergyStored()-sendEnergy;
			if (currentEnergy >= sendEnergy && analyzer.getEnergyStored() <= checkEnergy) {
				int newEnergy = analyzer.getField(0)+sendEnergy;
				int newGen = currentEnergy -= sendEnergy;
				generator.setField(0, newGen);
				analyzer.updateEnergy(newEnergy);
			}
		}
	}
}