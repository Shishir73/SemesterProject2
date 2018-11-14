package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBase {

	private Connection c;

	public DataBase() {
		c = getConnection();
	}

	public Connection getConnection() {
		 Connection c = null;
		try {
			Class.forName("org.postgresql.Driver");
//			c = DriverManager.getConnection(
//					"jdbc:postgresql://localhost:5432/postgres", "postgres",
//					"Postgres");
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return c;		
	}
	
	private void openConn() {
		try {
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres", "postgres",
					"Postgres");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertbook(int id, String BookName, String author,
			MyDate publishDate, int numbers) {
		openConn();
		Statement stmt = null;
		try {
			stmt = c.createStatement();
			String sql = "";

			sql = "INSERT INTO\"library\".books(id, Book_Name, Author, publish_Date, numberin_stock) VALUES ('"
					+ id
					+ "', '"
					+ BookName
					+ "','"
					+ author
					+ "','"
					+ publishDate.toString() + "','" + numbers + "' );";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println(BookName + " is now registered in the system");

	}

	public void removeABook(int id) {
		openConn();
		Statement stmt = null;
		try {
			stmt = c.createStatement();
			String sql = "DELETE FROM\"library\".books where id = '" + id
					+ "';";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);

		}
		System.out.println("ID no. = " + id
				+ " has been deleted from the system");
	}

	public Book getABook(String name) {
		try {
			PreparedStatement stmt = c
					.prepareStatement("SELECT * FROM \"library\".books where book_name = '"
							+ name + "';");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				int id = Integer.parseInt(rs.getString("id"));
				String date = rs.getString("publish_date");
				String[] dates = date.split("/");
				int day = Integer.parseInt(dates[0]);
				int month = Integer.parseInt(dates[1]);
				int year = Integer.parseInt(dates[2]);
				int numOfCopies = Integer.parseInt(rs
						.getString("numberin_stock"));

				MyDate md = new MyDate(day, month, year);

				Book book = new Book(id, rs.getString("book_name"),
						rs.getString("author"), md, numOfCopies);
				return book;
			}
			rs.close();
			stmt.close();
			c.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return null;
	}

	public void insertCustomer(String FullName, String StudentNo, int cpr,
			MyDate validity) {
		openConn();
		Statement stmt = null;
		try {
			stmt = c.createStatement();
			String sql = "";

			sql = "INSERT INTO\"library\".customers(Full_Name, Student_No, CPR, Validity) VALUES ('"
					+ FullName
					+ "', '"
					+ StudentNo
					+ "','"
					+ cpr
					+ "','"
					+ validity.toString() + "' );";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println(FullName + " has been registered in the system");

	}

	public void removeCustomer(int cpr) {
		openConn();
		Statement stmt = null;
		try {
			stmt = c.createStatement();
			String sql = "DELETE FROM\"library\".customers where cpr = '" + cpr
					+ "';";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("CPR no. = " + cpr
				+ " has been deleted from the system");
	}

	public Customer getACustomer(String name) {
		try {
			PreparedStatement stmt = c
					.prepareStatement("SELECT * FROM \"library\".customers where full_name = '"
							+ name + "';");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int cpr = Integer.parseInt(rs.getString("cpr"));
				String date = rs.getString("validity");
				String[] dates = date.split("/");
				int day = Integer.parseInt(dates[0]);
				int month = Integer.parseInt(dates[1]);
				int year = Integer.parseInt(dates[2]);
				MyDate valid = new MyDate(day, month, year);

				Customer customer = new Customer(rs.getString("full_name"),
						rs.getString("student_no"), cpr, valid);
				return customer;
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return null;
	}

	public ArrayList<Book> printAllBooks() {
		openConn();
		try {
			PreparedStatement stmt = c
					.prepareStatement("SELECT * FROM \"library\".books ");
			ResultSet rs = stmt.executeQuery();
			ArrayList<Book> books = new ArrayList<>();

			while (rs.next()) {

				int id = Integer.parseInt(rs.getString("id"));
				String date = rs.getString("publish_date");
				String[] dates = date.split("/");
				int day = Integer.parseInt(dates[0]);
				int month = Integer.parseInt(dates[1]);
				int year = Integer.parseInt(dates[2]);
				int numOfCopies = Integer.parseInt(rs
						.getString("numberin_stock"));

				MyDate md = new MyDate(day, month, year);

				Book book = new Book(id, rs.getString("book_name"),
						rs.getString("author"), md, numOfCopies);

				books.add(book);
			}
			rs.close();
			stmt.close();
			c.close();

			return books;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return null;
	}

	public ArrayList<Customer> getAllCustomers() {
		openConn();
		try {
			
			PreparedStatement stmt = c
					.prepareStatement("SELECT * FROM \"library\".customers");
			ResultSet rs = stmt.executeQuery();
			ArrayList<Customer> customers = new ArrayList<>();

			while (rs.next()) {
				int cpr = Integer.parseInt(rs.getString("cpr"));
				String date = rs.getString("validity");
				String[] dates = date.split("/");
				int day = Integer.parseInt(dates[0]);
				int month = Integer.parseInt(dates[1]);
				int year = Integer.parseInt(dates[2]);
				MyDate valid = new MyDate(day, month, year);

				Customer customer = new Customer(rs.getString("full_name"),
						rs.getString("student_no"), cpr, valid);

				customers.add(customer);
			}
			rs.close();
			stmt.close();
			c.close();
			return customers;
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return null;
	}

	public void burrowBook(int id, int cpr) {
		openConn();
		Statement stmt = null;
		try {
			stmt = c.createStatement();
			String sql = "";

			sql = "INSERT INTO\"library\".borrowed(id, cpr) VALUES ('" + id
					+ "', '" + cpr + "' );";
			stmt.executeUpdate(sql);
			
			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("CPR No: " + cpr + " borrowed the book ID: " + id);

	}

	public void ReturnBook(int id, int cpr) {
		openConn();
		Statement stmt = null;
		try {
			stmt = c.createStatement();
			String sql = "";

			sql = "DELETE FROM\"library\".borrowed where id = '" + id + "' and cpr = '"+ cpr +"';";
			stmt.executeUpdate(sql);

			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("CPR No: " + cpr + " has returned the book ID: " + id);

	}
	
	public ArrayList<Borrow> borrowBook() {
		openConn();
		try {
			PreparedStatement stmt = c.prepareStatement("SELECT * FROM \"library\".borrowed ");
			ResultSet rs = stmt.executeQuery();
			ArrayList<Borrow> bros = new ArrayList<>();

			while (rs.next()) {

				int id = Integer.parseInt(rs.getString("id"));
				int cpr = Integer.parseInt(rs.getString("cpr"));

				Borrow borrows = new Borrow(id, cpr);

				bros.add(borrows);
			}
			rs.close();
			stmt.close();
			c.close();

			return bros;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return null;
	}
	
	

}