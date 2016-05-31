package net.cc110.nbt;

import java.io.*;
import java.nio.charset.*;

public class NBTTagIntArray extends NBTTag<int[]>
{
	public byte getID()
	{
		return 11;
	}
	
	public void serialiseTo(DataOutput out) throws IOException
	{
		out.writeByte(getID());
		
		String name = getName();
		
		out.writeInt(name.length());
		out.write(name.getBytes(StandardCharsets.UTF_8));
		
		out.writeInt(payload.length);
		
		for(int i : payload)
		{
			out.writeInt(i);
		}
	}
	
	void readFrom(String name, NBTInput in) throws IOException
	{
		this.name = name;
		
		int payloadLength = in.readInt();
		
		payload = new int[payloadLength];
		
		if(payloadLength > 0)
		{
			for(int i = 0; i < payloadLength; i++)
			{
				payload[i] = in.readInt();
			}
		}
	}
}
