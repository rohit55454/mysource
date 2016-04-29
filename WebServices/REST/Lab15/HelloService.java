package com.jlc.jaxrs;

import javax.ws.rs.*;;

@Path("/hello")
public class HelloService {
	
	@GET
	@Path("/gm1/{name}")
	public String getMessage1(@PathParam("name") String nm){
		String msg = "Hello "+nm+" Welcome to REST Web Services";
		System.out.println(msg);
		return msg;
	}
	
	@POST
	@Path("/gm2/")
	public UserMessage getMessage2(User user){
		String nm = user.getName();
		String em = user.getEmail();
		String msg = "Hello "+nm+" Welcome to REST Web Services\nYour email is "+em;
		System.out.println(msg);

		UserMessage um = new UserMessage();
		um.setMsg(msg);
		return um;
	}
	
}
