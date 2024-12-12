package com.project.models.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class HistorialDTO {

    private Integer code;
    private String status;
    private String url;
    private LocalDateTime fecha;
}
