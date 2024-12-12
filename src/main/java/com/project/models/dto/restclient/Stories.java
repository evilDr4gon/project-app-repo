package com.project.models.dto.restclient;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Stories {

    private long available;
    private String collectionURI;
    private List<StoriesItem> items;
    private long returned;
}
