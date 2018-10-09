package com.drapala.shortlinkgenerator.repository;

import com.drapala.shortlinkgenerator.ShortLinkGeneratorApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Query;
import javax.persistence.EntityManager;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShortLinkGeneratorApplication.class)
public class JPQLTest {

    @Autowired
    EntityManager em;

    @Test
    public void getShortLink() {
        String shortLink = "z";
        Query query = em.createQuery("Select l.longLink from Link l where l.shortLink = :short")
                .setParameter("short", shortLink);
        String result = (String) query.getSingleResult();
        log.info("Short link for this query = {}", result);


    }
}
