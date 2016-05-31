package net.cc110.nbt;

import java.io.*;
import java.util.*;
import java.nio.charset.*;

public class NBTTagCompound extends NBTTag<HashMap<String, NBTTag<Object>>>
{
	public byte getID()
	{
		return 10;
	}
	
	public void serialiseTo(DataOutput out) throws IOException
	{
		out.writeByte(getID());
		
		String name = getName();
		
		out.writeInt(name.length());
		out.write(name.getBytes(StandardCharsets.UTF_8));
		
		for(NBTTag<?> tag : payload.values())
		{
			tag.serialiseTo(out);
		}
		
		out.writeByte(0);
	}
	
	void readFrom(String name, NBTInput in) throws IOException
	{
		this.name = name;
		
		//TODO
	}
	
	public NBTTag<Object> add(NBTTag<Object> value)
	{
		payload.put(value.getName(), value);
		
		return value;
	}
	
	public NBTTag<Object> get(String key)
	{
		return payload.get(key);
	}
}
