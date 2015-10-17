package seia.gra.utils;

import seia.gra.api.math.ILogicObject;

public class LogicHandler 
{
	public static boolean AND(ILogicObject o1, ILogicObject o2)
	{
		if(o1.isSendingSignal() && o2.isSendingSignal())
			return true;
		return false;
	}
	
	public static boolean AND(ILogicObject[] ot)
	{
		for(int i = 0; i < ot.length; i++)
			if(!(ot[i].isSendingSignal()))
				return false;
		return true;
	}
	
	public static boolean OR(ILogicObject o1, ILogicObject o2)
	{
		if(o1.isSendingSignal() || o2.isSendingSignal())
			return true;
		return false;
	}
	
	public static boolean OR(ILogicObject[] ot)
	{
		for(int i = 0; i < ot.length; i++)
			if(ot[i].isSendingSignal())
				return true;
		return false;
	}
	
	public static boolean NOT(ILogicObject o)
	{
		return !o.isSendingSignal();
	}
	
	public static boolean NAND(ILogicObject o1, ILogicObject o2)
	{
		return !AND(o1, o2);
	}
	
	public static boolean NAND(ILogicObject[] ot)
	{
		return !AND(ot);
	}
	
	public static boolean NOR(ILogicObject o1, ILogicObject o2)
	{
		return !OR(o1, o2);
	}
	
	public static boolean NOR(ILogicObject[] ot)
	{
		return !OR(ot);
	}
	
	public static boolean XOR(ILogicObject o1, ILogicObject o2)
	{
		if(o1.isSendingSignal() && !(o2.isSendingSignal()))
			return true;
		else if(!(o1.isSendingSignal()) && o2.isSendingSignal())
			return true;
		else
			return false;
	}
	
	public static boolean XNOR(ILogicObject o1, ILogicObject o2)
	{
		return !XOR(o1, o2);
	}
	
}
