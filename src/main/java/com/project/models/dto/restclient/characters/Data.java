package com.project.models.dto.restclient.characters;
import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Data {
    private long offset;
    private long limit;
    private long total;
    private long count;
    private List<Result> results;
}
