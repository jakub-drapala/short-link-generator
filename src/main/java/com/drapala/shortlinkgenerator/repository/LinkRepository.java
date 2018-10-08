package com.drapala.shortlinkgenerator.repository;

import com.drapala.shortlinkgenerator.entity.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class LinkRepository {

    @Autowired
    EntityManager em;

    public Link saveLink(Link toAdd) {
        em.persist(toAdd);
        return toAdd;
    }
}
