package seia.gra.utils;

public class Stack 
{
	private Stack() {}
	
	public class StackElement<T>
	{
		public StackElement<T> predecessor; //poprzednik
		public T value;
	}
	
	public abstract class StackAbstract<T>
	{
		public StackElement<T> TOP = null;
		public int size = 0;
		
		/**
		 * {
		 * 		StackElement<T> newElement = new StackElement<T>();
		 * 		newElement.value = value;
		 * 		newElement.predecessor = TOP;
		 * 		TOP = newElement;
		 * 		size++;
		 * }
		 * 
		 * @return - The element that was pushed.
		 */
		public abstract T push(T value);
		
		/**
		 * {
		 * 		T value2 = TOP.value;
		 * 		StackElement<T> helper = TOP;
		 * 		TOP = TOP.predecessor;
		 * 		if ( TOP != null ) 
		 * 			size--;
		 * 		return value2;
		 * }
		 * 
		 * @return - The element that was poped.
		 */
		public abstract T pop();
	}
	
}
