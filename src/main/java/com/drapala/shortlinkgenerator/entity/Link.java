package com.drapala.shortlinkgenerator.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
public class Link {

    @Id
    @GeneratedValue
    private int id;

    @Getter
    @Lob
    @Column(nullable = false, name = "long")
    private String longLink;

    @Column(name = "short")
    private String shortLink;

    public Link(String longLink, String shortLink) {
        this.longLink = longLink;
        this.shortLink = shortLink;
    }

    protected Link() {
    }
}
