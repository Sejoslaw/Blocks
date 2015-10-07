package seia.gra.block.movable.player;

import seia.gra.item.Item;
import seia.gra.item.ItemStack;

public class InventoryPlayer 
{
	public BlockPlayer player;
	public int inventorySize = 10;
	public ItemStack[] currentInventory = new ItemStack[inventorySize];
	public ItemStack currentlyInHand;
	
	public InventoryPlayer(BlockPlayer blockPlayer) 
	{
		player = blockPlayer;
	}
	
	public void addItemToInventory(int slot, Item item)
	{
		currentInventory[slot].stackSize++;
	}
	
	public int getFirstEmptySlot()
	{
		for(int i = 0; i < inventorySize; i++)
			if(currentInventory[i] == null)
				return i;
		return 0;
	}
	
	public boolean isItemValidForSlot(int slot, Item item)
	{
		ItemStack st = currentInventory[slot];
		if(st != null)
			if(st.item.itemID == item.itemID)
				if(st.stackSize < ItemStack.stackLimit)
					return true;
		return false;
	}
	
	public void addItemToFirstAvaiable(Item item)
	{
		for(int i = 0; i < inventorySize; i++)
		{
			ItemStack st = currentInventory[i];
			if(isItemValidForSlot(i, item))
			{
				addItemToInventory(i, item);
				return;
			}
			if(st == null)
			{
				currentInventory[i] = new ItemStack(item);
				return;
			}
			if(st.item == null)
			{
				currentInventory[i].addSingleItem(item);
				return;
			}
		}
	}
	
	public void clearSlot(int slot)
	{
		currentInventory[slot].emptyStack();
	}
}
