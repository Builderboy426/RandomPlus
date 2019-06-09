package com.builderboy426.randomplus.init;

import java.util.Map;
import java.util.Random;

import com.builderboy426.randomplus.enchantments.EnchanmentArcheology;
import com.builderboy426.randomplus.utils.Reference;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentInit {
	
	public static final Enchantment ARCHEOLOGY = new EnchanmentArcheology();
	
	@Mod.EventBusSubscriber(modid=Reference.MODID)
	public static class Archeology {
		@SubscribeEvent
		public static void archeologyEnchantmentFunction(BreakEvent event) {
			World world = event.getWorld();
			Random rand = new Random();
			int chance = rand.nextInt(1000);
			if (!world.isRemote) {
				EntityPlayer player = event.getPlayer();
				ItemStack tool = player.getHeldItem(EnumHand.MAIN_HAND);
				if (chance > 975) {
					if (isEnchantment(EnchantmentHelper.getEnchantments(tool), ARCHEOLOGY)) {
						BlockPos pos = event.getPos();
						if (world.getBlockState(pos) == Blocks.STONE.getDefaultState() || world.getBlockState(pos) == Blocks.COBBLESTONE.getDefaultState()
						|| world.getBlockState(pos) == Blocks.MOSSY_COBBLESTONE.getDefaultState()) {
							System.out.println("Unknown Artifact Found");
							world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.UNKNOWN_ARTIFACT)));
						}
					} else {
						System.out.println("Archeology Enchantment NOT Found!");
					}
				}
			}
		}
	}
	
	public static void init() {
		registerEnchantment(ARCHEOLOGY);
	}
	
	public static void registerEnchanments(Enchantment... enchantments) {
		for (Enchantment enchantment : enchantments) {
			registerEnchantment(enchantment);
		}
	}

	public static void registerEnchantment(Enchantment enchantment) {
		RegistryHandler.Enchantments.ENCHANTMENTS.add(enchantment);
	}
	
	private static boolean isEnchantment(Map<Enchantment, Integer> enchantments, Enchantment find) {
		return enchantments.containsKey(find);
	}
}