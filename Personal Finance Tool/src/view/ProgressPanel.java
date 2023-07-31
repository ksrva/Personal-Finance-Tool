
/*
Displats and controls user's progress and current budget amounts 
 *
 *
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import controller.DatabaseImportController;



public class ProgressPanel extends RoundedPanel {
	
	private String username; 
	
	//Design
		//Fonts 
		private static Font font1 = new Font("Arial", Font.BOLD, 40);
		private static Font font2 = new Font("Arial", Font.BOLD, 20);
		private static Font font3 = new Font("Arial", Font.BOLD, 12);
		//Colors
		private static Color black = new Color(0, 0, 0);
		private static Color darkGray = new Color(17, 17, 17);
		private static Color midGray = new Color(30, 30, 30);
		private static Color gray = new Color(60, 60, 60);
		private static Color lightGray = new Color(77, 77, 77);
		
	//Labels 
	private JLabel groceriesBar_lbl; 
	private JLabel rentBar_lbl;
	private JLabel billsBar_lbl;
	private JLabel transportationBar_lbl; 
	private JLabel courseBar_lbl; 
	private JLabel entertainmentBar_lbl; 
	private JLabel savingsBar_lbl; 
	private JLabel creditsBar_lbl; 
	private JLabel totalBar_lbl; 
	//Progress bars 
	private JProgressBar groceries_bar;
	private JProgressBar rent_bar;
	private JProgressBar bills_bar;
	private JProgressBar transportation_bar;
	private JProgressBar course_bar;
	private JProgressBar entertainment_bar;
	private JProgressBar savings_bar;
	private JProgressBar credits_bar;
	private JProgressBar total_bar;
	
	private static ArrayList<JProgressBar> progressBars; 
	private static ArrayList<JLabel> progressLabels; 

	public ProgressPanel() {
		super(20); 
		
		username = DatabaseImportController.getCurrentUser().getUsername(); 
		
		progressBars = new ArrayList<JProgressBar>();
		progressLabels = new ArrayList<JLabel>(); 
		
	
		setLayout(null);
		setBackground(midGray);
		setBounds(100, 350, 1480, 500); 
		setVisible(true);
	

		double total = DatabaseImportController.getBudgets().get(8).getTotalAllocated(); 
		double current = DatabaseImportController.getBudgets().get(8).getCurrentAmount(); 
		
		totalBar_lbl = new JLabel("Total $" + current + "/ $" + total);
		totalBar_lbl.setFont(font2);
		totalBar_lbl.setBounds(10, 10, 300, 30);
		progressLabels.add(totalBar_lbl);
		add(totalBar_lbl); 
		
		total_bar = new JProgressBar(SwingConstants.HORIZONTAL, 0, (int)total); 
		total_bar.setValue((int)total); 
		total_bar.setBounds(10, 10, 300, 50);
		progressBars.add(total_bar); 
		add(total_bar); 
		
		total = DatabaseImportController.getBudgets().get(0).getTotalAllocated(); 
		current = DatabaseImportController.getBudgets().get(0).getCurrentAmount(); 
		
		groceriesBar_lbl = new JLabel("Groceries $" + current + "/ $" + total);
		groceriesBar_lbl.setFont(font2);
		groceriesBar_lbl.setBounds(100, 90, 300, 30);
		progressLabels.add(groceriesBar_lbl);
		add(groceriesBar_lbl); 
		
		groceries_bar = new JProgressBar(SwingConstants.HORIZONTAL, 0, (int) total); 
		groceries_bar.setValue((int) total); 
		groceries_bar.setBounds(100, 100, 300, 50);
		progressBars.add(groceries_bar); 
		add(groceries_bar); 
		
		total = DatabaseImportController.getBudgets().get(1).getTotalAllocated(); 
		current = DatabaseImportController.getBudgets().get(1).getCurrentAmount(); 
		
		rentBar_lbl = new JLabel("Rent $" + current + "/ $" + total);
		rentBar_lbl.setFont(font2);
		rentBar_lbl.setBounds(100, 140, 300, 30);
		progressLabels.add(rentBar_lbl);
		add(rentBar_lbl); 
		
		rent_bar = new JProgressBar(SwingConstants.HORIZONTAL, 0, (int)total); 
		rent_bar.setValue((int)total); 
		rent_bar.setBounds(100, 150, 300, 50);
		progressBars.add(rent_bar); 
		add(rent_bar); 
		
		total = DatabaseImportController.getBudgets().get(2).getTotalAllocated(); 
		current = DatabaseImportController.getBudgets().get(2).getCurrentAmount(); 
		
		billsBar_lbl = new JLabel("Bills $" + current + "/ $" + total);
		billsBar_lbl.setFont(font2);
		billsBar_lbl.setBounds(100, 190, 300, 30);
		progressLabels.add(billsBar_lbl);
		add(billsBar_lbl); 
		
		bills_bar = new JProgressBar(SwingConstants.HORIZONTAL, 0, (int)total); 
		bills_bar.setValue((int)total); 
		bills_bar.setBounds(100, 200, 300, 50);
		progressBars.add(bills_bar); 
		add(bills_bar); 
		
		total = DatabaseImportController.getBudgets().get(3).getTotalAllocated(); 
		current = DatabaseImportController.getBudgets().get(3).getCurrentAmount(); 
		
		transportationBar_lbl = new JLabel("Transportation $" + current + "/ $" + total);
		transportationBar_lbl.setFont(font2);
		transportationBar_lbl.setBounds(100, 240, 300, 30);
		progressLabels.add(transportationBar_lbl);
		add(transportationBar_lbl); 
		
		transportation_bar = new JProgressBar(SwingConstants.HORIZONTAL, 0, (int)total); 
		transportation_bar.setValue((int)total); 
		transportation_bar.setBounds(100, 250, 300, 50);
		progressBars.add(transportation_bar); 
		add(transportation_bar); 
		
		total = DatabaseImportController.getBudgets().get(4).getTotalAllocated(); 
		current = DatabaseImportController.getBudgets().get(4).getCurrentAmount(); 
		
		courseBar_lbl = new JLabel("Course Materials $" + current + "/ $" + total);
		courseBar_lbl.setFont(font2);
		courseBar_lbl.setBounds(100, 290, 300, 30);
		progressLabels.add(courseBar_lbl);
		add(courseBar_lbl); 
		
		course_bar = new JProgressBar(SwingConstants.HORIZONTAL, 0,(int) total); 
		course_bar.setValue((int)total); 
		course_bar.setBounds(100, 300, 300, 50);
		progressBars.add(course_bar); 
		add(course_bar); 
		
		total = DatabaseImportController.getBudgets().get(5).getTotalAllocated(); 
		current = DatabaseImportController.getBudgets().get(5).getCurrentAmount(); 
		
		entertainmentBar_lbl = new JLabel("Entertainment $" + current + "/ $" + total);
		entertainmentBar_lbl.setFont(font2);
		entertainmentBar_lbl.setBounds(100, 340, 300, 30);
		progressLabels.add(entertainmentBar_lbl);
		add(entertainmentBar_lbl); 
		
		entertainment_bar = new JProgressBar(SwingConstants.HORIZONTAL, 0, (int)total); 
		entertainment_bar.setValue((int)total); 
		entertainment_bar.setBounds(100, 350, 300, 50);
		progressBars.add(entertainment_bar); 
		add(entertainment_bar); 
		
		total = DatabaseImportController.getBudgets().get(6).getTotalAllocated(); 
		current = DatabaseImportController.getBudgets().get(6).getCurrentAmount(); 
		
		savingsBar_lbl = new JLabel("Savings $" + total);
		savingsBar_lbl.setFont(font2);
		savingsBar_lbl.setBounds(100, 390, 300, 30);
		progressLabels.add(savingsBar_lbl);
		add(savingsBar_lbl); 
		
		savings_bar = new JProgressBar(SwingConstants.HORIZONTAL, 0, (int)total); 
		savings_bar.setValue((int)total); 
		savings_bar.setBounds(100, 400, 300, 50);
		progressBars.add(savings_bar); 
		add(savings_bar); 
		
		total = DatabaseImportController.getBudgets().get(7).getTotalAllocated(); 
		current = DatabaseImportController.getBudgets().get(7).getCurrentAmount(); 
		
		creditsBar_lbl = new JLabel("Credits -$" + total);
		creditsBar_lbl.setFont(font2);
		creditsBar_lbl.setBounds(100, 440, 300, 30);
		progressLabels.add(creditsBar_lbl);
		add(creditsBar_lbl); 
		
		credits_bar = new JProgressBar(SwingConstants.HORIZONTAL, 0, (int)total); 
		credits_bar.setValue((int)total); 
		credits_bar.setBounds(100, 450, 300, 50);
		progressBars.add(credits_bar); 
		add(credits_bar); 
		

		
		
		
		
	}
	

	public static void refreshProgress() {
		
		int i = 0; 
		for(JProgressBar cur : progressBars) {
			
			cur.setValue((int)DatabaseImportController.getBudgets().get(i).getCurrentAmount());
			i++; 
			
		}
		int j = 0; 
		for(JLabel cur : progressLabels) {
			String name = DatabaseImportController.getBudgets().get(j).getName(); 
			double currentAmount =  DatabaseImportController.getBudgets().get(j).getCurrentAmount(); 
			double totalAmount =  DatabaseImportController.getBudgets().get(j).getTotalAllocated(); 
			
			if(name.equals("Credits")) {
				cur.setText("Credits -$" + Math.abs(totalAmount));
			}else if(name.equals("Savings")) {
				cur.setText("Savings $" + currentAmount);
			}else {
				cur.setText(name + " $" + currentAmount + "/ $" + totalAmount);
			}
			
			j++; 
	
		}
	}
	
	
}

