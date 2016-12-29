package kriNon.endernet.proxy;

import kriNon.endernet.tileentities.TileEntityEnderTransmitter;
import kriNon.endernet.util.Utils;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void registerRenders() {
		
	}
	
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityEnderTransmitter.class, "ender_transmitter");
	}
}
