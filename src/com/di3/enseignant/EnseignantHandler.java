package com.di3.enseignant;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.di3.matiere.Matiere;
import com.di3.matiere.MatiereHandler;

@Path("/{token}/enseignant")
public class EnseignantHandler {
	
	private static List<Enseignant> enseignant_list = new ArrayList<Enseignant>();
	
	//----------------------------------------------------------GET-------------------------------------------------------------
	
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
	//----------------------------------------------------POST---------------------------------------------------
	@POST
	@Path("/ajouter")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Enseignant ajouterEns(Enseignant ens) {
		enseignant_list.add(ens);
		return ens;
	}
	
	//----------------------------------------------------DELETE-------------------------------------------------
	@DELETE
	@Path("/supp/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String eff_ens_pp_delete(@PathParam("id") int id)
	{
		for(int i = 0; i <= enseignant_list.size() - 1; i++)
		{
			if(id == enseignant_list.get(i).getId()) {
				enseignant_list.remove(i);
				return "enseignant avec id : " + id + "supprime";
			}
		}
		return "enseignant non trouve";
	}
	
	//---------------------------------------------------PUT-----------------------------------------------------
	@PUT
	@Path("/modif")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Enseignant mj_matiere(Enseignant enseignant)
	{
		for(int i = 0; i <= enseignant_list.size() - 1;i++)
		{
			if(enseignant.getId() == enseignant_list.get(i).getId())
			{
				enseignant_list.set(i, enseignant);
				return enseignant_list.get(i);
			}
		}
		return new Enseignant(-1,"impossible de mettre a jour un enseignant qui nexiste pas");
	}
}
