package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.domain.Tag;

import fr.istic.taa.jaxrs.domain.User;
import fr.istic.taa.jaxrs.dto.request.TagToAddDto;
import fr.istic.taa.jaxrs.services.TagService;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/tag")
@Produces({"application/json"})
public class TagRessource {

    TagService tagService = new TagService();

    @GET
    @Path("/all")
    public List<Tag> getAll(){
        return tagService.getAll();
    }

    @GET
    @Path("/{id}")
    public Tag getTagById(@PathParam("id") Long id){
        return tagService.find(id);
    }

    @POST
    @Path("/add")
    @Consumes("application/json")
    public Response insert(@Parameter(required = true) TagToAddDto tagToAddDto){

        boolean result = tagService.insert(tagToAddDto);
        if(result){
            return Response.ok().entity("Tag crée avec succes").build();
        }
        else{
            return Response.ok().entity("Echec de création").build();
        }
    }

    @PUT
    @Path("/update")
    @Consumes("application/json")
    public Response updateTag(@Parameter(required = true) Tag tag){

        boolean result = tagService.update(tag);
        if(result){
            return Response.ok().entity("Tag modifier avec succes").build();
        }
        else{
            return Response.ok().entity("Echec de la modification").build();
        }

    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteTag(@PathParam("id") Long id ){
        boolean result = tagService.delete(id);
        if(result){
            return Response.ok().entity("Tag supprimer avec succes").build();
        }
        else{
            return Response.ok().entity("Echec de la suppression").build();
        }
    }
}
