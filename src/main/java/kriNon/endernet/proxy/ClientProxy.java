package kriNon.endernet.proxy;

import kriNon.endernet.init.ModBlocks;
import kriNon.endernet.init.ModItems;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenders() {
		ModItems.registerRenders();
		ModBlocks.registerRenders();
	}
}
