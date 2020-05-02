package com.anuragprojects.urlshortener.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Builder
@ToString
public class Url {

    private String fullUrl;
    private String shortUrl;
    private Date creationTime;
    private Integer ttl;

}
