package com.di3.directeur;

import java.util.List;

public class DirecteurAuth {
	private DirecteurHandler Enseignant_handler = new DirecteurHandler();
	private List<Directeur> Directeur_list = Enseignant_handler.getAllDirecteurs();
	
	
	
	public boolean Auth(String username,String password) {
		for(int i = 0; i<= Directeur_list.size() - 1; i++) {
			if((Directeur_list.get(i).getUsername().equals(username)) && Directeur_list.get(i).getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
}
