package com.di3.enseignant;

import java.util.ArrayList;
import java.util.List;

import com.di3.matiere.*;
import com.di3.token.Token;
public class Enseignant {
	private int id;
	private String nom;
	private String prenom;
	private String username;
	private String password;
	private int role = 3;
	private List<Matiere> matieres = new ArrayList<Matiere>();
	
	public Enseignant() {
		
	}
	public Enseignant(int id,String nom,String prenom,String username,String password) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.username = username;
		this.role = 3;
	}
	public Enseignant(int i, String text) {
		// TODO Auto-generated constructor stub
		this.id = i;
		this.nom = text;
	}
	public int getRole() {
		return this.role;
	}
	public String ajouterMatieres(Matiere ma) {
		this.matieres.add(ma);
		return "matiere ajoute";
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
	public List<Matiere> getMatieres() {
		return matieres;
	}
	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}
	public void addMatiereToEns(Matiere m) {
		this.matieres.add(m);
	}
}
