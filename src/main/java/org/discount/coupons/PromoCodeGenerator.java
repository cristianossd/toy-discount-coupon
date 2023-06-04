package org.discount.coupons;

import java.util.Random;
import java.lang.StringBuilder;

public class PromoCodeGenerator {
    int defaultLength = 10;

    public String generate(int targetLength) {
        return this.build(targetLength);
    }

    public String generate() {
        return this.build(this.defaultLength);
    }

    private String build(int targetLength) {
        int leftBound = 48; // number '0'
        int rightBound = 122; // letter 'z';
        Random random = new Random();

        String randomString = random.ints(leftBound, rightBound + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return randomString;
    }
}
