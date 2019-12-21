package com.db;

import java.util.Date;

public class Directeur {
	private int id;
	private String Nom,Prenom,username,password;
	private Date dateCree;
	public Directeur() {
		
	}
	public Directeur(int id, String nom, String prenom, String username, String password) {
		super();
		this.id = id;
		Nom = nom;
		Prenom = prenom;
		this.username = username;
		this.password = password;
		this.setDateCree(new Date());
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDateCree() {
		return dateCree;
	}
	public void setDateCree(Date dateCree) {
		this.dateCree = dateCree;
	}
	
	
	
	
}
