package com.builderboy426.randomplus.objects.blocks.tileentity;

import com.builderboy426.randomplus.energy.ChaosEnergyStorage;
import com.builderboy426.randomplus.init.ItemInit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityChaosEnergizer extends TileEntity implements ITickable {
	
	public ItemStackHandler handler = new ItemStackHandler(2);
	private ChaosEnergyStorage storage = new ChaosEnergyStorage(7500);
	private String customName;
	public int energy = storage.getEnergyStored();
	public int cookTime;
	public int stability;
	
	@Override
	public void update() {
		if (!handler.getStackInSlot(0).isEmpty() && isItemFuel(handler.getStackInSlot(0))) {
			cookTime++;
			if (cookTime == 80) {
				energy += getFuelValue(handler.getStackInSlot(0));
				handler.getStackInSlot(0).shrink(1);
				cookTime = 0;
			} else if (cookTime == 60) {
				if (!handler.getStackInSlot(1).isEmpty()) {
					if (stability < 100) {
						stability++;
					}
					handler.getStackInSlot(1).shrink(1);
				} else {
					stability--;
				}
			}
			
			if (stability == 0) {
				EntityTNTPrimed explosion = new EntityTNTPrimed(this.world);
				explosion.setPosition((double)this.pos.getX(), (double)this.pos.getY(), (double)this.pos.getZ());
				explosion.setFuse(10);
				this.world.spawnEntity(explosion);
				this.world.playSound((EntityPlayer)null, explosion.posX, explosion.posY, explosion.posZ, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
			}
		}
	}
	
	private boolean isItemFuel(ItemStack stack) {
		return getFuelValue(stack) > 0;
	}
	
	private int getFuelValue(ItemStack stack) {
		if (stack.getItem() == ItemInit.CHAOS) { return 250; }
		return 0;
	}
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (capability == CapabilityEnergy.ENERGY) { return (T)this.storage; }
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) { return (T)this.handler; }
		return super.getCapability(capability, facing);
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityEnergy.ENERGY) { return true; }
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) { return true; }
		return super.hasCapability(capability, facing);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setTag("Inventory", this.handler.serializeNBT());
		compound.setInteger("CookTime", this.cookTime);
		compound.setInteger("Stability", this.stability);
		compound.setInteger("GuiEnergy", this.energy);
		compound.setString("Name", this.customName);
		this.storage.writeToNBT(compound);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.handler.deserializeNBT(compound.getCompoundTag("Inventory"));
		this.cookTime = compound.getInteger("CookTime");
		this.stability = compound.getInteger("Stability");
		this.energy = compound.getInteger("GuiEnergy");
		this.customName = compound.getString("Name");
		this.storage.readFromNBT(compound);
	}
	
	@Override
	public ITextComponent getDisplayName() {
		return new TextComponentTranslation("container.chaos_energizer");
	}
	
	public int getEnergyStored() {
		return this.energy;
	}
	
	public int getMaxEnergyStored() {
		return this.storage.getMaxEnergyStored();
	}
	
	public int getField(int id) {
		switch (id) {
			case 0: return this.energy;
			case 1: return this.cookTime;
			default: return 0;
		}
	}
	
	public boolean isEnabledByPlayer(EntityPlayer player) {
		return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5, (double)this.pos.getY() + 0.5, (double)this.pos.getZ() + 0.5) <= 64.0D;
	}
}