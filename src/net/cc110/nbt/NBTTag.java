package net.cc110.nbt;

import java.io.*;

public abstract class NBTTag<T>
{
	protected String name;
	protected T payload;
	
	public abstract byte getID();
	
	abstract void serialiseTo(DataOutput out) throws IOException;
	abstract void readFrom(String name, NBTInput in) throws IOException;
	
	public String getName()
	{
		return name;
	}
	
	T getPayload()
	{
		return payload;
	}
	
	//TODO LITERALLY EVERYTHING
}
