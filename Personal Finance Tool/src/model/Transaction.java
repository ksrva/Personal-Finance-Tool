
/*
 * Represents a single transaction made by the user. This is later passed back into the table when the user logs out 
 *  */


package model;

public class Transaction {
	
	//FIELDS 
	private String payee; 
	private double amount; 
	private String budget; 
	private Date date; 
	private boolean Type; //TODO What to call
	
	public Transaction(String payee, double amount, String budget, Date date, boolean type) {
		super();
		this.payee = payee;
		this.amount = amount;
		this.budget = budget;
		this.date = date;
		Type = type;
	}
	
	//GETTERS AND SETTERS 
	public String getPayee() {
		return payee;
	}
	public void setPayee(String payee) {
		this.payee = payee;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
	
	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isType() {
		return Type;
	}
	public void setType(boolean type) {
		Type = type;
	} 
	
	
	

}
