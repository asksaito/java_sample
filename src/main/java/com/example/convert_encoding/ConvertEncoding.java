package com.example.convert_encoding;

import com.opencsv.CSVWriterBuilder;

import java.io.*;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnmappableCharacterException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.apache.commons.io.output.NullOutputStream.NULL_OUTPUT_STREAM;

public class ConvertEncoding {
    public static void encodingTest() throws IOException {
//        String originalText = "このテキストは文字化けの起きない文字列です。";
//        String originalText = "あ～あ①髙島屋パバぱ";
//        String originalText = "テストＡＢＣ１２３４５";
//        String originalText = "～－￠￡￢―∥";
//        String originalText = "\uD852\uDC2B"; // サロゲートペア文字 (𤠫)

//        if (isConvertSuccess(originalText)) {
//            System.out.println("Matched!! : " + originalText);
//        } else {
//            System.out.println("Unmatched!! : " + originalText);
//        }

        String text = "This is normal text.";
        System.out.println(isConvert(text) + ": " + text);

        text = "このテキストは文字化けの起きない文字列です。";
        System.out.println(isConvert(text) + ": " + text);

        text = "～"; // 全角チルダ (文字化けする)
        System.out.println(isConvert(text) + ": " + text);

        text = "～－￠￡￢―∥"; // 特殊な記号 (文字化けする)
        System.out.println(isConvert(text) + ": " + text);

        text = "\uD852\uDC2B"; // サロゲートペア文字 (文字化けする)
        System.out.println(isConvert(text) + ": " + text);
    }

    private static boolean isConvert(String text) {
        String utf8Text = new String(
                text.getBytes(StandardCharsets.UTF_8),
                StandardCharsets.UTF_8);

        String sjisText = new String(
                text.getBytes(Charset.forName("Shift_JIS")),
                Charset.forName("Shift_JIS"));

        return utf8Text.equals(sjisText);
    }

    private static boolean isConvert2(String text) {
        CharsetEncoder encoder = Charset.forName("Shift_JIS").newEncoder();
        return encoder.canEncode(text);
    }
}
