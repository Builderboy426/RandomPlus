package com.builderboy426.randomplus.objects.blocks.machines;

import com.builderboy426.randomplus.Main;
import com.builderboy426.randomplus.objects.blocks.BlockBase;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityChaosEnergizer;
import com.builderboy426.randomplus.utils.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockChaosEnergizer extends BlockBase {

	public BlockChaosEnergizer(String name, Material material, float hardness, int harvest) {
		super(name, material, hardness, harvest);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			player.openGui(Main.instance, Reference.GUI_CHAOS_ENERGIZER, world, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
	
	@Override
	public boolean hasTileEntity() {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityChaosEnergizer();
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntityChaosEnergizer tileEntity = (TileEntityChaosEnergizer)world.getTileEntity(pos);
		world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), tileEntity.handler.getStackInSlot(0)));
		world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), tileEntity.handler.getStackInSlot(1)));
		super.breakBlock(world, pos, state);
	}
}