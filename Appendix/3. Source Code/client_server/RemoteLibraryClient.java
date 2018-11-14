package client_server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import library.Book;
import library.Borrow;
import library.Customer;
import library.MyDate;

public class RemoteLibraryClient {

	public static RemoteLibrary rml;

	public RemoteLibraryClient() throws MalformedURLException, RemoteException,
			NotBoundException {
		rml = (RemoteLibrary) Naming.lookup("rmi://localhost:1099/hTl");
	}

	public void insert(int id, String BookName, String author,
			MyDate publishDate, int numbers) throws MalformedURLException,
			RemoteException, NotBoundException {
		rml.insertBook(id, BookName, author, publishDate, numbers);
	}

	public void removeABook(int id) throws MalformedURLException,
			RemoteException, NotBoundException {
		rml.removeABook(id);
	}

	public void getABook(String name) throws MalformedURLException,
			RemoteException, NotBoundException {
		Book books = rml.getABook(name);
		
			System.out.println("");
			System.out.println("ID : " + books.getId());
			System.out.println("BOOK NAME : " + books.getBookName());
			System.out.println("AUTHOR NAME : " + books.getAuthor());
			System.out.println("PUBLISH DATE : " + books.getPublishDate());
			System.out.println("NUMBER OF BOOKS : " + books.getNumOfCopies());
			System.out.println("");
	}

	public void insertCustomer(String fullName, String customerNo, int cpr,
			MyDate validity) throws MalformedURLException, RemoteException,
			NotBoundException {
		rml.insertCustomer(fullName, customerNo, cpr, validity);
	}

	public void removeCustomer(int cpr) throws MalformedURLException,
			RemoteException, NotBoundException {
		rml.removeCustomer(cpr);
	}

	public void getACustomer(String name) throws MalformedURLException,
			RemoteException, NotBoundException {
		
		Customer customer = rml.getACustomer(name);
		System.out.println("");
		System.out.println("FULL NAME : " + customer.getFullName());
		System.out.println("STUDENT NUMBER : " + customer.getStudentNo());
		System.out.println("CPR : " + customer.getCPR());
		System.out.println("VALIDITY DATE : " + customer.getValidity());
		System.out.println("");
	}

	public ArrayList<Book> printAllBooks() throws MalformedURLException, RemoteException,
			NotBoundException {
		 return rml.printAllBook();
	}

	public ArrayList<Customer> getAllCustomers() throws MalformedURLException,
			RemoteException, NotBoundException {
	
		return rml.printAllCustomer();
	}

	public void burrowBook(int id, int cpr) throws MalformedURLException, RemoteException, NotBoundException{
		rml.burrowBook(id, cpr);
	}
	
	public void returnBook(int id, int cpr) throws MalformedURLException,
	RemoteException, NotBoundException{
		rml.ReturnBook(id, cpr);
	}
	
	public ArrayList<Borrow> borrowedBook() throws MalformedURLException,
	RemoteException, NotBoundException{
		return rml.borrowedBook();
	}
	
}
