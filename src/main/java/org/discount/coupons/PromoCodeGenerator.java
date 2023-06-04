package org.discount.coupons;

import java.util.Random;
import java.lang.StringBuilder;

public class PromoCodeGenerator {
    static int defaultLength = 10;

    public static String generate() {
        int leftBound = 48; // number '0'
        int rightBound = 122; // letter 'z';
        Random random = new Random();

        String randomString = random.ints(leftBound, rightBound + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(defaultLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return randomString;
    }
}
