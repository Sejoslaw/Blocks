package seia.gra.api.math;

public abstract interface IMathObject<T>
{
	public abstract T sum(T whatToAdd);				// +
	public abstract T subtract(T whatToSubtract);	// -
	public abstract T multiply(T multiplyBy);		// *
	public abstract T divide(T divideBy);			// /
}
