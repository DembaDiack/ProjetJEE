package com.di3;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import com.di3.token.*;
import com.di3.admin.AdminHandler;

@Provider
public class LoginFilter implements ContainerRequestFilter{

	/*
	role 0 : non connecte
	role 1 : administrateur
	role 2 : directeur
	role 3 : enseignant
	*/
	@Context
    private UriInfo info;
	@Override
	public void filter(ContainerRequestContext request) throws IOException {
		// met les liens et sous lien dans un tableau
		List<PathSegment> list = request.getUriInfo().getPathSegments();

		//la racine de la requete
		String root = list.get(0).getPath();

		//si la racine est vide ou eguale a login
		if(root.equals("") || root.equals("login")) {
			//ne rien faire
		}
		else {
			//on recupere la cle que luttilisateur a passer lors de la connection
			Token token_handler = new Token();
			String token = token_handler.getToken();
			//on recupere le role de luttilisateur
			int role = token_handler.getRole();
			//on recupere la methode quil veut uttliser
			String method = list.get(1).getPath();
			//la sous methode quil veut uttiliser
			String submethod = list.get(2).getPath();
			//si le role = 0, il nest pas connecte
			if(role == 0) {
				//on rejete
				request.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
			}
			//si il veut ajouter quoi que ca soit en etant enseignant
			if((submethod.equals("ajouter")) && role == 3 ) {
				//dehors
				request.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
			}
			//si il veut ajouter des enseignant ou des directeur alors quil est directeur
			if((method.equals("enseignant") || method.equals("directeur") && (submethod.equals("ajouter"))) && role == 2 ) {
				//dehors
				request.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
			}
		}
	}
}
