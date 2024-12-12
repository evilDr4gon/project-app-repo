package com.project.models.dto.restclient;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Characters {
    private long available;
    private String collectionURI;
    private List<Series> items;
    private long returned;
}
