package com.project.infrastructure.mapper;


import com.project.models.dto.ComicDTO;
import com.project.models.dto.DetalleComicDTO;
import com.project.models.dto.PersonajeDTO;
import com.project.models.dto.restclient.Comics;
import com.project.models.dto.restclient.ComicsItem;
import com.project.models.dto.restclient.characters.Result;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PersonajeMapper {



    @Mapping(target = "id", source = "result.id")
    @Mapping(target = "nombre", source = "result.name")
    @Mapping(target = "descripcion", source = "result.description")
    @Mapping(target = "urlimagen", source = "result.thumbnail.path")
    PersonajeDTO marvelToDTO(Result result);

    @Mapping(target = "id", source = "result.id")
    @Mapping(target = "nombre", source = "result.name")
    @Mapping(target = "descripcion", source = "result.description")
    List<PersonajeDTO> marvelToDTO(List<Result> result);

    @Mapping(target = "cantidadComics", source = "available")
    ComicDTO comicToDTO(Comics comics);


    @Mapping(target = "nombrecomic", source = "name")
    DetalleComicDTO itemComicDTO(ComicsItem comicsItem);

    @Mapping(target = "nombrecomic", source = "name")
    List<DetalleComicDTO> itemComicDTO(List<ComicsItem> comicsItem);
}
