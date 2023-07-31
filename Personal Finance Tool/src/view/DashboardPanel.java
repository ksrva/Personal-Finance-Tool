/*
 * (Main) Panel to Holds all panels 
 */

package view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import controller.DatabaseImportController;
import model.Budget;

//Displays current Budget progress 
public class DashboardPanel extends JPanel {

	private String username; 
	
	// labels (gen) 
	private JLabel welcome_lbl;
	private JLabel welcomeSub_lbl;
	private JLabel overview_lbl;
	private JLabel transactionsTitle_lbl;  
	
	//progress labels  
	private JLabel groceriesBar_lbl; 
	private JLabel rentBar_lbl;
	private JLabel billsBar_lbl;
	private JLabel transportationBar_lbl; 
	private JLabel courseBar_lbl; 
	private JLabel entertainmentBar_lbl; 
	private JLabel savingsBar_lbl; 
	private JLabel creditBar_lbl; 
	private JLabel totalBar_lbl; 
	
	//Progress bars 
	private JProgressBar groceries_bar;
	private JProgressBar rent_bar;
	private JProgressBar bills_bar;
	private JProgressBar transportation_bar;
	private JProgressBar course_bar;
	private JProgressBar entertainment_bar;
	private JProgressBar savings_bar;
	private JProgressBar credit_bar;
	private JProgressBar total_bar;
		
	//Panels 
	//private BudgetPanel budget_pnl; 
	private BudgetSettingsPanel budgetSettings_pnl; 
	private GoalsPanel goals_pnl; 
	
	//Progress overview panels 
	private static RoundedPanel progress_pnl;
	private RoundedPanel transactions_pnl; 
	
	private RoundedPanel totalProgress_pnl; 
	private RoundedPanel groceriesProgress_pnl; 
	private RoundedPanel rentProgress_pnl; 
	private RoundedPanel billsProgress_pnl; 
	private RoundedPanel transportationProgress_pnl; 
	private RoundedPanel courseProgress_pnl; 
	private RoundedPanel enterProgress_pnl; 
	private RoundedPanel savingsProgress_pnl; 
	private RoundedPanel creditProgress_pnl; 
	
	private JPanel savings_pnl; 
	private JPanel credits_pnl;
	
	
	//Buttons 
	private JButton settings_btn = new JButton();  
	private JButton return_btn = new JButton(); 
	private JButton goals_btn = new JButton(); 
	
	//Design
	//Fonts 
	private static Font font1 = new Font("Arial", Font.BOLD, 40);
	private static Font font2 = new Font("Arial", Font.BOLD, 20);
	private static Font font3 = new Font("Arial", Font.BOLD, 10);
	private static Font font4 = new Font("Arial", Font.PLAIN, 15);
	//Colors
	private static Color black = new Color(0, 0, 0);
	private static Color darkGray = new Color(17, 17, 17);
	private static Color midGray = new Color(30, 30, 30);
	private static Color gray = new Color(60, 60, 60);
	private static Color lightGray = new Color(77, 77, 77);
	
	private static ArrayList<JProgressBar> progressBars; 
	private static ArrayList<JLabel> progressLabels; 
	private static ArrayList<RoundedPanel> progressPanels; 
	
	public DashboardPanel(String username) {
		
		
		setLayout(null);
		setBounds(0, 0, 1680, 1000);
		setBackground(darkGray); 
		
		// LABELS

		// Format Full Name for display
		String userFullName = DatabaseImportController.getCurrentUser().getLastName();
		String lowercaseName = userFullName.toLowerCase();
		char firstChar = lowercaseName.charAt(0);
		char capitalizedFirstChar = Character.toUpperCase(firstChar);
		String finalName = capitalizedFirstChar + lowercaseName.substring(1);

		welcome_lbl = new JLabel("Personal Finance Tracker");
		welcome_lbl.setBounds(100, 100, 500, 50);
		welcome_lbl.setFont(font1);
		welcome_lbl.setForeground(Color.WHITE);
		add(welcome_lbl);

		welcomeSub_lbl = new JLabel("Welcome to your dashboard " + finalName);
		welcomeSub_lbl.setBounds(100, 170, 500, 50);
		welcomeSub_lbl.setFont(font2);
		welcomeSub_lbl.setForeground(Color.lightGray);
		add(welcomeSub_lbl);
		
		
		overview_lbl = new JLabel("MONTHLY OVERVIEW");
		overview_lbl.setBounds(100, 250, 500, 50);
		overview_lbl.setFont(font2);
		overview_lbl.setForeground(Color.WHITE);
		add(overview_lbl);
		
		// progress overview section TODO add button to change from percentage to ratio
		
		progressBars = new ArrayList<JProgressBar>();
		progressLabels = new ArrayList<JLabel>();
		progressPanels = new ArrayList<RoundedPanel>(); 
		 
		
		
		// GOALS
		goals_pnl = new GoalsPanel();
		goals_pnl.setLayout(null);
		goals_pnl.setBounds(95+710, 310+275+15, 775, 275);
		goals_pnl.setBackground(midGray);
		add(goals_pnl);
		
		
		//TANSACTIONS
		transactions_pnl = new TransactionPanel();
		transactions_pnl.setLayout(null);
		transactions_pnl.setBounds(95, 310+275+15, 700, 275);
		transactions_pnl.setBackground(midGray);
		add(transactions_pnl);
		//One by swiping 
		
		//PROGRESS
		progress_pnl = new RoundedPanel(20);
		progress_pnl.setLayout(null);
		progress_pnl.setBounds(95, 310, 1485, 275);
		progress_pnl.setBackground(midGray);
		add(progress_pnl);
		

		budgetSettings_pnl = new BudgetSettingsPanel(username); 
		budgetSettings_pnl.setBounds(95, 310, 1485, 275);
		budgetSettings_pnl.setBackground(midGray);
		budgetSettings_pnl.setVisible(false);
		add(budgetSettings_pnl); 
		
		//Buttons
		//Switch to settigns panel
		settings_btn = new JButton("Budget Settings"); 
		settings_btn.setLayout(null);
		settings_btn.setBounds(15, 200, 200, 50); 
		settings_btn.setVisible(true);
		settings_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				progress_pnl.setVisible(false);
				budgetSettings_pnl.setVisible(true);
			}
		});
		progress_pnl.add(settings_btn); 
		
		//Switch to main Budgets Progress panel 
		return_btn = new JButton("Return to Progress"); 
		return_btn.setLayout(null);
		return_btn.setBounds(350, 250, 200, 50); 
		return_btn.setVisible(true);
		return_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				progress_pnl.setVisible(true);
				budgetSettings_pnl.setVisible(false);
				
			}
		});
		add(return_btn); 
		
	
		


		double total = 0; 
		double current = 0;
		int percent = 0; 
		
		//Buttom row (expense) 
		// Groceries progress
		int x = 15;
		int a = 230;
		int b = 75; 
		int y = 15+b+15;
		
		groceriesProgress_pnl = new RoundedPanel(20);
		groceriesProgress_pnl.setLayout(null);
		groceriesProgress_pnl.setBounds(x, y, a, b);
		groceriesProgress_pnl.setBackground(gray);
		progressPanels.add(groceriesProgress_pnl); 
		progress_pnl.add(groceriesProgress_pnl);

		total = DatabaseImportController.getBudgets().get(0).getTotalAllocated();
		current = DatabaseImportController.getBudgets().get(0).getCurrentAmount();


		groceriesBar_lbl = new JLabel("GROCERIES: $" + current + " / $" + total);
		groceriesBar_lbl.setFont(font3);
		groceriesBar_lbl.setForeground(Color.WHITE);
		groceriesBar_lbl.setBounds(10, 10, 300, 30);
		progressLabels.add(groceriesBar_lbl);
		groceriesProgress_pnl.add(groceriesBar_lbl);

		groceries_bar = new JProgressBar(SwingConstants.HORIZONTAL, 0, (int) total);
		groceries_bar.setValue((int) total);
		groceries_bar.setBounds(10, 30, 150, 50);
		progressBars.add(groceries_bar);
		groceriesProgress_pnl.add(groceries_bar);

		// Rent progress
		x = x + a + 15;
		rentProgress_pnl = new RoundedPanel(20);
		rentProgress_pnl.setLayout(null);
		rentProgress_pnl.setBounds(x, y, a, b);
		rentProgress_pnl.setBackground(gray);
		progressPanels.add(rentProgress_pnl); 
		progress_pnl.add(rentProgress_pnl);

		total = DatabaseImportController.getBudgets().get(1).getTotalAllocated();
		current = DatabaseImportController.getBudgets().get(1).getCurrentAmount();

		rentBar_lbl = new JLabel("RENT: $" + current + " / $" + total);
		rentBar_lbl.setFont(font3);
		rentBar_lbl.setForeground(Color.WHITE);
		rentBar_lbl.setBounds(10, 10, 300, 30);
		progressLabels.add(rentBar_lbl);
		rentProgress_pnl.add(rentBar_lbl);

		rent_bar = new JProgressBar(SwingConstants.HORIZONTAL, 0, (int) total);
		rent_bar.setValue((int) total);
		rent_bar.setBounds(10, 30, 150, 50);
		progressBars.add(rent_bar);
		rentProgress_pnl.add(rent_bar);
				
		// Bills progress
		x = x + a + 15;
		billsProgress_pnl = new RoundedPanel(20);
		billsProgress_pnl.setLayout(null);
		billsProgress_pnl.setBounds(x, y, a, b);
		billsProgress_pnl.setBackground(gray);
		progressPanels.add(billsProgress_pnl); 
		progress_pnl.add(billsProgress_pnl);

		total = DatabaseImportController.getBudgets().get(2).getTotalAllocated();
		current = DatabaseImportController.getBudgets().get(2).getCurrentAmount();


		billsBar_lbl = new JLabel("BILLS: $" + current + " / $" + total);
		billsBar_lbl.setFont(font3);
		billsBar_lbl.setForeground(Color.WHITE);
		billsBar_lbl.setBounds(10, 10, 300, 30);
		progressLabels.add(billsBar_lbl);
		billsProgress_pnl.add(billsBar_lbl);

		bills_bar = new JProgressBar(SwingConstants.HORIZONTAL, 0, (int) total);
		bills_bar.setValue((int) total);
		bills_bar.setBounds(10, 30, 150, 50);
		progressBars.add(bills_bar);
		billsProgress_pnl.add(bills_bar);
		
		// Transportation progress
		x = x + a + 15;
		transportationProgress_pnl = new RoundedPanel(20);
		transportationProgress_pnl.setLayout(null);
		transportationProgress_pnl.setBounds(x, y, a, b);
		transportationProgress_pnl.setBackground(gray);
		progressPanels.add(transportationProgress_pnl); 
		progress_pnl.add(transportationProgress_pnl);

		total = DatabaseImportController.getBudgets().get(3).getTotalAllocated();
		current = DatabaseImportController.getBudgets().get(3).getCurrentAmount();

	

		transportationBar_lbl = new JLabel("TRANSPORTATION: $" + current + " / $" + total);
		transportationBar_lbl.setFont(font3);
		transportationBar_lbl.setForeground(Color.WHITE);
		transportationBar_lbl.setBounds(10, 10, 300, 30);
		progressLabels.add(transportationBar_lbl);
		transportationProgress_pnl.add(transportationBar_lbl);

		transportation_bar = new JProgressBar(SwingConstants.HORIZONTAL, 0, (int) total);
		transportation_bar.setValue((int) total);
		transportation_bar.setBounds(10, 30, 150, 50);
		progressBars.add(transportation_bar);
		transportationProgress_pnl.add(transportation_bar);
		
		// Course Materials progress
		x = x + a + 15;
		courseProgress_pnl = new RoundedPanel(20);
		courseProgress_pnl.setLayout(null);
		courseProgress_pnl.setBounds(x, y, a, b);
		courseProgress_pnl.setBackground(gray);
		progressPanels.add(courseProgress_pnl); 
		progress_pnl.add(courseProgress_pnl);

		total = DatabaseImportController.getBudgets().get(4).getTotalAllocated();
		current = DatabaseImportController.getBudgets().get(4).getCurrentAmount();


		courseBar_lbl = new JLabel("COURSE MATERIALS: $" + current + " / $" + total);
		courseBar_lbl.setFont(font3);
		courseBar_lbl.setForeground(Color.WHITE);
		courseBar_lbl.setBounds(10, 10, 300, 30);
		progressLabels.add(courseBar_lbl);
		courseProgress_pnl.add(courseBar_lbl);

		course_bar = new JProgressBar(SwingConstants.HORIZONTAL, 0, (int) total);
		course_bar.setValue((int) total);
		course_bar.setBounds(10, 30, 150, 50);
		progressBars.add(course_bar);
		courseProgress_pnl.add(course_bar);

		
		// Entertainment progress
		x = x + a + 15;
		enterProgress_pnl = new RoundedPanel(20);
		enterProgress_pnl.setLayout(null);
		enterProgress_pnl.setBounds(x, y, a, b);
		enterProgress_pnl.setBackground(gray);
		progressPanels.add(enterProgress_pnl); 
		progress_pnl.add(enterProgress_pnl);

		total = DatabaseImportController.getBudgets().get(5).getTotalAllocated();
		current = DatabaseImportController.getBudgets().get(5).getCurrentAmount();

		percent = (int) ((100 / total) * current);

		entertainmentBar_lbl = new JLabel("ENTERTAINMENT: $" + current + " / $" + total);
		entertainmentBar_lbl.setFont(font3);
		entertainmentBar_lbl.setForeground(Color.WHITE);
		entertainmentBar_lbl.setBounds(10, 10, 300, 30);
		progressLabels.add(entertainmentBar_lbl);
		enterProgress_pnl.add(entertainmentBar_lbl);

		entertainment_bar = new JProgressBar(SwingConstants.HORIZONTAL, 0, (int) total);
		entertainment_bar.setValue((int) total);
		entertainment_bar.setBounds(10, 30, 150, 50);
		progressBars.add(entertainment_bar);
		enterProgress_pnl.add(entertainment_bar);
		
		
		
		//Progress top row (3)
		// Savings progress
		savingsProgress_pnl = new RoundedPanel(20);
		savingsProgress_pnl.setLayout(null);
		savingsProgress_pnl.setBounds(505, 15, 475, 75);
		savingsProgress_pnl.setBackground(gray);
		progressPanels.add(savingsProgress_pnl); 
		progress_pnl.add(savingsProgress_pnl);

		total = DatabaseImportController.getBudgets().get(6).getTotalAllocated();
		current = DatabaseImportController.getBudgets().get(6).getCurrentAmount();

		percent = (int) ((100 / total) * current);

		savingsBar_lbl = new JLabel("SAVINGS: $" + current);
		savingsBar_lbl.setFont(font4);
		savingsBar_lbl.setForeground(Color.WHITE);
		savingsBar_lbl.setBounds(10, 10, 300, 30);
		progressLabels.add(savingsBar_lbl);
		savingsProgress_pnl.add(savingsBar_lbl);

		savings_bar = new JProgressBar(SwingConstants.HORIZONTAL, 0, (int) total);
		savings_bar.setValue((int) total);
		savings_bar.setBounds(10, 30, 300, 50);
		progressBars.add(savings_bar);
		savingsProgress_pnl.add(savings_bar);

		// Credit progress
		creditProgress_pnl = new RoundedPanel(20);
		creditProgress_pnl.setLayout(null);
		creditProgress_pnl.setBounds(995, 15, 475, 75);
		creditProgress_pnl.setBackground(gray);
		progressPanels.add(creditProgress_pnl); 
		progress_pnl.add(creditProgress_pnl);

		total = DatabaseImportController.getBudgets().get(7).getTotalAllocated();
		current = DatabaseImportController.getBudgets().get(7).getCurrentAmount();

		percent = (int) ((100 / total) * current);

		creditBar_lbl = new JLabel("CREDITS: $" + current);
		creditBar_lbl.setFont(font4);
		creditBar_lbl.setForeground(Color.WHITE);
		creditBar_lbl.setBounds(10, 10, 300, 30);
		progressLabels.add(creditBar_lbl);
		creditProgress_pnl.add(creditBar_lbl);

		credit_bar = new JProgressBar(SwingConstants.HORIZONTAL, 0, (int) total);
		credit_bar.setValue((int) total);
		credit_bar.setBounds(10, 30, 300, 50);
		progressBars.add(credit_bar);
		creditProgress_pnl.add(credit_bar);
		//total progress
		totalProgress_pnl = new RoundedPanel(20);
		totalProgress_pnl.setLayout(null);
		totalProgress_pnl.setBounds(15, 15, 475, 75);
		totalProgress_pnl.setBackground(gray);
		progressPanels.add(totalProgress_pnl); 
		progress_pnl.add(totalProgress_pnl);
		
		total = DatabaseImportController.getBudgets().get(8).getTotalAllocated();
		current = DatabaseImportController.getBudgets().get(8).getCurrentAmount();
	
		totalBar_lbl = new JLabel("TOTAL: $" + current + " / $" + total);
		
		totalBar_lbl.setFont(font4);
		totalBar_lbl.setForeground(Color.WHITE);
		totalBar_lbl.setBounds(10, 10, 300, 30);
		progressLabels.add(totalBar_lbl);
		totalProgress_pnl.add(totalBar_lbl);

		total_bar = new JProgressBar(SwingConstants.HORIZONTAL, 0, (int) total);
		total_bar.setValue((int) total);
		total_bar.setBounds(10, 30, 300, 50);
		progressBars.add(total_bar);
		totalProgress_pnl.add(total_bar);

	
		
		
		
		
		
		
	
		
		
		
		
		setVisible(true); 
		
		
		
		
//		budget_pnl = new BudgetPanel(username); 
//		budget_pnl.setBounds(200,200, 700, 700);
//		budget_pnl.setVisible(true);
//		add(budget_pnl); 
		
//		budgetSettings_pnl = new BudgetSettingsPanel(username); 
//		budgetSettings_pnl.setBounds(200,200, 700, 700);
//		budgetSettings_pnl.setVisible(false);
//		add(budgetSettings_pnl); 
//		
//		goals_pnl = new GoalsPanel(); 
//		goals_pnl.setBounds(200,200, 700, 700);
//		goals_pnl.setVisible(false);
//		add(goals_pnl); 
		


//		
//		// Switch to goals panel
//		goals_btn = new JButton("Goals");
//		goals_btn.setLayout(null);
//		goals_btn.setBounds(500, 10, 200, 50);
//		goals_btn.setVisible(true);
//		goals_btn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//
//				budget_pnl.setVisible(false);
//				budgetSettings_pnl.setVisible(false);
//				goals_pnl.setVisible(true);
//
//			}
//		});
//		add(goals_btn);
//		
//		//Switch to main Budgets Progress panel 
//		return_btn = new JButton("Return to Progress"); 
//		return_btn.setLayout(null);
//		return_btn.setBounds(300, 10, 200, 50); 
//		return_btn.setVisible(true);
//		return_btn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				budget_pnl.setVisible(true);
//				budgetSettings_pnl.setVisible(false);
//				goals_pnl.setVisible(false);
//				
//			}
//		});
//		add(return_btn); 
		
		
	}
	
	public static void resetProgress() {
		
		
		//Update all progress bars
		
		for(int i = 0; i < progressBars.size(); i++) {
			
			Budget currentBudget = DatabaseImportController.getBudgets().get(i); 
			
			progressBars.get(i).setValue((int)  currentBudget.getCurrentAmount()); 
			progressLabels.get(i).setText(currentBudget.getName().toUpperCase() + ": $" + currentBudget.getCurrentAmount() + " / $" + currentBudget.getTotalAllocated());
			
			progressPanels.get(i).add(progressBars.get(i));
			progressPanels.get(i).add(progressLabels.get(i));
			
			progress_pnl.add(progressPanels.get(i)); 
			
		}
		
		
		
		
		
	}

	
	
}
