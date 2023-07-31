
/*
 * Represents a date : day month and year
 *  */


package model;

public class Date {
	
	//FIELDS 
	private int date; 
	private int month; 
	private int year;
	
	//CONSTRUCTOR
	public Date(int date, int month, int year) {
		super();
		this.date = date;
		this.month = month;
		this.year = year;
	}
	
	//GETTERS & SETTERS
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	} 
	
	
	

}
