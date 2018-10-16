package com.drapala.shortlinkgenerator.generator;

import com.drapala.shortlinkgenerator.entity.Link;
import com.drapala.shortlinkgenerator.repository.LinkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Generator {

    @Autowired
    LinkRepository repository;

    LinkCreator linkCreator;

    public Generator() {
        this.linkCreator = new LinkCreator();
    }

    private int id = 1;


    public String process(String longLink) {

        if (checkLinkInDb(longLink)) {
            log.info("This link already exists in db");
            return getShortLinkFromDb(longLink);
        }
        saveLink(longLink);
        log.info("Link {} has been added", longLink);
        return getShortLinkFromDb(longLink);

    }


    public void saveLink(String longLink) {
        this.linkCreator.getCode(id);
        String startValue =   /*"https://" +*/ String.valueOf(this.linkCreator);
        Link toSave = new Link(longLink, startValue);
        repository.saveLink(toSave);

        setNextLink();
    }

    public boolean checkLinkInDb(String longLink) {
        return repository.isLonglinkExists(longLink);
    }

    public String getShortLinkFromDb(String longLink) {
        return repository.getShortLink(longLink);
    }




    public void setNextLink() {
        this.id++;
    }



}
