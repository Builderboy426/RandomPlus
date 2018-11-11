/*package com.builderboy426.randomplus.objects.blocks.machines;

import java.util.Random;

import com.builderboy426.randomplus.Main;
import com.builderboy426.randomplus.init.BlockInit;
import com.builderboy426.randomplus.objects.blocks.BlockBase;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityAncientGenerator;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityPylon;
import com.builderboy426.randomplus.utils.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockPylon extends BlockBase {

	public BlockPylon(String name) { super(name, Material.IRON, 20.125f); }
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		player.openGui(Main.instance, Reference.GUI_PYLON, world, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) { return true; }
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) { return new TileEntityPylon(); }
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) { super.breakBlock(world, pos, state); }
	
	@Override
	public int getHarvestLevel(IBlockState state) { return 2; }
}*/