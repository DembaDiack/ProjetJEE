package com.di3.enseignant;

import java.util.List;

public class EnseignantAuth {
	private EnseignantHandler Enseignant_handler = new EnseignantHandler();
	private List<Enseignant> Enseignant_list = Enseignant_handler.getAllEns();
	
	
	
	public boolean Auth(String username,String password) {
		for(int i = 0; i<= Enseignant_list.size() - 1; i++) {
			if((Enseignant_list.get(i).getUsername().equals(username)) && Enseignant_list.get(i).getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
}
