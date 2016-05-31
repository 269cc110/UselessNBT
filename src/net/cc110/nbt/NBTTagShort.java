package net.cc110.nbt;

import java.io.*;
import java.nio.charset.*;

public class NBTTagShort extends NBTTag<Short>
{
	public byte getID()
	{
		return 2;
	}
	
	public void serialiseTo(DataOutput out) throws IOException
	{
		out.writeByte(getID());
		
		String name = getName();
		
		out.writeInt(name.length());
		out.write(name.getBytes(StandardCharsets.UTF_8));
		
		out.writeShort(payload);
	}
	
	void readFrom(String name, NBTInput in) throws IOException
	{
		this.name = name;
		
		payload = in.readShort();
	}
}
