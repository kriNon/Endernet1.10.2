package kriNon.endernet.client.gui;

import kriNon.endernet.container.ContainerEnderTransmitter;
import kriNon.endernet.tileentities.TileEntityEnderTransmitter;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiEnderTransmitter extends GuiContainer {

	private TileEntityEnderTransmitter te;
	private IInventory playerInv;
	
	public GuiEnderTransmitter(IInventory playerInv, TileEntityEnderTransmitter te) {
		super(new ContainerEnderTransmitter(playerInv, te));
		
		this.te = te;
		this.playerInv = playerInv;
		
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		int xo = (this.width - this.xSize) / 2;
        int yo = (this.height - this.ySize) / 2;
		this.mc.getTextureManager().bindTexture(new ResourceLocation("endernet:textures/gui/container/endertransmitter.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		int progressWidth = Math.min(44, te.getProgress() * 44 / te.getMaxProgress());
		this.drawTexturedModalRect(xo+66, yo+53, 44-progressWidth, 167, progressWidth, 4);	
		
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = this.te.getDisplayName().getUnformattedText();
		this.fontRendererObj.drawString(s, 88 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		this.fontRendererObj.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, 30, 4210752);
	}

}
