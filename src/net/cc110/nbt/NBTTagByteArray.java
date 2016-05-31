package net.cc110.nbt;

import java.io.*;
import java.util.*;
import java.nio.charset.*;

public class NBTTagByteArray extends NBTTag<List<Byte>>
{
	public byte getID()
	{
		return 7;
	}
	
	public void serialiseTo(DataOutput out) throws IOException
	{
		out.writeByte(getID());
		
		String name = getName();
		
		out.writeInt(name.length());
		out.write(name.getBytes(StandardCharsets.UTF_8));
		
		int payloadLength = payload.size();
		
		out.writeInt(payloadLength);
		
		byte[] payloadBuffer = new byte[payloadLength];
		
		for(int i = 0; i < payloadLength; i++)
		{
			payloadBuffer[i] = payload.get(i);
		}
		
		out.write(payloadBuffer);
	}
	
	void readFrom(String name, NBTInput in) throws IOException
	{
		this.name = name;
		
		int payloadLength = in.readInt();
		
		payload = new ArrayList<Byte>();
		
		if(payloadLength > 0)
		{
			byte[] payloadBuffer = new byte[payloadLength];
			in.readFully(payloadBuffer);
			
			for(byte b : payloadBuffer)
			{
				payload.add(b);
			}
		}
	}
}
