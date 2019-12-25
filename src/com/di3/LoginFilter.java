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
	@Context
    private UriInfo info;
	@Override
	public void filter(ContainerRequestContext request) throws IOException {
		List<PathSegment> list = request.getUriInfo().getPathSegments();
		String root = list.get(0).getPath();
		if(root.equals("") || root.equals("login")) {
			System.out.println("no checking required");
			System.out.println(root);
		}else {
			Token token_handler = new Token();
			String token = token_handler.getToken();
			int role = token_handler.getRole();
			String method = list.get(1).getPath();
			String submethod = list.get(2).getPath();
			if(role == 0) {
				request.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
			}
			if((submethod.equals("ajouter")) && role == 3 ) {
				request.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
			}
			if((method.equals("enseignant") || method.equals("directeur") && (submethod.equals("ajouter"))) && role == 2 ) {
				request.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
			}
		}
	}
}
