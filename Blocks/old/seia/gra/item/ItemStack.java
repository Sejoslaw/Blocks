package seia.gra.item;

public class ItemStack
{
	public Item item;
	public int stackSize;
	public static final int stackLimit = 100;
	
	public ItemStack(Item item)
	{
		this(item, 0);
	}
	
	public ItemStack(Item item, int stacksize)
	{
		this.item = item;
		if(stacksize > stackLimit)
		{
			stackSize = stackLimit;
		}
		else
		{
			stackSize = stacksize;
		}
	}
	
	public int getItemID()
	{
		return item.itemID;
	}
	
	public boolean equals(ItemStack stack)
	{
		if(item.itemID == stack.item.itemID)
		{
			if(stackSize == stack.stackSize)
			{
				return true;
			}
		}
		return false;
	}
	
    public ItemStack splitStack(int i)
    {
        ItemStack itemstack = new ItemStack(item);
        stackSize -= i;
        return itemstack;
    }
    
    public ItemStack setItem(Item item)
    {
    	this.item = item;
    	return this;
    }
    
    public ItemStack copy()
    {
    	return new ItemStack(item, stackSize);
    }
    
    public void emptyStack()
    {
    	item = null;
    	stackSize = 0;
    }
    
    public void increaseStackSize()
    {
    	if(stackSize < stackLimit)
    	{
    		stackSize++;
    	}
    }

	public void addSingleItem(Item item2) 
	{
		if(item == null)
		{
			item = item2;
			increaseStackSize();
		}
		else
		{
			increaseStackSize();
		}
	}
}