package kriNon.endernet.blocks;

import java.util.Random;

import ibxm.Player;
import kriNon.endernet.Endernet;
import kriNon.endernet.Reference;
import kriNon.endernet.handlers.GuiHandler;
import kriNon.endernet.tileentities.TileEntityEnderReceiver;
import kriNon.endernet.tileentities.TileEntityEnderTransmitter;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;


public class BlockEnderReceiver extends Block{

	public BlockEnderReceiver(String unlocalizedName, String registryName) {
		super(Material.ROCK);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, registryName));
		this.setHardness(3);
		this.setResistance(20);
	}
	
@Override
public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
	if(!worldIn.isRemote) {
		TileEntityEnderReceiver te = (TileEntityEnderReceiver) worldIn.getTileEntity(pos);
		playerIn.addChatComponentMessage(new TextComponentString("EnderNet ID: " + te.getEndernetID()));
	}
	return true;
}
		
	@Override
	public boolean hasTileEntity(IBlockState state){
	return true;
	}
	
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
    	return new TileEntityEnderReceiver();
    }
	
    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState blockstate) {
        TileEntityEnderReceiver te = (TileEntityEnderReceiver) world.getTileEntity(pos);
        InventoryHelper.dropInventoryItems(world, pos, te);
        super.breakBlock(world, pos, blockstate);
    }

}
