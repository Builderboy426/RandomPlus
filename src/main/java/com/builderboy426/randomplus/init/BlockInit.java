package com.builderboy426.randomplus.init;

import java.util.ArrayList;
import java.util.List;

import com.builderboy426.randomplus.objects.blocks.BlockBase;
import com.builderboy426.randomplus.objects.blocks.machines.BlockAncientGenerator;
import com.builderboy426.randomplus.objects.blocks.machines.BlockAncientPylon;
import com.builderboy426.randomplus.objects.blocks.machines.BlockArtifactAnalyzer;
import com.builderboy426.randomplus.objects.blocks.machines.BlockBlastFurnace;
import com.builderboy426.randomplus.objects.blocks.ores.*;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//Material Blocks
	public static final Block BLOCK_RUBY = new BlockBase("block_ruby", Material.IRON, 5.0f);
	public static final Block BLOCK_SAPPHIRE = new BlockBase("block_sapphire", Material.IRON, 5.0f);
	public static final Block BLOCK_AMETHYST = new BlockBase("block_amethyst", Material.IRON, 5.0f);
	public static final Block BLOCK_CHAOS = new BlockBase("block_chaos", Material.IRON, 13.75f);
	
	//Ores / Materials
	public static final Block ORE_RUBY = new OreRuby("ore_ruby", Material.ROCK, 1.75f);
	public static final Block ORE_SAPPHIRE = new OreSapphire("ore_sapphire", Material.ROCK, 1.75f);
	public static final Block ORE_AMETHYST = new OreAmethyst("ore_amethyst", Material.ROCK, 1.75f);
	public static final Block ORE_CHAOS = new OreChaos("ore_chaos", Material.ROCK, 29.5f);
	public static final Block ROCK_ANCIENT = new OreAncient("rock_ancient", Material.ROCK, 20.5f);
	public static final Block ORE_LITHIUM = new OreLithium("ore_lithium", Material.ROCK, 1.75f);
	public static final Block ORE_COPPER = new OreCopper("ore_copper", Material.ROCK, 1.75f);
	public static final Block ORE_ALUMINIUM = new OreAluminium("ore_aluminium", Material.ROCK, 1.75f);
	
	//Ancient Machines:
	public static final Block ANCIENT_GENERATOR = new BlockAncientGenerator("ancient_generator");
	public static final Block ARTIFACT_ANALYZER = new BlockArtifactAnalyzer("artifact_analyzer");
	
	//Chaos Machines
	//public static final Block CHAOS_ENERGIZER = new BlockChaosEnergizer("chaos_energizer", Material.IRON, 42.5f, 3);
	//public static final Block CHAOS_ENCHANTER = new BlockChaosEnchanter("chaos_enchanter", Material.IRON, 45.75f, 3);
	
	//Energy Transmitters
	public static final Block ANCIENT_PYLON = new BlockAncientPylon("ancient_pylon");
	//public static final Block CHAOS_PYLON = new BlockChaosPylon("chaos_pylon");
	
	//Misc. Machines
	public static final Block BLAST_FURNACE = new BlockBlastFurnace("blast_furnace");
}