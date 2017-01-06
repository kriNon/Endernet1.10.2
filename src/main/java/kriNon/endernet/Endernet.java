package kriNon.endernet;

import com.google.gson.Gson;

import kriNon.endernet.init.ModBlocks;
import kriNon.endernet.init.ModItems;
import kriNon.endernet.lib.EnderRegistry;
import kriNon.endernet.proxy.CommonProxy;
import kriNon.endernet.tileentities.TileEntityEnderTransmitter;
import kriNon.endernet.util.Utils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Endernet {
	
	

	@Mod.Instance(Reference.MODID)
	public static Endernet instance;
	
		public static Gson gson = new Gson();
	
	@SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
	public static CommonProxy proxy;

	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.registerTileEntities();
		ModItems.init();
		ModBlocks.init();
		ModItems.register();
		ModBlocks.register();
		
		proxy.registerRenders();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.regiserGUIHandler();

	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
	
	@EventHandler
	public void serverStart(FMLServerAboutToStartEvent event){
		try {
    		EnderRegistry.instance = new EnderRegistry(event.getServer().getFile("endernet-registry.json"));
    	} catch(Exception e) {
    		Utils.getLogger().error("Could not start EnderNet server!");
    		e.printStackTrace();
    	}
	}
	
	 @EventHandler
	    public void serverStop(FMLServerStoppingEvent event) {
	    	EnderRegistry.instance.save();
	    }
	
}
