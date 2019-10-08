package com.WebserviceBeans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("webui")
public class WebUIService {
	
	List<WebServiceClass> web= new ArrayList<WebServiceClass>();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<WebServiceClass> getWebServiceClass(){
		
		System.out.println("geting started");
		
		
//		WebServiceClass webservice = new WebServiceClass();
//		
//		webservice.setName("Gopichand");
//		webservice.setPoints(20);
//		WebServiceClass webservice1 = new WebServiceClass();
//		
//		webservice1.setName("BEnu");
//		webservice1.setPoints(20);
		
		
		return web;
	}
	
	@POST
	@Path("gopi")
	public List<WebServiceClass> createWebService(WebServiceClass webser){
		System.out.println(webser);
		
		this.create(webser);
		
		return web;
	}
	
	public void create(WebServiceClass w){
		web.add(w);
	}

}
