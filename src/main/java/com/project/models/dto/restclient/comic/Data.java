package com.project.models.dto.restclient.comic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
