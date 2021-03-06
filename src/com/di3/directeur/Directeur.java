package com.di3.directeur;

import java.util.Date;

public class Directeur {
	private int id;
	private String nom;
	private String prenom;
	private String username;
	private String password;
	private int role = 2;
	public Directeur() {
		
	}
	public Directeur(int id,String nom,String prenom,String username,String password) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.role = 2;
	}
	public Directeur(int i, String err) {
		this.id = i;
		this.nom = err;
		// TODO Auto-generated constructor stub
	}
	public int getRole() {
		return this.role;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
	
}
