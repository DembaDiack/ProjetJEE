package com.di3.matiere;

import java.time.LocalTime;

import com.di3.crenaux.Crenaux;

public class Matiere {
	private String codeMatiere;
	private String nom;
	private int id;
	private Crenaux crenau;
	public Matiere(int id,String nom) {
		this.id = id;
		this.nom = nom;
	}
	public Matiere(int id,String codeMatiere,String nom,Crenaux c) {
		this.crenau = c;
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
	public Crenaux getCrenau() {
		return crenau;
	}
	public void setCrenau(Crenaux crenau) {
		this.crenau = crenau;
	}
	
}
