package com.avocado.tradeBook;

import java.util.Random;

public class SecurityGenerator {

    private static final String[] SECURITIES = {
           "tms01", "tms02", "tms03", "tms04", "tms05", "tms06", "tms07", "tms08", "tms09", "tms10"
    };

    private static final Random random = new Random();

    public static String getRandomSecurity() {
        return SECURITIES[random.nextInt(SECURITIES.length)];
    }
}
