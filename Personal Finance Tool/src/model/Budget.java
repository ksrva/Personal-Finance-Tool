

/*
Represents a single budget distribution of the user's income to keep track of financial distirbution*  */
package model;

import java.util.ArrayList;

public class Budget {

	//FIELDS 
	private String name; 
	private double totalAllocated; 
	private double currentAmount; 
	private boolean isDisplayed;
	private ArrayList<Transaction> transList; 
	
	//CONTRUCTOR 
	public Budget(String name, double totalAllocated, double currentAmount, boolean isDisplayed,
			ArrayList<Transaction> transList) {
		super();
		this.name = name;
		this.totalAllocated = totalAllocated;
		this.currentAmount = currentAmount;
		this.isDisplayed = isDisplayed;
		this.transList = transList;
	}
	
	
	
	//GETTERS AND SETTERS 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public double getTotalAllocated() {
		return totalAllocated;
	}
	public void setTotalAllocated(double newValues) {
		this.totalAllocated = newValues;
	}
	public double getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(double d) {
		this.currentAmount = d;
	}
	public boolean isDisplayed() {
		return isDisplayed;
	}
	public void setDisplayed(boolean isDisplayed) {
		this.isDisplayed = isDisplayed;
	}



	public ArrayList<Transaction> getTransList() {
		return transList;
	}



	public void setTransList(ArrayList<Transaction> transList) {
		this.transList = transList;
	} 
	
	
}
