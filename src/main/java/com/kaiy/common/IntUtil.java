package com.kaiy.common;

import java.util.Random;

public class IntUtil {

    private IntUtil() {
    }

    private static final Random random = new Random();

    public static int randomInt(int limit) {
        return random.nextInt(limit);
    }

    public static int randomIntContainsNegative(int limit) {
        return whetherToGenerateNegative(true) ? randomInt(limit) : randomInt(limit) * -1;
    }

    private static boolean whetherToGenerateNegative(boolean negative) {
        return negative && (IntUtil.randomInt(2) & 1) == 1;
    }
}
