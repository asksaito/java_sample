package com.example.transliterator;

import com.google.common.base.CharMatcher;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.Charset;

public class CharValidator {
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

    public static boolean isAscii(String text) {
        // ASCII文字 (制御文字は含まない)
        return StringUtils.isAsciiPrintable(text);
    }

//    public static boolean isHalfWidth(String text) {
//        return text.matches("^[｡-ﾟ]+$");
//    }

    public static boolean isHankakuKana(String text) {
        // 半角カタカナの正規表現
        return text.matches("^[ｦ-ﾟ]+$");
        // https://en.wikipedia.org/wiki/Halfwidth_and_Fullwidth_Forms_(Unicode_block)
    }

    public static boolean isZenkakuKana(String text) {
        // 全角カタカナの正規表現
        return text.matches("^[ァ-ヴー]+$");
        // https://en.wikipedia.org/wiki/Katakana_%28Unicode_block%29
    }

    public static boolean isHiragana(String text) {
        // ひらがなの正規表現
        return text.matches("^[ぁ-ん]+$");
        // https://en.wikipedia.org/wiki/Hiragana_%28Unicode_block%29
    }

    public static boolean isHankaku(String text) {
        // 半角 ＝ ASCII文字 or 半角カナ
        return text.chars()
                .mapToObj(Character::toString)
                .allMatch((c) -> isAscii(c) || isHankakuKana(c));
    }

    public static boolean isZenkaku(String text) {
        // 全角 ＝ 半角文字 or 制御文字 以外
        return text.chars()
                .noneMatch((cp) -> isHankaku(Character.toString(cp)) || Character.isISOControl(cp));
    }

    // 半角文字
    // 全角文字
    // 半角カナ
    // 全角カナ
    // ひらがな

}
