/*
 * displays and manages user's list of transactions
 *  
 *  */



package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import controller.DatabaseImportController;
import model.Budget;
import model.Date;
import model.Transaction;

//Single Transaction Panel
public class TransactionPanel extends RoundedPanel {

	private static ArrayList<SingleTransactionPanel> individualPanels; 
	private static String username = DatabaseImportController.getCurrentUser().getUsername(); 
	private static JPanel content_pnl; 
	private JPanel addTrans_pnl; 
	
	private int currentTransPanel; 
	
	
	//Buttons 
	private JButton addTransaction_btn = new JButton();
	private JButton submit_btn = new JButton(); 
	private JButton backToTransactions_btn = new JButton(); 
	private JButton backTrans_btn = new JButton(); 
	private JButton fwdTrans_btn = new JButton(); 
	private JButton refreshMonth_btn = new JButton(); 
	
	//Labels 
	private JLabel payee_lbl; 
	private JLabel total_lbl; 
	private JLabel budget_lbl; 
	private JLabel day_lbl; 
	private JLabel month_lbl; 
	private JLabel year_lbl; 
	private JLabel type_lbl; 
	
	private JLabel addTransactionTitle_lbl; 
	private JLabel transactionTitle_lbl; 
	
	//textfields 
	private JTextField payee_txtField; 
	private JTextField total_txtField; 
	private JTextField budget_txtField; //TODO Change to drop down 
	private JTextField day_txtField; 
	private JTextField month_txtField; 
	private JTextField year_txtField;
	//private JTextField type_txtField;
	
	//ComboBox 
	private JComboBox typeMenu; 
	private String typeAnswer; 
	private JComboBox budgetMenu; 
	private String budgetAnswer; 
	
	//Design
		//Fonts 
		private static Font font1 = new Font("Arial", Font.BOLD, 40);
		private static Font font2 = new Font("Arial", Font.BOLD, 20);
		private static Font font3 = new Font("Arial", Font.BOLD, 12);
		private static Font font4 = new Font("Arial", Font.PLAIN, 15);
		//Colors
		private static Color black = new Color(0, 0, 0);
		private static Color darkGray = new Color(17, 17, 17);
		private static Color midGray = new Color(30, 30, 30);
		private static Color gray = new Color(60, 60, 60);
		private static Color lightGray = new Color(77, 77, 77);
	
	@SuppressWarnings("rawtypes")
	public TransactionPanel() {
		super(20); 
		setLayout(null);
		setBackground(Color.GRAY);
		setBounds(1100, 300, 570, 700); 
		setVisible(true);
		
		currentTransPanel = 0; 
		individualPanels = new ArrayList<SingleTransactionPanel>(); 
	
		//Panels 
		content_pnl = new JPanel(); 
		content_pnl.setLayout(null);
		content_pnl.setBackground(midGray); 
		content_pnl.setBounds(10, 10, 650, 250); 
		content_pnl.setVisible(true);
		add(content_pnl); 
		
		
		addTrans_pnl = new JPanel(); 
		addTrans_pnl.setLayout(null);
		addTrans_pnl.setBackground(midGray); 
		addTrans_pnl.setBounds(10, 10, 650, 250); 
		addTrans_pnl.setVisible(false);
		add(addTrans_pnl); 
	
		
		//Labels 
		transactionTitle_lbl = new JLabel("MY TRANSACTIONS");
		transactionTitle_lbl.setBounds(10, 10, 300, 30);
		transactionTitle_lbl.setFont(font2);
		transactionTitle_lbl.setForeground(Color.WHITE);
		content_pnl.add(transactionTitle_lbl);
		
		addTransactionTitle_lbl = new JLabel("ADD NEW TRANSACTION");
		addTransactionTitle_lbl.setBounds(10, 10, 300, 30);
		addTransactionTitle_lbl.setFont(font2);
		addTransactionTitle_lbl.setForeground(Color.WHITE);
		addTrans_pnl.add(addTransactionTitle_lbl);
		

		payee_lbl = new JLabel("PAYEE");
		payee_lbl.setFont(font3);
		payee_lbl.setForeground(Color.WHITE);
		payee_lbl.setBounds(10, 50, 150, 30);
		addTrans_pnl.add(payee_lbl);
		
		total_lbl = new JLabel("TOTAL");
		total_lbl.setFont(font3);
		total_lbl.setForeground(Color.WHITE);
		total_lbl.setBounds(10, 90, 150, 30);
		addTrans_pnl.add(total_lbl);
		
		budget_lbl = new JLabel("BUDGET");
		budget_lbl.setFont(font3);
		budget_lbl.setForeground(Color.WHITE);
		budget_lbl.setBounds(10, 170, 150, 30);
		addTrans_pnl.add(budget_lbl);
		
		day_lbl = new JLabel("DATE");
		day_lbl.setFont(font3);
		day_lbl.setForeground(Color.WHITE);
		day_lbl.setBounds(10, 130, 150, 30);
		addTrans_pnl.add(day_lbl);
		
		
		
		type_lbl = new JLabel("TYPE");
		type_lbl.setFont(font3);
		type_lbl.setForeground(Color.WHITE);
		type_lbl.setBounds(10, 210, 150, 30);
		addTrans_pnl.add(type_lbl);
		
		
		//TextFields 
		payee_txtField = new JTextField("Enter Payee Name");
		payee_txtField.setBounds(70, 50, 300, 30);
		addTrans_pnl.add(payee_txtField);
		
		total_txtField = new JTextField("Enter Total");
		total_txtField.setBounds(70, 90, 300, 30);
		addTrans_pnl.add(total_txtField);
		
		day_txtField = new JTextField("DD");
		day_txtField.setBounds(70, 130, 40, 30);
		addTrans_pnl.add(day_txtField);
		
		month_txtField = new JTextField("MM");
		month_txtField.setBounds(110, 130, 40, 30);
		addTrans_pnl.add(month_txtField);
		
		year_txtField = new JTextField("YYYY");
		year_txtField.setBounds(150, 130, 60, 30);
		addTrans_pnl.add(year_txtField);
		
		//Combo Box
		
		String[] budgetArr = {"Groceries", "Rent", "Bills", "Transportation", "Course Materials", "Entertainment", "Savings" , "Credits"}; 
		budgetMenu = new JComboBox(budgetArr);
		budgetMenu.setSelectedIndex(1);
		budgetMenu.setBounds(70, 170, 300, 30);
		budgetMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JComboBox cb = (JComboBox)e.getSource();
		        budgetAnswer = (String)cb.getSelectedItem();
		      
			}
		});
		addTrans_pnl.add(budgetMenu);
		
		String[] typeArr = {"Debit", "Credit"}; 
		typeMenu = new JComboBox(typeArr);
		typeMenu.setSelectedIndex(1);
		typeMenu.setBounds(70, 210, 300, 30);
		typeMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JComboBox cb = (JComboBox)e.getSource();
		        typeAnswer = (String)cb.getSelectedItem();
		      
			}
		});
		addTrans_pnl.add(typeMenu);
	
		
	
		
		//Buttons
		addTransaction_btn = new JButton("Add"); 
		addTransaction_btn.setLayout(null);
		addTransaction_btn.setBounds(10, 200, 150, 50); 
		addTransaction_btn.setVisible(true);
		addTransaction_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addTrans_pnl.setVisible(true);
				content_pnl.setVisible(false);
				
				
				
			}
		});
		content_pnl.add(addTransaction_btn); 
		
		// Buttons
		backTrans_btn = new JButton("<--");
		backTrans_btn.setLayout(null);
		backTrans_btn.setBounds(175, 200, 40, 50);
		backTrans_btn.setVisible(true);
		backTrans_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				individualPanels.clear(); 
//				for(Transaction cur : DatabaseImportController.getCurrentUser().getTransactions()) { 
//					individualPanels.add(createTransPanel(cur)); 
//				}
				
				//Hide previous
				if (individualPanels.size() > currentTransPanel) {
					individualPanels.get(currentTransPanel).setBounds(10, 80, 200, 100);
					individualPanels.get(currentTransPanel).setVisible(false);
				}
				if (individualPanels.size() > currentTransPanel + 1) {

					individualPanels.get(currentTransPanel + 1).setBounds(215, 80, 200, 100);
					content_pnl.add(individualPanels.get(currentTransPanel + 1));
					individualPanels.get(currentTransPanel+1).setVisible(false);

				}
				if (individualPanels.size() > currentTransPanel + 2) {

					individualPanels.get(currentTransPanel + 2).setBounds(420, 80, 200, 100);
					content_pnl.add(individualPanels.get(currentTransPanel + 2));
					individualPanels.get(currentTransPanel+2).setVisible(false);

				} 
				
				currentTransPanel = currentTransPanel - 1;
				if (currentTransPanel < 0) {
					currentTransPanel = currentTransPanel + 1;
				}
				if (individualPanels.size() > currentTransPanel) {
					individualPanels.get(currentTransPanel).setBounds(10, 80, 200, 100);
					individualPanels.get(currentTransPanel).setVisible(true);
					content_pnl.add(individualPanels.get(currentTransPanel));
				}
				if (individualPanels.size() > currentTransPanel + 1) {

					individualPanels.get(currentTransPanel + 1).setBounds(215, 80, 200, 100);
					individualPanels.get(currentTransPanel + 1).setVisible(true);
					content_pnl.add(individualPanels.get(currentTransPanel + 1));

				}
				if (individualPanels.size() > currentTransPanel + 2) {

					individualPanels.get(currentTransPanel + 2).setBounds(420, 80, 200, 100);
					individualPanels.get(currentTransPanel + 2).setVisible(true);
					content_pnl.add(individualPanels.get(currentTransPanel + 2));

				}
				
				
			}
		});
		content_pnl.add(backTrans_btn);

		// Shifts Transactions list forward by 1
		fwdTrans_btn = new JButton("-->");
		fwdTrans_btn.setLayout(null);
		fwdTrans_btn.setBounds(215, 200, 40, 50);
		fwdTrans_btn.setVisible(true);
		fwdTrans_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				individualPanels.clear(); 
//				for(Transaction cur : DatabaseImportController.getCurrentUser().getTransactions()) { 
//					individualPanels.add(createTransPanel(cur)); 
//				}
				
				
				
				
				
				//Hide previous
				if (individualPanels.size() > currentTransPanel) {
					individualPanels.get(currentTransPanel).setBounds(10, 80, 200, 100);
					individualPanels.get(currentTransPanel).setVisible(false);
				}
				if (individualPanels.size() > currentTransPanel + 1) {

					individualPanels.get(currentTransPanel + 1).setBounds(215, 80, 200, 100);
					content_pnl.add(individualPanels.get(currentTransPanel + 1));
					individualPanels.get(currentTransPanel+1).setVisible(false);

				}
				if (individualPanels.size() > currentTransPanel + 2) {

					individualPanels.get(currentTransPanel + 2).setBounds(420, 80, 200, 100);
					content_pnl.add(individualPanels.get(currentTransPanel + 2));
					individualPanels.get(currentTransPanel+2).setVisible(false);

				}

				//Add new 
				currentTransPanel = currentTransPanel + 1;
				if (currentTransPanel == individualPanels.size() ) {
					currentTransPanel = currentTransPanel - 1;
				}
				if (individualPanels.size() > currentTransPanel) {
					individualPanels.get(currentTransPanel).setBounds(10, 80, 200, 100);
					individualPanels.get(currentTransPanel).setVisible(true);
					content_pnl.add(individualPanels.get(currentTransPanel));
					
				}
				if (individualPanels.size() > currentTransPanel + 1) {

					individualPanels.get(currentTransPanel + 1).setBounds(220, 80, 200, 100);
					individualPanels.get(currentTransPanel + 1).setVisible(true);
					content_pnl.add(individualPanels.get(currentTransPanel + 1));

				}
				if (individualPanels.size() > currentTransPanel + 2) {

					individualPanels.get(currentTransPanel + 2).setBounds(430, 80, 200, 100);
					individualPanels.get(currentTransPanel + 2).setVisible(true);
					content_pnl.add(individualPanels.get(currentTransPanel + 2));

				}
				
			
				
				
				//set current panels to invisible 
//				individualPanelsHide(0, 1, 2); 
//				
//				//TODO not working 
//				currentTransPanel = currentTransPanel + 1;
//				
//				if (currentTransPanel == DatabaseImportController.getTransactions().size()) {
//					currentTransPanel = currentTransPanel - 1;
//				}
//				
//				updateIndividualPanels(currentTransPanel, currentTransPanel+1, currentTransPanel+2); 
//				System.out.println("Printef"); 
				
				
//				if (DatabaseImportController.getTransactions().size() > currentTransPanel) {
//					
//					System.out.println(currentTransPanel); 
//					
//					individualPanels.get(currentTransPanel).setBounds(10, 80, 200, 100);
//					RoundedPanel newPanel = individualPanels.get(currentTransPanel);
//					content_pnl.add(newPanel);
//					
//					
//				}
//				if (DatabaseImportController.getTransactions().size() > currentTransPanel + 1) {
//
//					System.out.println(currentTransPanel); 
//					
//					individualPanels.get(currentTransPanel + 1).setBounds(220, 80, 200, 100);
//					RoundedPanel newPanel = individualPanels.get(currentTransPanel+1); 
//					content_pnl.add(newPanel);
//					
//
//				}
//				if (DatabaseImportController.getTransactions().size() > currentTransPanel + 2) {
// 
//					System.out.println(currentTransPanel); 
//					
//					individualPanels.get(currentTransPanel + 2).setBounds(430, 80, 200, 100);
//					RoundedPanel newPanel = individualPanels.get(currentTransPanel+2);
//					content_pnl.add(newPanel);
//
//				}
				

			}
		});
		content_pnl.add(fwdTrans_btn);
		
		
		backToTransactions_btn = new JButton("My Transactions");
		backToTransactions_btn.setLayout(null);
		backToTransactions_btn.setBounds(500, 10, 150, 50);
		backToTransactions_btn.setVisible(true);
		backToTransactions_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				currentTransPanel = 0; 
				content_pnl.setVisible(true);
				add(content_pnl); 
				addTrans_pnl.setVisible(false);
				
			}
		});
		addTrans_pnl.add(backToTransactions_btn);
		
		
		refreshMonth_btn = new JButton("Refresh Month");
		refreshMonth_btn.setLayout(null);
		refreshMonth_btn.setBounds(500, 10, 150, 50);
		refreshMonth_btn.setVisible(true);
		refreshMonth_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//TODO read values into sql chart 
				
			}
		});
		addTrans_pnl.add(refreshMonth_btn);
		
		
		submit_btn = new JButton("Submit");
		submit_btn.setLayout(null);
		submit_btn.setBounds(500, 70, 150, 50);
		submit_btn.setVisible(true);
		submit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String Payee = payee_txtField.getText(); 
				int Total = Integer.valueOf(total_txtField.getText());
				String Budget = budgetAnswer; 
				int day = Integer.valueOf(day_txtField.getText()); 
				int month = Integer.valueOf(month_txtField.getText()); 
				int year = Integer.valueOf(year_txtField.getText());  
				Date date = new Date(day, month, year); 
				boolean Type = false; 
				if(typeAnswer.equals("Debit")) {
					Type = true; 
				}
				
				if (Budget.equals("Savings") && Type == true) {
					//award 10 points 
					GoalsPanel.savingsDepositCount = GoalsPanel.savingsDepositCount + 1;
					DatabaseImportController.getCurrentUser().setPoints(DatabaseImportController.getCurrentUser().getPoints() + 10); 
					GoalsPanel.updateMyGoal(); 
				}
				
				//Creates a new Transaction object and adds it to user 
				Transaction newTrans = new Transaction(Payee, Total, Budget, date, Type); 
				DatabaseImportController.getCurrentUser().getTransactions().add(newTrans);
				SingleTransactionPanel newPanel = new SingleTransactionPanel(newTrans); 
				individualPanels.add(newPanel);
				
				
				
//				for(Budget cur : DatabaseImportController.getCurrentUser().getBudgets() ) {
//					System.out.println(cur.getName() + " = " + cur.getCurrentAmount());
//				}
//				
//				for(Transaction cur : DatabaseImportController.getCurrentUser().getTransactions() ) {
//					System.out.println(cur.getPayee() + "," + cur.getAmount() + "," + cur.getBudget()
//						+ "," + cur.getDate().getMonth() + "," + cur.isType());
//				}
				
				Budget savingsAcct = null; 
				Budget creditsAcct = null; 
				
				for(Budget cur : DatabaseImportController.getCurrentUser().getBudgets()) {
					if(cur.getName().equals("Savings")) {
						savingsAcct = cur; 
					}
					if(cur.getName().equals("Credits")) {
						creditsAcct = cur;
					}
				}
			
				//Updates other budget objects
				if(Type) { //If the user earns money add to whatever category chosen 
					for(Budget cur : DatabaseImportController.getCurrentUser().getBudgets()) {
						if(cur.getName().equals(Budget)) {
							if(cur.getCurrentAmount() + Total > cur.getTotalAllocated()) { //extra goes into savings 
								double leftover = cur.getCurrentAmount() + Total - cur.getTotalAllocated(); 
								cur.setCurrentAmount(cur.getTotalAllocated()); 
								savingsAcct.setCurrentAmount(savingsAcct.getCurrentAmount() + leftover); 
							}else {
								cur.setCurrentAmount(cur.getCurrentAmount() + Total); 
							}
						}
						if(cur.getName().equals("Total")) {
							cur.setCurrentAmount(cur.getCurrentAmount() + Total); //Add to savings
						}
					}
				}else { //User is paying money 
					
					
					
					for(Budget cur : DatabaseImportController.getCurrentUser().getBudgets()) {
				
						if (cur.getName().equals(Budget)) {

							if (cur.getCurrentAmount() < Total) { // Over the budget
								// set current to 0 and deduct from savings
								cur.setCurrentAmount(0); // set current amount to 0
								double leftover = Total - cur.getCurrentAmount();
								if (savingsAcct.getCurrentAmount() < leftover) {
									savingsAcct.setCurrentAmount(0);
									creditsAcct.setCurrentAmount(creditsAcct.getCurrentAmount() + leftover);
								} else {
									savingsAcct.setCurrentAmount(savingsAcct.getCurrentAmount() - leftover);
								}
							} else { //within the 
								cur.setCurrentAmount(cur.getCurrentAmount() - Total);
							}

						}
						if (cur.getName().equals("Total")) {
							cur.setCurrentAmount(cur.getCurrentAmount() - Total); // Add to savings
						}
						
					}
				}

//				for(Budget cur : DatabaseImportController.getCurrentUser().getBudgets() ) {
//					System.out.println(cur.getName() + " = " + cur.getCurrentAmount());
//				}
//				
				//Update individual transaction Panels 
				
				//updateIndividualPanels(0,1,2); 
				
				DashboardPanel.resetProgress(); 
				
			}
		});
		addTrans_pnl.add(submit_btn);
		

		updateIndividualPanels(0,1,2);
		currentTransPanel = 0; 
		
	}
	
	public static SingleTransactionPanel createTransPanel(Transaction transaction) {
		
		SingleTransactionPanel newPanel = new SingleTransactionPanel(transaction); 
		
		
		return newPanel; 
	}
	
	public static void updateIndividualPanels(int first, int second, int third ) {
		
		individualPanels.clear(); 
		for(Transaction cur : DatabaseImportController.getCurrentUser().getTransactions()) { 
			individualPanels.add(createTransPanel(cur)); 
		}
		System.out.println(individualPanels.size());
		
		
		//Validate to print all transactions
		if(!(individualPanels.size() <= first)) {
			individualPanels.get(first).setBounds(10, 80, 200, 100);
			individualPanels.get(first).setVisible(true);
			content_pnl.add(individualPanels.get(first)); 
		}
		if(!(individualPanels.size() <= second)) {
			individualPanels.get(second).setBounds(220, 80, 200, 100);
			individualPanels.get(first).setVisible(true);
			content_pnl.add(individualPanels.get(second)); 
		}
		if(!(individualPanels.size() <= third)) {
			individualPanels.get(third).setBounds(430, 80, 200, 100);
			individualPanels.get(first).setVisible(true);
			content_pnl.add(individualPanels.get(third)); 
		}
		
	

	}
	
	public static void individualPanelsHide(int first, int second, int third) {
		
		individualPanels.clear(); 
		for(Transaction cur : DatabaseImportController.getCurrentUser().getTransactions()) { 
			individualPanels.add(createTransPanel(cur)); 
		}
		System.out.println(individualPanels.size());
		
//		individualPanels.get(first).setVisible(false); 
//		individualPanels.get(second).setVisible(false); 
//		individualPanels.get(third).setVisible(false); 
//		
//		
		//Validate to print all transactions
//		if(!(individualPanels.size() <= first)) {
//			individualPanels.get(first).setVisible(false); 
//		}
//		if(!(individualPanels.size() <= second)) {
//			individualPanels.get(second).setVisible(false); 
//		}
//		if(!(individualPanels.size() <= third)) {
//			individualPanels.get(third).setVisible(false); 
//		}
		
	}
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
