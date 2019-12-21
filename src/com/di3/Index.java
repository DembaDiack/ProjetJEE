package com.di3;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
 public class Index {
	AdminService admin = new AdminService();
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String noLog() {
		return " authentifier vous svp, '/nom_duttil/mot_pass' ";
	}
	@GET
	@Path("/{username}/{password}")
	@Produces(MediaType.TEXT_PLAIN)
	public String home(@PathParam("username") String username,@PathParam("password") String password) {
		if((admin.getUsername().equals(username)) && (admin.getPassword().equals(password))) {
			
			return "bienvenue " + admin.getUsername();
		}else {
			
			return "verifier vos coordonnes nom_dut : "+username+" mdp : "+password;
		}
	}
}