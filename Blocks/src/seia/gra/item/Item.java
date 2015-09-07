package seia.gra.item;

public class Item 
{
	public final int itemID;
	private Item itemContaining = null;
	
	public Item(int id)
	{
		itemID = id;
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
}
