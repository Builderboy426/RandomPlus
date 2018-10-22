package com.builderboy426.randomplus.objects.blocks.gui;

import com.builderboy426.randomplus.objects.blocks.container.ContainerArtifactAnalyzer;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityAncientGenerator;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityArtifactAnalyzer;
import com.builderboy426.randomplus.utils.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiArtifactAnalyzer extends GuiContainer {
	
	private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/artifact_analyzer.png");
	private final InventoryPlayer player;
	private final TileEntityArtifactAnalyzer tileentity;
	
	public GuiArtifactAnalyzer(InventoryPlayer player, TileEntityArtifactAnalyzer tileentity) 
	{
		super(new ContainerArtifactAnalyzer(player, tileentity));
		this.player = player;
		this.tileentity = tileentity;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		String tileName = this.tileentity.getDisplayName().getUnformattedText();
		this.fontRenderer.drawString(tileName, (this.xSize / 2 - this.fontRenderer.getStringWidth(tileName) / 2) -5, 6, 4210752);
		this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 7, this.ySize - 96 + 2, 4210752);
		this.fontRenderer.drawString(Integer.toString(this.tileentity.getEnergyStored()), 115, 72, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURES);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		int l = this.getCookProgressScaled(24);
		this.drawTexturedModalRect(this.guiLeft + 113, this.guiTop + 32, 176, 14, l + 1, 16);
		
		int k = this.getEnergyStoredScaled(75);
		this.drawTexturedModalRect(this.guiLeft + 152, this.guiTop + 7, 176, 32, 16, 76 - k);
	}
	
	private int getEnergyStoredScaled(int pixels)
	{
		float i = (float)this.tileentity.getEnergyStored();
		float j = (float)this.tileentity.getMaxEnergyStored();
		return j != 0 ? (int)(i / j * pixels) : 0;
	}
	
	private int getCookProgressScaled(int pixels)
	{
		float i = (float)this.tileentity.cookTime;
		float j = (float)this.tileentity.getMaxCook();
		System.out.println("Current: "+i);
		System.out.println("Maximum: "+j);
		return j != 0 ? (int)(i / j * pixels) : 0;
	}
}