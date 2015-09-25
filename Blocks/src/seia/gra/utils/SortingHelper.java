package seia.gra.utils;

import java.util.ArrayList;
import java.util.List;

public class SortingHelper 
{
	/**
	 * After change in list:
	 * Pos 0 = a
	 * Pos 1 = b
	 */
	public static <T> List<T> change(T a, T b)
	{
		T tmp;
		tmp = a;
		a = b;
		b = tmp;
		List<T> l = new ArrayList<T>();
		l.add(a);
		l.add(b);
		return l;
	}
	
	public static <T extends Comparable<T>> T[] bubbleSort(T[] tab)
	{
		int n = tab.length;
		for(int i = 1; i < n; i++)
			for(int j = 0; j < n - i; j++)
				if(tab[j].compareTo(tab[j + 1]) > 0)
				{
					List<T> list = change(tab[j], tab[j + 1]);
					tab[j] = list.get(0);
					tab[j + 1] = list.get(1);
				}
		return tab;
	}
	
	public static String reverse(String s)
	{
		char[] in = s.toCharArray();
		int begin = 0;
		int end = in.length - 1;
		char tmp;
		while(end > begin)
		{
			tmp = in[begin];
			in[begin] = in[end];
			in[end] = tmp;
			end--;
			begin++;
		}
		return new String(in);
	}
	
	/**
	 * Card players method.
	 */
	public static <T extends Comparable<T>> T[] insertSort(T[] tab)
	{
		
	}
}
