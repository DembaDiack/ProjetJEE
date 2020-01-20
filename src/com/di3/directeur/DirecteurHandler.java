package com.di3.directeur;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.di3.enseignant.Enseignant;

@Path("/{token}/directeur")
public class DirecteurHandler {

	private static List<Directeur> Directeurs_list = new ArrayList<Directeur>();
	@GET
	@Path("/ajouter")
	@Produces(MediaType.APPLICATION_JSON)
	public Directeur ajouterDirecteur(
			@QueryParam("nom") String nom,
			@QueryParam("id") int id,
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
	
	//---------------------------------------------------POST------------------------------------------------------
	@POST
	@Path("/ajouter")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Directeur ajouterDirecteur_post(Directeur directeur) {
		Directeurs_list.add(directeur);
		return directeur;
	}
	
	//--------------------------------------------------DELETE----------------------------------------------------------
	@DELETE
	@Path("/supp/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String eff_directeur_pp_delete(@PathParam("id") int id)
	{
		for(int i = 0; i <= Directeurs_list.size() - 1; i++)
		{
			if(id == Directeurs_list.get(i).getId()) {
				Directeurs_list.remove(i);
				return "directeur avec id : " + id + "supprime";
			}
		}
		return "directeur non trouve";
	}
	//-------------------------------------------------PUT--------------------------------------------------------
	@PUT
	@Path("/modif")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Directeur mj_matiere(Directeur directeur)
	{
		for(int i = 0; i <= Directeurs_list.size() - 1;i++)
		{
			if(directeur.getId() == Directeurs_list.get(i).getId())
			{
				Directeurs_list.set(i, directeur);
				return Directeurs_list.get(i);
			}
		}
		return new Directeur(-1,"impossible de mettre a jour un directeur qui nexiste pas");
	}
}
