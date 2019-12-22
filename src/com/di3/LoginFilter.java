package com.di3;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;

import com.di3.adminModel.AdminHandler;

public class LoginFilter implements ContainerRequestFilter{
	private AdminHandler handler = new AdminHandler();
	@Override
	public void filter(ContainerRequestContext request) throws IOException {
		// TODO Auto-generated method stub
		MultivaluedMap<String, String> params = request.getUriInfo().getPathParameters();
	}

}
