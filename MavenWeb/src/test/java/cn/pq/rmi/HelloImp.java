package cn.pq.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImp extends UnicastRemoteObject implements IHello{

	protected HelloImp() throws RemoteException {
		super();
	}

	@Override
	public String hello() throws RemoteException {
		return "hello world!";
	}

	@Override
	public String sayHelloToSomebody(String somebody) throws RemoteException {
		return "hello "+somebody+" !";
	}

}
