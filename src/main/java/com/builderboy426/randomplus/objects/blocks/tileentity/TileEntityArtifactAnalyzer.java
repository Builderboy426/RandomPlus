package com.builderboy426.randomplus.objects.blocks.tileentity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.builderboy426.randomplus.energy.AncientEnergyStorage;
import com.builderboy426.randomplus.init.ItemInit;
import com.builderboy426.randomplus.objects.blocks.machines.BlockArtifactAnalyzer;
import com.builderboy426.randomplus.objects.items.artifacts.ArtifactBase;
import com.builderboy426.randomplus.objects.items.artifacts.ArtifactBase.ArtifactRarity;
import com.builderboy426.randomplus.objects.items.artifacts.FireArtifact;
import com.builderboy426.randomplus.objects.items.artifacts.NightArtifact;
import com.builderboy426.randomplus.objects.items.artifacts.WarArtifact;
import com.builderboy426.randomplus.objects.items.artifacts.WaterArtifact;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
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
	
	private final int maxEnergy = 50000;
	public int cookTime;
	
	public ItemStackHandler handler = new ItemStackHandler(3);
	private AncientEnergyStorage storage = new AncientEnergyStorage(maxEnergy);
	private String customName;
	
	private int energy = storage.getEnergyStored();
	private final int maxCook = 40;
	
	@Override
	public void update() {
		if (handler.getStackInSlot(0).getItem() == ItemInit.RESEARCH_KIT && handler.getStackInSlot(0).getCount() > 0
		&& handler.getStackInSlot(1).getItem() == ItemInit.UNKNOWN_ARTIFACT && handler.getStackInSlot(1).getCount() > 0
		&& handler.getStackInSlot(2).isEmpty()) {
			if (energy >= 35000) {
				cookTime++;
				if (cookTime == maxCook) {
					handler.getStackInSlot(0).shrink(1);
					handler.getStackInSlot(1).shrink(1);
					handler.setStackInSlot(2, getOutput());
					energy -= 35000;
					cookTime = 0;
				}
			}	
		} else {
			cookTime = 0;
		}
	}
	
	private ItemStack getOutput() {
		//TODO: get artifacts based on rarity
		Random rand = new Random();
		int randRarity = rand.nextInt(100);
		
		ArtifactRarity rarity = ArtifactBase.getRarity(randRarity);
		
		Item artifact = getArtifact(rarity);
		return new ItemStack(artifact);
	}
	
	private Item getArtifact(ArtifactRarity rarity) {
		Random random = new Random();
		List<ItemStack> rarityList = ArtifactBase.getRarityList(rarity);
		
		Item item = rarityList.get(random.nextInt(rarityList.size())).getItem();
		return item;
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
	public int getMaxCook() { return maxCook; }
	
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
			break;
		case 1:
			this.cookTime = value;
			break;
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

	public void updateEnergy(int newEnergy) {
		this.setField(0, newEnergy);
	}
}