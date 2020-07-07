package org.peddi.javase.rmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import static java.lang.System.out;

public class RMIServerSetup {
	
	public void setup() {
		
		out.println("RMIServerSetup.setup()");
		
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		try {
			
			ComputeEngineRemoteInterface engine = new ComputeEngine();
			ComputeEngineRemoteInterface stub = (ComputeEngineRemoteInterface) UnicastRemoteObject.exportObject(engine, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind(ComputeEngineRemoteInterface.name, stub);
			
			out.println("ComputeEngine Bound");
			
		} catch (RemoteException e) {
			System.err.println("ComputerEngine Exception");
			e.printStackTrace();
		}finally {
			
		}
	}

}
