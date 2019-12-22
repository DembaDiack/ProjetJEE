package com.di3.matiere;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/matiere")
public class MatiereHandler {
	private static List<Matiere> matieres_list = new ArrayList<Matiere>();
	
	@GET
	@Path("/ajouter")
	@Produces(MediaType.APPLICATION_JSON)
	public Matiere ajouterMatiere(
			@QueryParam("code") String code,
			@QueryParam("nom") String nom
			) {
		Matiere matiere = new Matiere(code,nom);
		matieres_list.add(matiere);
		return matiere;
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Matiere> allMatieres() {
		return matieres_list;
	}
	
}
