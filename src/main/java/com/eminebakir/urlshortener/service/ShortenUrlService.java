package com.eminebakir.urlshortener.service;

import com.eminebakir.urlshortener.entity.ShortenUrl;

import java.util.List;

public interface ShortenUrlService {

    List<ShortenUrl> getAllshortenurls();

    void deleteUrlById(long id);

}
