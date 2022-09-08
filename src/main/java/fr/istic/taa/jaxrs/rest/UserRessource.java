package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.domain.User;
import fr.istic.taa.jaxrs.dto.request.CardUserDto;
import fr.istic.taa.jaxrs.dto.request.LoginDto;
import fr.istic.taa.jaxrs.dto.response.LoginResponseDto;
import fr.istic.taa.jaxrs.dto.response.MessageDto;
import fr.istic.taa.jaxrs.services.UserService;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/user")
@Produces({"application/json"})
public class UserRessource {

    UserService userService = new UserService();
    MessageDto messageDto = new MessageDto();

    @GET
    @Path("/all")
    public List<User> getAllUser(){
        System.out.println("Je suis dans le get All");
        return userService.getAll();
    }

    @GET
    @Path("/{id}")
    public User getUserById(@PathParam("id") Long id){
        return userService.find(id);
    }

    @POST
    @Path("/login")
    @Consumes("application/json")
    public Response login(@Parameter(required = true) LoginDto loginDto){

        LoginResponseDto loginResponseDto = new LoginResponseDto();
        User user = userService.login(loginDto.getEmail(), loginDto.getPassword());
       // return Response.ok().entity("Bien "+loginDto.getEmail()+ " "+loginDto.getPassword()).build();

        if(user == null){
            loginResponseDto.setUserFound(false);
            return Response.ok().entity(loginResponseDto).build();
        }
        loginResponseDto.setUserFound(true);
        loginResponseDto.setUser(user);
        return Response.ok().entity(loginResponseDto).build();

    }



    @POST
    @Path("/add")
    @Consumes("application/json")
    public Response addUser(@Parameter(required = true) User user){

        boolean result = userService.insert(user);

        if(result){
            messageDto.setMessage("Utilisateur crée avec succes");
            return Response.ok().entity(messageDto).build();
        }
        else{
            messageDto.setMessage("Echec de création");
            return Response.ok().entity(messageDto).build();
        }
    }

    @PUT
    @Path("/update")
    @Consumes("application/json")
    public Response updateUser(@Parameter(required = true) User user){
        boolean result = userService.update(user);
        if(result){
            return Response.ok().entity("Utilisateur update avec succes").build();
        }
        else{
            return Response.ok().entity("Echec de la modification").build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteUser(@PathParam("id") Long id ){
        boolean result = userService.delete(id);
        if(result){
            return Response.ok().entity("Utilisateur supprimer avec succes").build();
        }
        else{
            return Response.ok().entity("Echec de la suppression").build();
        }
    }
}
