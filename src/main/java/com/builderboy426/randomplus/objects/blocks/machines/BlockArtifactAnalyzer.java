package com.builderboy426.randomplus.objects.blocks.machines;

import java.util.Random;

import com.builderboy426.randomplus.Main;
import com.builderboy426.randomplus.init.BlockInit;
import com.builderboy426.randomplus.objects.blocks.BlockBase;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityArtifactAnalyzer;
import com.builderboy426.randomplus.utils.Reference;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockArtifactAnalyzer extends BlockBase {
	
	public BlockArtifactAnalyzer(String name) { super(name, Material.IRON, 20.125f); }
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		player.openGui(Main.instance, Reference.GUI_ARTIFACT_ANALYZER, world, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityArtifactAnalyzer();
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntityArtifactAnalyzer tileEntity = (TileEntityArtifactAnalyzer)world.getTileEntity(pos);
		world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), tileEntity.handler.getStackInSlot(0)));
		world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), tileEntity.handler.getStackInSlot(1)));
		world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), tileEntity.handler.getStackInSlot(2)));
		super.breakBlock(world, pos, state);
	}
	
	@Override
	public int getHarvestLevel(IBlockState state) { return 2; }
}