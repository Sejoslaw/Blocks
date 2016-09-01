package seia.gra.utils;

public interface IMathObject<T>
{	
	public IMathObject<T> add(T whatToAdd);
	
	public IMathObject<T> subtract(T whatToSubtract);
	
	public IMathObject<T> multiply(T multiplyBy);
	
	public IMathObject<T> divide(T divideBy);
}