package com.avocado.tradeBook;

import java.util.Random;

public class SecurityGenerator {

    private static final String[] SECURITIES = {
           "Security A", "Security B", "Security C", "Security D", "Security E"

    };

    private static final Random random = new Random();

    public static String getRandomSecurity() {
        return SECURITIES[random.nextInt(SECURITIES.length)];
    }
}
