package kriNon.endernet.blocks;

import java.util.Random;

import kriNon.endernet.Reference;
import kriNon.endernet.tileentities.TileEntityEnderTransmitter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockEnderTransmitter extends Block{
	public BlockEnderTransmitter(String unlocalizedName, String registryName) {
		super(Material.ROCK);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, registryName));
		this.setHardness(3);
		this.setResistance(20);
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state){
	return true;
	}
	
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
    	return new TileEntityEnderTransmitter();
    }
	
}
