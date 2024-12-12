package com.project.interfaces.restclient;

import com.project.application.MarvelService;
import com.project.models.dto.restclient.comic.Marvel;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestQuery;

import java.time.temporal.ChronoUnit;
import java.util.Map;

@RegisterRestClient(configKey = "marvel-api")
public interface MarvelAPI {

    static final Logger LOGGER = Logger.getLogger(MarvelAPI.class);

    @Path("/comics")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Retry(delayUnit = ChronoUnit.SECONDS, maxRetries = 2, delay = 1)
    //@Fallback(fallbackMethod = "printLog")
    @CircuitBreaker(delayUnit = ChronoUnit.SECONDS, requestVolumeThreshold = 4,
            failureRatio = .75, delay = 3, successThreshold = 2)
    Uni<Marvel> getComis(@RestQuery Map<String, String> params);


    default String printLog() {
        LOGGER.log(Logger.Level.ERROR, "Error haciendo peticion a API");
        return "Error haciendo peticion a API RETURN";
    }


}
