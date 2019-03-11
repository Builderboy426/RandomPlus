package com.builderboy426.randomplus.objects.blocks.tileentity;

import com.builderboy426.randomplus.init.ItemInit;
import com.builderboy426.randomplus.objects.blocks.machines.BlockAncientGenerator;

import cofh.redstoneflux.api.IEnergyProvider;
import cofh.redstoneflux.api.IEnergyReceiver;
import cofh.redstoneflux.impl.EnergyStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
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

public class TileEntityAncientGenerator extends TileEntity implements ITickable, IEnergyProvider {
	
	private final int maxEnergy = 250000;
	private final int maxSendEnergy = 250;
	private int cookTime;
	
	private EnergyStorage storage = new EnergyStorage(maxEnergy, maxSendEnergy);
	private String customName;
	public ItemStackHandler handler = new ItemStackHandler(1);
	
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
	
	private void generateEnergy(int generatedAmount) {
		if (storage.getEnergyStored() < storage.getMaxEnergyStored()) {
			storage.modifyEnergyStored(generatedAmount);
		}
	}
	
	private void setState(boolean active) {
		if (!active) {
			BlockAncientGenerator.setState(active, world, pos);
			cookTime = 0;
			return;
		}
		BlockAncientGenerator.setState(active, world, pos);
	}
	
	@Override
	public void update() {
		for (int x = -2; x < 2; x++) {
			for (int y = -2; y < 2; y++) {
				for (int z = -2; z < 2; z++) {
					extractEnergyToSurroundingReceivers(x, y, z);
				}
			}
		}
		
		ItemStack fuel = handler.getStackInSlot(0);
		
		//if (fuel.isEmpty() || storage.getEnergyStored() > (maxEnergy-7500)) { setState(false); }
		
		if (storage.getEnergyStored() > (maxEnergy-7500)) {
			if (handler.getStackInSlot(0).getItem() == (Item)null) {
				setState(false);
			}
		}
		
		if (isItemFuel(fuel)) {	
			if (!fuel.isEmpty()) {
				if (storage.getEnergyStored() <= (maxEnergy-7500)) {
					cookTime++;
					setState(true);
					if (cookTime == 40) {
						generateEnergy(getFuelValue(fuel));
						fuel.shrink(1);
						cookTime = 0;
						if (fuel.isEmpty()) { setState(false); }
						return;
					}
					return;
				}
			}
		}
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)  {
		if (capability == CapabilityEnergy.ENERGY) { return (T)this.storage; }
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) { return (T)this.handler; }
		return super.getCapability(capability, facing);
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)  {
		if (capability == CapabilityEnergy.ENERGY) { return true; }
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) { return true; }
		return super.hasCapability(capability, facing);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setTag("inventory", this.handler.serializeNBT());
		compound.setInteger("cooktime", this.cookTime);
		compound.setInteger("energy", storage.getEnergyStored());
		compound.setString("name", getDisplayName().toString());
		this.markDirty();
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.handler.deserializeNBT(compound.getCompoundTag("inventory"));
		this.cookTime = compound.getInteger("cooktime");
		storage.setEnergyStored(compound.getInteger("energy"));
	}
	
	@Override
	public int getEnergyStored(EnumFacing from) { return storage.getEnergyStored(); }

	@Override
	public int getMaxEnergyStored(EnumFacing from) { return storage.getMaxEnergyStored(); }

	@Override
	public boolean canConnectEnergy(EnumFacing from) { return true; }

	@Override
	public int extractEnergy(EnumFacing from, int maxExtract, boolean simulate) { return storage.extractEnergy(maxExtract, simulate); }
	
	private boolean isItemFuel(ItemStack stack) { return getFuelValue(stack) > 0; }
	public boolean isUseableByPlayer(EntityPlayer player) { return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX()+0.5, (double)this.pos.getY()+0.5, (double)this.pos.getZ()+0.5) <=64.0D; }
	
	private int getFuelValue(ItemStack stack) { if (stack.getItem() == ItemInit.ANCIENT_SHARD) { return 7500; } return 0; }
	public ITextComponent getDisplayName() { return new TextComponentTranslation("container.ancient_generator"); }
	public int getEnergyStored() { return storage.getEnergyStored(); }
	public int getMaxEnergyStored() { return storage.getMaxEnergyStored(); }
	public int getCookTime() { return cookTime; }
	
	public void setEnergy(int data) { storage.setEnergyStored(data); }
	public void setCookTime(int data) { cookTime = data; }
}