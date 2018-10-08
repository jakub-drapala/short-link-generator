package com.drapala.shortlinkgenerator.sercive;

import com.drapala.shortlinkgenerator.generator.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneratorService {

    private Generator generator;

    @Autowired
    public GeneratorService(Generator generator) {
        this.generator = generator;
    }

    public void saveLink(String longLink) {
        generator.saveLink(longLink);
    }
}
