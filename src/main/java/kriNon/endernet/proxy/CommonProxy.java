package kriNon.endernet.proxy;

import kriNon.endernet.Endernet;
import kriNon.endernet.handlers.GuiHandler;
import kriNon.endernet.tileentities.TileEntityEnderTransmitter;
import kriNon.endernet.util.Utils;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void registerRenders() {
		
	}
	
	public void registerTileEntities() {
		Utils.getLogger().info("RegisterTileEntities Started");
		GameRegistry.registerTileEntity(TileEntityEnderTransmitter.class, "ender_transmitter");
		Utils.getLogger().info("RegisterTileEntities ender_transmitter");
	}
	
	public void regiserGUIHandler() {
		NetworkRegistry.INSTANCE.registerGuiHandler(Endernet.instance, new GuiHandler());
	}
}
