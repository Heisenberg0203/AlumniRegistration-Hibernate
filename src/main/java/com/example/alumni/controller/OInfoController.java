package com.example.alumni.controller;

import com.example.alumni.bean.AlumniOrganisation;
import com.example.alumni.bean.Organisation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import static com.example.alumni.dao.OInfoDAO.getCompanyNames;
import static com.example.alumni.service.AlumniRegistration.insert_oinfo;

import java.util.List;

@Path("oinfo")
public class OInfoController {
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanies(){
        List<Organisation> company_names=getCompanyNames();
        return Response.ok().entity(company_names).build();
    }

    @POST
    @Path("register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerOrganisationDetails(List<AlumniOrganisation> odetails){
        if(odetails.get(0).getOrganisation().equals("Company")){
            return  Response.status(204).build();
        }

        int returnvalue=insert_oinfo(odetails);
        if(returnvalue==1)
            return Response.ok().build();
        else
            return Response.notModified().build();
    }


}
