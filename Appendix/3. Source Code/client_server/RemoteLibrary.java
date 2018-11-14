package client_server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import library.Book;
import library.Borrow;
import library.Customer;
import library.MyDate;

public interface RemoteLibrary extends Remote {

	void insertBook(int id, String BookName, String author, MyDate publishDate, int numbers) throws RemoteException;

	void removeABook(int id) throws RemoteException;

	Book getABook(String name) throws RemoteException;

	void insertCustomer(String FullName, String StudentNo, int cpr, MyDate validity) throws RemoteException;
	
	void removeCustomer(int cpr) throws RemoteException;

	Customer getACustomer(String name) throws RemoteException;
	
	ArrayList<Book> printAllBook() throws RemoteException;
	
	ArrayList<Customer> printAllCustomer() throws RemoteException;
	
	void burrowBook(int id, int cpr) throws RemoteException;
	
	void ReturnBook(int id, int cpr) throws RemoteException;
	
	ArrayList<Borrow> borrowedBook() throws RemoteException;
}
