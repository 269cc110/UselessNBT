package net.cc110.nbt;

import java.io.*;
import java.nio.charset.*;

public class NBTInput implements DataInput
{
	private final DataInput wrapped;
	
	public NBTInput(DataInput in)
	{
		wrapped = in;
	}
	
	// dammit
	public void readFully(byte[] b) throws IOException
	{
		wrapped.readFully(b);
	}
	
	// Java
	public void readFully(byte[] b, int off, int len) throws IOException
	{
		wrapped.readFully(b, off, len);
	}
	
	// is
	public int skipBytes(int n) throws IOException
	{
		return wrapped.skipBytes(n);
	}
	
	// this
	public boolean readBoolean() throws IOException
	{
		return wrapped.readBoolean();
	}
	
	// all
	public byte readByte() throws IOException
	{
		return wrapped.readByte();
	}
	
	// really
	public int readUnsignedByte() throws IOException
	{
		return wrapped.readUnsignedByte();
	}
	
	// necessary
	public short readShort() throws IOException
	{
		return wrapped.readShort();
	}
	
	// I
	public int readUnsignedShort() throws IOException
	{
		return wrapped.readUnsignedShort();
	}
	
	// mean
	public char readChar() throws IOException
	{
		return wrapped.readChar();
	}
	
	// really
	public int readInt() throws IOException
	{
		return wrapped.readChar();
	}
	
	// why
	public long readLong() throws IOException
	{
		return wrapped.readLong();
	}
	
	// isn't
	public float readFloat() throws IOException
	{
		return wrapped.readFloat();
	}
	
	// true
	public double readDouble() throws IOException
	{
		return wrapped.readDouble();
	}
	
	// encapsulation
	public String readLine() throws IOException
	{
		return wrapped.readLine();
	}
	
	// a feature
	public String readUTF() throws IOException
	{
		return wrapped.readUTF();
	}
	
	public NBTTag<?> readTag() throws IOException
	{
		NBTTag<?> result = null;
		
		byte id = readByte(); // fairly sure handled somewhere else
		
		switch(id) //TODO MORE TAGS
		{
			case 1:
				result = new NBTTagByte();
				break;
			case 2:
				result = new NBTTagShort();
				break;
			case 3:
				result = new NBTTagInt();
				break;
			case 4:
				result = new NBTTagLong();
				break;
			case 5:
				result = new NBTTagFloat();
				break;
			case 6:
				result = new NBTTagDouble();
				break;
			case 7:
				result = new NBTTagByteArray();
				break;
			case 8:
				result = new NBTTagString();
				
		}
		
		int nameLength = readInt();
		
		if(nameLength == 0) result.readFrom("", this);
		else
		{
			byte[] nameBytes = new byte[nameLength];
			readFully(nameBytes);
			
			result.readFrom(new String(nameBytes, StandardCharsets.UTF_8), this);
		}
		
		return result;
	}
}
