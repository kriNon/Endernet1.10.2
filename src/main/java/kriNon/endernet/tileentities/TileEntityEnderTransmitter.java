package kriNon.endernet.tileentities;

import java.util.ArrayList;
import kriNon.endernet.util.Utils;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityEnderTransmitter extends TileEntity implements ITickable{

	private boolean aBoolean;
	private byte aByte;
	private short aShort;
	private long aLong;
	private int aInt;
	private float aFloat;
	private double aDouble;
	private String aString;
	private byte[] aByteArray;
	private int[] aIntArray;

	private ItemStack aItemStack;
	private ArrayList aArrayList = new ArrayList();
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		
		nbt.setBoolean("aBoolean", aBoolean);
		nbt.setByte("aByte", aByte);
		nbt.setShort("aShort", aShort);
		nbt.setLong("aLong", aLong);
		nbt.setInteger("aInt", aInt);
		nbt.setFloat("aFloat", aFloat);
		nbt.setDouble("aDouble", aDouble);
		nbt.setString("aString", aString);
		nbt.setByteArray("aByteArray", aByteArray);
		nbt.setIntArray("aIntArray", aIntArray);
		
		//ITEMSTACK
		NBTTagCompound stack = new NBTTagCompound();
		this.aItemStack.writeToNBT(stack);
		nbt.setTag("aItemStack", stack);
		
		//TagList of IntegerTags
		NBTTagList list = new NBTTagList();
		for(int i = 0; i < this.aArrayList.size(); i++) {
			NBTTagCompound compound = new NBTTagCompound();
			nbt.setInteger("id", i);
			nbt.setInteger("value", (Integer) this.aArrayList.get(i));
			list.appendTag(compound);
		}
		nbt.setTag("aArraylist", list);
		return nbt;
		
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		
		this.aBoolean = nbt.getBoolean("aBoolean");
		this.aByte = nbt.getByte("aByte");
		this.aShort = nbt.getShort("aShort");
		this.aLong = nbt.getLong("aLong");
		this.aInt = nbt.getInteger("aInt");
		this.aFloat = nbt.getFloat("aFloat");
		this.aDouble = nbt.getDouble("aDouble");
		this.aString = nbt.getString("aString");
		this.aByteArray = nbt.getByteArray("aByteArray");
		this.aIntArray = nbt.getIntArray("aIntArray");
		
		//ItemStack
		this.aItemStack = ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("aItemStack"));
		
		//TagList of Integer Tags
		NBTTagList list = nbt.getTagList("aArrayList", 10);
		this.aArrayList.clear();
		for(int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound compound = list.getCompoundTagAt(i);
			int id = compound.getInteger("id");
			int value = compound.getInteger("value");
			this.aArrayList.ensureCapacity(id);
			this.aArrayList.set(id, value);
		}
	}

	@Override
	public void update() {
		if(this.worldObj.isRemote) {
			Utils.getLogger().info("Updated in tile entity");
			Utils.getLogger().info("AINT = " + aInt);
			aInt++;
		}
		
	}
}
