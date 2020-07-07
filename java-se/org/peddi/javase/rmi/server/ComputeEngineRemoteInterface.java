package org.peddi.javase.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ComputeEngineRemoteInterface extends Remote{
	String name = "ComputeRemoteObject";
	<T>  T submitTask(Task<T> task) throws RemoteException;
}
