package cn.pq.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RmiTest {
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
      //创建远程调用对象
		IHello hello = new HelloImp();
		//创建rmi注册表
		LocateRegistry.createRegistry(8090);
		//添加远程调用对象到注册表
		Naming.bind("rmi://localhost:8090/Hello", hello);
	}
}
