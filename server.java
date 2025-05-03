import java.rmi.*;		
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.*; 
public class server
{
    public server() throws RemoteException
    {
        super();
    }
    public static void main(String args[]) throws RemoteException
    {
        Registry reg=LocateRegistry.createRegistry(2000);
        circleImplementation ci=new circleImplementation();
        reg.rebind("circle",ci);
        System.out.println("|-|-|-|-|-|-|-|-|-|-|");
        System.out.println("Server is Waiting.....");
    }
}
