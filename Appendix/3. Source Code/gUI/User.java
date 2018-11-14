package gUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import library.Book;
import library.Borrow;
import library.Customer;

public class User extends JPanel {
   
   private Controller ctr;
   
   private JButton back;
   private JButton Borrowlist;
   private JButton BookButton;
   private JButton Customerbutton;
   private JButton Returnbutton;
   private JButton Borrowbutton;
   private JTextArea textArea;
   private JTextField BookidtextField;
   private JTextField CprtextField;
   private JTextField bookidtextField;
   private JTextField cprtextField;

   public User(Controller ctr) {
      createComponents();
      addComponents();
      this.ctr = ctr;
      setVisible(true);
   }

   public void createComponents() {
      this.back = new JButton("Back");
      
      this.Borrowlist = new JButton("Borrow List");
      Borrowlist.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e) {
            try {
               
               ArrayList<Borrow> bros = ctr.borrowBook();

               String col = "";
               for (int i = 0; i < bros.size(); i++) {
                  col += bros.get(i).getId() + "\t"
                        + bros.get(i).getCpr() + "\n";
               }

               textArea.setText("ID\t" + " CPR\n" + col);
               
            } catch (MalformedURLException | RemoteException
                  | NotBoundException e2) {
               e2.printStackTrace();
            }

         }
      });
      this.BookButton = new JButton("Book List");
      BookButton.addActionListener(new ActionListener() {
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

               textArea.setText("ID    " + "BOOK NAME         "
                     + "AUTHOR NAME       " + "PUBLISH DATE   "
                     + "NUMBER OF BOOKS\n" + col);
               
            } catch (MalformedURLException | RemoteException
                  | NotBoundException e2) {
               e2.printStackTrace();
            }

         }
      });      
      this.Customerbutton = new JButton("Customers List");
      Customerbutton.addActionListener(new ActionListener() {
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
               textArea.setText("FULL NAME      " + "STUDENT NO         "
                     + "C.P.R          " + "   VALIDITY   \n" + cou);

            } catch (MalformedURLException | RemoteException
                  | NotBoundException e1) {
               e1.printStackTrace();
            }
         }
      });
      
      this.Returnbutton = new JButton("Return");
      this.Returnbutton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         int id = Integer.parseInt(bookidtextField.getText());
         int cpr = Integer.parseInt(cprtextField.getText());
         ctr.returnBook(id, cpr);
         textArea.setText("Book ID : " + id + " has been returned by CPR " + cpr);
      }
   });
      
      this.Borrowbutton = new JButton("Borrow");
      this.Borrowbutton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(BookidtextField.getText());
            int cpr = Integer.parseInt(CprtextField.getText());
            ctr.burrowBook(id, cpr);
            textArea.setText("Book ID : " + id + " has been burrowed by CPR " + cpr);
         }
      });
   }
  

   public void addComponents() {

      setLayout(null);

      JPanel Main = new JPanel();
      Main.setBounds(0, 0, 600, 700);
      add(Main);
      Main.setLayout(null);

      JPanel toppanel = new JPanel();
      toppanel.setBounds(0, 0, 550, 150);
      Main.add(toppanel);
      toppanel.setLayout(null);

      textArea = new JTextArea();
      textArea.setBounds(10, 5, 550, 160);
      toppanel.add(textArea);

      JPanel bottonpanel = new JPanel();
      bottonpanel.setBounds(20, 390, 510, 110);
      Main.add(bottonpanel);
      bottonpanel.setLayout(null);

      Borrowlist.setBounds(210, 10, 110, 25);
      bottonpanel.add(Borrowlist);

      back.setBounds(210, 70, 110, 25);
      bottonpanel.add(back);

      JPanel borrowpanel = new JPanel();
      borrowpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
      borrowpanel.setBounds(10, 200, 260, 180);
      Main.add(borrowpanel);
      borrowpanel.setLayout(null);

      BookButton.setBounds(80, 150, 110, 25);
      Main.add(BookButton);

      JLabel BookIDLabel = new JLabel("Book_ID");
      BookIDLabel.setBounds(10, 50, 55, 15);
      borrowpanel.add(BookIDLabel);

      BookidtextField = new JTextField();
      BookidtextField.setBounds(75, 50, 100, 20);
      borrowpanel.add(BookidtextField);
      BookidtextField.setColumns(10);

      JLabel CPRlabel = new JLabel("C.P.R");
      CPRlabel.setBounds(10, 100, 55, 15);
      borrowpanel.add(CPRlabel);

      CprtextField = new JTextField();
      CprtextField.setColumns(10);
      CprtextField.setBounds(75, 100, 100, 20);
      borrowpanel.add(CprtextField);

      Borrowbutton.setBounds(75, 140, 100, 25);
      borrowpanel.add(Borrowbutton);

      JPanel returnpanel = new JPanel();
      returnpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
      returnpanel.setBounds(280, 200, 260, 180);
      Main.add(returnpanel);
      returnpanel.setLayout(null);

      bookidtextField = new JTextField();
      bookidtextField.setColumns(10);
      bookidtextField.setBounds(75, 50, 100, 20);
      returnpanel.add(bookidtextField);

      cprtextField = new JTextField();
      cprtextField.setColumns(10);
      cprtextField.setBounds(75, 100, 100, 20);
      returnpanel.add(cprtextField);

      JLabel bookidlabel = new JLabel("Book ID");
      bookidlabel.setBounds(10, 50, 55, 15);
      returnpanel.add(bookidlabel);

      JLabel cprlabel = new JLabel("CPR");
      cprlabel.setBounds(10, 100, 55, 15);
      returnpanel.add(cprlabel);
      
      Customerbutton.setBounds(350, 150, 130, 25);
      Main.add(Customerbutton);

      Returnbutton.setBounds(75, 140, 100, 25);
      returnpanel.add(Returnbutton);

   }

   public void addActionListener(ActionListener listener) {
      back.addActionListener(listener);
      Borrowlist.addActionListener(listener);
      Customerbutton.addActionListener(listener);
      Returnbutton.addActionListener(listener);
      BookButton.addActionListener(listener);
      Borrowbutton.addActionListener(listener);
   }

// public void clear() {
//    bookidtextField.setText("");
//    BookidtextField.setText("");
//    cprtextField.setText("");
//    CprtextField.setText("");
// }

   public void setText(String what) {
      textArea.setText(what);
   }

// public String[] getInput() {
//    String[] all = { bookidtextField.getText(), cprtextField.getText(),
//          BookidtextField.getText(), CprtextField.getText() };
//
//    return all;
// }

}
