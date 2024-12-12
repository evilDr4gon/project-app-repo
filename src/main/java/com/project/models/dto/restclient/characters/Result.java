package com.project.models.dto.restclient.characters;


import com.project.models.dto.restclient.Comics;
import com.project.models.dto.restclient.Stories;
import com.project.models.dto.restclient.Thumbnail;
import com.project.models.dto.restclient.URL;
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


}
