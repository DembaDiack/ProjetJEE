package com.di3.enseignant;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.di3.matiere.Matiere;
import com.di3.matiere.MatiereHandler;

@Path("/{token}/enseignant")
public class EnseignantHandler {
	private static List<Enseignant> enseignant_list = new ArrayList<Enseignant>();
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String Home() {
		return "welcome";
	}
	@GET
	@Path("/ajouter")
	@Produces(MediaType.APPLICATION_JSON)
	public Enseignant ajouterEns(
			@QueryParam("id") int id,
			@QueryParam("nom") String nom,
			@QueryParam("prenom") String prenom,
			@QueryParam("username") String username,
			@QueryParam("password") String password
			) {
		
		Enseignant ens = new Enseignant(id,nom, prenom, username, password);
		enseignant_list.add(ens);
		return ens;
	}
	@POST
	@Path("/ajouter")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Enseignant ajouterEns(Enseignant ens) {
		enseignant_list.add(ens);
		return ens;
	}
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Enseignant> getAllEns(){
		return enseignant_list;
	}
	@GET
	@Path("/matiere/ajouter/")
	@Produces(MediaType.APPLICATION_JSON)
	public Enseignant ajoutMatEns(@QueryParam("mat") int idMatiere,@QueryParam("ens") int idEns){
		List<Matiere> all_matieres = MatiereHandler.matieres_list;
		for(int id = 0; id <= all_matieres.size() - 1; id++) {
			if(all_matieres.get(id).getId() == idMatiere) {
				for(int e = 0; e <= enseignant_list.size() - 1; e++) {
					if(enseignant_list.get(e).getId() == idEns) {
						enseignant_list.get(e).addMatiereToEns(all_matieres.get(id));
						return enseignant_list.get(e);
					}
				}
			}
		}
		return new Enseignant();
		
	}
	
	
}
