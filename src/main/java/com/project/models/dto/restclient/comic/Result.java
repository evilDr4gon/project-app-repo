package com.project.models.dto.restclient.comic;

import com.project.models.dto.restclient.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Result {
    private long id;
    private long digitalID;
    private String title;
    private long issueNumber;
    private String variantDescription;
    private String description;
    private String modified;
    private String isbn;
    private String upc;
    private String diamondCode;
    private String ean;
    private String issn;
    private String format;
    private long pageCount;
    private List<TextObject> textObjects;
    private String resourceURI;
    private List<URL> urls;
    private Series series;
    private List<Object> variants;
    private List<Object> collections;
    private List<Object> collectedIssues;
    private List<Price> prices;
    private Thumbnail thumbnail;
    private List<Thumbnail> images;
    private Characters creators;
    private Characters characters;
    private Characters stories;
    private Characters events;


}
