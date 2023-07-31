/*
 * Allows users to rgister a new account and saves values into sql table 
 */


package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.pwmController;


public class RegisFrame extends JFrame {

	private JFrame frmRegister; 
	
	//Labels 
	private JLabel title_lbl; 
	private JLabel fullName_lbl; 
	private JLabel email_lbl; 
	private JLabel income_lbl; 
	private JLabel username_lbl; 
	private JLabel password_lbl; 
	private JLabel savingsGoal_lbl; 
	
	//Text & Pass Fields 
	private JTextField fullName_txtField;
	private JTextField email_txtField; 
	private JTextField income_txtField; 
	private JTextField username_txtField; 
	private JPasswordField password_passField; 
	private JTextField savingsGoal_passField; 
	
	//Buttons 
	private JButton hidden_btn = new JButton(); 
	private JButton visible_btn = new JButton(); 
	private JButton submit_btn = new JButton(); 
	private JButton reset_btn = new JButton(); 
	private JButton login_btn = new JButton(); 
	private JButton exit_btn = new JButton(); 

	
	
	//Text & Pass fields 
	
	//Buttons
	
	//Design 
	private Font font1;
	private Font font2;
	private Font font3;
	
	public RegisFrame() {
		

		// FRAME
		setTitle("Registration Page");
		setLayout(null);
		setSize(500, 400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//COMPONENTS 
		
		//Fonts 
		font1 = new Font("Tahoma", Font.BOLD, 20);
		font2 = new Font("Tahoma", Font.BOLD, 15);
		font3 = new Font("Tahoma", Font.BOLD, 12);
		
		//LABELS 

		title_lbl = new JLabel("New User Registration");
		title_lbl.setFont(font1);
		title_lbl.setBounds(150, 10, 300, 30);
		add(title_lbl);
		
		fullName_lbl = new JLabel("Full Name");
		fullName_lbl.setFont(font2);
		fullName_lbl.setBounds(30, 60, 150, 30);
		add(fullName_lbl);
		
		email_lbl = new JLabel("Email");
		email_lbl.setFont(font2);
		email_lbl.setBounds(30, 110, 150, 30);
		add(email_lbl);
		
		income_lbl = new JLabel("Monthly Income");
		income_lbl.setFont(font2);
		income_lbl.setBounds(30, 160, 150, 30);
		add(income_lbl);
		
		username_lbl = new JLabel("Username");
		username_lbl.setFont(font2);
		username_lbl.setBounds(30, 210, 150, 30);
		add(username_lbl);
		
		password_lbl = new JLabel("Password");
		password_lbl.setFont(font2);
		password_lbl.setBounds(30, 260, 150, 30);
		add(password_lbl);	
		
//		savingsGoal_lbl = new JLabel("Annual Savings Goal");
//		savingsGoal_lbl.setFont(font2);
//		savingsGoal_lbl.setBounds(30, 290, 150, 30);
//		add(savingsGoal_lbl);
		
		//TEXT & PASS FIELDS  
		
		fullName_txtField = new JTextField("Full Name");
		fullName_txtField.setBounds(160, 60, 300, 30);
		fullName_txtField.setColumns(10); //update sql 
		add(fullName_txtField);

		email_txtField = new JTextField("name@domain.com");
		email_txtField.setBounds(160, 110, 300, 30);
		email_txtField.setColumns(10);
		add(email_txtField);
		
		income_txtField = new JTextField("Enter Number Only");
		income_txtField.setBounds(160, 160, 300, 30);
		income_txtField.setColumns(10); //update sql 
		add(income_txtField);
		
		username_txtField = new JTextField();
		username_txtField.setBounds(160, 210, 300, 30);
		username_txtField.setColumns(10); //update sql 
		add(username_txtField);
		
		password_passField = new JPasswordField();
		password_passField.setBounds(160, 260, 270, 30);
		password_passField.setColumns(10); //update sql 
		add(password_passField);
	
		
//		savingsGoal_passField = new JTextField("Enter Number Only");
//		savingsGoal_passField.setBounds(160, 290, 270, 30);
//		savingsGoal_passField.setColumns(10); //update sql 
//		add(savingsGoal_passField);
//		
		
		//BUTTONS
		
		//Buttons to set the password to visible or hidden 
		ImageIcon hide = new ImageIcon(new ImageIcon("images/hideeye.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)); 
		hidden_btn.setBounds(430, 260, 30, 30);
		hidden_btn.setIcon(hide);
		hidden_btn.setVisible(true);
		hidden_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hidden_btn.setVisible(false);
				visible_btn.setVisible(true);
				password_passField.setEchoChar((char) 0);
			}
		});
		add(hidden_btn);
		
		ImageIcon visible = new ImageIcon(new ImageIcon("images/visibleeye.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)); 
		visible_btn.setBounds(430, 260, 30, 30);
		visible_btn.setIcon(visible);
		visible_btn.setVisible(false);
		visible_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visible_btn.setVisible(false);
				hidden_btn.setVisible(true);
				password_passField.setEchoChar('*');
			}
		});
		add(visible_btn);
		
		
		//Submit information entered to create a new account 	
		submit_btn = new JButton("SUBMIT");
		submit_btn.setFont(font3);
		submit_btn.setBounds(20, 310, 100, 40);
		submit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = String.valueOf(fullName_txtField.getText());
				String email = String.valueOf(email_txtField.getText());
				String sincome = String.valueOf(income_txtField.getText());
				String user_name = String.valueOf(username_txtField.getText());
				String pass_word = String.valueOf(password_passField.getText());

				
				if (name.trim().isEmpty() || email.trim().isEmpty() || user_name.trim().isEmpty() || pass_word.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all required information on the Registration form", "Please fill all the fields in the form!", 1);
				}
				else if (!isValid(email)) {
					JOptionPane.showMessageDialog(null, "Please Fill Correct Email Address!", "Wrong E-mail Format!", 1);
				}
				else if (!isNumeric(sincome)) {
					JOptionPane.showMessageDialog(null, "Please Fill Income with numeric numbers!", "Wrong income Format!", 1);
				}		
				else {
					int income = Integer.valueOf(sincome);
					try{  
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pwm","root","Bubbletea_23");  
						java.sql.Statement stmt = con.createStatement();
						String sql = "SELECT * FROM `userinfor` WHERE `UserName` = '" + user_name + "'";
					    stmt.execute(sql);
					    ResultSet rs = stmt.executeQuery(sql);
					    if (rs.next())
					    {
					        JOptionPane.showMessageDialog(null, "User Name is alredy exist! Please try another User Name", "Try another User Name!", 1);        
					    } 
					    else {			
					    	String query = "INSERT INTO userinfor (LastName, EMail, MonthlyIncome, UserName, Pass_word, Points, TotalSavingsGoal, TotalSaved) VALUES ('" + name + "','" + email + "','" +  income + "','" +  user_name + "','" + pass_word + "','" + 0 + "', '" + 0 + "','" + 0 + "')";					    	
					    	stmt.executeUpdate(query);
					    	
					    	String queryb = "INSERT INTO budget (user, Groceries, groceriesValue, Rent, rentValue, Bills, billsValue, Transportation, transportationValue, Coursematerials, courseValue, Entertainment, enterValue, Savings, savingsValue, Credits, creditsValue, Total, totalValue) VALUES ('" + user_name + "','" + (0.2*income) + "','"  + (0.2*income) + "','" + (0.4*income) + "','" + (0.4*income) + "','" + (0.04*income) + "','" + (0.04*income) + "','" + (0.1*income) + "','" + (0.1*income) + "','" + (0.13*income) + "','" + (0.13*income) + "','" + (0.08*income) + "','" + (0.08*income) + "','" + (0.05*income) + "','" + (0.05*income) + "','" + 0 + "','" + 0 + "','" + (1*income) + "','" + (1*income) + "')"; 
					    	stmt.executeUpdate(queryb);

					    	JOptionPane.showMessageDialog(null, "Welcome, "  + "Your account is sucessfully created", "Your Registration is sucess!", 2);
	                        
					    	// Create a nrew table for user expense records
					    	
					    	java.sql.Statement stmt1 = con.createStatement();
					    	stmt1 = con.createStatement(); 
					    	String title = user_name + "_ExpenseReport";
					    	String sql1 = ("CREATE TABLE " + title + "" 
					    			+ "(Month DATE not NULL, "
					    			+ " Groceries SMALLINT, " 
					    			+ " Rent SMALLINT, "
					    			+ " Bills SMALLINT, " 
					    			+ " Transportation SMALLINT, "
					    			+ " Coursematerials SMALLINT, "
					    			+ " Entertainment SMALLINT, "
					    			+ " Investment SMALLINT, "
					    			+ " PRIMARY KEY ( Month ))");
					    	stmt1.executeUpdate(sql1);
					    	
					    	// close the mysql database connection
					    	con.close();
					    	fullName_txtField.setText(null);
					    	email_txtField.setText(null);
					    	income_txtField.setText(null);
					    	username_txtField.setText(null);
					    	password_passField.setText(null);
					    }
					}catch(Exception e1){ System.out.println(e1);} 
				}
			}
		});
		add(submit_btn);
		
		
		//Button to reset to default recommended settings 
		reset_btn = new JButton("RESET");
		reset_btn.setFont(font3);
		reset_btn.setBounds(125, 310, 100, 40);
		reset_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fullName_txtField.setText(null);
				email_txtField.setText(null);
				income_txtField.setText(null);
				username_txtField.setText(null);
				password_passField.setText(null);
			}
		});
		add(reset_btn);
		
		//Exit application
		exit_btn = new JButton("EXIT");
		exit_btn.setFont(font3);
		exit_btn.setBounds(230, 310, 100, 40);
		exit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegister= new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmRegister,"Confirm if you want to exit","Login Systems",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
					System.exit(1);
				}
			}
		});
		add(exit_btn);
		
		//Return to Login Page 
		login_btn = new JButton("Go to LOGIN");
		login_btn.setFont(new Font("Tahoma", Font.BOLD, 12));		
		login_btn.setBounds(335, 310, 140, 40);
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame newFrame = new LoginFrame(); 
				setVisible(false);
			}
		});
		add(login_btn);
		
		setVisible(true); 
	
	}
	
	//VALIDATION METHODS 
	//Determines if the provided email is valid 
	public static boolean isValid(String email)
    {
		//Default email address validation alg
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

	//Determines if the provided income is valid 
	public boolean isNumeric(String text) {
	    if (text == null || text.trim().equals("")) {
	        return false;
	    }
	    for (int iCount = 0; iCount < text.length(); iCount++) {
	        if (!Character.isDigit(text.charAt(iCount))) {
	            return false;
	        }
	    }
	    return true;
	    
	}


	//GETTERS AND SETTERS 
	
	
	public JFrame getFrmRegister() {
		return frmRegister;
	}

	public void setFrmRegister(JFrame frmRegister) {
		this.frmRegister = frmRegister;
	}

	public JLabel getTitle_lbl() {
		return title_lbl;
	}

	public void setTitle_lbl(JLabel title_lbl) {
		this.title_lbl = title_lbl;
	}

	public JLabel getFullName_lbl() {
		return fullName_lbl;
	}

	public void setFullName_lbl(JLabel fullName_lbl) {
		this.fullName_lbl = fullName_lbl;
	}

	public JLabel getEmail_lbl() {
		return email_lbl;
	}

	public void setEmail_lbl(JLabel email_lbl) {
		this.email_lbl = email_lbl;
	}

	public JLabel getIncome_lbl() {
		return income_lbl;
	}

	public void setIncome_lbl(JLabel income_lbl) {
		this.income_lbl = income_lbl;
	}

	public JLabel getUsername_lbl() {
		return username_lbl;
	}

	public void setUsername_lbl(JLabel username_lbl) {
		this.username_lbl = username_lbl;
	}

	public JLabel getPassword_lbl() {
		return password_lbl;
	}

	public void setPassword_lbl(JLabel password_lbl) {
		this.password_lbl = password_lbl;
	}

	public JTextField getFullName_txtField() {
		return fullName_txtField;
	}

	public void setFullName_txtField(JTextField fullName_txtField) {
		this.fullName_txtField = fullName_txtField;
	}

	public JTextField getEmail_txtField() {
		return email_txtField;
	}

	public void setEmail_txtField(JTextField email_txtField) {
		this.email_txtField = email_txtField;
	}

	public JTextField getIncome_txtField() {
		return income_txtField;
	}

	public void setIncome_txtField(JTextField income_txtField) {
		this.income_txtField = income_txtField;
	}

	public JTextField getUsername_txtField() {
		return username_txtField;
	}

	public void setUsername_txtField(JTextField username_txtField) {
		this.username_txtField = username_txtField;
	}

	public JPasswordField getPassword_passField() {
		return password_passField;
	}

	public void setPassword_passField(JPasswordField password_passField) {
		this.password_passField = password_passField;
	}

	public JButton getHidden_btn() {
		return hidden_btn;
	}

	public void setHidden_btn(JButton hidden_btn) {
		this.hidden_btn = hidden_btn;
	}

	public JButton getVisible_btn() {
		return visible_btn;
	}

	public void setVisible_btn(JButton visible_btn) {
		this.visible_btn = visible_btn;
	}

	public JButton getSubmit_btn() {
		return submit_btn;
	}

	public void setSubmit_btn(JButton submit_btn) {
		this.submit_btn = submit_btn;
	}

	public JButton getReset_btn() {
		return reset_btn;
	}

	public void setReset_btn(JButton reset_btn) {
		this.reset_btn = reset_btn;
	}

	public JButton getLogin_btn() {
		return login_btn;
	}

	public void setLogin_btn(JButton login_btn) {
		this.login_btn = login_btn;
	}

	public JButton getExit_btn() {
		return exit_btn;
	}

	public void setExit_btn(JButton exit_btn) {
		this.exit_btn = exit_btn;
	}

	public Font getFont1() {
		return font1;
	}

	public void setFont1(Font font1) {
		this.font1 = font1;
	}

	public Font getFont2() {
		return font2;
	}

	public void setFont2(Font font2) {
		this.font2 = font2;
	}

	public Font getFont3() {
		return font3;
	}

	public void setFont3(Font font3) {
		this.font3 = font3;
	}
	
	
	
	
	
	
	
	
	
}
















































