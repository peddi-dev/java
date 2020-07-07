package org.peddi.javase.rmi.server;

import java.rmi.RemoteException;

public class ComputeEngine implements ComputeEngineRemoteInterface {
	
	

	public ComputeEngine() {
		super();
		
	}

	@Override
	public <T> T submitTask(Task<T> task) throws RemoteException {
		
		return task.execute();
	}

	public static void main(String[] args) {
		RMIServerSetup rss = new RMIServerSetup();
		rss.setup();

	}

}
