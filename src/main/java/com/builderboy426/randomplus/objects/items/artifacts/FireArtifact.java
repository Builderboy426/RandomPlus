package com.builderboy426.randomplus.objects.items.artifacts;

import java.util.List;

import com.builderboy426.randomplus.utils.config.RandomPlusConfig;
import com.builderboy426.randomplus.utils.handlers.EnumHandler.ArtifactRarity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class FireArtifact extends ArtifactBase {
	
	//Config Variables
	private int maxUses = RandomPlusConfig.CLIENT.artifactConfig.fireArtifact.uses;
	private int time = (int)(RandomPlusConfig.CLIENT.artifactConfig.fireArtifact.time * (20 * 60));
	
	//Artifact Variables
	private static Potion effect = MobEffects.FIRE_RESISTANCE;
	private boolean active = false;
	
	public FireArtifact(String name) {
		super(name);
		super.EFFECTS.add(this.effect);
		super.ARTIFACTS.add(new ItemStack(this));
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack item = player.getHeldItem(hand);
		if (this.active) { return new ActionResult<ItemStack>(EnumActionResult.PASS, item); }
		if (!world.isRemote) {
			if (player.isPotionActive(effect)) { return new ActionResult<ItemStack>(EnumActionResult.PASS, item); }
			
			NBTTagCompound nbt = item.getTagCompound();
			
			if (nbt == null) { nbt = new NBTTagCompound(); }
			if (nbt.hasKey("uses")) { nbt.setInteger("uses", nbt.getInteger("uses") + 1); }
			else { nbt.setInteger("uses", 0); }
			item.setTagCompound(nbt);
			int usesLeft = this.maxUses-nbt.getInteger("uses");
			
			if (usesLeft >= 1) {
				if (!player.isPotionActive(effect)) {
					player.addPotionEffect(new PotionEffect(this.effect, time, 1));
					return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
				} else {
					player.sendMessage(new TextComponentString("The artifact's power is still within you!"));
					return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
				}
			} else if (usesLeft < 1) {
				if (!player.isPotionActive(effect)) {
					player.addPotionEffect(new PotionEffect(this.effect, time, 1));
					player.setHeldItem(hand, new ItemStack((Item)null));
					return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
				}
			}
			return new ActionResult<ItemStack>(EnumActionResult.PASS, item);
		}
		return new ActionResult<ItemStack>(EnumActionResult.PASS, item);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		NBTTagCompound nbt = stack.getTagCompound();
		if (nbt == null) { nbt = new NBTTagCompound(); }
		if (!nbt.hasKey("uses")) { nbt.setInteger("uses", 0); }
		stack.setTagCompound(nbt);
		
		int usesLeft = this.maxUses-nbt.getInteger("uses");
		String info = I18n.format("Only "+usesLeft+"/"+this.maxUses+" Uses");
		tooltip.addAll(Minecraft.getMinecraft().fontRenderer.listFormattedStringToWidth(info, 150));
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
		checkConfigValues();
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entity;
			this.active = super.checkActive(player);
		}
	}
	
	private void checkConfigValues() {
		if (maxUses != RandomPlusConfig.CLIENT.artifactConfig.fireArtifact.uses) { maxUses = RandomPlusConfig.CLIENT.artifactConfig.fireArtifact.uses; }
		if (time != (int)(RandomPlusConfig.CLIENT.artifactConfig.fireArtifact.time * (20 * 60))) { time = (int)(RandomPlusConfig.CLIENT.artifactConfig.fireArtifact.time * (20 * 60)); }
	}
	
	public static ArtifactRarity getRarity() {
		return ArtifactRarity.COMMON;
	}
}