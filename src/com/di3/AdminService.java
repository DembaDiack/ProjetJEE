package com.di3;
public class AdminService {
	private static String username = "admin";
	private static String password = "admin";
	
	public AdminService() {
		
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		AdminService.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		AdminService.password = password;
	}

	public String changeAdminUsrPswd(String username,String password) {
		try {
			AdminService.username = username;
			AdminService.password = password;
			return "nom duttilisateur et mot de passe change avec success";
		} catch (Exception e) {
			return "an error has occured";
		}
	}
}
