package com.db;

import java.util.ArrayList;
import java.util.List;
import com.db.Directeur;

public class ServiceDirecteur {
	public List<Directeur> getAllDirecteurs(){
		Directeur d1 = new Directeur(1,"John","Doe","admin","admin");
		List<Directeur> list = new ArrayList<>();
		list.add(d1);
		return list;
		
	}
}
