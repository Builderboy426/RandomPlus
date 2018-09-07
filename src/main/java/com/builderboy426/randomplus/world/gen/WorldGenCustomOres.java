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
	
	private WorldGenerator ore_ruby, ore_sapphire, ore_amethyst, ore_chaos, ore_ancient;
	
	public WorldGenCustomOres() {
		ore_ruby = new WorldGenMinable(BlockInit.ORE_RUBY.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.STONE));
		ore_sapphire = new WorldGenMinable(BlockInit.ORE_SAPPHIRE.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.STONE));
		ore_amethyst = new WorldGenMinable(BlockInit.ORE_AMETHYST.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.STONE));
		ore_chaos = new WorldGenMinable(BlockInit.ORE_CHAOS.getDefaultState(), 4, BlockMatcher.forBlock(Blocks.STONE));
		ore_ancient = new WorldGenMinable(BlockInit.ROCK_ANCIENT.getDefaultState(), 15, BlockMatcher.forBlock(Blocks.STONE));
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.getDimension()) {
			case -1: //Nether
			break;
			case 0: //Overworld
				runGenerator(ore_ruby, world, random, chunkX, chunkZ, 10, 0, 40);
				runGenerator(ore_sapphire, world, random, chunkX, chunkZ, 10, 0, 40);
				runGenerator(ore_amethyst, world, random, chunkX, chunkZ, 10, 0, 40);
				runGenerator(ore_chaos, world, random, chunkX, chunkZ, 1, 0, 10);
				runGenerator(ore_ancient, world, random, chunkX, chunkZ, 1, 15, 50);
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