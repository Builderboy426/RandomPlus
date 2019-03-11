package com.builderboy426.randomplus.enchantments;

import com.builderboy426.randomplus.init.EnchantmentInit;
import com.builderboy426.randomplus.utils.Reference;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class EnchanmentArcheology extends Enchantment {
	public EnchanmentArcheology() {
		super(Rarity.RARE, EnumEnchantmentType.DIGGER, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
		this.setName("archeology");
		this.setRegistryName(new ResourceLocation(Reference.MODID+":archeology"));
	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return 20;
	}
	
	public int getMaxEnchantability(int enchantmentLevel) {
		return this.getMaxEnchantability(enchantmentLevel)+10;
	}
	
	@Override
	public int getMaxLevel() {
		return 1;
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) {
		return super.canApplyTogether(ench) && ench != Enchantments.FORTUNE;
	}
	
	@Override
	public boolean canApply(ItemStack stack) {
		if (stack.getItem() instanceof ItemPickaxe) {
			return super.canApply(stack);
		}
		return false;
	}
}