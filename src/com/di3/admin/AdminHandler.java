package com.di3.admin;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/{token}/settings")
public class AdminHandler {
	Admin handler = new Admin();
	@GET
	@Path("/")
	public String help() {
		return "uttiliser '/settings/change/nouv_nom_duttil/nouv_mdp' pour changer le nom duttilisateur ou '/settings/change?username=nouv_nom_duttil&password=nouv_mdp'";
	}
	@GET
	@Path("/admin/change/{username}/{password}")
	@Produces(MediaType.TEXT_PLAIN)
	public String changeUsr(@PathParam("username") String username,@PathParam("password") String password) {
		if(username =="" || password =="") {
			return "champs vide non authorise";
		}else {
			return handler.changeAdminUsrPswd(username, password) + handler.getUsername();
		}
	}
	@GET
	@Path("/admin/change")
	@Produces(MediaType.TEXT_PLAIN)
	public String changeUsr_(@QueryParam("username") String username,@QueryParam("password") String password) {
		try {
			return handler.changeAdminUsrPswd(username, password);
		} catch (Exception e) {
			return "erreur";
		}
	}
	@POST
	@Path("/ajouter")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Admin changeUsr_post(Admin admin) {
		try {
			String username = admin.getUsername();
			String password = admin.getPassword();
			
			handler.changeAdminUsrPswd(username, password);
			return handler;
		} catch (Exception e) {
			return new Admin();
		}
	}
}
 