package gUI;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import library.Book;
import library.Borrow;
import library.Customer;
import library.MyDate;
import client_server.RemoteLibraryClient;

public class Model {

	private RemoteLibraryClient rlc;
	 	
	public Model(RemoteLibraryClient rlc)
	{
		this.rlc = rlc;
	
	}

	public void insertBook(int id, String bookName, String Author,
			MyDate md, int noCopy) throws MalformedURLException,
			RemoteException, NotBoundException {
		rlc.insert(id, bookName, Author, md, noCopy);
	}
	
	public void insertUser(String username,
			String Stuno,int cpr,MyDate valid)throws MalformedURLException,
			RemoteException, NotBoundException{
		rlc.insertCustomer(username, Stuno, cpr, valid);
	}

	public ArrayList<Book> printAllbooks() throws MalformedURLException,
			RemoteException, NotBoundException {

		return rlc.printAllBooks();
	}

	public ArrayList<Customer> printAllCustoemrs()
			throws MalformedURLException, RemoteException, NotBoundException {

		return rlc.getAllCustomers();
	}

	public void deleteBook(int id) {
		try {
			rlc.removeABook(id);

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(int cpr) {
		try {
			rlc.removeCustomer(cpr);

		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			e1.printStackTrace();
		}
	}
	
	public void burrowBook(int id, int cpr){
		try {
			rlc.burrowBook(id, cpr);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public void returnBook(int id, int cpr){
				try {
					rlc.returnBook(id, cpr);
				} catch (MalformedURLException | RemoteException
						| NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	public ArrayList<Borrow> borrowBook() throws MalformedURLException, RemoteException, NotBoundException{
		return rlc.borrowedBook();
	}
}
