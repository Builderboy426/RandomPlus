package com.builderboy426.randomplus.objects.blocks.tileentity;

import java.util.Random;

import com.builderboy426.randomplus.energy.AncientEnergyStorage;
import com.builderboy426.randomplus.init.ItemInit;
import com.builderboy426.randomplus.objects.blocks.machines.BlockArtifactAnalyzer;
import com.builderboy426.randomplus.objects.items.artifacts.ArtifactBase;
import com.builderboy426.randomplus.objects.items.artifacts.WaterArtifact;
import com.builderboy426.randomplus.utils.handlers.EnumHandler.MachineType;

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

public class TileEntityArtifactAnalyzer extends TileEntity implements ITickable {
	
	public ItemStackHandler handler = new ItemStackHandler(3);
	private AncientEnergyStorage storage = new AncientEnergyStorage(50000);
	private String customName;
	private ItemStack analyzing = ItemStack.EMPTY;
	
	public int cookTime;
	private int energy = storage.getEnergyStored();
	private int maxEnergy = 50000;
	
	@Override
	public void update() {
		if (handler.getStackInSlot(0).getItem() == ItemInit.RESEARCH_KIT && handler.getStackInSlot(0).getCount() > 0 && handler.getStackInSlot(1).getItem() == ItemInit.UNKNOWN_ARTIFACT && handler.getStackInSlot(1).getCount() > 0 && handler.getStackInSlot(2).isEmpty()) {
			if (energy >= 175) {
				energy -= 175;
				cookTime++;
				if (cookTime == 200) {
					handler.getStackInSlot(0).shrink(1);
					handler.getStackInSlot(1).shrink(1);
					handler.setStackInSlot(2, getOutput());
					cookTime = 0;
				}
			}	
		}
	}
	
	private ItemStack getOutput() {
		//TODO: get artifacts based on rarity
		Random rarity = new Random();
		int randArtifact = rarity.nextInt(4);
		
		switch (randArtifact) {
		case 0:
			return new ItemStack(ItemInit.WATER_ARTIFACT);
		case 1:
			return new ItemStack(ItemInit.FIRE_ARTIFACT);
		case 2:
			return new ItemStack(ItemInit.NIGHT_ARTIFACT);
		case 3:
			return new ItemStack(ItemInit.WAR_ARTIFACT);
		case 4:
			return new ItemStack(ItemInit.SPEED_ARTIFACT);
		}
		return ItemStack.EMPTY;
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
	
	public ITextComponent getDisplayName() { return new TextComponentTranslation("container.artifact_analyzer"); }
	public int getEnergyStored() { return this.energy; }
	public int getMaxEnergyStored() { return this.maxEnergy; }
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setTag("inventory", this.handler.serializeNBT());
		compound.setInteger("cooktime", this.cookTime);
		compound.setInteger("guienergy", this.energy);
		compound.setString("name", getDisplayName().toString());
		this.storage.writeToNBT(compound);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.handler.deserializeNBT(compound.getCompoundTag("inventory"));
		this.cookTime = compound.getInteger("cooktime");
		this.energy = compound.getInteger("guienergy");
		this.customName = compound.getString("name");
		this.storage.readFromNBT(compound);
	}
	
	public void setField(int id, int value) {
		switch (id) {
		case 0:
			this.energy = value;
		case 1:
			this.cookTime = value;
		}
	}
	
	public int getField(int id) {
		switch (id) {
		case 0:
			return this.energy;
		case 1:
			return this.cookTime;
		default:
			return 0;
		}
	}
	
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX()+0.5, (double)this.pos.getY()+0.5, (double)this.pos.getZ()+0.5) <=64.0D;
	}
}