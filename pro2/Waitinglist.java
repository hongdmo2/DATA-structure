import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
public class Waitinglist implements Comparable<Waitinglist>{
	private String firstName;
	private String lastName;
	private int IDNo;
	//Constructor

	public Waitinglist(String firstName, String lastName, int IDNo) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.IDNo = IDNo;
	}
	//getters and setters

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getIDNo() {
		return IDNo;
	}

	public void setIDNo(int IDNo) {
		this.IDNo = IDNo;
	}


	public boolean equals(Object x) {
		
		Waitinglist student = (Waitinglist) x;
		return IDNo == student.IDNo;
	}


	public int compareTo(Waitinglist x) {
		if(firstName.equalsIgnoreCase(x.firstName))
			return lastName.compareTo(x.lastName);
		else 
			return firstName.compareTo(x.firstName);
		
	}

	public String toString() {
		return "Student: " + "Name: " + this.getFirstName() +" " +
				this.getLastName() + " :::ID number: "+this.getIDNo();
				
	}
	
	

}
 
