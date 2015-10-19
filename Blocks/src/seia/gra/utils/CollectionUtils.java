package seia.gra.utils;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtils 
{
	public static <T> Object[] toObjectArray(List<T> list)
	{
		Object[] obt = new Object[list.size()];
		for(int i = 0; i < list.size(); i++)
			obt[i] = list.get(i);
		return obt;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[] toArray(List<T> list)
	{
		return (T[]) toObjectArray(list);
	}
	
	public static <T> List<Object> toObjectList(T[] array)
	{
		List<Object> obl = new ArrayList<Object>();
		for(int i = 0; i < array.length; i++)
			obl.add(array[i]);
		return obl;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> toList(T[] array)
	{
		return (List<T>) toObjectList(array);
	}
}
