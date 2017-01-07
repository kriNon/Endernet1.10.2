package kriNon.endernet.handlers;

import kriNon.endernet.client.gui.GuiEnderTransmitter;
import kriNon.endernet.container.ContainerEnderTransmitter;
import kriNon.endernet.tileentities.TileEntityEnderTransmitter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public static final int ENDER_TRANSMITTER = 0;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == ENDER_TRANSMITTER){
			return new ContainerEnderTransmitter(player.inventory, (TileEntityEnderTransmitter) world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == ENDER_TRANSMITTER){
			return new GuiEnderTransmitter(player.inventory, (TileEntityEnderTransmitter) world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}

}
