package com.eminebakir.urlshortener.repository;

import com.eminebakir.urlshortener.entity.ShortenUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortenUrlRepository extends JpaRepository<ShortenUrl, Long> {

}
