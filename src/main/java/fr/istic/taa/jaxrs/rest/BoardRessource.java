package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.domain.Board;
import fr.istic.taa.jaxrs.domain.Section;
import fr.istic.taa.jaxrs.dto.request.BoardToAddDto;
import fr.istic.taa.jaxrs.dto.request.SectionToBoardDto;
import fr.istic.taa.jaxrs.services.BoardService;
import fr.istic.taa.jaxrs.utlis.Utils;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/board")
@Produces({"application/json"})
public class BoardRessource {

    BoardService boardService =  new BoardService();

    @GET
    @Path("/all")
    public List<Board> getAll(){
        return boardService.getAll();
    }


    @GET
    @Path("/{id}")
    public Board getBoardById(@PathParam("id") Long id){
        return boardService.find(id);
    }

    @POST
    @Path("/add")
    @Consumes("application/json")
    public Response insert(@Parameter(required = true) BoardToAddDto boardToAddDto){
        boolean result = boardService.insert(boardToAddDto);
        if(result){
            return Response.ok().entity("Board crée avec succes").build();
        }
        else{
            return Response.ok().entity("Echec de création").build();
        }

    }

    @PUT
    @Path("/update")
    @Consumes("application/json")
    public Response update(@Parameter(required = true) Board board){
        boolean result = boardService.update(board);
        if(result){
            return Response.ok().entity("Board modifier avec succes").build();
        }
        else{
            return Response.ok().entity("Echec de modification").build();
        }
    }

    // NE fonctionne pas lorqu'on ajoute une section, a revoir
    @DELETE
    @Path("/delete/{id}")
    public Response deleteBoard(@PathParam("id") Long id ){
        boolean result = boardService.delete(id);
        if(result){
            return Response.ok().entity("Board supprimer avec succes").build();
        }
        else{
            return Response.ok().entity("Echec de la suppression").build();
        }
    }

    @POST
    @Path("/addsection")
    @Consumes("application/json")
    public Response addSectionToBoard(@Parameter(required = true) SectionToBoardDto sectionToBoardDto){
        boolean result = boardService.addSection(sectionToBoardDto);
        if(result){
            return Response.ok().entity("Section ajouter au tableau avec succes").build();
        }
        else{
            return Response.ok().entity("Echec de l ajout").build();
        }

    }

    //Delete Section will be implment


}
