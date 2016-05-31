package net.cc110.nbt;

import java.io.*;
import java.nio.charset.*;

public class NBT
{
	public static NBTTagCompound readUncompressedStream(InputStream in) throws IOException
	{
		NBTInput nbtIn = new NBTInput(in instanceof DataInputStream ? (DataInputStream)in : new DataInputStream(in));
		
		NBTTagCompound result = new NBTTagCompound();
		
		int nameLength = nbtIn.readInt();
		
		if(nameLength == 0) result.readFrom("", nbtIn);
		else
		{
			byte[] nameBytes = new byte[nameLength];
			nbtIn.readFully(nameBytes);
			
			result.readFrom(new String(nameBytes, StandardCharsets.UTF_8), nbtIn);
		}
		
		return result;
	}
}
