package com.project.models.dto.restclient;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Comics {
    private long available;
    private String collectionURI;
    private List<ComicsItem> items;
    private long returned;
}
