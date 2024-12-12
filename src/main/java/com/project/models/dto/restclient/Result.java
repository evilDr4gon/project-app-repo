package com.project.models.dto.restclient;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Result {
    private long id;
    private String name;
    private String description;
    private String modified;
    private Thumbnail thumbnail;
    private String resourceURI;
    private Comics comics;
    private Comics series;
    private Stories stories;
    private Comics events;
    private List<URL> urls;
    private long digitalID;
    private String title;
    private long issueNumber;
    private String variantDescription;
    private String isbn;
    private String upc;
    private String diamondCode;
    private String ean;
    private String issn;
    private String format;
    private long pageCount;
    private List<TextObject> textObjects;
    private List<Series> variants;
    private List<Object> collections;
    private List<Object> collectedIssues;
    private List<Price> prices;
    private List<Thumbnail> images;
    private Creators creators;
    private Characters characters;

}
