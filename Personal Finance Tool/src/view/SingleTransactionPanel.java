/*
 * Panel to represent a single transaction ont he user's transaction panel section
 */



package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import model.Transaction;

public class SingleTransactionPanel extends RoundedPanel {

	//FIELDS 
	private Transaction transaction;
	
	private JLabel payee_lbl; 
	private JLabel amount_lbl; 
	private JLabel budget_lbl; 
	private JLabel date_lbl;
	private JLabel type_lbl; 
	
	// Design
	// Fonts
	private static Font font1 = new Font("Arial", Font.BOLD, 40);
	private static Font font2 = new Font("Arial", Font.BOLD, 20);
	private static Font font3 = new Font("Arial", Font.BOLD, 12);
	private static Font font4 = new Font("Arial", Font.PLAIN, 15);
	// Colors
	private static Color black = new Color(0, 0, 0);
	private static Color darkGray = new Color(17, 17, 17);
	private static Color midGray = new Color(30, 30, 30);
	private static Color gray = new Color(60, 60, 60);
	private static Color lightGray = new Color(77, 77, 77);

	//CONSTRUCTOR 
	public SingleTransactionPanel(Transaction transaction) {
		super(20);
		this.transaction = transaction;
		
		setLayout(null);
		setBackground(gray);
		setSize(200, 100); 
		setVisible(true);
	

		//Labels 
		payee_lbl = new JLabel("PAYEE: " + transaction.getPayee());
		payee_lbl.setFont(font3);
		payee_lbl.setForeground(Color.white);
		payee_lbl.setBounds(10, 10, 150, 30);
		add(payee_lbl);
		
		amount_lbl = new JLabel("AMOUNT: $" + transaction.getAmount());
		amount_lbl.setFont(font3);
		amount_lbl.setForeground(Color.white);
		amount_lbl.setBounds(10, 25, 150, 30);
		add(amount_lbl);
		
		budget_lbl = new JLabel("BUDGET: " + transaction.getBudget());
		budget_lbl.setFont(font3);
		budget_lbl.setForeground(Color.white);
		budget_lbl.setBounds(10, 40, 150, 30);
		add(budget_lbl);
		
		date_lbl = new JLabel("DATE: " + transaction.getDate().getDate() 
				+ " " + transaction.getDate().getMonth() + " " 
				+ transaction.getDate().getYear());
		date_lbl.setFont(font3);
		date_lbl.setForeground(Color.white);
		date_lbl.setBounds(10, 55, 150, 30);
		add(date_lbl);
		
		String type = "Credit"; 
		if(transaction.isType()) {
			type = "Debit"; 
		}
		
		type_lbl = new JLabel("TYPE: " + type);  
		type_lbl.setFont(font3);
		type_lbl.setForeground(Color.white);
		type_lbl.setBounds(10, 70, 150, 30);
		add(type_lbl);
		
		
	} 
	
	
	
	
	
	
}
