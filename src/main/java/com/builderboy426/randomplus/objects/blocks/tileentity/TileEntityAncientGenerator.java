package com.builderboy426.randomplus.objects.blocks.tileentity;

import com.builderboy426.randomplus.energy.AncientEnergyStorage;
import com.builderboy426.randomplus.init.ItemInit;
import com.builderboy426.randomplus.objects.blocks.machines.BlockAncientGenerator;
import com.builderboy426.randomplus.utils.misc.Machines;

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
import net.minecraftforge.fml.common.WorldAccessContainer;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityAncientGenerator extends TileEntity implements ITickable {
	
	private final int maxEnergy = 250000;
	
	public ItemStackHandler handler = new ItemStackHandler(1);
	private AncientEnergyStorage storage = new AncientEnergyStorage(maxEnergy);
	private String customName;
	
	public int burnTime = 40;
	private int energy = storage.getEnergyStored();
	private final int maxSendEnergy = 500;
	
	@Override
	public void update() {
		if (!handler.getStackInSlot(0).isEmpty() && isItemFuel(handler.getStackInSlot(0))) {
			if (energy <= (maxEnergy-7500)) {
				burnTime -= 1;
				
				if (burnTime == 0) {
					energy += getFuelValue(handler.getStackInSlot(0));
					handler.getStackInSlot(0).shrink(1);
					burnTime = 40;
				}
			} else { burnTime = 40; }
		} else { burnTime = 40; }
		
		BlockAncientGenerator.setState(isBurning(), world, pos);
		
		//TODO: Generator radius (2)
		getMachines(1,0);
		getMachines(-1,0);
		getMachines(0,1);
		getMachines(0,-1);
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
		compound.setInteger("burntime", this.burnTime);
		compound.setInteger("guienergy", this.energy);
		compound.setString("name", getDisplayName().toString());
		this.storage.writeToNBT(compound);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.handler.deserializeNBT(compound.getCompoundTag("inventory"));
		this.burnTime = compound.getInteger("burntime");
		this.energy = compound.getInteger("guienergy");
		this.customName = compound.getString("name");
		this.storage.readFromNBT(compound);
	}
	
	public ITextComponent getDisplayName() { return new TextComponentTranslation("container.ancient_generator"); }
	public int getEnergyStored() { return this.energy; }
	public int getMaxEnergyStored() { return this.maxEnergy; }
	
	public void setField(int id, int value) {
		switch (id) {
		case 0:
			this.energy = value;
			break;
		case 1:
			this.burnTime = value;
			break;
		default:
			return;
		}
	}
	
	public int getField(int id) {
		switch (id) {
		case 0:
			return this.energy;
		case 1:
			return this.burnTime;
		default:
			return 0;
		}
	}
	
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX()+0.5, (double)this.pos.getY()+0.5, (double)this.pos.getZ()+0.5) <=64.0D;
	}
	
/*	private boolean isItemUpgrade(ItemStack stack) {
		if (stack.getItem() == ItemInit.UPGRADE) { return true; }
		return false;
	}*/
	
	private boolean isItemFuel(ItemStack stack) { return getFuelValue(stack) > 0; }
	
	private boolean isBurning() { return burnTime > 0 ? false : true; }
	
	private int getFuelValue(ItemStack stack) {
		if (stack.getItem() == ItemInit.ANCIENT_SHARD) { return 7500; }
		return 0;
	}
	
	private void getMachines(int x, int z) {
		BlockPos newPos = new BlockPos(getPos().getX()+x, getPos().getY(), getPos().getZ()+z);
		TileEntity tileEntity = getWorld().getTileEntity(newPos);
		
		TileEntityArtifactAnalyzer analyzer = Machines.getAnalyzer(tileEntity);
		Machines.sendEnergyAnalyzer(analyzer, this.energy, maxSendEnergy, this);
	}
}