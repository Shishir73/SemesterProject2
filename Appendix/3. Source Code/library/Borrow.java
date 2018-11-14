package library;

import java.io.Serializable;

public class Borrow implements Serializable{
	
	private int id;
	private int cpr;

	public Borrow(int id, int cpr){
		this.id = id;
		this.cpr = cpr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCpr() {
		return cpr;
	}

	public void setCpr(int cpr) {
		this.cpr = cpr;
	}
	
	
}
