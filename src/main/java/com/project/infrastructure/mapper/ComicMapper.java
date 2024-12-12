package com.project.infrastructure.mapper;

import com.project.models.dto.DetalleComicDTO;
import com.project.models.dto.restclient.comic.Result;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface ComicMapper {


    @Mapping(target = "nombrecomic", source = "title")
    DetalleComicDTO itemComicDTO(Result result);

    @Mapping(target = "nombrecomic", source = "title")
    List<DetalleComicDTO> itemComicDTO(List<Result> result);
}
