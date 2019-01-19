package com.builderboy426.randomplus.objects.items.artifacts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.builderboy426.randomplus.Main;
import com.builderboy426.randomplus.init.ItemInit;
import com.builderboy426.randomplus.objects.items.ItemBase;
import com.builderboy426.randomplus.utils.RandomPlusConfig;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@EventBusSubscriber
public class ArtifactBase extends Item {
	
	public static final List<Potion> EFFECTS = new ArrayList<Potion>();
	public static final List<ItemStack> COMMON_ARTIFACTS = new ArrayList<ItemStack>();
	public static final List<ItemStack> UNCOMMON_ARTIFACTS = new ArrayList<ItemStack>();
	public static final List<ItemStack> RARE_ARTIFACTS = new ArrayList<ItemStack>();
	public static final List<ItemStack> EPIC_ARTIFACTS = new ArrayList<ItemStack>();
	public static final List<ItemStack> LEGENDARY_ARTIFACTS = new ArrayList<ItemStack>();
	
	public enum ArtifactRarity {
		COMMON, //50 (60)
		UNCOMMON, //20 (25)
		RARE, //15 (15)
		EPIC, //10
		LEGENDARY; //5
	}
	
	public ArtifactBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.RANDOM_PLUS);
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
	
	public NBTTagCompound getNBTTagCompound(NBTTagCompound compound) {
		if (compound != null && compound.hasKey("uses")) { return compound; }
		return null;
	}
	
	public static ArtifactRarity getRarity(int chance) {
		if (chance >= 0 && chance <= 59) {
			return ArtifactRarity.COMMON;
		} else if (chance >= 60 && chance <= 84) {
			return ArtifactRarity.UNCOMMON;
		} else if (chance >= 85 && chance <= 99) {
			return ArtifactRarity.RARE;
		}
		return ArtifactRarity.COMMON;
	}
	
	public static List<ItemStack> getRarityList(ArtifactRarity rarity) {
		switch (rarity) {
		case COMMON:
			return COMMON_ARTIFACTS;
		case UNCOMMON:
			return UNCOMMON_ARTIFACTS;
		case RARE:
			return RARE_ARTIFACTS;
		case EPIC:
			return EPIC_ARTIFACTS;
		case LEGENDARY:
			return LEGENDARY_ARTIFACTS;
		}
		return COMMON_ARTIFACTS;
	}
	
	protected boolean checkActive(EntityPlayer player) {
		if (getRestrictedArtifacts()) {
			for (int e = 0; e < this.EFFECTS.size(); e++) {
				if (player.getActivePotionEffect(this.EFFECTS.get(e)) != null) {
					return true;
				}
			}
			return false;
		}
		return false;
	}
	
	private boolean getRestrictedArtifacts() {
		return RandomPlusConfig.CLIENT.artifactConfig.restrictedArtifact;
	}
}