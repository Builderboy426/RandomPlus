package com.builderboy426.randomplus.init;

import com.builderboy426.randomplus.objects.blocks.BlockBase;
import com.builderboy426.randomplus.objects.blocks.machines.BlockAncientGenerator;
import com.builderboy426.randomplus.objects.blocks.machines.BlockAncientPylon;
import com.builderboy426.randomplus.objects.blocks.machines.BlockArtifactAnalyzer;
import com.builderboy426.randomplus.objects.blocks.machines.BlockBlastFurnace;
import com.builderboy426.randomplus.objects.blocks.ores.OreAluminium;
import com.builderboy426.randomplus.objects.blocks.ores.OreAmethyst;
import com.builderboy426.randomplus.objects.blocks.ores.OreAncient;
import com.builderboy426.randomplus.objects.blocks.ores.OreChaos;
import com.builderboy426.randomplus.objects.blocks.ores.OreCopper;
import com.builderboy426.randomplus.objects.blocks.ores.OreLithium;
import com.builderboy426.randomplus.objects.blocks.ores.OreRuby;
import com.builderboy426.randomplus.objects.blocks.ores.OreSapphire;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityAncientGenerator;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityAncientPylon;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityArtifactAnalyzer;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityBlastFurnace;
import com.builderboy426.randomplus.utils.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockInit {
	
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
	
	public static void init() {
		//Materials
		registerBlocks(BLOCK_AMETHYST, BLOCK_CHAOS, BLOCK_RUBY, BLOCK_SAPPHIRE);
		//Ores
		registerBlocks(ORE_ALUMINIUM, ORE_AMETHYST, ORE_CHAOS, ORE_COPPER, ORE_LITHIUM,
				   ORE_RUBY, ORE_SAPPHIRE, ROCK_ANCIENT);
		//Machines
		//Ancient
		registerBlocks(ANCIENT_GENERATOR, ANCIENT_PYLON);
		//Chaos
		//registerBlocks(blocks);
		//Misc.
		registerBlocks(ARTIFACT_ANALYZER, BLAST_FURNACE);
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityAncientGenerator.class, new ResourceLocation(Reference.MODID+":ancient_generator"));
		GameRegistry.registerTileEntity(TileEntityArtifactAnalyzer.class, new ResourceLocation(Reference.MODID+":artifact_analyzer"));
		GameRegistry.registerTileEntity(TileEntityAncientPylon.class, new ResourceLocation(Reference.MODID+":ancient_pylon"));
		GameRegistry.registerTileEntity(TileEntityBlastFurnace.class, new ResourceLocation(Reference.MODID+":blast_furnace"));
	}
	
	private static void registerBlocks(Block... blocks) {
		for (Block block : blocks) {
			registerBlock(block);
		}
	}
	
	private static void registerBlock(Block block) {
		RegistryHandler.Blocks.BLOCKS.add(block);
		ItemBlock itemBlock = (ItemBlock) new ItemBlock(block).setRegistryName(block.getRegistryName());
		RegistryHandler.Items.ITEMS.add(itemBlock);
	}
}