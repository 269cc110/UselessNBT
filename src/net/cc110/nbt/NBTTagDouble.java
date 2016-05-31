package net.cc110.nbt;

import java.io.*;
import java.nio.charset.*;

public class NBTTagDouble extends NBTTag<Double>
{
	public byte getID()
	{
		return 6;
	}
	
	public void serialiseTo(DataOutput out) throws IOException
	{
		out.writeByte(getID());
		
		String name = getName();
		
		out.writeInt(name.length());
		out.write(name.getBytes(StandardCharsets.UTF_8));
		
		out.writeDouble(payload);
	}
	
	void readFrom(String name, NBTInput in) throws IOException
	{
		this.name = name;
		
		payload = in.readDouble();
	}
}
