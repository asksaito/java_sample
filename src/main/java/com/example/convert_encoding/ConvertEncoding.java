package com.example.convert_encoding;

import com.opencsv.CSVWriterBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ConvertEncoding {
    public static void main(String args[]) {
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

        text = "～"; // 全角チルダ
        System.out.println(isConvert(text) + ": " + text);

        text = "～－￠￡￢―∥";
        System.out.println(isConvert(text) + ": " + text);

        text = "\uD852\uDC2B"; // サロゲートペア文字 (𤠫)
        System.out.println(isConvert(text) + ": " + text);
    }

    private static boolean isConvert(String text) {
        String utf8Text = new String(text.getBytes(StandardCharsets.UTF_8),
                StandardCharsets.UTF_8);

        String sjisText = new String(utf8Text.getBytes(Charset.forName("Shift_JIS")),
                Charset.forName("Shift_JIS"));

        return utf8Text.equals(sjisText);
    }

    private static void opencsvtest() throws IOException {
        Writer writer = new FileWriter("yourfile.csv");
        CSVWriterBuilder builder = new CSVWriterBuilder(writer);
    }
}
