package com.di3;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.db.Message;
import com.di3.admin.Admin;
import com.di3.admin.AdminAuth;
import com.di3.directeur.DirecteurAuth;
import com.di3.enseignant.EnseignantAuth;
import com.di3.token.Token;

@Path("/")
 public class Index {
	Admin admin = new Admin();
	public String homeMsg(int role,String token) {
		return Message.msg(role,token);
	}
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String noLog() {
		return " authentifier vous svp, 'rest/nom_duttilisateur/mot_de_passe' ";
	}
	@GET
	@Path("/login/{username}/{password}")
	@Produces(MediaType.TEXT_HTML)
	public String home(@PathParam("username") String username,@PathParam("password") String password) {
		AdminAuth adminAuth = new AdminAuth();
		EnseignantAuth ensAuth = new EnseignantAuth();
		DirecteurAuth direcAuth = new DirecteurAuth();
		
		if(adminAuth.Auth(username, password)) {
			Token token_handler = new Token(1);
			String token = token_handler.getToken();
			int role = token_handler.getRole();
			return homeMsg(role,token);
		}
		if(direcAuth.Auth(username, password)) {
			Token token_handler = new Token(2);
			String token = token_handler.getToken();
			int role = token_handler.getRole();
			return homeMsg(role,token);
		}
		if(ensAuth.Auth(username, password)) {
			Token token_handler = new Token(3);
			String token = token_handler.getToken();
			int role = token_handler.getRole();
			System.out.println(token);
			return homeMsg(role,token);
		}
		
		else {
			
			return "verifier vos coordonnes nom_dut : "+username+" mdp : "+password;
		}
	}
}