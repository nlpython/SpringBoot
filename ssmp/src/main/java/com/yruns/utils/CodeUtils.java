package com.yruns.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * CodeUtils
 */
@Component
public class CodeUtils {

    private String[] zeros = new String[]{"000", "00", "0", ""};

    public String generator(String tele) {
        int hash = tele.hashCode();
        int encryption = 2020;
        long result = hash ^ encryption;

        long nowTimes = System.currentTimeMillis();
        result = hash ^ nowTimes;
        result = result < 0 ? -result: result;

        String code = result % 10000 + "";
        code = code + zeros[code.length() - 1];

        return code;
    }

    @Cacheable(value = "smsCode", key = "#tele")
    public String get(String tele) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new CodeUtils().generator("133443553"));
    }
}
