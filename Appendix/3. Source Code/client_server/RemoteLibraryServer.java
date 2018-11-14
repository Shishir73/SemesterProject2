package client_server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import library.Book;
import library.Borrow;
import library.Customer;
import library.DataBase;
import library.MyDate;

public class RemoteLibraryServer implements RemoteLibrary{
	
	DataBase db = new DataBase();
	
	public RemoteLibraryServer() throws RemoteException {
		UnicastRemoteObject.exportObject(this, 0);
	}

	public void insertBook(int id, String BookName, String author,
			MyDate date, int numbers) throws RemoteException {
	 db.insertbook(id, BookName, author, date, numbers);
	}

	public void removeABook(int id) throws RemoteException {
		db.removeABook(id);	
	}

	public Book getABook(String name) throws RemoteException {
		 return db.getABook(name);	
	}
	
	public void insertCustomer(String FullName, String StudentNo, int cpr,
			MyDate validity) throws RemoteException {
		db.insertCustomer(FullName, StudentNo, cpr, validity);
	}

	public void removeCustomer(int cpr) throws RemoteException{
		db.removeCustomer(cpr);
	}

	public Customer getACustomer(String name) throws RemoteException {
		return db.getACustomer(name);	
	}
	
	public ArrayList<Book> printAllBook() throws RemoteException{
		return db.printAllBooks();
	}
	
	public ArrayList<Customer> printAllCustomer() throws RemoteException{
		return db.getAllCustomers();
	}
	
	public void burrowBook(int id, int cpr) throws RemoteException{
		db.burrowBook(id, cpr);
	}
	
	public void ReturnBook(int id, int cpr) throws RemoteException{
		db.ReturnBook(id, cpr);
	}
	
	public ArrayList<Borrow> borrowedBook() throws RemoteException{
		return db.borrowBook();
	}
}
