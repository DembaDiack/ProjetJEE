package com.di3.crenaux;

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

import com.di3.directeur.Directeur;

@Path("{token}/crenaux")
public class CrenauxHandler {
	@GET
	@Path("/ajouter")
	@Produces(MediaType.APPLICATION_JSON)
	public Crenaux ajouterCr(@QueryParam("h") int h,@QueryParam("m") int m,@QueryParam("id") int id) {
		Crenaux c = new Crenaux(id,h,m);
		Crenaux.crenaux_list.add(c);
		return c;
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Crenaux> allCren() {
		return Crenaux.crenaux_list;
	}
	
	//--------------------------------------------POST--------------------------------------------------
	@POST
	@Path("/ajouter")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Crenaux ajouterCr_post(Crenaux crenau) {
		Crenaux.crenaux_list.add(crenau);
		return crenau;
	}
	//--------------------------------------------DELETE-------------------------------------------------
	@DELETE
	@Path("/supp/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String eff_cren_pp_delete(@PathParam("id") int id)
	{
		for(int i = 0; i <= Crenaux.crenaux_list.size() - 1; i++)
		{
			if(id == Crenaux.crenaux_list.get(i).getId()) {
				Crenaux.crenaux_list.remove(i);
				return "crenau avec id : " + id + "supprime";
			}
		}
		return "crenau non trouve";
	}
	//-------------------------------------------PUT--------------------------------------------------
	@PUT
	@Path("/modif")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Crenaux mj_matiere(Crenaux crenau)
	{
		for(int i = 0; i <= Crenaux.crenaux_list.size() - 1;i++)
		{
			if(crenau.getId() == Crenaux.crenaux_list.get(i).getId())
			{
				Crenaux.crenaux_list.set(i, crenau);
				return Crenaux.crenaux_list.get(i);
			}
		}
		return new Crenaux(-1,"impossible de mettre a jour un crenau qui nexiste pas");
	}
}
