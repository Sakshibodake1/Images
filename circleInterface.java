	import java.rmi.*;
	
	public interface circleInterface extends Remote                       //We want to results remotely
	{
	    public double area(int radius) throws RemoteException;	    
	    public double perimeter(int radius) throws RemoteException;
	}
