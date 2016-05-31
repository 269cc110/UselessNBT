package net.cc110.nbt;

import java.io.*;
import java.nio.charset.*;

public class NBTTagLong extends NBTTag<Long>
{
	public byte getID()
	{
		return 4;
	}
	
	public void serialiseTo(DataOutput out) throws IOException
	{
		out.writeByte(getID());
		
		String name = getName();
		
		out.writeInt(name.length());
		out.write(name.getBytes(StandardCharsets.UTF_8));
		
		out.writeLong(payload);
	}
	
	void readFrom(String name, NBTInput in) throws IOException
	{
		this.name = name;
		
		payload = in.readLong();
	}
}
