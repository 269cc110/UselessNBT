package net.cc110.nbt;

import java.io.*;
import java.nio.charset.*;

public class NBTTagString extends NBTTag<String>
{
	public byte getID()
	{
		return 8;
	}
	
	public void serialiseTo(DataOutput out) throws IOException
	{
		out.writeByte(getID());
		
		String name = getName();
		
		out.writeInt(name.length());
		out.write(name.getBytes(StandardCharsets.UTF_8));
		
		byte[] payloadBytes = payload.getBytes(StandardCharsets.UTF_8);
		
		int maxLength = payloadBytes.length & 0xFFFF;
		
		out.writeShort(maxLength);
		out.write(payloadBytes, 0, maxLength);
	}
	
	void readFrom(String name, NBTInput in) throws IOException
	{
		this.name = name;
		
		int payloadByteLength = in.readInt();
		
		if(payloadByteLength > 0)
		{
			byte[] payloadBytes = new byte[payloadByteLength];
			
			in.readFully(payloadBytes);
			
			payload = new String(payloadBytes, StandardCharsets.UTF_8);
		}
		else payload = "";
	}
}
