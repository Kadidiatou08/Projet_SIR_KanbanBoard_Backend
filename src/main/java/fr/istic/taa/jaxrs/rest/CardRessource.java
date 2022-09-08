package fr.istic.taa.jaxrs.rest;


import fr.istic.taa.jaxrs.domain.Card;
import fr.istic.taa.jaxrs.dto.request.CardSectionDto;
import fr.istic.taa.jaxrs.dto.request.CardToAddDto;
import fr.istic.taa.jaxrs.dto.request.CardToUpdateDto;
import fr.istic.taa.jaxrs.dto.request.CardUserDto;
import fr.istic.taa.jaxrs.services.CardService;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/card")
@Produces({"application/json"})
public class CardRessource {

    CardService cardService = new CardService();

    @GET
    @Path("/all")
    public List<Card> getAllCard(){
        System.out.printf("getAllCard");
        return cardService.getAll();
    }

    @GET
    @Path("/{id}")
    public Card getCardById(@PathParam("id") Long id){

        return cardService.find(id);
    }

    @POST
    @Path("/add")
    @Consumes("application/json")
    public Response addCard(@Parameter(required = true) CardToAddDto cardDto){

        boolean result = cardService.insert(cardDto);
        if(result){
            return Response.ok().entity("Fiche crée avec succes").build();
        }
        else{
            return Response.ok().entity("Echec de création").build();
        }

    }

    @PUT
    @Path("/update")
    @Consumes("application/json")
    public Response updateCard(@Parameter(required = true) CardToUpdateDto cardToUpdateDto){
        boolean result = cardService.update(cardToUpdateDto);
        if(result){
            return Response.ok().entity("Fiche modifier avec succes").build();
        }
        else{
            return Response.ok().entity("Echec de la modification").build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteCard(@PathParam("id") Long id ){
        boolean result = cardService.delete(id);
        if(result){
            return Response.ok().entity("Fiche supprimer avec succes").build();
        }
        else{
            return Response.ok().entity("Echec de la suppression").build();
        }
    }

    @POST
    @Path("/adduser")
    @Consumes("application/json")
    public Response assignedUsersToCard(@Parameter(required = true) CardUserDto cardUserDto){
        boolean result = cardService.userToCard(cardUserDto,true);
        if(result){
            return Response.ok().entity("Utilisateur ajouter à la fiche avec succes").build();
        }
        else{
            return Response.ok().entity("Echec de l ajout").build();
        }
    }

    @POST
    @Path("/deleteuser")
    @Consumes("application/json")
    public Response deleteUsersToCard(@Parameter(required = true) CardUserDto cardUserDto){
        boolean result = cardService.userToCard(cardUserDto,false);
        if(result){
            return Response.ok().entity("Utilisateur supprimer de la fiche avec succes").build();
        }
        else{
            return Response.ok().entity("Echec de la suppression").build();
        }
    }

    @POST
    @Path("/changesection")
    @Consumes("application/json")
    public Response changesection(@Parameter(required = true)CardSectionDto cardSectionDto){
        boolean result = cardService.changeSection(cardSectionDto);
        if(result){
            return Response.ok().entity("changement effectué avec succes").build();
        }
        else{
            return Response.ok().entity("Echec du changement").build();
        }
    }

    // Add tag to card will be implment
}
