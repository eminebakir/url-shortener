package com.eminebakir.urlshortener.controller;

import com.eminebakir.urlshortener.entity.ShortenUrl;
import com.eminebakir.urlshortener.service.impl.ShortenUrlImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UrlShorterRestController {

    private Map<String, ShortenUrl> shortenUrlList = new HashMap<>();

    @Autowired private ShortenUrlImpl shortenUrlImpl;

    @RequestMapping(value="/shortenurl", method= RequestMethod.POST)
    public ResponseEntity<Object> getShortenUrl(@RequestBody ShortenUrl shortenUrl) throws MalformedURLException {
        String randomChar = getRandomChars();
        setShortUrl(randomChar, shortenUrl);

        shortenUrlImpl.save(shortenUrl);
        return new ResponseEntity<Object>(shortenUrl, HttpStatus.OK);
    }

    @RequestMapping(value="/s/{randomstring}", method=RequestMethod.GET)
    public void getFullUrl(HttpServletResponse response, @PathVariable("randomstring") String randomString) throws IOException {
        response.sendRedirect(shortenUrlList.get(randomString).getFull_url());
    }

    private void setShortUrl(String randomChar, ShortenUrl shortenUrl) throws MalformedURLException {
        shortenUrl.setShort_url("http://localhost:8080/s/"+randomChar);
        shortenUrlList.put(randomChar, shortenUrl);
    }

    private String getRandomChars() {
        String randomStr = "";
        String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < 5; i++)
            randomStr += possibleChars.charAt((int) Math.floor(Math.random() * possibleChars.length()));
        return randomStr;
    }




}
