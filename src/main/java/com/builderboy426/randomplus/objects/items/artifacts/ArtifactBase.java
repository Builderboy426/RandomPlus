package com.builderboy426.randomplus.objects.items.artifacts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.builderboy426.randomplus.Main;
import com.builderboy426.randomplus.init.ItemInit;
import com.builderboy426.randomplus.objects.items.ItemBase;
import com.builderboy426.randomplus.utils.config.RandomPlusConfig;
import com.builderboy426.randomplus.utils.interfaces.IHasModel;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@EventBusSubscriber
public class ArtifactBase extends Item implements IHasModel {
	
	public static final List<Potion> EFFECTS = new ArrayList<Potion>();
	
	public ArtifactBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.RANDOM_PLUS);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public int getItemStackLimit() {
		return 1;
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		return false;
	}
	
	@Override
	public boolean canDestroyBlockInCreative(World world, BlockPos pos, ItemStack stack, EntityPlayer player) {
		return false;
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	public boolean getRestrictedArtifacts() {
		return RandomPlusConfig.CLIENT.artifactConfig.restrictedArtifact;
	}
}