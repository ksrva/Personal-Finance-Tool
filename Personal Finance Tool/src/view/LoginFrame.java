/*
 * Login frame allows user to enter information and  displays users relative plane 
 */


package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.*;

public class LoginFrame extends JFrame {
	
	private JFrame frmLogin; //login frame placeholder 
	
	//Labels 
	private JLabel welcome_lbl;
	private JLabel username_lbl; 
	private JLabel password_lbl;
	private JLabel registration_lbl; 
	
	//Text & passwrd fields 
	private JTextField username_txtfield; 
	private JPasswordField password_passField;
	
	//Buttons
	private JButton visible_btn = new JButton();
	private JButton hidden_btn = new JButton();
	private JButton login_btn = new JButton(); 
	private JButton reset_btn = new JButton(); 
	private JButton exit_btn = new JButton();
	private JButton registration_btn = new JButton();
	

	public LoginFrame() {

		
		// FRAME
		setTitle("Login Page");
		setLayout(null);
		setSize(500, 350);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		// COMPONENTS 

		//LABELS 
		//Welcome message 
		welcome_lbl = new JLabel("Personal Financial Management Tool");
		welcome_lbl.setBounds(50, 10, 400, 30);
		welcome_lbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(welcome_lbl);

		//Username lbl
		username_lbl = new JLabel("Username");
		username_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		username_lbl.setBounds(30, 60, 150, 30);
		add(username_lbl);
		
		//Password lbl
		password_lbl = new JLabel("Password");
		password_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		password_lbl.setBounds(30, 110, 150, 30);
		add(password_lbl);	
		
		registration_lbl = new JLabel("If you are not a Registered User, You can Register here!");
		registration_lbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
		registration_lbl.setBounds(30, 210, 420, 40);
		add(registration_lbl);
		
		//TEXTFIELDS 
		//Textfield for user to enter username 
		username_txtfield = new JTextField();
		username_txtfield.setBounds(134, 60, 325, 30);
		add(username_txtfield);
		username_txtfield.setColumns(10);
		
		//Textfield for user to enter password
		password_passField = new JPasswordField();
		password_passField.setColumns(10);
		password_passField.setBounds(134, 110, 295, 30);
		add(password_passField);
		
		//BUTTONS 
		//Show and hide password icons
		ImageIcon hide = new ImageIcon(new ImageIcon("images/hideeye.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)); //SCALE_DEFAULT));
		hidden_btn.setBounds(429, 110, 30, 30);
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
		
		ImageIcon visible = new ImageIcon(new ImageIcon("images/visibleeye.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)); //SCALE_DEFAULT));
		visible_btn.setBounds(429, 110, 30, 30);
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
		
		
					
		login_btn = new JButton("LOGIN");
		login_btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		login_btn.setBounds(30, 160, 140, 40);
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = String.valueOf(username_txtfield.getText());
				String pass_word = String.valueOf(password_passField.getText());
				try{  
					
					//To establish connection I referenced the following link : https://stackoverflow.com/questions/37668260/how-to-use-try-catch-exception-in-mysql-database-connect
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pwm","root","Bubbletea_23");  
					java.sql.Statement stmt = con.createStatement();
				    String sql = "SELECT * FROM `userinfor` WHERE `UserName` = '" + username + "' AND `Pass_word` ='" + pass_word + "'";
				    stmt.execute(sql);
				    ResultSet rs = stmt.executeQuery(sql);
				    if (rs.next())
				    {
				        JOptionPane.showMessageDialog(null, "Login Successfull", "Login Success", 1);
				       
				        DatabaseImportController newContr = new DatabaseImportController(username); 
				        System.out.println("Passed");
				        
				        LandingFrame newLandingFrame = new LandingFrame(username);
				         
				        setVisible(false); 
				    } else {
				        JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "Login Failed", 2);
				    }
					con.close();  
				}catch(Exception e1){ System.out.println(e1);} 
			}
		});
		add(login_btn);
		
		reset_btn = new JButton("RESET");
		reset_btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		reset_btn.setBounds(175, 160, 140, 40);
		reset_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				password_passField.setText(null);
				username_txtfield.setText(null);	
			}
		});
		add(reset_btn);
		
		exit_btn = new JButton("EXIT");
		exit_btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		exit_btn.setBounds(320, 160, 140, 40);
		exit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLogin,"Confirm if you want to exit","Login Systems",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
					System.exit(0);
				}
			}
		});
		add(exit_btn);
		
		
		registration_btn = new JButton("Register");
		registration_btn.setFont(new Font("Tahoma", Font.BOLD, 15));		
		registration_btn.setBounds(155, 250, 180, 40);
		registration_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisFrame newRegisFrame = new RegisFrame(); 
				setVisible(false);
			}
		});
		add(registration_btn);
		
		
		

		setVisible(true);
	}

	
	//GETTERS & SETTERS 

	public JFrame getFrmLogin() {
		return frmLogin;
	}


	public void setFrmLogin(JFrame frmLogin) {
		this.frmLogin = frmLogin;
	}


	public JLabel getWelcome_lbl() {
		return welcome_lbl;
	}


	public void setWelcome_lbl(JLabel welcome_lbl) {
		this.welcome_lbl = welcome_lbl;
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


	public JLabel getRegistration_lbl() {
		return registration_lbl;
	}


	public void setRegistration_lbl(JLabel registration_lbl) {
		this.registration_lbl = registration_lbl;
	}


	public JTextField getUsername_txtfield() {
		return username_txtfield;
	}


	public void setUsername_txtfield(JTextField username_txtfield) {
		this.username_txtfield = username_txtfield;
	}


	public JPasswordField getPassword_passField() {
		return password_passField;
	}


	public void setPassword_passField(JPasswordField password_passField) {
		this.password_passField = password_passField;
	}


	public JButton getVisible_btn() {
		return visible_btn;
	}


	public void setVisible_btn(JButton visible_btn) {
		this.visible_btn = visible_btn;
	}


	public JButton getHidden_btn() {
		return hidden_btn;
	}


	public void setHidden_btn(JButton hidden_btn) {
		this.hidden_btn = hidden_btn;
	}


	public JButton getLogin_btn() {
		return login_btn;
	}


	public void setLogin_btn(JButton login_btn) {
		this.login_btn = login_btn;
	}


	public JButton getReset_btn() {
		return reset_btn;
	}


	public void setReset_btn(JButton reset_btn) {
		this.reset_btn = reset_btn;
	}


	public JButton getExit_btn() {
		return exit_btn;
	}


	public void setExit_btn(JButton exit_btn) {
		this.exit_btn = exit_btn;
	}


	public JButton getRegistration_btn() {
		return registration_btn;
	}


	public void setRegistration_btn(JButton registration_btn) {
		this.registration_btn = registration_btn;
	}
	
	

}
