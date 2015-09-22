package seia.gra.item;

import java.util.ArrayList;

public class Item 
{
	public final int itemID;
	private Item itemContaining = null;
	public static ArrayList<Item> itemList = new ArrayList<Item>();
	
	public Item(int id)
	{
		itemID = id;
		itemList.add(this);
	}
	
	public Item setContainingItem(Item item)
	{
		itemContaining = item;
		return this;
	}
	
	public Item getContainingItem()
	{
		return itemContaining;
	}
	
	static
	{
		//TODO: Tu beda dodawane poszczegolne przedmioty
	}
}
