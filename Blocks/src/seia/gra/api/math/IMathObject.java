package seia.gra.api.math;

/**
 * Try to use something like "return this;" in each method.
 * @author Krzysztof Dobrzynski
 * @param <T>
 */
public interface IMathObject<T>
{	
	public IMathObject<T> add(T whatToAdd);				// +
	public IMathObject<T> subtract(T whatToSubtract);	// -
	public IMathObject<T> multiply(T multiplyBy);		// *
	public IMathObject<T> divide(T divideBy);			// /
}
