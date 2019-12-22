package com.di3.matiere;

public class Matiere {
	private String codeMatiere;
	private String nom;
	
	public Matiere() {
		
	}
	public Matiere(String codeMatiere,String nom) {
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
	
}
