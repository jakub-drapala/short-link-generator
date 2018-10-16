package com.drapala.shortlinkgenerator.repository;

import com.drapala.shortlinkgenerator.ShortLinkGeneratorApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShortLinkGeneratorApplication.class)
public class CharTest {

    @Test
    public void keyGenerator () {
        int value = 100;
        char ch = (char) value;
        log.info("Value in char: {}", ch);
    }

    @Test
    public void checkAllChars() {
        char ch;
        for (int i=1; i<99; i++ ) {
            ch = (char) i;
            log.info("{} {}", i, ch);
        }
    }
}
