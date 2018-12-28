package com.builderboy426.randomplus.objects.blocks.machines;

import java.util.Random;

import com.builderboy426.randomplus.Main;
import com.builderboy426.randomplus.init.BlockInit;
import com.builderboy426.randomplus.objects.blocks.BlockBase;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityAncientGenerator;
import com.builderboy426.randomplus.utils.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockAncientGenerator extends BlockBase {
	
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final PropertyBool BURNING = PropertyBool.create("burning");
	
	public BlockAncientGenerator(String name) {
		super(name, Material.IRON, 20.125f);
		setSoundType(SoundType.METAL);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(BURNING, false));
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		player.openGui(Main.instance, Reference.GUI_ANCIENT_GENERATOR, world, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
	
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		if (!world.isRemote) {
			IBlockState north = world.getBlockState(pos.north());
			IBlockState south = world.getBlockState(pos.south());
			IBlockState west = world.getBlockState(pos.west());
			IBlockState east = world.getBlockState(pos.east());
			EnumFacing face = (EnumFacing)state.getValue(FACING);
			
			if (face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) { face = EnumFacing.SOUTH; }
			else if (face == EnumFacing.SOUTH && !north.isFullBlock() && south.isFullBlock()) { face = EnumFacing.NORTH; }
			else if (face == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock()) { face = EnumFacing.EAST; }
			else if (face == EnumFacing.NORTH && !west.isFullBlock() && east.isFullBlock()) { face = EnumFacing.SOUTH; }
			world.setBlockState(pos, state.withProperty(FACING, face), 2);
		}
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityAncientGenerator();
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {BURNING,FACING});
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntityAncientGenerator tileEntity = (TileEntityAncientGenerator)world.getTileEntity(pos);
		world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), tileEntity.handler.getStackInSlot(0)));
		super.breakBlock(world, pos, state);
	}
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		world.setBlockState(pos, this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
	}
	
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
	}
	
	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirror) {
		return state.withRotation(mirror.toRotation((EnumFacing)state.getValue(FACING)));
	}
	
	@Override
	public int getHarvestLevel(IBlockState state) { return 2; }
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing facing = EnumFacing.getFront(meta);
		if (facing.getAxis() == EnumFacing.Axis.Y) { facing = EnumFacing.NORTH; }
		return this.getDefaultState().withProperty(FACING, facing);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing)state.getValue(FACING)).getIndex();
	}
	
	public static void setState(boolean active, World world, BlockPos pos) {
		IBlockState state = world.getBlockState(pos);
		TileEntity tileEntity = world.getTileEntity(pos);
		
		if (active) { world.setBlockState(pos, BlockInit.ANCIENT_GENERATOR.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(BURNING, true), 3); }
		else { world.setBlockState(pos, BlockInit.ANCIENT_GENERATOR.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(BURNING, false), 3); }
		
		if (tileEntity != null) {
			tileEntity.validate();
			world.setTileEntity(pos, tileEntity);
		}
	}
}