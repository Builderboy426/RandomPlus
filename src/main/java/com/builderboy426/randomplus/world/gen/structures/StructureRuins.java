package com.builderboy426.randomplus.world.gen.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.builderboy426.randomplus.world.gen.generators.WorldGenStructure;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeSnow;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class StructureRuins implements IWorldGenerator {
	
	private static final WorldGenStructure RUINS = new WorldGenStructure("ruins");
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		if (world.provider.getDimension() == 1) {
			this.generateStructure(RUINS, world, random, chunkX, chunkZ, 100, Blocks.GRASS);
		}
		
	}
	
	public static void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock) {
		int x = (chunkX * 16) + random.nextInt(15) + 8;
		int z = (chunkZ * 16) + random.nextInt(15) + 8;
		int y = calculateGenerationHeight(world, x, z, topBlock);
		BlockPos pos = new BlockPos(x,y,z);
		
		Biome curBiome = world.provider.getBiomeForCoords(pos);
		
		if(world.getWorldType() != WorldType.FLAT) {
			if(curBiome == Biome.getBiome(1) || curBiome == Biome.getBiome(4)) { //Plains or Forest
				if(random.nextInt(chance) == 0) {
					generator.generate(world, random, pos);
				}
			}
		}
	}
	
	private static int calculateGenerationHeight(World world, int x, int z, Block topBlock) {
		int y = world.getHeight();
		boolean foundGround = false;
		
		while(!foundGround && y-- >= 0) {
			Block block = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			foundGround = block == topBlock;
		}
		
		return y;
	}
}