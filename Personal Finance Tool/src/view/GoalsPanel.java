/*
 * Panel that manages user's points, deposits & leaderboard 
 */

package view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import controller.DatabaseImportController;
import model.Budget;

public class GoalsPanel extends RoundedPanel {
	
	
	//FIELDS
	


	// Labels
	
	private JLabel goalsTitle_lbl;
	private JLabel goalsDescription_lbl; 
	
	private JLabel myPointsTitle_lbl; 
	private static JLabel myPoints_lbl;
	
	private JLabel leaderboardTitle_lbl; 
	
	private JLabel myDepositsTitle_lbl; 
	private static JLabel myDeposits_lbl;
	
	private JLabel savingsGoals_lbl; 
	private JLabel currentSavings_lbl;
	
	private JLabel thisMonthSavingsGoal_lbl; 
	private JLabel thisMonthSavings_lbl; 
	
	private JLabel noCreditsGoal_lbl; 
	private JLabel noCredits_lbl;

	private JLabel savingsTransactionsGoal_lbl; 
	private JLabel savingsTransactions_lbl; 
	
	public static int savingsDepositCount; 
	
	private JLabel leaderboard_lbl; 
	
	private RoundedPanel points_pnl; 
	private RoundedPanel deposits_pnl; 
	private RoundedPanel leaderboard_pnl;
	
	private JScrollPane scrollPane; 
	
	//Fonts 
			private static Font font1 = new Font("Arial", Font.BOLD, 40);
			private static Font font5 = new Font("Arial", Font.BOLD, 60);
			private static Font font2 = new Font("Arial", Font.BOLD, 20);
			private static Font font3 = new Font("Arial", Font.BOLD, 12);
			private static Font font4 = new Font("Arial", Font.PLAIN, 15);
			//Colors
			private static Color black = new Color(0, 0, 0);
			private static Color darkGray = new Color(17, 17, 17);
			private static Color midGray = new Color(30, 30, 30);
			private static Color gray = new Color(60, 60, 60);
			private static Color lightGray = new Color(77, 77, 77);
	
	public GoalsPanel() {
		super(20); 
	
		setLayout(null);
		setBackground(midGray);
		setBounds(50, 400, 570, 700);
		setVisible(true);
		
		savingsDepositCount = 0; 
		
		//Labels 
		goalsTitle_lbl = new JLabel("MY POINTS");
		goalsTitle_lbl.setBounds(20, 20, 300, 30);
		goalsTitle_lbl.setFont(font2);
		goalsTitle_lbl.setForeground(Color.WHITE);
		add(goalsTitle_lbl);
		
		goalsTitle_lbl = new JLabel("NOTE - Preset Goal : 10 pts per savings deposit");
		goalsTitle_lbl.setBounds(20, 40, 300, 30);
		goalsTitle_lbl.setFont(font3);
		goalsTitle_lbl.setForeground(Color.WHITE);
		add(goalsTitle_lbl);
		
		points_pnl = new RoundedPanel(20);
		points_pnl.setLayout(null);
		points_pnl.setBounds(18, 80, 100 ,175);
		points_pnl.setBackground(gray);
		add(points_pnl);
		
		myPointsTitle_lbl = new JLabel("POINTS");
		myPointsTitle_lbl.setBounds(20, 10, 100, 40);
		myPointsTitle_lbl.setFont(font4);
		myPointsTitle_lbl.setForeground(Color.WHITE);
		points_pnl.add(myPointsTitle_lbl);

		
		myPoints_lbl = new JLabel(DatabaseImportController.getCurrentUser().getPoints() + "");
		myPoints_lbl.setBounds(30, 80, 300, 60);
		myPoints_lbl.setFont(font5);
		myPoints_lbl.setForeground(Color.WHITE);
		points_pnl.add(myPoints_lbl);
		
		deposits_pnl = new RoundedPanel(20);
		deposits_pnl.setLayout(null);
		deposits_pnl.setBounds(125, 80, 100 ,175);
		deposits_pnl.setBackground(gray);
		add(deposits_pnl);
		
		myDepositsTitle_lbl = new JLabel("DEPOSITS");
		myDepositsTitle_lbl.setBounds(10, 10, 100, 40);
		myDepositsTitle_lbl.setFont(font4);
		myDepositsTitle_lbl.setForeground(Color.WHITE);
		deposits_pnl.add(myDepositsTitle_lbl);
		
		myDeposits_lbl = new JLabel(savingsDepositCount + "");
		myDeposits_lbl.setBounds(30, 80, 300, 60);
		myDeposits_lbl.setFont(font5);
		myDeposits_lbl.setForeground(Color.WHITE);
		deposits_pnl.add(myDeposits_lbl);
		
		leaderboard_pnl = new RoundedPanel(20);
		leaderboard_pnl.setLayout(null);
		leaderboard_pnl.setBounds(320, 20, 430 ,230);
		leaderboard_pnl.setBackground(gray);
		add(leaderboard_pnl);
		
		leaderboardTitle_lbl = new JLabel("Leaderboard");
		leaderboardTitle_lbl.setBounds(20, 20, 300, 30);
		leaderboardTitle_lbl.setFont(font2);
		leaderboardTitle_lbl.setForeground(Color.WHITE);
		leaderboard_pnl.add(leaderboardTitle_lbl);
		
		ArrayList<String> sortedUsers = sortLeaderBoard(); 
		
		JTextArea leaderboardList = resetLeaderboard(sortedUsers); 
		
		scrollPane = new JScrollPane();  
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 10, 400, 200);
		scrollPane.setViewportView(leaderboardList);
		leaderboard_pnl.add(scrollPane); 
		
		
		
//		
//		
//				
//		savingsGoals_lbl = new JLabel("Annual Savings Goal (1200pts)");
//		savingsGoals_lbl.setFont(font2);
//		savingsGoals_lbl.setForeground(Color.white);
//		savingsGoals_lbl.setBounds(30, 10, 300, 30);
//		add(savingsGoals_lbl);
//		
//		
//		currentSavings_lbl = new JLabel("This year: $" + totalSavings + "/$" + DatabaseImportController.getCurrentUser().getAnnualSavingsGoal());
//		currentSavings_lbl.setFont(font2);
//		currentSavings_lbl.setBounds(30, 50, 300, 30);
//		add(currentSavings_lbl); 
//		
//		thisMonthSavingsGoal_lbl = new JLabel("Current Month Savings Goal (100pts)");
//		thisMonthSavingsGoal_lbl.setFont(font2);
//		thisMonthSavingsGoal_lbl.setBounds(30, 90, 300, 30);
//		add(thisMonthSavingsGoal_lbl);
//	
//		thisMonthSavings_lbl = new JLabel("This month: $" + totalSavings + "/$" + DatabaseImportController.getCurrentUser().getAnnualSavingsGoal()/12);
//		thisMonthSavings_lbl.setFont(font2);
//		thisMonthSavings_lbl.setBounds(30, 130, 300, 30);
//		add(thisMonthSavings_lbl);
//		
//		noCreditsGoal_lbl = new JLabel("No Credits Challenge");
//		noCreditsGoal_lbl.setFont(font2);
//		noCreditsGoal_lbl.setBounds(30, 180, 300, 30);
//		add(noCreditsGoal_lbl);
//		
//		noCredits_lbl = new JLabel("Value (if month is complete win 100pts"); //link monthly checking function
//		noCredits_lbl.setFont(font2);
//		noCredits_lbl.setBounds(30, 230, 300, 30);
//		add(noCredits_lbl);
//		
//		savingsTransactionsGoal_lbl = new JLabel("Monthly Savings Deposits Count (10pts per deposit)");
//		savingsTransactionsGoal_lbl.setFont(font2);
//		savingsTransactionsGoal_lbl.setBounds(30, 280, 300, 30);
//		add(savingsTransactionsGoal_lbl);
//		
//		savingsTransactions_lbl = new JLabel("Count"); //TODO link count to transactions 
//		savingsTransactions_lbl.setFont(font2);
//		savingsTransactions_lbl.setBounds(30, 330, 300, 30);
//		add(savingsTransactions_lbl);
//		
//		myPoints_lbl = new JLabel("My Points: " + DatabaseImportController.getCurrentUser().getPoints()); //TODO link count to transactions 
//		myPoints_lbl.setFont(font2);
//		myPoints_lbl.setBounds(30, 380, 300, 30);
//		add(myPoints_lbl);
//		
//			
		
		/*
		 SAVINGS GOALS 
		 - Total Savings Goal #by number (set personal) 
		 - Total Savings by percent (set personal) 
		 - add transaction added to savings + points 
		 
		 
		 EXPENSE GOALS 
		 - 0 credit (monthly) - stayed within budgets 
		 
		 CHALLENGES 
		 - 0 credits streak (per month) 
		 
		 EDUCATIONAL MODULES 
		  
		 */
//		leaderboard_lbl = new JLabel("1: " + sortedUsers.get(0) + "," + DatabaseImportController.getUserPoints().get(sortedUsers.get(0))
//				+ "\n2: " + sortedUsers.get(1) + "," + DatabaseImportController.getUserPoints().get(sortedUsers.get(1))
//				+ "\n3: " + sortedUsers.get(2) + "," + DatabaseImportController.getUserPoints().get(sortedUsers.get(2))); //TODO link count to transactions 
//		leaderboard_lbl.setFont(font2);
//		leaderboard_lbl.setBounds(30, 430, 300, 200);
//		add(leaderboard_lbl);
//		
//		
		
	}
	
	public static void updateMyGoal() {
		
		int pointsCount = DatabaseImportController.getCurrentUser().getPoints(); 
		int deposits = DatabaseImportController.getCurrentUser().getPoints()/10;
		
		myPoints_lbl.setText(pointsCount + "");
		myDeposits_lbl.setText(deposits + ""); 
		
		
		
		
	}
	
	
	
	public static ArrayList<String> sortLeaderBoard() {
		
		
		//Sorts hashmap by value using bubble sort
		 ArrayList<Map.Entry<String, Integer>> entryList = new ArrayList<>(DatabaseImportController.getUserPoints().entrySet());

	        int n = entryList.size();
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = 0; j < n - i - 1; j++) {
	                if (entryList.get(j).getValue() < entryList.get(j + 1).getValue()) {
	                    // Swap the elements
	                    Collections.swap(entryList, j, j + 1);
	                }
	            }
	        }

	        ArrayList<String> leaderboardSorted = new ArrayList<>();
	        for (Map.Entry<String, Integer> entry : entryList) {
	        	leaderboardSorted.add(entry.getKey());
	        }
	        
	        return leaderboardSorted; 
		
	        
	}
	
	
	public static JTextArea resetLeaderboard(ArrayList<String> sortedBoard) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < sortedBoard.size(); i++) {
            stringBuilder.append(i + 1).append(". ").append(sortedBoard.get(i));
            if (i != sortedBoard.size() - 1) {
                stringBuilder.append("\n");
            }
        }
        
        String arrayListString = stringBuilder.toString();
        
        JTextArea leaderLabel = new JTextArea(arrayListString); 
        
        return leaderLabel; 
		
	}
	
	
	
	
}
































































































































