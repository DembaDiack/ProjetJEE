package com.di3.crenaux;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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
	@POST
	@Path("/ajouter")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Crenaux ajouterCr_post(Crenaux crenau) {
		Crenaux.crenaux_list.add(crenau);
		return crenau;
	}
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Crenaux> allCren() {
		return Crenaux.crenaux_list;
	}
}
