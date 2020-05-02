package com.anuragprojects.urlshortener;

import com.anuragprojects.urlshortener.exception.UserNotRegisteredException;
import com.anuragprojects.urlshortener.service.UrlShortenerService;

public class UrlShortener {

    public static void main(String[] args) throws InterruptedException{

        UrlShortenerService urlShortenerService = new UrlShortenerService();

        try {
            String shortenUrl1 = urlShortenerService.shortenUrl("www.full_url1.com", "PersonA", 1);
            String shortenUrl2 = urlShortenerService.shortenUrl("www.full_url1.com", "PersonA", null);
            String shortenUrl3 = urlShortenerService.shortenUrl("www.full_url2.com", "PersonB", 10);
            String shortenUrl4 = urlShortenerService.shortenUrl("www.full_url2.com", null, null);
            String shortenUrl5 = urlShortenerService.shortenUrl("www.full_url3.com", null, null);

            System.out.println(urlShortenerService.fetchFullUrl(shortenUrl1));
            System.out.println(urlShortenerService.fetchFullUrl(shortenUrl2));
            System.out.println(urlShortenerService.fetchFullUrl(shortenUrl3));
            System.out.println(urlShortenerService.fetchFullUrl(shortenUrl4));
            System.out.println(urlShortenerService.fetchFullUrl(shortenUrl5));

            System.out.println("all urls::" + urlShortenerService.getAllUrls());
            System.out.println("personA::" + urlShortenerService.getUrls(urlShortenerService.getUser("PersonA")));
            System.out.println("personB::" + urlShortenerService.getUrls(urlShortenerService.getUser("PersonB")));

            Thread.sleep(1*60*1000);
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println(urlShortenerService.fetchFullUrl(shortenUrl1));
            System.out.println(urlShortenerService.fetchFullUrl(shortenUrl2));
            System.out.println(urlShortenerService.fetchFullUrl(shortenUrl3));
            System.out.println(urlShortenerService.fetchFullUrl(shortenUrl4));
            System.out.println(urlShortenerService.fetchFullUrl(shortenUrl5));

            System.out.println("all urls::" + urlShortenerService.getAllUrls());
            System.out.println("personA::" + urlShortenerService.getUrls(urlShortenerService.getUser("PersonA")));
            System.out.println("personB::" + urlShortenerService.getUrls(urlShortenerService.getUser("PersonB")));

            Thread.sleep(1*60*1000);
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println(urlShortenerService.fetchFullUrl(shortenUrl1));
            System.out.println(urlShortenerService.fetchFullUrl(shortenUrl2));
            System.out.println(urlShortenerService.fetchFullUrl(shortenUrl3));
            System.out.println(urlShortenerService.fetchFullUrl(shortenUrl4));
            System.out.println(urlShortenerService.fetchFullUrl(shortenUrl5));

            System.out.println("all urls::" + urlShortenerService.getAllUrls());
            System.out.println("personA::" + urlShortenerService.getUrls(urlShortenerService.getUser("PersonA")));
            System.out.println("personB::" + urlShortenerService.getUrls(urlShortenerService.getUser("PersonB")));

        }catch (UserNotRegisteredException exception){
            System.out.println(exception.getMessage());
        }
    }

}
