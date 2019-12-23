package com.di3.matiere;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.di3.crenaux.Crenaux;

@Path("/matiere")
public class MatiereHandler {
	public static List<Matiere> matieres_list = new ArrayList<Matiere>();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String Home() {
		return "Welcome";
	}
	
	@GET
	@Path("/ajouter")
	@Produces(MediaType.APPLICATION_JSON)
	public Matiere ajouterMatiere(
			@QueryParam("id") int id,
			@QueryParam("code") String code,
			@QueryParam("nom") String nom,
			@QueryParam("idcrenau") int idc
			)
	{
		for(int cmpt = 0; cmpt <= Crenaux.crenaux_list.size() - 1; cmpt++) {
			if(Crenaux.crenaux_list.get(cmpt).getId() == idc) {
				Matiere matiere = new Matiere(id,code,nom,Crenaux.crenaux_list.get(cmpt));
				matieres_list.add(matiere);
				return matiere;
			}
		}
		return new Matiere(-1,"Erreur crenaux inexistant");
	}
	
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Matiere> allMatieres() {
		return matieres_list;
	}
	
	
}
