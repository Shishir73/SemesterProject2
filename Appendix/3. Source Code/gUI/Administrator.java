package gUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import library.Book;
import library.Customer;
import library.MyDate;
import client_server.RemoteLibrary;
import client_server.RemoteLibraryClient;

public class Administrator extends JPanel {

	private Controller ctr;
	
	private JTextField bookNameField;
	private JTextField bookidField;
	private JTextField nameofAuthorField;
	private JTextField copyField;
	private JTextField dayField;
	private JTextField monthField;
	private JTextField usernamefield;
	private JTextField Stunofield;
	private JTextField CPRfield;
	private JTextField dayufield;
	private JTextField dfield;
	private JTextField DField;
	private JTextField yearField;
	private JTextField monthufield;
	private JTextField yearufield;
	private JButton InsertB;
	private JButton DeleteB;
	private JButton InsertU;
	private JButton DeleteU;
	private JButton back;

	public Administrator(Controller ctr) {
		createComponents();
		AddComponentsToPanel();
		this.ctr = ctr;
		setSize(550, 600);
	}

	public void createComponents() {
		// this.back = new JButton("Back");
		// this.booklist = new JButton("Book list");
		// this.Book = new JTextArea(30, 30);

		// this.userlist = new JButton("User list");

		InsertB = new JButton("Insert Books");
		DeleteB = new JButton("Delete Books");
		InsertU = new JButton("Insert Users");
		DeleteU = new JButton("Delete Users");
		back = new JButton("Back");
	}

	public void AddComponentsToPanel() {

		JPanel panel = new JPanel(null);
		panel.setBounds(20, 0, 550, 600);
		add(panel);

		JPanel top = new JPanel();
		top.setBounds(0, 390, 520, 61);
		panel.add(top);
		top.setLayout(null);

		JPanel b1 = new JPanel();
		b1.setBounds(0, 10, 550, 180);
		panel.add(b1);
		b1.setLayout(null);

		JTextArea book = new JTextArea();
		book.setBounds(0, 0, 550, 150);
		b1.add(book);

		JLabel BookIDd = new JLabel("Book_ID");
		BookIDd.setBounds(5, 36, 55, 15);
		top.add(BookIDd);

		DField = new JTextField();
		DField.setBounds(55, 35, 55, 20);
		top.add(DField);
		DField.setColumns(10);

		JButton DeleteB_1 = new JButton("Delete Book");
		DeleteB_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(DField.getText());
				ctr.deleteBook(id);
				book.setText("ID: " + id + " has been deleted from the system");
			}
		});
		DeleteB_1.setBounds(115, 35, 105, 20);
		top.add(DeleteB_1);

		JLabel stunoD = new JLabel("CPR  ");
		stunoD.setBounds(290, 36, 55, 15);
		top.add(stunoD);

		dfield = new JTextField();
		dfield.setBounds(319, 35, 90, 20);
		top.add(dfield);
		dfield.setColumns(10);
		setLayout(null);

		JButton DeleteU_1 = new JButton("Delete User");
		DeleteU_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cpr = Integer.parseInt(dfield.getText());
				ctr.deleteUser(cpr);
				book.setText("CPR :" + cpr
						+ " has been deleted from the system");
			}
		});
		DeleteU_1.setBounds(412, 35, 105, 20);
		top.add(DeleteU_1);

		JButton Book = new JButton("Booklist");
		Book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					ArrayList<Book> books = ctr.printAllbooks();

					String col = "";
					for (int i = 0; i < books.size(); i++) {
						col += books.get(i).getId() + "     "
								+ books.get(i).getBookName() + "          "
								+ books.get(i).getAuthor() + "\t"
								+ books.get(i).getPublishDate() + "\t"
								+ books.get(i).getNumOfCopies() + "\n";
					}

					book.setText("ID    " + "BOOK NAME         "
							+ "AUTHOR NAME       " + "PUBLISH DATE   "
							+ "NUMBER OF BOOKS\n" + col);
					
				} catch (MalformedURLException | RemoteException
						| NotBoundException e2) {
					e2.printStackTrace();
				}

			}
		});
		Book.setBounds(10, 160, 105, 20);
		b1.add(Book);

		JButton User = new JButton("Userlist");
		User.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Customer> customers = ctr.printAllCustomer();
					String cou = "";
					for (int i = 0; i < customers.size(); i++) {
						cou += customers.get(i).getFullName() + "     "
								+ customers.get(i).getStudentNo()
								+ "               " + customers.get(i).getCPR()
								+ "\t" + customers.get(i).getValidity() + "\n";
					}
					book.setText("FULL NAME      " + "STUDENT NO         "
							+ "C.P.R          " + "   VALIDITY   \n" + cou);

				} catch (MalformedURLException | RemoteException
						| NotBoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		User.setBounds(400, 160, 105, 20);
		b1.add(User);

		JPanel l1Panel = new JPanel();
		l1Panel.setBounds(0, 190, 265, 200);
		panel.add(l1Panel);
		l1Panel.setLayout(null);

		JLabel bookName = new JLabel("Book Name");
		bookName.setBounds(5, 15, 65, 15);
		l1Panel.add(bookName);

		bookNameField = new JTextField();
		bookNameField.setBounds(100, 15, 95, 20);
		l1Panel.add(bookNameField);
		bookNameField.setColumns(10);

		JLabel nameofAuthor = new JLabel("Author");
		nameofAuthor.setBounds(5, 40, 55, 15);
		l1Panel.add(nameofAuthor);

		nameofAuthorField = new JTextField();
		nameofAuthorField.setBounds(100, 40, 95, 20);
		l1Panel.add(nameofAuthorField);
		nameofAuthorField.setColumns(10);

		JLabel bookid = new JLabel("Book ID");
		bookid.setBounds(5, 65, 55, 15);
		l1Panel.add(bookid);

		bookidField = new JTextField();
		bookidField.setBounds(100, 65, 95, 20);
		l1Panel.add(bookidField);
		bookidField.setColumns(10);

		JLabel copy = new JLabel("Number of  Copy");
		copy.setBounds(5, 90, 95, 15);
		l1Panel.add(copy);

		copyField = new JTextField();
		copyField.setBounds(125, 90, 45, 20);
		l1Panel.add(copyField);
		copyField.setColumns(10);

		JLabel date = new JLabel("Publish Date");
		date.setBounds(5, 115, 75, 15);
		l1Panel.add(date);

		dayField = new JTextField();
		dayField.setBounds(100, 115, 18, 20);
		l1Panel.add(dayField);
		dayField.setColumns(10);

		monthField = new JTextField();
		monthField.setBounds(120, 115, 18, 20);
		l1Panel.add(monthField);
		monthField.setColumns(10);

		yearField = new JTextField();
		yearField.setBounds(140, 115, 35, 20);
		l1Panel.add(yearField);
		yearField.setColumns(10);

		JLabel sign1 = new JLabel("(DD:MM:YY)");
		sign1.setBounds(180, 115, 65, 15);
		l1Panel.add(sign1);

		JButton InsertB = new JButton("Insert book");
		InsertB.setBounds(50, 145, 105, 20);
		l1Panel.add(InsertB);
		InsertB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(bookidField.getText());
					int noCopy = Integer.parseInt(copyField.getText());

					int day = Integer.parseInt(dayField.getText());
					int month = Integer.parseInt(monthField.getText());
					int year = Integer.parseInt(yearField.getText());
					MyDate md = new MyDate(day, month, year);

					ctr.insertBook(id, bookNameField.getText(),
							nameofAuthorField.getText(), md, noCopy);
					book.setText(bookNameField.getText()
							+ " is now registered in the DataBase.");

				} catch (MalformedURLException | RemoteException
						| NotBoundException e1) {
					e1.printStackTrace();
				}
			}
		});

		JPanel l2Panel = new JPanel();
		l2Panel.setBounds(275, 190, 265, 200);
		panel.add(l2Panel);
		l2Panel.setLayout(null);

		JLabel username = new JLabel("User Name");
		username.setBounds(12, 15, 65, 15);
		l2Panel.add(username);

		usernamefield = new JTextField();
		usernamefield.setBounds(90, 15, 90, 20);
		l2Panel.add(usernamefield);
		usernamefield.setColumns(10);

		JLabel stuno = new JLabel("Student ID ");
		stuno.setBounds(12, 40, 65, 15);
		l2Panel.add(stuno);

		Stunofield = new JTextField();
		Stunofield.setBounds(90, 40, 90, 20);
		l2Panel.add(Stunofield);
		Stunofield.setColumns(10);

		JLabel CPR = new JLabel("CPR No");
		CPR.setBounds(12, 65, 55, 15);
		l2Panel.add(CPR);

		CPRfield = new JTextField();
		CPRfield.setBounds(90, 65, 90, 20);
		l2Panel.add(CPRfield);
		CPRfield.setColumns(10);

		JLabel userdate = new JLabel("Validate");
		userdate.setBounds(12, 90, 55, 15);
		l2Panel.add(userdate);

		dayufield = new JTextField();
		dayufield.setBounds(90, 90, 18, 20);
		l2Panel.add(dayufield);
		dayufield.setColumns(10);

		monthufield = new JTextField();
		monthufield.setBounds(110, 90, 18, 20);
		l2Panel.add(monthufield);
		monthufield.setColumns(10);

		yearufield = new JTextField();
		yearufield.setBounds(130, 90, 40, 20);
		l2Panel.add(yearufield);
		yearufield.setColumns(10);

		JLabel sign2 = new JLabel("(DD:MM:YY)");
		sign2.setBounds(175, 90, 65, 15);
		l2Panel.add(sign2);

		JButton InsertU = new JButton("Insert User");
		InsertU.setBounds(50, 120, 105, 20);
		l2Panel.add(InsertU);
		InsertU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int cpr = Integer.parseInt(CPRfield.getText());
					int day = Integer.parseInt(dayufield.getText());
					int month = Integer.parseInt(monthufield.getText());
					int year = Integer.parseInt(yearufield.getText());
					MyDate valid = new MyDate(day, month, year);

					ctr.insertUser(usernamefield.getText(),
							Stunofield.getText(), cpr, valid);
					book.setText(usernamefield.getText()
							+ " is now registered in the DataBase.");
				} catch (MalformedURLException | RemoteException
						| NotBoundException e1) {
					e1.printStackTrace();
				}
			}
		});

		JPanel button = new JPanel();
		button.setBounds(0, 580, 520, 50);
		panel.add(button);
		button.setLayout(null);

		back.setBounds(230, 0, 65, 20);
		button.add(back);

	}

	public void addActionListener(ActionListener listener) {
		InsertB.addActionListener(listener);
		DeleteB.addActionListener(listener);
		InsertU.addActionListener(listener);
		DeleteU.addActionListener(listener);
		back.addActionListener(listener);
	}
}