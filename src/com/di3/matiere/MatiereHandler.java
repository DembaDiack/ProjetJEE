package com.di3.matiere;

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

import com.di3.crenaux.Crenaux;

@Path("/{token}/matiere")
public class MatiereHandler {
	//----------------------------------------GET---------------------------------------------
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
	
	@GET
	@Path("/supp")
	@Produces(MediaType.TEXT_PLAIN)
	public String eff_matiere(@QueryParam("id") int id)
	{
		for(int i = 0; i <= matieres_list.size() - 1; i++)
		{
			if(id == matieres_list.get(i).getId()) {
				matieres_list.remove(i);
				return "matiere avec id : " + id + "supprime";
			}
		}
		return "matiere non trouve";
	}
	@GET
	@Path("/supp/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String eff_matiere_pp(@PathParam("id") int id)
	{
		for(int i = 0; i <= matieres_list.size() - 1; i++)
		{
			if(id == matieres_list.get(i).getId()) {
				matieres_list.remove(i);
				return "matiere avec id : " + id + "supprime";
			}
		}
		return "matiere non trouve";
	}
	//retourners une liste contenant des objets de classe matiere
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Matiere> allMatieres() {
		return matieres_list;
	}
	
	//-----------------------------------------------POST--------------------------------------------------------
	@POST
	@Path("/ajouter")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Matiere ajouterMatiere_post(Matiere matiere) {
		int idc = matiere.getId();
		//nous cherchons le crenaux avec le idcrenau passe dans le lien
				for(int cmpt = 0; cmpt <= Crenaux.crenaux_list.size() - 1; cmpt++) {
					if(Crenaux.crenaux_list.get(cmpt).getId() == idc) {
						matieres_list.add(matiere);
						return matiere;
					}
				}
				//on ajoute rien et on revoi une erreur
				return new Matiere(-1,"Erreur crenaux inexistant");
	}
	
	
	
	
	//------------------------------------------------PUT-------------------------------------------------------
	@PUT
	@Path("/modif")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Matiere mj_matiere(Matiere matiere)
	{
		for(int i = 0; i <= matieres_list.size() - 1; i++)
		{
			if(matiere.getId() == matieres_list.get(i).getId())
			{
				matieres_list.set(i, matiere);
				return matieres_list.get(i);
			}
		}
		return new Matiere(-1,"impossible de mettre a jour une matiere qui nexiste pas");
	}
	//------------------------------------------------DELETE---------------------------------------------------
	@DELETE
	@Path("/supp/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String eff_matiere_pp_delete(@PathParam("id") int id)
	{
		for(int i = 0; i <= matieres_list.size() - 1; i++)
		{
			if(id == matieres_list.get(i).getId()) {
				matieres_list.remove(i);
				return "matiere avec id : " + id + "supprime";
			}
		}
		return "matiere non trouve";
	}
}
