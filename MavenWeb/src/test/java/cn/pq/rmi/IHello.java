package cn.pq.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHello extends Remote{

	public String hello() throws RemoteException;
	
	public String sayHelloToSomebody (String somebody) throws RemoteException;
}
