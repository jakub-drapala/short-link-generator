package com.drapala.shortlinkgenerator.generator;

public class LinkCreator {


    String link;


    public  String getCode (int id) {

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
        link = result;
       return result;
    }





    private String getSingleChar(int value) {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(link);
        sb.reverse();
        return sb.toString();
    }
}
