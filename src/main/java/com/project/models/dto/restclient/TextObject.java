package com.project.models.dto.restclient;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TextObject {

    private String type;
    private String language;
    private String text;
}
