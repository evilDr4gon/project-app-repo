package com.project.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ComicDTO {

    private Integer cantidadComics;
    private List<DetalleComicDTO> comics;
}
