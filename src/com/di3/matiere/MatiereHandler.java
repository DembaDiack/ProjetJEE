package com.di3.matiere;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.di3.crenaux.Crenaux;

@Path("/{token}/matiere")
public class MatiereHandler {
	//on genere une liste vide qui prend des objects de classe matiere
	public static List<Matiere> matieres_list = new ArrayList<Matiere>();


	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String Home() {
		return "Welcome";
	}
	

	//on recupere les donnees id,code etc...
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
		//nous cherchons le crenaux avec le idcrenau passe dans le lien
		for(int cmpt = 0; cmpt <= Crenaux.crenaux_list.size() - 1; cmpt++) {
			if(Crenaux.crenaux_list.get(cmpt).getId() == idc) {
				Matiere matiere = new Matiere(id,code,nom,Crenaux.crenaux_list.get(cmpt));
				//si on trouve le crenau on ajoute la matiere et on lui attache le crenau
				matieres_list.add(matiere);
				return matiere;
			}
		}
		//on ajoute rien et on revoi une erreur
		return new Matiere(-1,"Erreur crenaux inexistant");
	}
	
	
	//retourners une liste contenant des objets de classe matiere
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Matiere> allMatieres() {
		return matieres_list;
	}
	
	
}
