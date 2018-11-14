package library;

import java.util.ArrayList;
import java.util.Scanner;

import client_server.RemoteLibraryClient;
import library.MyDate;

public class Menu {

	public static void menu() {
		int choice = 0;

		Scanner keyboard = new Scanner(System.in);

		do {
			System.out.println("\t***************|MENU|*************");
			System.out.println(" \t\t 1. Insert Book!");
			System.out.println(" \t\t 2. Remove Book!");
			System.out.println(" \t\t 3. Add Customer");
			System.out.println(" \t\t 4. Remove Customer");
			System.out.println(" \t\t 5. Look for a Book");
			System.out.println(" \t\t 6. Look for a Customer");
			System.out.println(" \t\t 7. See all books!");
			System.out.println(" \t\t 8. See all Customer!");
			System.out.println(" \t\t 9. Burrow Book!");
			System.out.println(" \t\t 10. Return Book!");
			System.out.println(" \t\t 11. EXIT");
			System.out.println("\t___________________________________");
			System.out.print("Choose your option.");
			choice = keyboard.nextInt();
			keyboard.nextLine();

			switch (choice) {

			case 1:
				insertBook();
				break;
			case 2:
				deleteBook();
				break;
			case 3:
				insertCustomer();
				break;
			case 4:
				removeCustomer();
				break;
			case 5:
				getABook();
				break;
			case 6:
				getACustomer();
				break;
			case 7:
				getAllBooks();
				break;
			case 8:
				getAllCustomers();
				break;
			case 9:
				burrowBook();
				break;
			case 10:
				ReturnBook();
				break;
			case 11 :
			default:
				break;
			}
		} while (choice == 11);
		keyboard.close();

	}

	private static void ReturnBook() {
		int cpr, id;
		
		Scanner type = new Scanner(System.in);

		System.out.println("Enter the id(Integer) of the book.");
		id = type.nextInt();
		
		System.out.println("Enter the cpr number.");
		cpr = type.nextInt();

		try {
			RemoteLibraryClient rlc = new RemoteLibraryClient();
			rlc.returnBook(id, cpr);
			System.out.println("CPR No: " + cpr + " has returned the book ID: " + id);
			menu();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		type.close();
		
	}

	private static void burrowBook() {
		int cpr, id;
		
		Scanner type = new Scanner(System.in);

		System.out.println("Enter the id(Integer) of the book.");
		id = type.nextInt();
		
		System.out.println("Enter the cpr number.");
		cpr = type.nextInt();

		try {
			RemoteLibraryClient rlc = new RemoteLibraryClient();
			rlc.burrowBook(id, cpr);
			System.out.println("CPR No: " + cpr + " burrowed the book ID: " + id);
			menu();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		type.close();
				
	}

	public static void insertBook() {
		int id, day, month, year, numbers;

		String BookName, author;
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter the id(Integer).");
		id = keyboard.nextInt();
		keyboard.nextLine();
		System.out.println("Enter the name of book.");
		BookName = keyboard.nextLine();
		System.out.println("Enter the name of author.");
		author = keyboard.nextLine();
		System.out.print("Enter the published day ");
		day = keyboard.nextInt();
		System.out.print("Enter the published month ");
		month = keyboard.nextInt();
		System.out.print("Enter the published year ");
		year = keyboard.nextInt();
		System.out.println("Enter the number of copy of books ");
		numbers = keyboard.nextInt();

		try {
			MyDate publishDate = new MyDate(day, month, year);

			RemoteLibraryClient rlc = new RemoteLibraryClient();
			rlc.insert(id, BookName, author, publishDate, numbers);
			System.out.println(BookName + " is now registered in the system.");
			menu();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		keyboard.close();

	}

	private static void deleteBook() {
		int id;
		try {
			Scanner key = new Scanner(System.in);
			System.out
					.println("Enter the id(int) of book that is to be deleted. ");
			id = key.nextInt();

			RemoteLibraryClient rlc = new RemoteLibraryClient();
			rlc.removeABook(id);
			menu();

			key.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	private static void getABook() {
		String name;
		try {
			Scanner key = new Scanner(System.in);

			System.out.println("Enter the name of book that you want to burrow. ");
			name = key.nextLine();

			RemoteLibraryClient rlc = new RemoteLibraryClient();
			rlc.getABook(name);
			menu();

			key.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	private static void insertCustomer() {
		int cpr, day, month, year;
		String FullName, customerNo;

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter the full name customer.");
		FullName = keyboard.nextLine();
		System.out.println("Enter the customerNo(String).");
		customerNo = keyboard.nextLine();
		System.out.println("Enter the CPR number.");
		cpr = keyboard.nextInt();
		System.out.print("Enter the validity DAY ");
		day = keyboard.nextInt();
		System.out.print("Enter the validity MONTH ");
		month = keyboard.nextInt();
		System.out.print("Enter the validity year ");
		year = keyboard.nextInt();

		try {
			MyDate validity = new MyDate(day, month, year);

			RemoteLibraryClient rlc = new RemoteLibraryClient();
			rlc.insertCustomer(FullName, customerNo, cpr, validity);
			System.out.println(FullName + " is now registered in the system.");
			menu();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		keyboard.close();
	}

	private static void removeCustomer() {
		int cpr;
		try {
			Scanner key = new Scanner(System.in);
			System.out.println("Enter the CPR(int) of Customer to be deleted.");
			cpr = key.nextInt();

			RemoteLibraryClient rlc = new RemoteLibraryClient();
			rlc.removeCustomer(cpr);
			menu();

			key.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	private static void getACustomer() {
		String name;
		try {
			Scanner key = new Scanner(System.in);

			System.out.println("Enter the full name of customer that you want to see. ");
			name = key.nextLine();

			RemoteLibraryClient rlc = new RemoteLibraryClient();
			rlc.getACustomer(name);
			menu();

			key.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	private static void getAllBooks() {
		try {
			Scanner key = new Scanner(System.in);
			RemoteLibraryClient rlc = new RemoteLibraryClient();
			ArrayList<Book> books = rlc.printAllBooks();
				for (int i = 0; i < books.size(); i++) {
					System.out.println("");
					System.out.println(books.get(i).getId());
					System.out.println(books.get(i).getBookName());
					System.out.println(books.get(i).getAuthor());
					System.out.println(books.get(i).getPublishDate());
					System.out.println(books.get(i).getNumOfCopies());
				}
				menu();
			key.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	private static void getAllCustomers() {
		try {
			Scanner key = new Scanner(System.in);
			RemoteLibraryClient rlc = new RemoteLibraryClient();
			rlc.getAllCustomers();
			menu();

			key.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
}
