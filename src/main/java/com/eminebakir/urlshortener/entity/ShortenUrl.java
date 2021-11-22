package com.eminebakir.urlshortener.entity;


import javax.persistence.*;

@Entity
@Table(name = "urlshortener")
public class ShortenUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_url", nullable = false)
    private String full_url;

    @Column(name = "short_url")
    private String short_url;

    public ShortenUrl(){

    }

    public ShortenUrl(String full_url, String lastName) {
        this.full_url = full_url;
        this.short_url = short_url;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getFull_url() {
        return full_url;
    }

    public void setFull_url(String full_url) {
        this.full_url = full_url;
    }

    public String getShort_url() {
        return short_url;
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }

}
