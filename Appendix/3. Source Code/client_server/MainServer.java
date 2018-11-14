package client_server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class MainServer {
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			RemoteLibrary server = new RemoteLibraryServer();
			Naming.rebind("hTl", server);
			System.out.println("Server Started!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
