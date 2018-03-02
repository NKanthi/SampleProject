package com.example.demo.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorldEndpoint {

  @Inject
  private HelloWorldService helloWorldService;

  @GET
	@Produces("text/plain")
	public Response doGet() {
		return Response.ok("Hello from WildFly Swarm!").build();
	}

	@GET
  @Path("/test")
	@Produces("text/plain")
	public Response doGetWithService() {
		return Response.ok(helloWorldService.getPerson()).build();
	}

}
