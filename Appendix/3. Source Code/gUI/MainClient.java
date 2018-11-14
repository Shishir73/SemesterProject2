package gUI;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import client_server.RemoteLibraryClient;

public class MainClient {

	public static void main(String[] args) throws MalformedURLException,
			RemoteException, NotBoundException {
		System.out.println("Client Connected");

		RemoteLibraryClient rlc = new RemoteLibraryClient();
		Model mdl = new Model(rlc);
		Controller ct = new Controller(mdl);
		View vi = new View(ct);
		vi.start(ct);
	}
}
