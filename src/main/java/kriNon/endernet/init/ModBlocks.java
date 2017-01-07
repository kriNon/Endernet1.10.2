package kriNon.endernet.init;

import kriNon.endernet.Reference;
import kriNon.endernet.blocks.BlockEnderTransmitter;
import kriNon.endernet.blocks.BlockEnderReceiver;
import kriNon.endernet.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block ender_receiver;
	public static Block ender_transmitter;


	public static void init() {
		ender_receiver = new BlockEnderReceiver("ender_receiver", "ender_receiver");
		ender_transmitter = new BlockEnderTransmitter("ender_transmitter", "ender_transmitter");

	}
	
	public static void register() {
		registerBlock(ender_receiver);
		registerBlock(ender_transmitter);
	}
	
	public static void registerRenders() {
		registerRender(ender_receiver);
		registerRender(ender_transmitter);
	}
	
	public static void registerBlock(Block block) {
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered Block:" + block.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered Render for" + block.getUnlocalizedName().substring(5));
	}
	
}
