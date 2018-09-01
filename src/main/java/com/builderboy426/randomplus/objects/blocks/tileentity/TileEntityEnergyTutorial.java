package com.builderboy426.randomplus.objects.blocks.tileentity;

import com.builderboy426.randomplus.energy.ChaosEnergyStorage;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;

public class TileEntityEnergyTutorial extends TileEntity implements ITickable {
	
	private ChaosEnergyStorage storage = new ChaosEnergyStorage(5000);
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (capability == CapabilityEnergy.ENERGY) { return (T)this.storage; }
		return super.getCapability(capability, facing);
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityEnergy.ENERGY) { return true; }
		return super.hasCapability(capability, facing);
	}
	
	@Override
	public void update() {
		this.storage.receiveEnergy(250, false);
		this.storage.extractEnergy(150, false);
	}
	
}