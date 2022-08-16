package net.javaguides.sms.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {

    public static String generateRandomSting(){
        return RandomStringUtils.randomAlphabetic(8);
    }
}
