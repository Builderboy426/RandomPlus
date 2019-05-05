package com.builderboy426.randomplus.world.gen;

import java.util.Random;

import com.builderboy426.randomplus.init.BlockInit;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustomOres implements IWorldGenerator {
	
	private WorldGenerator ore_ruby, ore_sapphire, ore_amethyst,
						 ore_chaos, ore_ancient, ore_copper,
						 ore_aluminium, ore_tin, ore_lithium, 
						 ore_titanium;
	
	public WorldGenCustomOres() {
		ore_ruby = new WorldGenMinable(BlockInit.ORE_RUBY.getDefaultState(), 4, BlockMatcher.forBlock(Blocks.STONE));
		ore_sapphire = new WorldGenMinable(BlockInit.ORE_SAPPHIRE.getDefaultState(), 4, BlockMatcher.forBlock(Blocks.STONE));
		ore_amethyst = new WorldGenMinable(BlockInit.ORE_AMETHYST.getDefaultState(), 4, BlockMatcher.forBlock(Blocks.STONE));
		ore_chaos = new WorldGenMinable(BlockInit.ORE_CHAOS.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE));
		ore_ancient = new WorldGenMinable(BlockInit.ROCK_ANCIENT.getDefaultState(), 10, BlockMatcher.forBlock(Blocks.STONE));
		ore_copper = new WorldGenMinable(BlockInit.ORE_COPPER.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.STONE));
		ore_tin= new WorldGenMinable(BlockInit.ORE_TIN.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.STONE));
		ore_aluminium = new WorldGenMinable(BlockInit.ORE_ALUMINIUM.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.STONE));
		ore_lithium = new WorldGenMinable(BlockInit.ORE_LITHIUM.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE));
		ore_titanium = new WorldGenMinable(BlockInit.ORE_TITANIUM.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE));
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.getDimension()) {
			case -1: //Nether
			break;
			case 0: //Overworld
				runGenerator(ore_ruby, world, random, chunkX, chunkZ, 13, 0, 40);
				runGenerator(ore_sapphire, world, random, chunkX, chunkZ, 13, 0, 40);
				runGenerator(ore_amethyst, world, random, chunkX, chunkZ, 13, 0, 40);
				runGenerator(ore_chaos, world, random, chunkX, chunkZ, 3, 5, 10);
				runGenerator(ore_ancient, world, random, chunkX, chunkZ, 2, 15, 50);
				runGenerator(ore_copper, world, random, chunkX, chunkZ, 15, 15, 65);
				runGenerator(ore_aluminium, world, random, chunkX, chunkZ, 15, 15, 50);
				runGenerator(ore_tin, world, random, chunkX, chunkZ, 15, 15, 50);
				runGenerator(ore_lithium, world, random, chunkX, chunkZ, 10, 0, 25);
				runGenerator(ore_titanium, world, random, chunkX, chunkZ, 10, 0, 25);
			break;
			case 1: //End
			break;
		}
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight) {
		if (minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore Generated out of bounds");
		
		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chance; i++) {
			int x = chunkX*16+rand.nextInt(16);
			int y = minHeight+rand.nextInt(chance);
			int z = chunkZ*16+rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x, y, z));
		}
	}
}