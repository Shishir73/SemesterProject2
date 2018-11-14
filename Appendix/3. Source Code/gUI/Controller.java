package gUI;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import library.Book;
import library.Borrow;
import library.Customer;
import library.MyDate;

public class Controller implements Serializable {

	private Model mdl;
	
	public Controller(Model mdl){
		this.mdl = mdl;
	}

	public void insertBook(int id, String bookName, String Author,
			MyDate md, int noCopy) throws MalformedURLException,
			RemoteException, NotBoundException {
		mdl.insertBook(id, bookName, Author, md, noCopy);
	}
	
	public void insertUser(String username,
			String Stuno,int cpr,MyDate valid)throws MalformedURLException,
			RemoteException, NotBoundException{
		mdl.insertUser(username, Stuno, cpr, valid);
		
	}

	public ArrayList<Book> printAllbooks() throws MalformedURLException,
			RemoteException, NotBoundException {
		 return mdl.printAllbooks();
	}

	public ArrayList<Customer> printAllCustomer()
			throws MalformedURLException, RemoteException, NotBoundException {
		return mdl.printAllCustoemrs();
	}

	public void deleteBook(int id) {
		mdl.deleteBook(id);
	}

	public void deleteUser(int cpr) {
		mdl.deleteUser(cpr);
	}
	
	public void burrowBook(int id, int cpr){
		mdl.burrowBook(id, cpr);
	}
	
	public void returnBook(int id, int cpr){
		mdl.returnBook(id, cpr);
	}

	public ArrayList<Borrow> borrowBook() throws MalformedURLException, RemoteException, NotBoundException{
		return mdl.borrowBook();
	}
}
