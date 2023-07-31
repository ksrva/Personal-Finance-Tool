/*
 * This class hodl the panel that controls changes to the budget settings by the user for customzied income distribution
 */

package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.DatabaseImportController;
import model.Budget;

public class BudgetSettingsPanel extends RoundedPanel {

	private String username; 
	
	private int addSavings;


	// Design
	private Font font1;
	private Font font2;
	private Font font3;
	
	//Labels 
	private JLabel groceries_lbl; 
	private JLabel rent_lbl; 
	private JLabel bills_lbl; 
	private JLabel transportation_lbl;
	private JLabel course_lbl; 
	private JLabel entertainment_lbl;
	private JLabel savings_lbl;
	private JLabel credits_lbl; 
	private JLabel total_lbl; 
	
	//textfields 
	private JTextField groceries_txtField; 
	private JTextField rent_txtField; 
	private JTextField bills_txtField; 
	private JTextField transportation_txtField; 
	private JTextField course_txtField; 
	private JTextField entertainment_txtField; 
	private JTextField savings_txtField;
	private JTextField credits_txtField; 
	private JTextField total_txtField; 
	
	public BudgetSettingsPanel(String username) {
		super(20); 
		// Fonts
		font1 = new Font("Tahoma", Font.BOLD, 20);
		font2 = new Font("Tahoma", Font.BOLD, 15);
		font3 = new Font("Tahoma", Font.BOLD, 12);

		setLayout(null);
		setBackground(Color.GREEN);
		setSize(1485, 275);
		setVisible(true);
		
		// Labels
		groceries_lbl = new JLabel("Groceries");
		groceries_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		groceries_lbl.setForeground(Color.white);
		groceries_lbl.setBounds(30, 60, 200, 30);
		add(groceries_lbl);

		rent_lbl = new JLabel("Rent/Property Tax");
		rent_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		rent_lbl.setBounds(30, 110, 200, 30);
		rent_lbl.setForeground(Color.white);
		add(rent_lbl);

		bills_lbl = new JLabel("Bills/Utility");
		bills_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		bills_lbl.setForeground(Color.white);
		bills_lbl.setBounds(30, 160, 200, 30);
		add(bills_lbl);

		// Textfields
		String Groceries = Double.toString(DatabaseImportController.getBudgets().get(0).getTotalAllocated());
		groceries_txtField = new JTextField(Groceries);
		groceries_txtField.setBounds(205, 60, 250, 30);
		add(groceries_txtField);

		String Rent = Double.toString(DatabaseImportController.getBudgets().get(1).getTotalAllocated());
		rent_txtField = new JTextField(Rent);
		rent_txtField.setBounds(205, 110, 250, 30);
		add(rent_txtField);

		String Bills = Double.toString(DatabaseImportController.getBudgets().get(2).getTotalAllocated());
		bills_txtField = new JTextField(Bills);
		bills_txtField.setBounds(205, 160, 250, 30);
		add(bills_txtField);
		
		
		//COlumn 2
		transportation_lbl = new JLabel("Transportation");
		transportation_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		transportation_lbl.setForeground(Color.white);
		transportation_lbl.setBounds(475, 60, 200, 30);
		add(transportation_lbl);
		
		course_lbl = new JLabel("Course Materials");
		course_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		course_lbl.setForeground(Color.white);
		course_lbl.setBounds(475, 110, 200, 30);
		add(course_lbl);
		
		entertainment_lbl  = new JLabel("Entertainment");
		entertainment_lbl .setFont(new Font("Tahoma", Font.BOLD, 15));
		entertainment_lbl.setForeground(Color.white);
		entertainment_lbl .setBounds(475, 160, 200, 30);
		add(entertainment_lbl);
		

		String Transportation = Double.toString(DatabaseImportController.getBudgets().get(3).getTotalAllocated()); 
		transportation_txtField = new JTextField(Transportation);
		transportation_txtField.setBounds(665, 60, 250, 30);
		add(transportation_txtField);
		

		String Coursematerials = Double.toString(DatabaseImportController.getBudgets().get(4).getTotalAllocated()); 
		course_txtField = new JTextField(Coursematerials);
		course_txtField.setColumns(10);
		course_txtField.setBounds(665, 110, 250, 30);
		add(course_txtField);
		

		String Entertainment = Double.toString(DatabaseImportController.getBudgets().get(5).getTotalAllocated()); 
		entertainment_txtField = new JTextField(Entertainment);
		entertainment_txtField.setBounds(665, 160, 250, 30);
		add(entertainment_txtField);
		
		
	
		savings_lbl = new JLabel("Savings/Investments");
		savings_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		savings_lbl.setBounds(935, 60, 200, 30);
		savings_lbl.setForeground(Color.white);
		add(savings_lbl);

		credits_lbl = new JLabel("Credits");
		credits_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		credits_lbl.setBounds(935, 110, 200, 30);
		credits_lbl.setForeground(Color.white);
		add(credits_lbl);

		total_lbl = new JLabel("Total");
		total_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		total_lbl.setBounds(935, 160, 200, 30);
		total_lbl.setForeground(Color.white);
		add(total_lbl);

		String Savings = Double.toString(DatabaseImportController.getBudgets().get(6).getTotalAllocated());
		savings_txtField = new JTextField(Savings);
		savings_txtField.setBounds(1145, 60, 250, 30);
		savings_txtField.setEditable(false);
		add(savings_txtField);

		// User cannot edit creidts but the change see how the value changes in the
		// settings

		String Credits = Double.toString(DatabaseImportController.getBudgets().get(7).getCurrentAmount());
		credits_txtField = new JTextField(Credits);
		credits_txtField.setBounds(1145, 110, 250, 30);
		credits_txtField.setEditable(false);
		add(credits_txtField);

		String Total = Double.toString(DatabaseImportController.getBudgets().get(8).getTotalAllocated());
		total_txtField = new JTextField(Total);
		total_txtField.setBounds(1145, 160, 250, 30);
		add(total_txtField);
		
		
				
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBounds(30, 210, 100, 40);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Budget groceries = DatabaseImportController.getBudgets().get(0); 
				double Groceries = Double.valueOf(groceries_txtField.getText());
				//adjust remainder in accounts based on account changes 
				if(groceries.getTotalAllocated() < Groceries) { //Value was changed
					double increase = Groceries - groceries.getTotalAllocated(); 
					groceries.setCurrentAmount(	groceries.getCurrentAmount() + increase); 
				}
				
				Budget rent = DatabaseImportController.getBudgets().get(1); 
				double Rent = Double.valueOf(rent_txtField.getText());
				//adjust remainder in accounts based on account changes 
				if(rent.getTotalAllocated() < Rent) { //Value was changed
					double increase = Rent - rent.getTotalAllocated(); 
					rent.setCurrentAmount(	rent.getCurrentAmount() + increase); 
				}
				
				Budget bills = DatabaseImportController.getBudgets().get(2); 
				double Bills = Double.valueOf(bills_txtField.getText());
				//adjust remainder in accounts based on account changes 
				if(bills.getTotalAllocated() < Bills) { //Value was changed
					double increase = Bills - bills.getTotalAllocated(); 
					bills.setCurrentAmount(	bills.getCurrentAmount() + increase); 
				}
				
				Budget transportation = DatabaseImportController.getBudgets().get(3); 
				double Transportation = Double.valueOf(transportation_txtField.getText());
				//adjust remainder in accounts based on account changes 
				if(transportation.getTotalAllocated() < Transportation) { //Value was changed
					double increase = Transportation - transportation.getTotalAllocated(); 
					transportation.setCurrentAmount(transportation.getCurrentAmount() + increase); 
				}
				
				Budget courseMaterials = DatabaseImportController.getBudgets().get(4); 
				double Coursematerials = Double.valueOf(course_txtField.getText());
				//adjust remainder in accounts based on account changes 
				if(courseMaterials.getTotalAllocated() < Coursematerials) { //Value was changed
					double increase = Coursematerials - courseMaterials.getTotalAllocated(); 
					courseMaterials.setCurrentAmount(courseMaterials.getCurrentAmount() + increase); 
				}
				
				Budget entertainment = DatabaseImportController.getBudgets().get(5); 
				double Entertainment = Double.valueOf(entertainment_txtField.getText());
				//adjust remainder in accounts based on account changes 
				if(entertainment.getTotalAllocated() < Entertainment) { //Value was changed
					double increase = Entertainment - entertainment.getTotalAllocated(); 
					entertainment.setCurrentAmount(entertainment.getCurrentAmount() + increase); 
				}
				
				double Savings = Double.valueOf(savings_txtField.getText());
				double Credits = Double.valueOf(credits_txtField.getText());
				
				double Total = Double.valueOf(total_txtField.getText());
				double sum = Groceries + Rent + Bills + Transportation + Coursematerials + Entertainment + Savings;
				//Determine whether user will need to use credits (they went over budget) 
				if (sum > Total) {
					JOptionPane.showMessageDialog(null, "You have to use Credit or from Savings! ", "Expense Plan Exceeds the income!", 1);
					Savings = Total - (Groceries + Rent + Bills + Transportation + Coursematerials + Entertainment);
					//If savings can't make up for extra values, use credit  
					if (Savings < 0) {
						Credits = 0 + Savings;
						Savings = 0;
						
						//Update vlaues for savings increase
						double[] newValues = {Groceries, Rent, Bills, Transportation, Coursematerials
								, Entertainment, Savings, Credits, Total}; 
						
						int i = 0; 
						for(Budget cur : DatabaseImportController.getBudgets()) {
							if(cur.getName().equals("Savings")) {
								cur.setCurrentAmount(newValues[i]); 
							}else {

								cur.setTotalAllocated(newValues[i]);
							} 
							i++;
						
						}
					}else { // USe savings to make up for extra costs 
						double[] newValues = {Groceries, Rent, Bills, Transportation, Coursematerials
								, Entertainment, Savings, Credits, Total}; 
						
						int i = 0; 
						for(Budget cur : DatabaseImportController.getBudgets()) {
							if(cur.getName().equals("Savings")) {
								cur.setCurrentAmount(newValues[i]); 
							}else {

								cur.setTotalAllocated(newValues[i]);
							} 
							i++;
							
							

						}
					}
					
					
				}
				else if (sum <= Total) { //If the user stays within their amount they will have more for their savinfs 
					JOptionPane.showMessageDialog(null, "You have more for savings!", "expense Plan is within the income! ", 1);
					Savings = Total - (Groceries + Rent + Bills + Transportation + Coursematerials + Entertainment);
					Credits = 0;
					
					//Update vlaues for savings increase
					double[] newValues = {Groceries, Rent, Bills, Transportation, Coursematerials
							, Entertainment, Savings, Credits, Total}; 
					
					int i = 0; 
					for(Budget cur : DatabaseImportController.getBudgets()) {
						double oldTotal = cur.getTotalAllocated(); 
						cur.setTotalAllocated(newValues[i]); 
						double increase = cur.getTotalAllocated() - oldTotal;
						if(cur.getCurrentAmount() > cur.getTotalAllocated()) {
							cur.setCurrentAmount(cur.getTotalAllocated()); 
						}
						i++;
						if(cur.getName().equals("Savings")) {
							cur.setCurrentAmount(cur.getCurrentAmount() + increase);
						}
						
					}
				}
			
				
				DashboardPanel.resetProgress();
			}
		});
		add(btnUpdate);

		
		
		
	}
	
	
}
