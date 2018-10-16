package com.drapala.shortlinkgenerator.repository;

import com.drapala.shortlinkgenerator.ShortLinkGeneratorApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static java.lang.Math.log;
import static java.lang.Math.pow;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShortLinkGeneratorApplication.class)
public class LinkCreatorTest {

    public String getCode(int id) {

        int charAmount = id;

        int firstDigit = id/62;
        if (id%62 == 0) {
            firstDigit--;
        }

        String firstChar = getSingleChar(firstDigit);

        int secondDigig = id - 62*firstDigit;

        String secondChar = getSingleChar(secondDigig);

        return firstChar + secondChar;
    }


    @Test
    public void getCode2 () {

        int id = 187;

        String singleChar = "";
        String result = "";
        while (id > 0) {
            int charValue = id%62;
            if (charValue == 0) {
                charValue = 62;
                id-=62;
            }
            id /=62;

            singleChar = getSingleChar(charValue);
            result += singleChar;

        }

        log.info("result {}", result);



    }




    public int charAmount(int id) {
        int charAmount = (int )logarithm(62, id) +1;
        if (id%62 == 0) {
            charAmount--;
        }
        return charAmount;
    }



    private double logarithm(int base, int value) {

        double up = log((double) value);
        double down =log((double) base);

        return up/down;
    }

    public String getSingleChar(int value) {
        if (value < 27){
            char ch = 'a';
            for (int i=1; i<value; i++){
                ch++;
            }
            return String.valueOf(ch);
        } else if (value < 53) {
            char ch = 'A';
            for (int i=27; i<value; i++){
                ch++;
            }
            return String.valueOf(ch);
        } else if (value < 63) {
            int ch = 0;
            for (int i =53; i<value; i++) {
                ch++;
            }
            return String.valueOf(ch);
        }
        return null;
    }

}
