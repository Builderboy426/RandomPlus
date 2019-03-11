package com.builderboy426.randomplus.objects.blocks.tileentity;

import com.builderboy426.randomplus.init.ItemInit;

import cofh.redstoneflux.api.IEnergyProvider;
import cofh.redstoneflux.api.IEnergyReceiver;
import cofh.redstoneflux.impl.EnergyStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityPylon extends TileEntity implements ITickable, IEnergyProvider, IEnergyReceiver {
	
	private final int maxEnergy = 500;
	private int maxSendEnergy = 250;
	
	private EnergyStorage storage = new EnergyStorage(maxEnergy, maxSendEnergy);
	private String customName;
	
	private void extractEnergyToSurroundingReceivers(int x, int y, int z) {
		for (EnumFacing facing : EnumFacing.VALUES) {
			BlockPos tilePos = new BlockPos(pos.getX()+x, pos.getY()+y, pos.getZ()+z);
			TileEntity tileEntity = world.getTileEntity(tilePos);
			if (tileEntity instanceof IEnergyReceiver && ((IEnergyReceiver)tileEntity).canConnectEnergy(facing)) {
				try {
					int received = ((IEnergyReceiver)tileEntity).receiveEnergy(facing.getOpposite(), extractEnergy(facing, storage.getMaxExtract(), true), false);
					extractEnergy(facing, received, false);
				} catch (NullPointerException e) {}
			}
		}
	}
	
	@Override
	public void update() {
		for (int x = -6; x < 6; x++) {
			for (int y = -6; y < 6; y++) {
				for (int z = -6; z < 6; z++) {
					extractEnergyToSurroundingReceivers(x, y, z);
				}
			}
		}
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)  {
		if (capability == CapabilityEnergy.ENERGY) { return (T)this.storage; }
		return super.getCapability(capability, facing);
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)  {
		if (capability == CapabilityEnergy.ENERGY) { return true; }
		return super.hasCapability(capability, facing);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("energy", storage.getEnergyStored());
		compound.setString("name", getDisplayName().toString());
		this.markDirty();
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		storage.setEnergyStored(compound.getInteger("energy"));
		this.customName = compound.getString("name");
	}

	@Override
	public int getEnergyStored(EnumFacing from) { return storage.getEnergyStored(); }

	@Override
	public int getMaxEnergyStored(EnumFacing from) { return storage.getMaxEnergyStored(); }

	@Override
	public boolean canConnectEnergy(EnumFacing from) { return true; }

	@Override
	public int receiveEnergy(EnumFacing from, int maxReceive, boolean simulate) { return storage.receiveEnergy(maxReceive, simulate); }

	@Override
	public int extractEnergy(EnumFacing from, int maxExtract, boolean simulate) { return storage.extractEnergy(maxExtract, simulate); }
	
	public boolean isUseableByPlayer(EntityPlayer player) { return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX()+0.5, (double)this.pos.getY()+0.5, (double)this.pos.getZ()+0.5) <=64.0D; }
	
	public ITextComponent getDisplayName() { return new TextComponentTranslation("container.ancient_generator"); }
	public int getEnergyStored() { return storage.getEnergyStored(); }
	public int getMaxEnergyStored() { return storage.getMaxEnergyStored(); }
	public int getMaxSendEnergy() { return maxSendEnergy; }
}