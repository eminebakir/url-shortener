package com.eminebakir.urlshortener.service.impl;

import com.eminebakir.urlshortener.entity.ShortenUrl;
import com.eminebakir.urlshortener.repository.ShortenUrlRepository;
import com.eminebakir.urlshortener.service.ShortenUrlService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortenUrlImpl implements ShortenUrlService {

    private ShortenUrlRepository shortenUrlRepository;

    public ShortenUrlImpl(ShortenUrlRepository shortenUrlRepository) {
        this.shortenUrlRepository = shortenUrlRepository;
    }

    public void save(ShortenUrl shortenUrl){

        shortenUrlRepository.save(shortenUrl);
    }

    @Override
    public List<ShortenUrl> getAllshortenurls() {

        return shortenUrlRepository.findAll();

    }

    @Override
    public void deleteUrlById(long id) {

        ShortenUrl url = shortenUrlRepository.getById(id);
        shortenUrlRepository.delete(url);

    }
}
