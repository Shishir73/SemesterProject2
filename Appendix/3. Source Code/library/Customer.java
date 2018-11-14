package library;

import java.io.Serializable;

public class Customer implements Serializable{
	private String fullName;
	private String studentNo;
	private int CPR;
	private MyDate validity;
	
	public Customer(String fullName, String studentNo, int CPR, MyDate validity){
		this.fullName = fullName;
		this.studentNo = studentNo;
		this.CPR = CPR;
		this.validity = validity;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public int getCPR() {
		return CPR;
	}

	public void setCPR(int cPR) {
		CPR = cPR;
	}

	public MyDate getValidity() {
		return validity;
	}

	public void setValidity(MyDate validity) {
		this.validity = validity;
	}
	
	
}
