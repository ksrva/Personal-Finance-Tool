
/*
Main Controller for project. Opens the login frame when run *  
 *  */

package controller;

import java.util.*;

import view.*;
 

public class pwmController {

	//Frames 
	private LoginFrame loginFrame; 
	private RegisFrame regisFrame; 
	private LandingFrame landingFrame; 

	public pwmController() {
		
		loginFrame = new LoginFrame(); 
		
	}

	public LoginFrame getLoginFrame() {
		return loginFrame;
	}

	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}

	public RegisFrame getRegisFrame() {
		return regisFrame;
	}

	public void setRegisFrame(RegisFrame regisFrame) {
		this.regisFrame = regisFrame;
	}

	public LandingFrame getLandingFrame() {
		return landingFrame;
	}

	public void setLandingFrame(LandingFrame landingFrame) {
		this.landingFrame = landingFrame;
	}

	
	
	
	
	
}
