package com.webservices.restserv1;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
//import jakarta.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
	
	@QueryParam("name")
	String firstName;
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got itTT!";
    }
    
    @Path("/hi")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getFullName() {
        return "Hi.. "+firstName+" !!";
    }
    
    
    @Path("/getnum/{nameParam}")
    @GET
//    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNumber(@PathParam("nameParam")String name)
    {
    	int num = 0;

    	if(name.equals("prasanth1"))
    	{
    		num = 1;
    	}
    	else if(name.equals("prasanth2"))
    	{
    		num = 2;
    	}

    	System.out.println(num);
    	Response respwrap = Response.ok(String.valueOf(num)).build();
    	
    	return respwrap;
    }

    // http://localhost:8080/service1/webapi/myresource/getUser?name=prasanth1
	@Path("/getuser")
	@GET
	//@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser()
	{
		DBIntegrator dbobj = new DBIntegrator();
		UserVO user = dbobj.getUserDetails(firstName);
		System.out.println(user.toString());
		Response respwrap = Response.ok(user).build();
//		System.out.println("obj to response");

		return respwrap;
	}

//http://localhost:8080/service1/webapi/myresource/setuser/252525
@Path("/setuser/{mobileNumber}")
//@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.APPLICATION_JSON)
@POST
public Response setUserMobile(@PathParam("mobileNumber") String mobileNumber) {
	DBIntegrator dbobj = new DBIntegrator();
	UserVO user = dbobj.setUserMobile(mobileNumber);
	Response resp= Response.ok(user).build();
	
	return resp;
}


@Path("/setuserdetails")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@POST
public Response setUserd(UserVO user) {
//	UserVO user
	System.out.println("request recieveddd");
	DBIntegrator dbobj = new DBIntegrator();
	UserVO user1 = dbobj.setUser(user);
	Response resp= Response.ok(user1).build();
	
	return resp;
}

}


