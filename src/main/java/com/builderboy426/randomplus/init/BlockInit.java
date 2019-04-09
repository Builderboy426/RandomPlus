package com.builderboy426.randomplus.init;

import com.builderboy426.randomplus.objects.blocks.BlockBase;
import com.builderboy426.randomplus.objects.blocks.machines.BlockAlloyPress;
import com.builderboy426.randomplus.objects.blocks.machines.BlockAncientGenerator;
import com.builderboy426.randomplus.objects.blocks.machines.BlockPylon;
import com.builderboy426.randomplus.objects.blocks.machines.BlockArtifactAnalyzer;
import com.builderboy426.randomplus.objects.blocks.ores.OreAluminium;
import com.builderboy426.randomplus.objects.blocks.ores.OreAmethyst;
import com.builderboy426.randomplus.objects.blocks.ores.OreAncient;
import com.builderboy426.randomplus.objects.blocks.ores.OreChaos;
import com.builderboy426.randomplus.objects.blocks.ores.OreCopper;
import com.builderboy426.randomplus.objects.blocks.ores.OreLithium;
import com.builderboy426.randomplus.objects.blocks.ores.OreRuby;
import com.builderboy426.randomplus.objects.blocks.ores.OreSapphire;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityAlloyPress;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityAncientGenerator;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityPylon;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityArtifactAnalyzer;
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
	public static final Block BLOCK_COPPER = new BlockBase("block_copper", Material.IRON, 5.0f);
	public static final Block BLOCK_ALUMINIUM = new BlockBase("block_aluminium", Material.IRON, 5.0f);
	public static final Block BLOCK_STEEL = new BlockBase("block_steel", Material.IRON, 10.5f);
	public static final Block BLOCK_TIN = new BlockBase("block_tin", Material.IRON, 5.0f);
	public static final Block BLOCK_TITANIUM = new BlockBase("block_titanium", Material.IRON, 10.5f);
	public static final Block BLOCK_BRONZE = new BlockBase("block_bronze", Material.IRON, 10.5f);
	public static final Block BLOCK_MAGNITE = new BlockBase("block_magnite", Material.IRON, 5.0f);
	public static final Block BLOCK_REINFORCED_STEEL = new BlockBase("block_reinforced_steel", Material.IRON, 10.5f);
	
	//Ores / Materials
	public static final Block ORE_RUBY = new OreRuby("ore_ruby", Material.ROCK, 1.75f);
	public static final Block ORE_SAPPHIRE = new OreSapphire("ore_sapphire", Material.ROCK, 1.75f);
	public static final Block ORE_AMETHYST = new OreAmethyst("ore_amethyst", Material.ROCK, 1.75f);
	public static final Block ORE_CHAOS = new OreChaos("ore_chaos", Material.ROCK, 17.5f);
	public static final Block ROCK_ANCIENT = new OreAncient("rock_ancient", Material.ROCK, 15.5f);
	public static final Block ORE_LITHIUM = new OreLithium("ore_lithium", Material.ROCK, 1.75f);
	public static final Block ORE_COPPER = new OreCopper("ore_copper", Material.ROCK, 1.75f);
	public static final Block ORE_ALUMINIUM = new OreAluminium("ore_aluminium", Material.ROCK, 1.75f);
	public static final Block ORE_TIN = new OreCopper("ore_tin", Material.ROCK, 1.75f);
	public static final Block ORE_TITANIUM = new OreAluminium("ore_titanium", Material.ROCK, 1.75f);
	
	//Machines:
	public static final Block ANCIENT_GENERATOR = new BlockAncientGenerator("ancient_generator");
	public static final Block ARTIFACT_ANALYZER = new BlockArtifactAnalyzer("artifact_analyzer");
	public static final Block ALLOY_PRESS = new BlockAlloyPress("alloy_press");
	
	//Energy Transmitters
	public static final Block PYLON = new BlockPylon("pylon");
	
	public static void init() {
		//Materials
		registerBlocks(BLOCK_AMETHYST, BLOCK_CHAOS, BLOCK_RUBY, BLOCK_SAPPHIRE, BLOCK_COPPER,
				   BLOCK_ALUMINIUM, BLOCK_STEEL, BLOCK_TIN, BLOCK_TITANIUM, BLOCK_BRONZE,
				   BLOCK_MAGNITE, BLOCK_REINFORCED_STEEL);
		//Ores
		registerBlocks(ORE_ALUMINIUM, ORE_AMETHYST, ORE_CHAOS, ORE_COPPER, ORE_LITHIUM,
				   ORE_RUBY, ORE_SAPPHIRE, ROCK_ANCIENT, ORE_TIN, ORE_TITANIUM);
		//Machines
		registerBlocks(ANCIENT_GENERATOR, PYLON, ARTIFACT_ANALYZER, ALLOY_PRESS);
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityAncientGenerator.class, new ResourceLocation(Reference.MODID+":ancient_generator"));
		GameRegistry.registerTileEntity(TileEntityArtifactAnalyzer.class, new ResourceLocation(Reference.MODID+":artifact_analyzer"));
		GameRegistry.registerTileEntity(TileEntityPylon.class, new ResourceLocation(Reference.MODID+":pylon"));
		GameRegistry.registerTileEntity(TileEntityAlloyPress.class, new ResourceLocation(Reference.MODID+":alloy_press"));
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