package com.di3.matiere;

public class Matiere {
	private String codeMatiere;
	private String nom;
	private int id;
	
	public Matiere() {
		
	}
	public Matiere(int id,String codeMatiere,String nom) {
		this.setId(id);
		this.codeMatiere = codeMatiere;
		this.nom = nom;
	}


	public String getCodeMatiere() {
		return codeMatiere;
	}


	public void setCodeMatiere(String codeMatiere) {
		this.codeMatiere = codeMatiere;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
