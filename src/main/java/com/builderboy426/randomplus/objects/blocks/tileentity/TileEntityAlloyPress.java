package com.builderboy426.randomplus.objects.blocks.tileentity;

import java.util.List;

import com.builderboy426.randomplus.objects.blocks.machines.BlockAlloyPress;
import com.builderboy426.randomplus.recipes.AlloyPressRecipes;

import cofh.redstoneflux.api.IEnergyReceiver;
import cofh.redstoneflux.impl.EnergyStorage;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityAlloyPress extends TileEntity implements ITickable, IEnergyReceiver {
	
	private final int maxEnergy = 500000;
	private final int maxTemp = 5000;
	private final int maxCook = 200;
	private int temperature = 0; //Degrees in Celsius
	private int tempTime = 80;
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
	
	private AlloyPressRecipes checkInputSlots() {
		List<AlloyPressRecipes> recipes = AlloyPressRecipes.RECIPES;
		//for (int i = 0; i < recipes.size(); i++) {
		for (AlloyPressRecipes apRecipe : recipes) {
			ItemStack[] recipe = apRecipe.getRecipe();
			ItemStack[] inputs = apRecipe.getInputs(recipe);
			if (checkInputs(inputs)) { return apRecipe; }
		}
		return null;
	}
	
	private boolean checkInputs(ItemStack[] inputs) {
		boolean input1 = false, input2 = false;
		for (ItemStack input : inputs) {
			if (handler.getStackInSlot(0) == input) { input1 = true; }
			else if (handler.getStackInSlot(1) == input) { input2 = true; }
		}
		
		if (input1 && input2) { return true; }
		else { return false; }
	}
	
	@Override
	public void update() {
		if (storage.getEnergyStored() >= 10) {
			if (temperature < maxTemp && tempTime == 0) {
				++temperature;
				tempTime = 80;
			} else { --tempTime; }
		}
		
		if (!isHandlerEmpty()) {
			AlloyPressRecipes apRecipe = checkInputSlots();
			ItemStack[] recipe = apRecipe.getRecipe();
			ItemStack output = apRecipe.getOutputFromRecipe(recipe);
			int temperature = apRecipe.getTemperature();
			if (recipe != null && output != null) {
				if (temperature >= this.temperature) {
					BlockAlloyPress.setState(true, world, pos);
					if (cookTime == maxCook) {
						handler.getStackInSlot(0).shrink(1);
						handler.getStackInSlot(1).shrink(1);
						handler.setStackInSlot(2, output);
						cookTime = 0;
					} else { ++cookTime; }
				} else {
					BlockAlloyPress.setState(false, world, pos);
					cookTime = 0;
				}
			} else { BlockAlloyPress.setState(false, world, pos); }
		} else {
			BlockAlloyPress.setState(false, world, pos);
			cookTime = 0;
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
	public int receiveEnergy(EnumFacing from, int maxReceive, boolean simulate) { return storage.receiveEnergy(maxReceive, simulate); }
}