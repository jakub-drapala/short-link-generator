package com.drapala.shortlinkgenerator.repository;

import com.drapala.shortlinkgenerator.entity.Link;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Repository
@Transactional
public class LinkRepository {

    @Autowired
    EntityManager em;


    public Link saveLink(Link toAdd) {
        em.persist(toAdd);
        return toAdd;
    }

    public String getLongLink(String shortLink) {
        Query query = em.createQuery("Select l.longLink from Link l where l.shortLink = :short")
                .setParameter("short", shortLink);
        String result = (String) query.getSingleResult();
        log.info("Long link for this query = {}", result);
        return result;
    }

    public boolean isLonglinkExists(String longLink) {
        Query query = em.createQuery("Select l.shortLink from Link l where l.longLink = :long")
                .setParameter("long", longLink);
        List<Object> results = query.getResultList();
        boolean isEmpty = results.isEmpty();
        log.info("Is the result empty - {}", isEmpty);
/*        if (isEmpty) {
            return false;
        } else {
            return true;
        }*/
        return isEmpty ? false : true;
    }

    public String getShortLink(String longLink) {
        Query query = em.createQuery("Select l.shortLink from Link l where l.longLink = :long")
                .setParameter("long", longLink);
        String shortLink = (String) query.getSingleResult();
        return shortLink;
    }
}
