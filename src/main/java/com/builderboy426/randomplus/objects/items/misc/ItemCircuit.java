package com.builderboy426.randomplus.objects.items.misc;

import com.builderboy426.randomplus.objects.items.ItemBase;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class ItemCircuit extends ItemBase {

	public ItemCircuit(String name) {
		super(name, 16);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack item = player.getHeldItem(hand);
		world.playSound(player, player.getPosition(), new SoundEvent(new ResourceLocation("ui.button.click")), SoundCategory.MASTER, 0.5F, 0.0F);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
	}
}