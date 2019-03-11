package com.builderboy426.randomplus.utils.handlers;

import com.builderboy426.randomplus.objects.blocks.container.ContainerAlloyPress;
import com.builderboy426.randomplus.objects.blocks.container.ContainerAncientGenerator;
import com.builderboy426.randomplus.objects.blocks.container.ContainerArtifactAnalyzer;
import com.builderboy426.randomplus.objects.blocks.gui.GuiAlloyPress;
import com.builderboy426.randomplus.objects.blocks.gui.GuiAncientGenerator;
import com.builderboy426.randomplus.objects.blocks.gui.GuiArtifactAnalyzer;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityAlloyPress;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityAncientGenerator;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityArtifactAnalyzer;
import com.builderboy426.randomplus.utils.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == Reference.GUI_ANCIENT_GENERATOR) { return new ContainerAncientGenerator(player.inventory, (TileEntityAncientGenerator)world.getTileEntity(new BlockPos(x, y, z))); }
		if (ID == Reference.GUI_ARTIFACT_ANALYZER) { return new ContainerArtifactAnalyzer(player.inventory, (TileEntityArtifactAnalyzer)world.getTileEntity(new BlockPos(x, y, z))); }
		if (ID == Reference.GUI_ALLOY_PRESS) { return new ContainerAlloyPress(player.inventory, (TileEntityAlloyPress)world.getTileEntity(new BlockPos(x, y, z))); }
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == Reference.GUI_ANCIENT_GENERATOR) { return new GuiAncientGenerator(player.inventory, (TileEntityAncientGenerator)world.getTileEntity(new BlockPos(x, y, z))); }
		if (ID == Reference.GUI_ARTIFACT_ANALYZER) { return new GuiArtifactAnalyzer(player.inventory, (TileEntityArtifactAnalyzer)world.getTileEntity(new BlockPos(x, y, z))); }
		if (ID == Reference.GUI_ALLOY_PRESS) { return new GuiAlloyPress(player.inventory, (TileEntityAlloyPress)world.getTileEntity(new BlockPos(x, y, z))); }
		return null;
	}
	
	
	
}