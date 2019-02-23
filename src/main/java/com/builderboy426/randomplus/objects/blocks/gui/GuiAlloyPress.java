package com.builderboy426.randomplus.objects.blocks.gui;

import com.builderboy426.randomplus.objects.blocks.container.ContainerAlloyPress;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityAlloyPress;
import com.builderboy426.randomplus.utils.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiAlloyPress extends GuiContainer {
	
	private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/alloy_press.png");
	private final InventoryPlayer player;
	private final TileEntityAlloyPress tileentity;
	
	public GuiAlloyPress(InventoryPlayer player, TileEntityAlloyPress tileentity) 
	{
		super(new ContainerAlloyPress(player, tileentity));
		this.player = player;
		this.tileentity = tileentity;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		super.drawScreen(mouseX, mouseY, partialTicks);
		super.renderHoveredToolTip(mouseX, mouseY);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		String tileName = this.tileentity.getDisplayName().getUnformattedText();
		this.fontRenderer.drawString(tileName, (this.xSize / 2 - this.fontRenderer.getStringWidth(tileName) / 2) -5, 6, 4210752);
		this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 7, this.ySize - 96 + 2, 4210752);
		this.fontRenderer.drawString(Integer.toString(this.tileentity.getTemperature())+"°C", 115, 62, 4210752);
		this.fontRenderer.drawString(Integer.toString(this.tileentity.getEnergyStored())+" RF", 115, 72, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		this.drawDefaultBackground();
		
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURES);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		int l = this.getCookProgressScaled(24);
		this.drawTexturedModalRect(this.guiLeft + 64, this.guiTop + 32, 176, 14, l+1, 16);
		
		int k = this.getEnergyStoredScaled(73);
		this.drawTexturedModalRect(this.guiLeft + 152, this.guiTop + 7, 176, 32, 16, 73 - k);
		
		int j = this.getTempProgressScaled(45);
		this.drawTexturedModalRect(this.guiLeft + 145, this.guiTop + 7, 193, 32, 16, 45 - j);
	}
	
	private int getEnergyStoredScaled(int pixels)
	{
		float i = (float)this.tileentity.getEnergyStored();
		float j = (float)this.tileentity.getMaxEnergyStored();
		int compare = (int)(i/j);
		if (compare == 1) { return pixels+1; }
		return j != 0 ? (int)((i / j)*pixels) : 0;
	}
	
	private int getCookProgressScaled(int pixels)
	{
		float i = (float)this.tileentity.getCookTime();
		float j = (float)200;
		return j != 0 ? (int)((i/j)*pixels) : 0;
	}
	
	private int getTempProgressScaled(int pixels)
	{
		float i = (float)this.tileentity.getTemperature();
		float j = (float)this.tileentity.getMaxTemp();
		return j != 0 ? (int)((i/j)*pixels) : 0;
	}
}