package com.project.application;


import com.project.infrastructure.config.ConfigMarvel;
import com.project.infrastructure.exceptions.ErrorResponse;
import com.project.infrastructure.mapper.ComicMapper;
import com.project.interfaces.restclient.MarvelAPI;
import com.project.models.dto.ComicDTO;
import com.project.models.dto.DetalleComicDTO;
import com.project.models.dto.restclient.comic.Marvel;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.smallrye.mutiny.Uni;
import io.vertx.ext.web.client.WebClient;
import io.vertx.core.Vertx;
import io.vertx.ext.web.client.WebClientOptions;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@ApplicationScoped
public class MarvelService {

    private static final Logger LOGGER = Logger.getLogger(MarvelService.class);

    @Inject
    private ConfigMarvel configMarvel;

    @Inject
    private ComicMapper comicMapper;

    private final Vertx vertx;
    private final WebClient webClient;

    @Inject
    @RestClient
    MarvelAPI marvelAPI;

    public MarvelService(Vertx vertx) {
        this.vertx = vertx;
        this.webClient = WebClient.create(vertx);
    }



    public List<DetalleComicDTO> getComicByCharacter(Integer idcharacter) throws ExecutionException, InterruptedException {

        /*return this.webClient.getAbs(configMarvel.geBaseURL() + "/characters/" +idcharacter +"/comics")
                .send()
                .onSuccess(bufferHttpResponse -> bufferHttpResponse)

        );*/
        Map<String, String> params = new HashMap<>();
        params.put("apikey", configMarvel.getApiKeyPublic());
        params.put("hash", configMarvel.getHash());
        params.put("ts", String.valueOf(configMarvel.getTimeStamp()));

        return marvelAPI.getComis(params)
                .onFailure().invoke(i -> new NotFoundException("No se encontro 1"))
                //.subscribe().asCompletionStage().get()


                //.failWith(() -> LOGGER.log(Logger.Level.ERROR, "Error"))

               // .onItem().failWith(marvel -> new Throwable("Error"))
                .onItem()
                //.invoke(i -> new NotFoundException("No se encontro 3"))
                //.onItem()
                .transform(marvel -> comicMapper.itemComicDTO(marvel.getData().getResults()))
                //.onFailure().invoke(i -> new NotFoundException("No se encontro 2"))
                .subscribe()
                .asCompletionStage().get()
                ;

    }

    /*public Uni<DetalleComicDTO> getComicByCharacter2() throws ExecutionException, InterruptedException {

        return this.webClient.getAbs(configMarvel.geBaseURL() + "/characters/" +idcharacter +"/comics")
                .send()
                .onSuccess(bufferHttpResponse -> bufferHttpResponse)

        );
        Map<String, String> params = new HashMap<>();
        params.put("apikey", configMarvel.getApiKeyPublic());
        params.put("hash", configMarvel.getHash());
        params.put("ts", String.valueOf(configMarvel.getTimeStamp()));

        return marvelAPI.getComis(params)
                .onFailure().invoke(this::errorResponse)
                //.subscribe().asCompletionStage().get()

                //.failWith(() -> LOGGER.log(Logger.Level.ERROR, "Error"))

                .onItem().failWith(marvel -> new Throwable("Error")).onItem()
                .transform(marvel -> comicMapper.itemComicDTO(marvel.getData().getResults()))
                ;

    }*/



    private void errorResponse(Throwable throwable){
        ErrorResponse.builder()
                .status(HttpResponseStatus.INTERNAL_SERVER_ERROR.code())
                .message(throwable.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
        //return true;
    }


}
