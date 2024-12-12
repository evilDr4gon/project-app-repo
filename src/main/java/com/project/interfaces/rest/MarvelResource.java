package com.project.interfaces.rest;


import com.project.application.MarvelService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.concurrent.ExecutionException;

@Path("/marvel")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MarvelResource {

    @Inject
    MarvelService marvelService;

    @GET
    @Path("/personajes")
    public Response personajes() throws ExecutionException, InterruptedException {
        return Response.ok(marvelService.getComicByCharacter(1)).build();
    }
}
