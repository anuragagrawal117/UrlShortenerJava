package com.anuragprojects.urlshortener.service;

import com.anuragprojects.urlshortener.constant.Constants;
import com.anuragprojects.urlshortener.constant.RegisteredUserList;
import com.anuragprojects.urlshortener.exception.UserNotRegisteredException;
import com.anuragprojects.urlshortener.model.Url;
import com.anuragprojects.urlshortener.model.User;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class UrlShortenerService {

    private HashMap<String, Url> urlMap = new HashMap<String, Url>();
    private HashMap<String, User> userMap = new HashMap<String, User>();

    private HashMap<String, String> shortUrlIdentityMap = new HashMap<String, String>();

    public UrlShortenerService(){
        for(User user: RegisteredUserList.userList){
            userMap.put(user.getIdentity(), user);
        }
    }

    public String shortenUrl(String fullUrl, String userIdentity, Integer ttl) throws UserNotRegisteredException {
        String shortUrl = generateShortUrl();
        Url url = Url.builder().fullUrl(fullUrl).shortUrl(shortUrl).creationTime(new Date()).build();
        if(userIdentity != null){
            if(userMap.get(userIdentity) != null){
                shortUrlIdentityMap.put(shortUrl, userIdentity);
                if(ttl != null) url.setTtl(ttl);
            }else{
                throw new UserNotRegisteredException("User not registered with identity - " + userIdentity);
            }
        }
        if(url.getTtl() == null) url.setTtl(Constants.DEFAULT_TTL);
        urlMap.put(shortUrl, url);
        return shortUrl;
    }

    public String fetchFullUrl(String shortUrl){
        Url url =  urlMap.get(shortUrl);
        if(url != null){
            if(new Date().compareTo(DateUtils.addMinutes(url.getCreationTime(), url.getTtl())) <= 0){
                return url.getFullUrl();
            }else{
                shortUrlIdentityMap.remove(shortUrl);
                urlMap.remove(shortUrl);
            }
        }
        return null;
    }

    public ArrayList<Url> getAllUrls(){
        return new ArrayList<Url>(urlMap.values());
    }

    public ArrayList<User> getAllUsers(){
        return new ArrayList<User>(userMap.values());
    }

    public Url getUrl(String shortUrl){
        return urlMap.get(shortUrl);
    }

    public User getUser(String userIdentity){
        return userMap.get(userIdentity);
    }

    public ArrayList<Url> getUrls(User user){
        if(user == null) return null;
        ArrayList<Url> urlList = new ArrayList<Url>();
        for(String shortUrl : shortUrlIdentityMap.keySet()){
            if(shortUrlIdentityMap.get(shortUrl) == user.getIdentity()){
                urlList.add(urlMap.get(shortUrl));
            }
        }
        return urlList;
    }

    public User getUser(Url url){
        if(url == null) return null;
        String userIdentity = shortUrlIdentityMap.get(url.getShortUrl());
        if(userIdentity != null) return userMap.get(userIdentity);
        return null;
    }

    private String generateShortUrl(){
        String shortUrl = RandomStringUtils.randomAlphanumeric(8);
        while(urlMap.get(shortUrl) != null) shortUrl = RandomStringUtils.randomAlphanumeric(8);
        return shortUrl;
    }
}
