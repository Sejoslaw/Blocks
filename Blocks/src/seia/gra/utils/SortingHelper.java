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
		List<T> l = new ArrayList<T>();
		l.add(b);
		l.add(a);
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
	
	public static int reverseNumber(int n)
	{
		int reverse = 0;
		while(n != 0)
		{
			reverse = reverse * 10;
			reverse = reverse + (n % 10);
			n = (n / 10);
		}
		return reverse;
	}
	
	/**
	 * Card players method.
	 */
	public static <T extends Comparable<T>> T[] insertSort(T[] tab)
	{
		T x;
		int n = tab.length;
		for(int i = 1; i < n; i++)
		{
			x = tab[i];
			for(int j = 0; j < i; j++)
			{
				if(tab[j].compareTo(x) > 0) 
					break;
				for(int k = i; k > j; k--)
					tab[k] = tab[k - 1];
			}
		}
		return tab;
	}
	
	public static <T extends Comparable<T>> T[] selectionSort(T[] tab)
	{
		int n = tab.length;
		int nr;
		for(int i = 0; i < n - 1; i++)
		{
			T min = tab[i];
			nr = i;
			for(int j = i + 1; j < n; j++)
				if(tab[j].compareTo(min) < 0)
				{
					min = tab[j];
					nr = j;
				}
			List<T> l = change(tab[i], tab[nr]);
			tab[i] = l.get(0);
			tab[nr] = l.get(1);
		}
		return tab;
	}
	
	public static <T extends Comparable<T>> T[] reverse(T[] tab)
	{
		if(tab == null)
			return null;
		int i = 0;
		int j = tab.length - 1;
		T tmp;
		while(j > i)
		{
			tmp = tab[j];
			tab[j] = tab[i];
			tab[i] = tmp;
			j--;
			i++;
		}
		return tab;
	}
}