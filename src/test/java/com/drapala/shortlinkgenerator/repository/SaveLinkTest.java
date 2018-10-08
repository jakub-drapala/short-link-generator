package com.drapala.shortlinkgenerator.repository;

import com.drapala.shortlinkgenerator.ShortLinkGeneratorApplication;
import com.drapala.shortlinkgenerator.entity.Link;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShortLinkGeneratorApplication.class)
public class SaveLinkTest {

    @Autowired
    EntityManager em;

    @Autowired
    LinkRepository repository;


    @Test
    @DirtiesContext
    public void saveInDb() {
        Link firstLink = new Link("aa", "a");
        repository.saveLink(firstLink);
    }


}
