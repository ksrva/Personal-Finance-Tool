

/*
Represents the current user. All users are created on registration and passed into sql table
 *  */


package model;

import java.util.ArrayList;
import java.util.HashMap;

public class User {

	//FIELDS 
	private String lastName; 
	private String email; 
	private String income; 
	private String username; 
	private String password;
	private ArrayList<Budget> budgets;
	private ArrayList<Transaction> transactions;
	private int points; 
	private double annualSavingsGoal;
	private HashMap<String, double[]> monthlyLog; 
	
	
	public User() {
		
	}
	//CONSTRUCTOR 
	public User(String lastName, String email, String income, String username, String password,
			ArrayList<Budget> budgets, ArrayList<Transaction> transactions, int points, double annualSavingsGoal, HashMap<String, double[]> monthlyLog) {
		super();
		this.lastName = lastName;
		this.email = email;
		this.income = income;
		this.username = username;
		this.password = password;
		this.budgets = budgets;
		this.transactions = transactions;
		this.points = points; 
		this.annualSavingsGoal = annualSavingsGoal;
		this.monthlyLog = monthlyLog; 
	}
	
	//GETTERS & SETTERS 
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<Budget> getBudgets() {
		return budgets;
	}
	public void setBudgets(ArrayList<Budget> budgets) {
		this.budgets = budgets;
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public double getAnnualSavingsGoal() {
		return annualSavingsGoal;
	}
	public void setAnnualSavingsGoal(double annualSavingsGoal) {
		this.annualSavingsGoal = annualSavingsGoal;
	}
	public HashMap<String, double[]> getMonthlyLog() {
		return monthlyLog;
	}
	public void setMonthlyLog(HashMap<String, double[]> monthlyLog) {
		this.monthlyLog = monthlyLog;
	} 
	
	

	
}
