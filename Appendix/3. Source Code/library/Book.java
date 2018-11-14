package library;

import java.io.Serializable;

public class Book implements Serializable{
	
	private int id;
	private String BookName;
	private MyDate publishDate;
	private String author;
	private int numOfCopies;
	
	public Book(int id, String BookName, String author, MyDate publishDate, int numOfCopies) {
		this.id = id;
		this.BookName = BookName;
		this.publishDate = publishDate;
		this.author = author;
		this.numOfCopies = numOfCopies;
	}
	
	public int getNumOfCopies() {
		return numOfCopies;
	}

	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
	}

	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}
	
	public MyDate getPublishDate() {
		return publishDate;
	}

	public String getAuthor() {
		return author;
	}
	
	public String print(){
		return "ID of book: "+ id +" Book Name: "+ BookName +" Author "+ author;
	}

}
