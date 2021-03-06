package com.builderboy426.randomplus.objects.blocks.gui;

import com.builderboy426.randomplus.objects.blocks.container.ContainerAncientGenerator;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityAncientGenerator;
import com.builderboy426.randomplus.utils.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiAncientGenerator extends GuiContainer {
	
	private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/ancient_generator.png");
	private final InventoryPlayer player;
	private final TileEntityAncientGenerator tileentity;
	
	public GuiAncientGenerator(InventoryPlayer player, TileEntityAncientGenerator tileentity) 
	{
		super(new ContainerAncientGenerator(player, tileentity));
		this.player = player;
		this.tileentity = tileentity;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
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
		this.fontRenderer.drawString(Integer.toString(this.tileentity.getEnergyStored())+" RF", 115, 72, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURES);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		int l = this.getCookProgressScaled(24);
		this.drawTexturedModalRect(this.guiLeft + 113, this.guiTop + 32, 176, 14, l+1, 16);
		
		int k = this.getEnergyStoredScaled(73);
		this.drawTexturedModalRect(this.guiLeft + 152, this.guiTop + 7, 176, 32, 16, 73 - k);
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
		float j = (float)40;
		return j != 0 ? (int)((i/j)*pixels) : 0;
	}
}