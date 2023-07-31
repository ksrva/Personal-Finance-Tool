

/*
Reads in all data from mySQL tables when program frame i sopened to user's frame 
 *  
 *  */

package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import model.*;

public class DatabaseImportController {
	
	private static User currentUser;
	private static ArrayList<Budget> budgets; 
	private static ArrayList<Transaction> transactions;
	private static double[] monthlySavings; 
	private static HashMap<String,Integer> userPoints; 
	private static HashMap<String,double[]> monthlyLog; 

	//Will import files from MySQL database based on username 
	public DatabaseImportController(String username) {
		
		currentUser = new User(); 
		budgets = new ArrayList<Budget>();
		transactions = new ArrayList<Transaction>();
		monthlySavings = new double[12]; 
		userPoints = new HashMap<String,Integer>(); 
		monthlyLog = new HashMap<String,double[]>(); 
		
		
		//Connect to database table for budgets and create budget objects to put in list  
		//Code for reading in from database was referenced from :  https://alvinalexander.com/java/java-mysql-select-query-example/
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pwm","root","Bubbletea_23");  
			java.sql.Statement stmt = con.createStatement();
		    String sql = "SELECT * FROM `budget` WHERE `user` = '" + username + "'";
		    stmt.execute(sql);
		    ResultSet rs = stmt.executeQuery(sql);
		    if (rs.next())
		    {
		    	

		
		    	
		    	budgets = new ArrayList<Budget>(); 
		    	
		    	
		    	
		    	double Groceries = Double.valueOf(rs.getString("Groceries"));
		    
		    	double groceriesValue = Double.valueOf(rs.getString("groceriesValue")); //current amount  
		    	budgets.add(new Budget("Groceries", Groceries, groceriesValue, true, new ArrayList<Transaction>()));
		    	
		   
		    	
		    	double Rent = Double.valueOf(rs.getString("Rent"));
		    	double rentValue = Double.valueOf(rs.getString("rentValue")); 
		    	budgets.add(new Budget("Rent", Rent, rentValue, true, new ArrayList<Transaction>())); 
		    	
		    	double Bills = Double.valueOf(rs.getString("Bills"));
		    	double billsValue = Double.valueOf(rs.getString("billsValue")); 
		    	budgets.add(new Budget("Bills", Bills, billsValue, true, new ArrayList<Transaction>()));  
		    	
		    	double Transportation = Double.valueOf(rs.getString("Transportation"));
		    	double transportationValue = Double.valueOf(rs.getString("transportationValue")); 
		      	budgets.add(new Budget("Transportation", Transportation, transportationValue, true, new ArrayList<Transaction>()));  
		    	
		      	double Coursematerials = Double.valueOf(rs.getString("Coursematerials"));
		      	double courseValue = Double.valueOf(rs.getString("courseValue")); 
		    	budgets.add(new Budget("Course Materials", Coursematerials, courseValue, true, new ArrayList<Transaction>()));
		    	
		    	double Entertainment = Double.valueOf(rs.getString("Entertainment"));
		    	double enterValue = Double.valueOf(rs.getString("enterValue")); 
		    	budgets.add(new Budget("Entertainment", Entertainment, enterValue, true, new ArrayList<Transaction>())); 
		    	
		    	double Savings = Double.valueOf(rs.getString("Savings"));
		    	//double savingsValue = Integer.valueOf(rs.getString("savingsValue")); TODO is this needed?  
		    	budgets.add(new Budget("Savings", Savings, Savings, true, new ArrayList<Transaction>())); 
		    	
		    	double Credits = Double.valueOf(rs.getString("Credits"));
		     	//double creditsValue = Integer.valueOf(rs.getString("creditsValue")); TODO us this needed? 
		    	budgets.add(new Budget("Credits", Credits, Credits, true, new ArrayList<Transaction>())); 
		    	
		    	double Total = Double.valueOf(rs.getString("Total"));
		    	double totalValue = Double.valueOf(rs.getString("totalValue")); 
		    	budgets.add(new Budget("Total", Total, totalValue, true, new ArrayList<Transaction>())); 

		    	
		    	
		    } else {

		        // error message
		        JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "Login Failed", 2);
		    }
			con.close();  
			
		}catch(Exception e1){ System.out.println(e1);} 
		 
		
		//Read in user's transactions 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pwm", "root", "Bubbletea_23");
			java.sql.Statement stmt = con.createStatement();
			String sql = "SELECT * FROM Transactions";
			stmt.execute(sql);
			ResultSet rs = stmt.executeQuery(sql);

			transactions = new ArrayList<Transaction>(); 
			while (rs.next()) {
				if (rs.getString("user").equals(username)) {
					String Payee = rs.getString("Payee");
					double amount = Double.valueOf(rs.getString("Amount")); 
					String budget = rs.getString("Budget"); 
					int day = Integer.valueOf(rs.getString("Date")); 
					int month = Integer.valueOf(rs.getString("month")); 
					int year = Integer.valueOf(rs.getString("year")); 
					Date date = new Date(day, month, year); 
					String typeStr = rs.getString("Type"); 
					boolean type = false; 
					if(typeStr.equals("debit")) {
						type = true; 
					}
				
					Transaction newTransac = new Transaction(Payee, amount, budget, date, type);
					transactions.add(newTransac); 
					for(Budget cur : budgets) {
						if(budget.equals(cur.getName())) {
							cur.getTransList().add(newTransac); 
						}
					}
					
				}

			}
			
			for(Budget curB : budgets ) {
				for(Transaction curT : curB.getTransList()) {
					System.out.println(curB.getName() + ", " + curT.getBudget()); 
				}
			}
			con.close();

		} catch (Exception e1) {
			System.out.println(e1);
		}
		

		//Read in monthly log
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pwm", "root", "Bubbletea_23");
			java.sql.Statement stmt = con.createStatement();
			String sql = "SELECT * FROM " + username + "_ExpenseReport";
			stmt.execute(sql);
			ResultSet rs = stmt.executeQuery(sql);

			monthlyLog = new HashMap<String, double[]>(); 
			
			while (rs.next()) {
				String Month = rs.getString("Month"); //key
				//values 
				double Groceries = Double.valueOf(rs.getString("Groceries"));
				double Rent = Double.valueOf(rs.getString("Rent"));
				double Bills = Double.valueOf(rs.getString("Bills"));
				double Transportation = Double.valueOf(rs.getString("Transportation"));
				double Coursematerials = Double.valueOf(rs.getString("Coursematerials"));
				double Entertainment = Double.valueOf(rs.getString("Entertainment"));
				double Savings = Double.valueOf(rs.getString("Investment"));
				
				double[] budgets = {Groceries, Rent, Bills, Transportation, Coursematerials, Entertainment, Savings}; 
				
				monthlyLog.put(Month, budgets); 
				

			}
			
			
			con.close();

		} catch (Exception e1) {
			System.out.println(e1);
		}
		
		
		//Connect and read in data from user table to create user object 
				try{  
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pwm","root","Bubbletea_23");  
					java.sql.Statement stmt = con.createStatement();
				    String sql = "SELECT * FROM `userinfor` WHERE `UserName` = '" + username + "'";
				    stmt.execute(sql);
				    ResultSet rs = stmt.executeQuery(sql);
				    if (rs.next())
				    {
				    	
				    	ArrayList<String> list = new ArrayList<String>(); 
				    	String lastname = rs.getString("LastName");
				    	list.add(lastname); 
				    	String email = rs.getString("EMail");
				    	list.add(email); 
				    	String income = rs.getString("MonthlyIncome");
				    	list.add(income); 
//				    	String user_name = rs.getString("UserName");
//				    	list.add(user_name); 
				    	String password = rs.getString("Pass_word");
				    	list.add(password);
				    	int points = Integer.valueOf(rs.getString("Points")); 
				    	
				    	double totalSavingsGoal = Double.valueOf(rs.getString("TotalSavingsGoal")); 
				    	
				    	currentUser = new User(lastname, email, income, username, password, budgets, transactions, points, totalSavingsGoal, monthlyLog); 
				    	
				    	
				 
				    } else {

				        // error message
				        JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "Login Failed", 2);
				    }
					con.close();  
					
				}catch(Exception e1){ System.out.println(e1);}

	
				
				
				
				//Read in users and their points for leaderboard  
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pwm", "root", "Bubbletea_23");
					java.sql.Statement stmt = con.createStatement();
					String sql = "SELECT * FROM userinfor";
					stmt.execute(sql);
					ResultSet rs = stmt.executeQuery(sql);

					
					
					while (rs.next()) {
						
						String userName = rs.getString("UserName");
						int points = Integer.valueOf(rs.getString("Points"));
						
						userPoints.put(userName, points); 

					}
					
					con.close();

				} catch (Exception e1) {
					System.out.println(e1);
				}
				
				
				
				
	}

	public static User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public static ArrayList<Budget> getBudgets() {
		return budgets;
	}

	public void setBudgets(ArrayList<Budget> budgets) {
		this.budgets = budgets;
	}

	public static ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public static void setTransactions(ArrayList<Transaction> transactions) {
		transactions = transactions;
	}

	public static double[] getMonthlySavings() {
		return monthlySavings;
	}

	public static void setMonthlySavings(double[] monthlySavings) {
		DatabaseImportController.monthlySavings = monthlySavings;
	}

	public static HashMap<String, Integer> getUserPoints() {
		return userPoints;
	}

	public static void setUserPoints(HashMap<String, Integer> userPoints) {
		DatabaseImportController.userPoints = userPoints;
	}
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
}
