package net.cc110.nbt;

import java.io.*;
import java.util.*;

/**
 * entirely broken
 */
public class NBTTagList<E extends NBTTag<?>> extends NBTTag<List<E>>
{
	private byte listType; // somewhere over the rainbow
	
	public byte getID()
	{
		return 9;
	}
	
	void serialiseTo(DataOutput out) throws IOException
	{
		if(payload.size() > 0)
		{
			out.writeByte(payload.get(0).getID());
			
			out.writeByte(listType);
			out.writeInt(payload.size());
			
			for(NBTTag<?> tag : payload)
			{
				tag.serialiseTo(out); //TODO deal with names
			}
		}
	}
	
	@Deprecated
	void readFrom(String name, NBTInput in) throws IOException
	{
		payload = new ArrayList<E>();
		
		int length = in.readInt();
		
		for(int i = 0; i < length; i++)
		{
			E element = (E)new NBTTag<List<E>>(); // ?
		}
	}
	
	static <T extends NBTTag<?>> NBTTagList<T> read(String name, NBTInput in) throws IOException
	{
		NBTTagList<T> result = new NBTTagList<T>();
		
		result.readFrom(name, in); //TODO make it work
		
		return result;
	}
}
