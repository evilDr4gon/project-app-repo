package com.project.models.dto.restclient;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Creators {
    private long available;
    private String collectionURI;
    private List<CreatorsItem> items;
    private long returned;
}
