package com.avocado.tradeBook;

import java.util.Random;

public class SymbolGenerator {
    private static final String[] SYMBOLS = {"DBLS", "ADBL", "AHL", "ANLB", "ADB", "SAMAJ", "VLBS"};

    private static final Random random = new Random();

    public static String getRandomSymbol() {
        return SYMBOLS[random.nextInt(SYMBOLS.length)];
    }
}
