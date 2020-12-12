package com.example.alumni.controller;

import com.example.alumni.bean.AlumniDetails;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import static com.example.alumni.service.AlumniRegistration.insert_pinfo;

@Path("pinfo")
public class PInfoController {


        @POST
        @Path("/register")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public Response registerAlumni(AlumniDetails alumni) throws URISyntaxException {
            System.out.println(alumni.getStudent().getId());
            System.out.println(alumni.getEmail());
            System.out.println(alumni.getContact());

            int returnvalue=insert_pinfo(alumni);
            if(returnvalue==1)
                return Response.ok().build();
            else
                return Response.notModified().build();


    }
}
