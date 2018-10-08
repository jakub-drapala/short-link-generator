package com.drapala.shortlinkgenerator.generator;

import com.drapala.shortlinkgenerator.entity.Link;
import com.drapala.shortlinkgenerator.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Generator {

    @Autowired
    LinkRepository repository;

    private char startValue = 'a';

    public void saveLink(String longLink) {
        String startValue =   String.valueOf(this.startValue);
        Link toSave = new Link(longLink, startValue);
        repository.saveLink(toSave);
    }



}
