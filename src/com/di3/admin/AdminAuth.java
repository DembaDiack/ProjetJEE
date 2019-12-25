package com.di3.admin;

public class AdminAuth {
	private Admin admin = new Admin();
	
	
	public boolean Auth(String username,String password) {
		if((admin.getUsername().equals(username)) && (admin.getPassword().equals(password))) {
			return true;
		}
		else {
			return false;
		}
	}
}
