/*
 * Main frame to hold all content
 */

package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

import controller.DatabaseImportController;
import model.Transaction;
import model.User;


public class LandingFrame extends JFrame {

	private JFrame frmHome; 
	
	//FIELDS 
	private static String username;
	private int currentMonth; //Keep track of which month to show data for 
	
	
	//labels 
	
	
	//buttons
	private JButton exit_btn = new JButton();
	private JButton budget_btn = new JButton(); 
	private JButton expense_btn = new JButton(); 
	
	
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
	
	
	//Panels
	private DashboardPanel dash_pnl; 
	private TransactionPanel trans_pnl;
	private JPanel test_pnl; 
	
	public static String Groceries;
	public static String Rent;
	public static String Bills;
	public static String Transportation;
	public static String Coursematerials;
	public static String Entertainment;
	public static String Savings;
	public static String Credits;
	public static String Total;
	
	public static String LastName; 
	public static String Email;
	
	
	
	public LandingFrame(String username) throws HeadlessException {
		super();
		this.username = username;
		
		


	
		// FRAME
		setTitle("Home Page");
		setLayout(null);
		setSize(1680, 1000);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		

		
	
		//COMPONENTS 
		
		//LABELS 
		
		
		//BUTTONS 
		//Button to exit system 
//		exit_btn = new JButton("EXIT");
//		exit_btn.setFont(font2);
//		exit_btn.setBounds(200, 160, 140, 40);
//		exit_btn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				sendDataToSQL(); 
//				frmHome = new JFrame("Exit");
//				if(JOptionPane.showConfirmDialog(frmHome,"Confirm if you want to exit","Login Systems",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
//					System.exit(0);
//				}
//			}
//		});
//		add(exit_btn);
		
		//button to go to OLD budget page 
//		budget_btn = new JButton("BUDGET");
//		budget_btn.setFont(font2);
//		budget_btn.setBounds(37, 276, 140, 40);
//		budget_btn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				BudgetFrame.main(username);
//				frmHome.setVisible(false);
//			}
//		});
//		add(budget_btn);
		
		
		//MENU BAR 
		JMenuBar menuBar;
		JMenu home, help, logout; // Menu Options displayed in bar
		JMenuItem homeItem, helpItem, logoutItem; 

		// Create the menu bar.
		menuBar = new JMenuBar();

		// TODO change menu names to more relevant ones
		// BUILD HOME MENU
		home = new JMenu("Home");
		home.setMnemonic(KeyEvent.VK_F);
		home.getAccessibleContext().setAccessibleDescription("Return to Landing Page");
		menuBar.add(home);
		
		homeItem = new JMenuItem("Return to Title Screen");
		homeItem.setMnemonic(KeyEvent.VK_F);
		homeItem.getAccessibleContext().setAccessibleDescription("");
		homeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				//TODO what if they are already on home page  
				
			}
		});
		home.add(homeItem);

		

		// BUILD HELP MENU
		help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_F);
		help.getAccessibleContext().setAccessibleDescription("Get Help");
		menuBar.add(help);

		// create help menu sub-items & Implement ActionListeners
		// TODO add more help items to split "How to use" and "directions" information
		// into sections related to each frame, etc
		helpItem = new JMenuItem("Get Help");
		helpItem.setMnemonic(KeyEvent.VK_F);
		helpItem.getAccessibleContext().setAccessibleDescription("help item 1?");
		helpItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				// Add a JOptionPane 
			
			}
		});
		help.add(helpItem);

		// BUILD OTHER LOGOUT MENU
		logout = new JMenu("Log Out");
		logout.setMnemonic(KeyEvent.VK_F);
		logout.getAccessibleContext().setAccessibleDescription("Log Out");
		menuBar.add(logout);

		// create other frames menu sub-items & Implement ActionListeners
		logoutItem = new JMenuItem("Log Out");
		logoutItem.setMnemonic(KeyEvent.VK_F);
		logoutItem.getAccessibleContext().setAccessibleDescription("Log Out");
		logoutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				sendDataToSQL(); 
				setVisible(false); 
				LoginFrame login = new LoginFrame(); 
				dispose(); 
				
			}
		});
		logout.add(logoutItem);
		
		setJMenuBar(menuBar);

		
		//PANELS
		
		dash_pnl = new DashboardPanel(username); 
		add(dash_pnl);
		

		//savingslog
		
	
		setVisible(true); 
	
	} 
	

	//For ALL try catch statements that connect data to the mySQL database I referenced the following: https://stackoverflow.com/questions/37668260/how-to-use-try-catch-exception-in-mysql-database-connect
	public static void sendDataToSQL() {
		
		
		
		//1. Update Budgets  
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pwm","root","Bubbletea_23"); 
			java.sql.Statement stmt = con.createStatement();
			
			String Groceries = String.valueOf(DatabaseImportController.getBudgets().get(0).getTotalAllocated()); // Total
			String groceriesValue = String.valueOf(DatabaseImportController.getBudgets().get(0).getCurrentAmount()); // Current

			String Rent = String.valueOf(DatabaseImportController.getBudgets().get(1).getTotalAllocated()); // Total
			String rentValue = String.valueOf(DatabaseImportController.getBudgets().get(1).getCurrentAmount()); // Current

			String Bills = String.valueOf(DatabaseImportController.getBudgets().get(2).getTotalAllocated()); // Total
			String billsValue = String.valueOf(DatabaseImportController.getBudgets().get(2).getCurrentAmount()); // Current

			String Transportation = String.valueOf(DatabaseImportController.getBudgets().get(3).getTotalAllocated()); // Total
			String transportationValue = String.valueOf(DatabaseImportController.getBudgets().get(3).getCurrentAmount()); // Current

			String Coursematerials = String.valueOf(DatabaseImportController.getBudgets().get(4).getTotalAllocated()); // Total
			String courseValue = String.valueOf(DatabaseImportController.getBudgets().get(4).getCurrentAmount()); // Current

			String Entertainment = String.valueOf(DatabaseImportController.getBudgets().get(5).getTotalAllocated()); // Total
			String enterValue = String.valueOf(DatabaseImportController.getBudgets().get(5).getCurrentAmount()); // Current

			String Savings = String.valueOf(DatabaseImportController.getBudgets().get(6).getCurrentAmount()); // Current
			
			String Credits = String.valueOf(DatabaseImportController.getBudgets().get(7).getCurrentAmount()); // Current

			String Total = String.valueOf(DatabaseImportController.getBudgets().get(8).getTotalAllocated()); // Total
			String totalValue = String.valueOf(DatabaseImportController.getBudgets().get(8).getCurrentAmount()); // Current 
			
			String sql = "UPDATE budget SET Groceries = '" + Groceries + "', groceriesValue = '" + groceriesValue 
					+ "', Rent = '" + Rent + "', rentValue = '" + rentValue 
					+ "', Bills = '" + Bills + "', billsValue = '" + billsValue 
					+ "', Transportation = '" + Transportation + "', transportationValue = '" + transportationValue 
					+ "', Coursematerials = '" + Coursematerials + "', courseValue = '" + courseValue 
					+ "', Entertainment = '" + Entertainment + "', enterValue = '" + enterValue 
					+ "', Savings = '" + Savings 
					+ "', Credits = '" + Credits 
					+ "', Total = '" + Total + "', totalValue = '" + totalValue + "' WHERE user = '" + username + "'";
		    stmt.execute(sql);

		}catch(Exception e1){ System.out.println(e1);} 
		
		
		//3. Update Transactions
		try{  
			
			User current = DatabaseImportController.getCurrentUser(); 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pwm","root","Bubbletea_23"); 
			java.sql.Statement stmt = con.createStatement();
			String user = String.valueOf(DatabaseImportController.getCurrentUser().getUsername());
			String sql = "SELECT * FROM Transactions"; 
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			//getting the column type
			int tableSize = rsmd.getPrecision(1);
			
	
			for(Transaction cur : DatabaseImportController.getTransactions()) { //Upload each transaction as a new row in Transaction table 
				
				String Payee = cur.getPayee(); 
				String Amount = String.valueOf(cur.getAmount()); 
				String Budget = cur.getBudget(); 
				String Date = String.valueOf(cur.getDate().getDate()); 
				String month = String.valueOf(cur.getDate().getMonth()); 
				String year = String.valueOf(cur.getDate().getYear()); 
				String Type = "credit"; 
				if(cur.isType()) {
					Type = "debit"; 
				}
				String order = String.valueOf(tableSize); 
				
				sql = "INSERT INTO `Transactions` (`user`,`Payee`,`Amount`,`Budget`,`Date`,`month`,`year`,`Type`,`order`)  "
						+ "VALUES ('" + user + "','" + Payee + "','" + Amount + "', '" + Budget + "'"
								+ ", '" + Date + "', '" + month + "', '" + year + "', '" + Type + "', '" + order + "')";
						
				tableSize++; 
				stmt.execute(sql);
				
			}
		

		}catch(Exception e1){ System.out.println(e1);} 
		
		
		//3. Update Monthly transactions TODO
				try{  
					
					User current = DatabaseImportController.getCurrentUser(); 
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pwm","","Bubbletea_23"); 
					java.sql.Statement stmt = con.createStatement();
					String user = String.valueOf(DatabaseImportController.getCurrentUser().getUsername());
					String sql = "SELECT * FROM Transactions"; 
					ResultSet rs = stmt.executeQuery(sql);
					ResultSetMetaData rsmd = rs.getMetaData();
					
					//getting the column type
					int tableSize = rsmd.getPrecision(1);
					
					String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}; 
					double[] Jan = current.getMonthlyLog().get("Jan");
					double[] Feb = current.getMonthlyLog().get("Feb");
					double[] Mar = current.getMonthlyLog().get("Mar");
					double[] Apr = current.getMonthlyLog().get("Apr");
					double[] May = current.getMonthlyLog().get("May");
					double[] Jun = current.getMonthlyLog().get("Jun");
					double[] Jul = current.getMonthlyLog().get("Jul");
					double[] Aug = current.getMonthlyLog().get("Aug");
					double[] Sep = current.getMonthlyLog().get("Sep");
					double[] Oct = current.getMonthlyLog().get("Oct");
					double[] Nov = current.getMonthlyLog().get("Nov");
					double[] Dec = current.getMonthlyLog().get("Dec");
					
					
					
			
					for(Transaction cur : DatabaseImportController.getTransactions()) { //Upload each transaction as a new row in Transaction table 
						
						String Payee = cur.getPayee(); 
						String Amount = String.valueOf(cur.getAmount()); 
						String Budget = cur.getBudget(); 
						String Date = String.valueOf(cur.getDate().getDate()); 
						String month = String.valueOf(cur.getDate().getMonth()); 
						String year = String.valueOf(cur.getDate().getYear()); 
						String Type = "credit"; 
						if(cur.isType()) {
							Type = "debit"; 
						}
						String order = String.valueOf(tableSize); 
						
						sql = "INSERT INTO `Transactions` (`user`,`Payee`,`Amount`,`Budget`,`Date`,`month`,`year`,`Type`,`order`)  "
								+ "VALUES ('" + user + "','" + Payee + "','" + Amount + "', '" + Budget + "'"
										+ ", '" + Date + "', '" + month + "', '" + year + "', '" + Type + "', '" + order + "')";
								
					 
						stmt.execute(sql);
						
					}
				

				}catch(Exception e1){ System.out.println(e1);} 
				
				
				
		//4. Update User Info 
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pwm","root","Bubbletea_23"); 
			java.sql.Statement stmt = con.createStatement();
			
			String LastName = String.valueOf(DatabaseImportController.getCurrentUser().getLastName()); 
			String EMail = String.valueOf(DatabaseImportController.getCurrentUser().getEmail()); 
			String MonthlyIncome = String.valueOf(DatabaseImportController.getCurrentUser().getIncome()); 
			String UserName = String.valueOf(DatabaseImportController.getCurrentUser().getUsername());
			String Pass_word = String.valueOf(DatabaseImportController.getCurrentUser().getPassword()); 
			String Points = String.valueOf(DatabaseImportController.getCurrentUser().getPoints()); 
			String TotalSavingsGoal = String.valueOf(DatabaseImportController.getCurrentUser().getAnnualSavingsGoal()); 
			System.out.println("Points : " + Points); 
			
			
			String sql = "UPDATE userinfor SET LastName = '" + LastName 
					+ "', EMail = '" + Email 
					+ "', MonthlyIncome = '" + MonthlyIncome 
					+ "', UserName = '" + UserName 
					+ "', Pass_word = '" + Pass_word  
					+ "', Points = '" + Points 
					+ "', TotalSavingsGoal = '" + TotalSavingsGoal 
					+ "' WHERE UserName = '" + username + "'";
		    stmt.execute(sql);

		}catch(Exception e1){ System.out.println(e1);} 
		
		
		
		
		
	}
	
	
	
}
















































