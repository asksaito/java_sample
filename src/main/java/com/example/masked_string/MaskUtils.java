package com.example.masked_string;

import org.apache.commons.lang3.StringUtils;

public class MaskUtils {
    public static String mask(String input, int size) {
        return StringUtils.leftPad(StringUtils.right(input, size), StringUtils.length(input), '*');
    }
}
