package org.peddi.javase.rmi.client;

import java.math.BigDecimal;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.peddi.javase.rmi.server.ComputeEngineRemoteInterface;

public class ComputePi {

	public void computePi(String host) {

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		try {
			
			String name = "ComputeRemoteObject";
			Registry registry = LocateRegistry.getRegistry(host);
			ComputeEngineRemoteInterface remoteObectStub = (ComputeEngineRemoteInterface) registry.lookup(name);
			PiTask task = new PiTask(3);
			BigDecimal pi = remoteObectStub.submitTask(task);

			System.out.println(pi);

		} catch (RemoteException e) {
			
			e.printStackTrace();
		} catch (NotBoundException e) {
			
			e.printStackTrace();
		} finally {

		}

	}

	public static void main(String[] args) {
		ComputePi app = new ComputePi();
		String host = "localhost";
		app.computePi(host);

	}

}
