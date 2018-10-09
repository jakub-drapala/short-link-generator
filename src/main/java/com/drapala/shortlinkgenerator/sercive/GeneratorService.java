package com.drapala.shortlinkgenerator.sercive;

import com.drapala.shortlinkgenerator.generator.Generator;
import com.drapala.shortlinkgenerator.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneratorService {

    private Generator generator;
    LinkRepository repository;

    @Autowired
    public GeneratorService(Generator generator, LinkRepository repository) {
        this.generator = generator;
        this.repository = repository;
    }

    public void saveLink(String longLink) {
        generator.saveLink(longLink);
    }


    public String getLongLink(String shortLink) {
        return repository.getLongLink(shortLink);
    }
}
