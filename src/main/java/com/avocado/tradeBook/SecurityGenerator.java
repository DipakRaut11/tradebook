package com.avocado.tradeBook;

import java.util.Random;

public class SecurityGenerator {

    private static final String[] SECURITIES = {
           "Kumari Securities Pvt. Ltd.", "Arun Securities Pvt. Ltd.", "Agrawal Securities Pvt. Ltd.", "Pragyan Securities Pvt. Ltd."
    };

    private static final Random random = new Random();git

    public static String getRandomSecurity() {
        return SECURITIES[random.nextInt(SECURITIES.length)];
    }
}
