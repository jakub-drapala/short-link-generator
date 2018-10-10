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

    private char nextLink = 'a';


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
        String startValue =   String.valueOf(this.nextLink);
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
        this.nextLink++;
    }



}
