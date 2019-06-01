package com.builderboy426.randomplus.objects.blocks.tileentity;

import com.builderboy426.randomplus.objects.blocks.machines.BlockAlloyPress;
import com.builderboy426.randomplus.recipes.AlloyPressRecipes;

import cofh.redstoneflux.api.IEnergyReceiver;
import cofh.redstoneflux.impl.EnergyStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityAlloyPress extends TileEntity implements ITickable, IEnergyReceiver {
	
	private final int maxEnergy = 500000;
	private final int maxTemp = 5000;
	private final int maxCook = 200;
	private int temperature = 0; //Degrees in Celsius
	private int tempTime = 30;
	private int cookTime = 0;
	
	private EnergyStorage storage = new EnergyStorage(maxEnergy);
	private String customName;
	public ItemStackHandler handler = new ItemStackHandler(3);
	
	private boolean isHandlerEmpty() {
		for (int slot = 0; slot < handler.getSlots(); slot++) {
			if (handler.getStackInSlot(slot).isEmpty() && slot < 2) {
				return true;
			}
		}
		return false;
	}
	
	private void modifyTemperature (int heatModifier) {
		if (temperature < maxTemp && tempTime == 0) {
			temperature += heatModifier;
			if (temperature > maxTemp) { temperature = maxTemp; }
			else if (temperature < 0) { temperature = 0; }
			tempTime = 30;
		} else { --tempTime; }
	}
	
	private void setState(boolean active) {
		if (!active) {
			BlockAlloyPress.setState(active, world, pos);
			cookTime = 0;
			return;
		}
		BlockAlloyPress.setState(active, world, pos);
	}
	
	@Override
	public void update() {
		this.markDirty();
		if (storage.getEnergyStored() >= 100) { modifyTemperature(getHeatValue(storage.getEnergyStored())); }
		else { modifyTemperature(-100); }
		
		if (storage.getEnergyStored() >= 1500) {
			ItemStack[] inputs = {handler.getStackInSlot(0), handler.getStackInSlot(1)};
			ItemStack output = AlloyPressRecipes.getInstance().getAlloyPressResult(inputs[0], inputs[1]);
			
			if (!output.isEmpty()) {
				int temp = AlloyPressRecipes.getInstance().getTemperature(output);
				if (temp != 0) {
					if (temperature >= temp) {
						setState(true);
						if (cookTime == maxCook) {
							if (handler.getStackInSlot(2).getCount() > 0) {
								handler.getStackInSlot(0).shrink(1);
								handler.getStackInSlot(1).shrink(1);
								handler.getStackInSlot(2).grow(output.getCount());
							} else {
								handler.getStackInSlot(0).shrink(1);
								handler.getStackInSlot(1).shrink(1);
								handler.insertItem(2, output, false);
							}
							cookTime = 0;
							storage.modifyEnergyStored(-1500);
						} else { cookTime++; }
					}
				}
				return;
			} else { setState(false); }
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
		compound.setInteger("temperature", this.temperature);
		compound.setString("name", getDisplayName().toString());
		this.markDirty();
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.handler.deserializeNBT(compound.getCompoundTag("inventory"));
		this.cookTime = compound.getInteger("cooktime");
		this.customName = compound.getString("name");
		storage.setEnergyStored(compound.getInteger("energy"));
		this.temperature = compound.getInteger("temperature");
	}
	
	private int getHeatValue(int currentEnergy) { return (int)Math.floor(Math.sqrt(currentEnergy/2)); }
	
	@Override
	public int getEnergyStored(EnumFacing from) { return storage.getEnergyStored(); }
	
	@Override
	public int getMaxEnergyStored(EnumFacing from) { return storage.getMaxEnergyStored(); }
	
	@Override
	public boolean canConnectEnergy(EnumFacing from) { return true; }
	
	@Override
	public int receiveEnergy(EnumFacing from, int maxReceive, boolean simulate) { return storage.receiveEnergy(maxReceive, simulate); }
	
	public boolean isUseableByPlayer(EntityPlayer player) { return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX()+0.5, (double)this.pos.getY()+0.5, (double)this.pos.getZ()+0.5) <=64.0D; }
	
	public ITextComponent getDisplayName() { return new TextComponentTranslation("container.artifact_analyzer"); }
	
	public int getEnergyStored() { return storage.getEnergyStored(); }
	public int getMaxEnergyStored() { return storage.getMaxEnergyStored(); }
	public int getMaxCook() { return maxCook; }
	public int getCookTime() { return cookTime; }
	public int getTemperature() { return temperature; }
	public int getMaxTemp() { return maxTemp; }
	
	public void setEnergy(int data) { storage.setEnergyStored(data); }
	public void setCookTime(int data) { cookTime = data; }
}