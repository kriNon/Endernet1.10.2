package kriNon.endernet.init;

import kriNon.endernet.Reference;
import kriNon.endernet.util.Utils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	//public static Item tinIngot;

	public static void init() {
		//tinIngot = new ItemTinIngot("tin_ingot", "tin_ingot");
	}
	public static void register() {
		//registerItem(tinIngot);
	}
	public static void registerRenders() {
		//registerRender(tinIngot);
	}
	public static void registerItem(Item item) {
		GameRegistry.register(item);
		Utils.getLogger().info("Registered Item" + item.getUnlocalizedName().substring(5));
	}
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Register Render for" + item.getUnlocalizedName().substring(5));
	}
}
