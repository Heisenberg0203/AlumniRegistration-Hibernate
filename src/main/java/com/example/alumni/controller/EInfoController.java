package com.example.alumni.controller;

import com.example.alumni.bean.AlumniDetails;
import com.example.alumni.bean.AlumniEducation;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

import static com.example.alumni.service.AlumniRegistration.insert_einfo;


@Path("einfo")
public class EInfoController {
    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerEducationDetails(List<AlumniEducation> edetails) throws URISyntaxException {
        System.out.println(edetails.get(0).getAlumni().getId());
        System.out.println(edetails.get(0).getCollege_name());
        System.out.println(edetails.get(0).getAddress());
        System.out.println(edetails.get(0).getJoining_year());

        System.out.println(edetails.get(1).getAlumni().getId());
        System.out.println(edetails.get(1).getCollege_name());
        System.out.println(edetails.get(1).getAddress());
        System.out.println(edetails.get(1).getJoining_year());




        int returnvalue=insert_einfo(edetails);
        if(returnvalue==1)
            return Response.ok().entity(edetails).build();
        else
            return Response.notModified().build();

        //return  Response.ok().entity(edetails).build();


    }
}
