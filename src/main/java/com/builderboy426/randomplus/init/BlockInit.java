package com.builderboy426.randomplus.init;

import java.util.ArrayList;
import java.util.List;

import com.builderboy426.randomplus.objects.blocks.BlockBase;
import com.builderboy426.randomplus.objects.blocks.machines.BlockChaosEnergizer;
import com.builderboy426.randomplus.objects.blocks.ores.*;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block BLOCK_RUBY = new BlockBase("block_ruby", Material.IRON, 5.0f, 2);
	public static final Block BLOCK_SAPPHIRE = new BlockBase("block_sapphire", Material.IRON, 5.0f, 2);
	public static final Block BLOCK_AMETHYST = new BlockBase("block_amethyst", Material.IRON, 5.0f, 2);
	public static final Block BLOCK_CHAOS = new BlockBase("block_chaos", Material.IRON, 13.75f, 3);
	
	public static final Block ORE_RUBY = new OreRuby("ore_ruby", Material.ROCK, 1.75f);
	public static final Block ORE_SAPPHIRE = new OreSapphire("ore_sapphire", Material.ROCK, 1.75f);
	public static final Block ORE_AMETHYST = new OreAmethyst("ore_amethyst", Material.ROCK, 1.75f);
	public static final Block ORE_CHAOS = new OreChaos("ore_chaos", Material.ROCK, 29.5f);
	public static final Block ROCK_ANCIENT = new OreAncient("rock_ancient", Material.ROCK, 25.75f);
	
	//public static final Block CHAOS_ENERGIZER = new BlockChaosEnergizer("chaos_energizer", Material.IRON, 42.5f, 3);
	//public static final Block CHAOS_ENCHANTER = new BlockChaosEnchanter("chaos_enchanter", Material.IRON, 45.75f, 3);
}