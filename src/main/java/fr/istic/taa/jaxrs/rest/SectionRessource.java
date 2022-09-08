package fr.istic.taa.jaxrs.rest;


import fr.istic.taa.jaxrs.domain.Section;
import fr.istic.taa.jaxrs.dto.request.CardUserDto;
import fr.istic.taa.jaxrs.dto.request.SectionToAddDto;
import fr.istic.taa.jaxrs.services.SectionService;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/section")
@Produces({"application/json"})
public class SectionRessource {

    SectionService sectionService = new SectionService();

    @GET
    @Path("/all")
    public List<Section> getAllSection(){
        return sectionService.getAll();
    }

    @GET
    @Path("/{id}")
    public Section getSectionById(@PathParam("id") Long id){
        return sectionService.find(id);
    }

    @POST
    @Path("/add")
    @Consumes("application/json")
    public Response addSection(@Parameter(required = true) SectionToAddDto sectionDto){

        boolean result = sectionService.insert(sectionDto);
        if(result){
            return Response.ok().entity("Section crée avec succes").build();
        }
        else{
            return Response.ok().entity("Echec de création").build();
        }
    }

    @PUT
    @Path("/update")
    @Consumes("application/json")
    public Response updateSection(@Parameter(required = true) Section section){
        boolean result = sectionService.update(section);
        if(result){
            return Response.ok().entity("Section modifier avec succes").build();
        }
        else{
            return Response.ok().entity("Echec de modification").build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteSection(@PathParam("id") Long id ){
        boolean result = sectionService.delete(id);
        if(result){
            return Response.ok().entity("Section supprimer avec succes").build();
        }
        else{
            return Response.ok().entity("Echec de la suppression").build();
        }
    }



}
