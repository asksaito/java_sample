package com.example.transliterator;

import com.google.common.base.CharMatcher;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.Charset;

public class CharacterExample {
    public static void isZenkakuPrint(String text) {
//        System.out.println("alphabetic: " + Character.isAlphabetic(String.valueOf(ch).codePointAt(0)));
//        Boolean result = !(Character.isAlphabetic(ch) || Character.isDigit(ch) || Character.isISOControl(ch)
//                || Character.isWhitespace(ch));
//        Boolean result = StringUtils.isAsciiPrintable(text);

        System.out.println(text + ": isAsciiPrintable = " + StringUtils.isAsciiPrintable(text));
        System.out.println(text + ": isPureAscii = " + isPureAscii(text));
        System.out.println(text + ": matchesAllOf = " + CharMatcher.ascii().matchesAllOf(text));
        System.out.println(text + ": inRange = " + CharMatcher.inRange(' ', '~').matchesAllOf(text));
        System.out.println(text + ": matches = " + text.matches("\\A\\p{ASCII}*\\z"));
    }

    public static boolean isPureAscii(String v) {
        return Charset.forName("US-ASCII").newEncoder().canEncode(v);
        // or "ISO-8859-1" for ISO Latin 1
        // or StandardCharsets.US_ASCII with JDK1.7+
    }

    public static Boolean isAscii(String text) {
        // ASCII文字
        return StringUtils.isAsciiPrintable(text);
    }

    public static Boolean isHankakuKana(String text) {
        // 半角カタカナの正規表現
        return text.matches("^[｡-ﾟ]+$");
    }

    public static Boolean isZenkaku(String text) {
        // 全角 ＝ 半角文字 or 制御文字 以外
        return text.chars()
                .noneMatch((c) -> isHankaku(Character.toString(c)) || Character.isISOControl(c));
    }

    public static Boolean isHankaku(String text) {
        // 半角 ＝ ASCII文字 or 半角カナ
        return isAscii(text) || isHankakuKana(text);
    }

}
