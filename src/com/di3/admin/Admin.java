package com.di3.admin;
public class Admin {
	private static String username = "admin";
	private static String password = "admin";
	private int role = 1;
	public Admin() {
		this.role = 1;
	}
	
	public int getRole() {
		return this.role;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		Admin.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		Admin.password = password;
	}

	public String changeAdminUsrPswd(String username,String password) {
		try {
			Admin.username = username;
			Admin.password = password;
			return "nom duttilisateur et mot de passe change avec success";
		} catch (Exception e) {
			return "an error has occured";
		}
	}
}
