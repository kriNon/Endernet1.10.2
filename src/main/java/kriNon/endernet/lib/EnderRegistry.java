package kriNon.endernet.lib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.HashSet;

import kriNon.endernet.Endernet;

public class EnderRegistry {
	class RegistryInformation {
		HashSet<Integer> addresses;
		int maxAddress;
		
		public void init() {
			addresses = new HashSet<Integer>();
			maxAddress = 0;
		}
		
		public void updateAddresses() {
			if(addresses.contains(maxAddress)) {
				// New address added, look up
				while(addresses.contains(maxAddress)) maxAddress++;
			} else {
				// Old address removed, look down
				while(!addresses.contains(maxAddress)) maxAddress--;
				maxAddress++;
			}
		}
	}

	public static EnderRegistry instance;
	
	private RegistryInformation r;
	private final HashMap<Integer, Object> objects = new HashMap<Integer, Object>();
	private final File file;
	
	public EnderRegistry(File file) {
		this.file = file;
		try {
			r = (RegistryInformation)(Endernet.gson.fromJson(new FileReader(file), RegistryInformation.class));
		} catch(FileNotFoundException e) {
			r = new RegistryInformation();
			r.init();
		}
	}
	
	public int register(Object o) {
		r.updateAddresses();
		int address = r.maxAddress;
		r.addresses.add(address);
		objects.put(address, o);
		r.updateAddresses();
		return address;
	}
	
	public void unregister(int address) {
		r.addresses.remove(address);
		objects.remove(address);
		r.updateAddresses();
	}
	
	public Object get(int address) {
		return objects.get(address);
	}
	
	public void set(int address, Object o) {
		objects.put(address, o);
		r.updateAddresses();
	}
	
	public void save() {
		try {
			Endernet.gson.toJson(r, new FileWriter(file));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
