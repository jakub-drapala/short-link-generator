package com.drapala.shortlinkgenerator.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Link {

    @Id
    @GeneratedValue
    private int id;

    @Getter
    @Column(nullable = false)
    private String longLink;

    @Column
    private String shortLink;

    public Link(String longLink, String shortLink) {
        this.longLink = longLink;
        this.shortLink = shortLink;
    }

    protected Link() {
    }
}
