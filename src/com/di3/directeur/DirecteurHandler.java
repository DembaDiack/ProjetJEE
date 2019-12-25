package com.di3.directeur;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/{token}/directeur")
public class DirecteurHandler {

	private static List<Directeur> Directeurs_list = new ArrayList<Directeur>();
	@GET
	@Path("/ajouter")
	@Produces(MediaType.APPLICATION_JSON)
	public Directeur ajouterDirecteur(
			@QueryParam("nom") String nom,
			@QueryParam("prenom") String prenom,
			@QueryParam("username") String username,
			@QueryParam("password") String password) {
		Directeur directeur = new Directeur(nom,prenom,username,password);
		Directeurs_list.add(directeur);
		return directeur;
	}
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Directeur> getAllDirecteurs(){
		return Directeurs_list;
	}
}
