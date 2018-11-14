package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateDataBase {
	
	public static void main(String[] args) throws Exception {
		getConnection();
		createSchema();
		setPath();
		createBookTable();
		insertBook();
		createCustomerTable();
		insertCustomer();
		createBorrowed();
		insertBorrowed();
	}

	public static Connection getConnection() throws Exception {
		Connection c = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres", "postgres",
					"Postgres");
			System.out.println("Connected");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return c;
	}
	
	public static void createSchema() throws Exception {
		try {
			Connection c = getConnection();
			PreparedStatement create = c
					.prepareStatement("CREATE SCHEMA library");
			create.executeUpdate();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		} finally {
			System.out.println("Schema created");
		}

	}
	
	public static void setPath() throws Exception{
		try {
			Connection c = getConnection();
			PreparedStatement create = c
					.prepareStatement("SET search_path = 'library'");
			create.executeUpdate();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		} finally {
			System.out.println("Path set!!");
		}
	}

	public static void createBookTable() throws Exception {
		try {
			Connection c = getConnection();
			PreparedStatement create = c.prepareStatement("CREATE TABLE \"library\".books(Id int NOT NULL, Book_Name VARCHAR(225) NOT NULL, Author VARCHAR(225) NOT NULL, publish_Date VARCHAR(20), numberin_stock int, PRIMARY KEY(Id))");
			create.executeUpdate();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		} finally {
			System.out.println("Books Table created");
		}

	}
	
	public static void insertBook() throws Exception{
		try{
			Connection c = getConnection();
			PreparedStatement insert = c.prepareStatement("INSERT INTO \"library\".books(id, book_name, author, publish_Date, numberin_stock) VALUES ('"+1+"', 'karnali blues', 'buddhi sagar', '1/1/2003', '"+2+"')");
			insert.executeUpdate();
			PreparedStatement insert2 = c.prepareStatement("INSERT INTO \"library\".books(id, book_name, author, publish_Date, numberin_stock) VALUES ('"+2+"', 'the alcamist', 'phoulo choelo', '2/3/2001', '"+5+"')");
			insert2.executeUpdate();
			PreparedStatement insert3 = c.prepareStatement("INSERT INTO \"library\".books(id, book_name, author, publish_Date, numberin_stock) VALUES ('"+3+"', 'applied java', 'anupa tamang', '5/2/2010', '"+7+"')");
			insert3.executeUpdate();
			PreparedStatement insert4 = c.prepareStatement("INSERT INTO \"library\".books(id, book_name, author, publish_Date, numberin_stock) VALUES ('"+4+"', 'optional math', 'rishav dhakal', '2/6/2000', '"+4+"')");
			insert4.executeUpdate();
			PreparedStatement insert5 = c.prepareStatement("INSERT INTO \"library\".books(id, book_name, author, publish_Date, numberin_stock) VALUES ('"+5+"', 'white tigers', 'krishna pun', '3/7/2001', '"+8+"')");
			insert5.executeUpdate();
		}catch ( Exception e ) {
		         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		         System.exit(0);
		}finally{
			System.out.println("BOOKS VALUE INSERTED");
		}
	}
	
	public static void createCustomerTable() throws Exception {
		try {
			Connection c = getConnection();
			PreparedStatement create = c
					.prepareStatement("CREATE TABLE IF NOT EXISTS \"library\".customers(Full_Name VARCHAR(225), Student_No VARCHAR(225), CPR INTEGER, Validity VARCHAR(20), PRIMARY KEY(CPR))");
			create.executeUpdate();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		} finally {
			System.out.println("Customers Table created");
		}
	}
	public static void insertCustomer() throws Exception{
		try{
			Connection c = getConnection();
			PreparedStatement insert = c.prepareStatement("INSERT INTO \"library\".customers(Full_Name, Student_No, CPR, Validity) VALUES ('sunil narian', 'sn123','"+1908991234+"', '1/7/2023')");
			insert.executeUpdate();
			PreparedStatement insert2 = c.prepareStatement("INSERT INTO \"library\".customers(Full_Name, Student_No, CPR, Validity) VALUES ('ayush aryal', 'ayh23','"+1009981234+"', '9/1/2020')");
			insert2.executeUpdate();
			PreparedStatement insert3 = c.prepareStatement("INSERT INTO \"library\".customers(Full_Name, Student_No, CPR, Validity) VALUES ('wangshu xu', 'wx123','"+1234567890+"', '3/2/2021')");
			insert3.executeUpdate();
			PreparedStatement insert4 = c.prepareStatement("INSERT INTO \"library\".customers(Full_Name, Student_No, CPR, Validity) VALUES ('astha poudel', 'atp2','"+222222222+"', '1/10/2026')");
			insert4.executeUpdate();
			PreparedStatement insert5 = c.prepareStatement("INSERT INTO \"library\".customers(Full_Name, Student_No, CPR, Validity) VALUES ('lukas gram', 'lg234','"+333333333+"', '9/11/2019')");
			insert5.executeUpdate();
		}catch ( Exception e ) {
		         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		         System.exit(0);
		}finally{
			System.out.println("CUSTOMERS INSERTED");
		}
	}
	
	public static void createBorrowed() throws Exception {
		try {
			Connection c = getConnection();
			PreparedStatement create = c
					.prepareStatement("CREATE TABLE IF NOT EXISTS \"library\".borrowed(id INTEGER REFERENCES \"library\".books (id), cpr INTEGER REFERENCES \"library\".customers (cpr));");
			create.executeUpdate();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		} finally {
			System.out.println("BORROW TABLE CREATED");
		}
	}
	
	public static void insertBorrowed() throws Exception{
		try{
			Connection c = getConnection();
			PreparedStatement insert = c.prepareStatement("INSERT INTO \"library\".borrowed(id, cpr) VALUES ('"+1+"','"+1908991234+"')");
			insert.executeUpdate();
			PreparedStatement insert2 = c.prepareStatement("INSERT INTO \"library\".borrowed(id, cpr) VALUES ('"+4+"','"+1009981234+"')");
			insert2.executeUpdate();
			PreparedStatement insert3 = c.prepareStatement("INSERT INTO \"library\".borrowed(id, cpr) VALUES ('"+5+"','"+1234567890+"')");
			insert3.executeUpdate();
		}catch ( Exception e ) {
		         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		         System.exit(0);
		}finally{
			System.out.println("INSERTED IN BORROWED BOOK");
		}
	}
}
