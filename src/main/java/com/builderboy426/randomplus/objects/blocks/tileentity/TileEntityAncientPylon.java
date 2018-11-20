package com.builderboy426.randomplus.objects.blocks.tileentity;

import com.builderboy426.randomplus.energy.AncientEnergyStorage;
import com.builderboy426.randomplus.init.ItemInit;
import com.builderboy426.randomplus.objects.blocks.utils.Machines;

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

public class TileEntityAncientPylon extends TileEntity implements ITickable {
	
	private final int maxEnergy = 250000;
	
	public ItemStackHandler handler = new ItemStackHandler(1);
	private AncientEnergyStorage storage = new AncientEnergyStorage(maxEnergy);
	private String customName;
	
	private int energy = storage.getEnergyStored();
	private int maxSendEnergy = 500;
	
	@Override
	public void update() {
		//TODO: UPGRADES
		//Generator radius (5)
		for (int x = -6; x < 6; x++) {
			for (int y = -6; y < 6; y++) {
				for (int z = -6; z < 6; z++) {
					getMachines(x, y, z);
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
		compound.setInteger("guienergy", this.energy);
		compound.setString("name", getDisplayName().toString());
		this.storage.writeToNBT(compound);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.handler.deserializeNBT(compound.getCompoundTag("inventory"));
		this.energy = compound.getInteger("guienergy");
		this.customName = compound.getString("name");
		this.storage.readFromNBT(compound);
	}
	
	public ITextComponent getDisplayName() { return new TextComponentTranslation("container.ancient_generator"); }
	public int getEnergyStored() { return this.energy; }
	public int getMaxEnergyStored() { return this.maxEnergy; }
	public void setEnergy(int newEnergy) { this.energy = newEnergy; }
	
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX()+0.5, (double)this.pos.getY()+0.5, (double)this.pos.getZ()+0.5) <=64.0D;
	}
	
/*	private boolean isItemUpgrade(ItemStack stack) {
		if (stack.getItem() == ItemInit.UPGRADE) { return true; }
		return false;
	}*/
	
	private boolean isItemFuel(ItemStack stack) { return getFuelValue(stack) > 0; }
	
	private int getFuelValue(ItemStack stack) {
		if (stack.getItem() == ItemInit.ANCIENT_SHARD) { return 10000; }
		return 0;
	}
	
	private void getMachines(int x, int y, int z) {
		BlockPos newPos = new BlockPos(getPos().getX()+x, getPos().getY()+y, getPos().getZ()+z);
		TileEntity tileEntity = getWorld().getTileEntity(newPos);
		
		Machines.updateAnalyzer(tileEntity, (TileEntity)this, this.energy, maxSendEnergy);
	}
}