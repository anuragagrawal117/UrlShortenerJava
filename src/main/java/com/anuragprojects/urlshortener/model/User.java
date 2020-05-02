package com.anuragprojects.urlshortener.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@ToString
public class User {

    private String identity;
    private String userId;
    private String name;
}
