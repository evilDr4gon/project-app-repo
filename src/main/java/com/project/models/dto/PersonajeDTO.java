package com.project.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class PersonajeDTO {

    private Integer id;
    private String nombre;
    private String descripcion;
    private String urlimagen;
    private ComicDTO comics;
}
