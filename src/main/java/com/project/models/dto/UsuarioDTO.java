package com.project.models.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UsuarioDTO {

    private String usuario;
    private List<HistorialDTO> historial;
}
