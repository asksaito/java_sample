package com.example;

import com.example.char_encoding.CharEncoding;
import com.example.convert_encoding.ConvertCsv;
import com.example.convert_encoding.ConvertEncoding;
import com.example.csv.ParseCsv;
import com.example.csv.ParseCsvGuava;
import com.example.transliterator.CharacterExample;
import com.example.transliterator.TransliteratorExample;
import com.google.common.base.Charsets;
import org.apache.commons.lang3.time.StopWatch;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {
    public static void main(String args[]) throws Exception {
//        String src = "E:\\temp\\gradle_test\\apex.txt";
//        String dest = "E:\\temp\\gradle_test\\";
        String src = "D:\\temp\\test\\GameHard.csv";
        String dest = "D:\\temp\\test\\GameHard_SJIS.csv";
        String csvfile = "D:\\temp\\test\\parse_sample.csv";

        StopWatch stopWatch = new StopWatch();

//        // test JDK 1.0
//        stopWatch.start();
//        FileIoLibrary.jdk1_0Style(src, dest + "jdk10.txt");
//        stopWatch.stop();
//        System.out.println("JDK 1.0: " + stopWatch.getTime() + " (msec)");
//
//        // test JDK 1.7
//        stopWatch.reset();
//        stopWatch.start();
//        FileIoLibrary.jdk1_7Style(src, dest + "jdk17.txt");
//        stopWatch.stop();
//        System.out.println("JDK 1.7: " + stopWatch.getTime() + " (msec)");
//
//        // test JDK 1.8
//        stopWatch.reset();
//        stopWatch.start();
//        FileIoLibrary.jdk1_8Style(src, dest + "jdk18.txt");
//        stopWatch.stop();
//        System.out.println("JDK 1.8: " + stopWatch.getTime() + " (msec)");
//
//        // test apache
//        stopWatch.reset();
//        stopWatch.start();
//        FileIoLibrary.apacheCommonsStyle(src, dest + "apache.txt");
//        stopWatch.stop();
//        System.out.println("Apache: " + stopWatch.getTime() + " (msec)");
//
//        // test guava
//        stopWatch.reset();
//        stopWatch.start();
//        FileIoLibrary.googleGuavaStyle(src, dest + "guava.txt");
//        stopWatch.stop();
//        System.out.println("Guava: " + stopWatch.getTime() + " (msec)");

//        ConvertEncoding.encodingTest();

//        System.out.println(MaskUtils.rightMask("1234-5678-9012-3456", 5));

//        MapVsFlatMap.example();

//        CurrencySample.viewCurrencyList();

//        CharEncoding.printHexBinary();

//        ConvertCsv.convertCsv(src, dest);

//        ParseCsv.parse(csvfile);

        /*
        // Easy CSV 案
        StringCsvReader stringCsvReader = new StringCsvReader(filePath, StandardCharsets.UTF_8);
        String line = stringCsvReader.readLine();
        List<String> stringList = stringCsvReader.readAll();

        EasyCsvReader<SomeBean> csvReader = new EasyCsvReader(filePath, StandardCharsets.UTF_8);
        SomeBean bean = csvReader.read();
        List<SomeBean> list = csvReader.readAll();

        EasyCsvReaderBuilder<SomeBean> builder = new EasyCsvReaderBuilder();
        EasyCsvReader<SomeBean> csvReader =
                builder.doubleQuote(true)
                .encoding(Charsets.UTF_8)
                .configuration(config)
                .build();
         */

//        ParseCsvGuava parseCsvGuava = new ParseCsvGuava();
//        parseCsvGuava.readCsvAsList("D:\\temp\\test\\GameHard.csv", false, Charsets.UTF_8);
//        parseCsvGuava.readCsvAsMap("D:\\temp\\test\\GameHardWithBOMWithHeader.csv", true, Charsets.UTF_8);

//        try {
//            System.out.println(TransliteratorExample.getAvailableIDs());
////            NullPointerException
//            String text = "あいうえお";
//            System.out.println(text + " -> " + TransliteratorExample.zenkakuToHankaku(text));
//            text = "アイウエオ";
//            System.out.println(text + " -> " + TransliteratorExample.zenkakuToHankaku(text));
//            text = "ｳﾞｧｲｵﾘﾝ";
//            System.out.println(text + " -> " + TransliteratorExample.zenkakuToHankaku(text));
//            text = "abcdefg";
//            System.out.println(text + " -> " + TransliteratorExample.zenkakuToHankaku(text));
//            text = "ＡＢＣＤＥＦＧ";
//            System.out.println(text + " -> " + TransliteratorExample.zenkakuToHankaku(text));
//            text = "漢字";
//            System.out.println(text + " -> " + TransliteratorExample.zenkakuToHankaku(text));
//            text = "あいうえおアイウエオｳﾞｧｲｵﾘﾝabcdefgＡＢＣＤＥＦＧ漢字";
//            System.out.println(text + " -> " + TransliteratorExample.zenkakuToHankaku(text));
//
//            text = "あいうえお";
//            System.out.println(text + " -> " + TransliteratorExample.hankakuToZenkaku(text));
//            text = "アイウエオ";
//            System.out.println(text + " -> " + TransliteratorExample.hankakuToZenkaku(text));
//            text = "ｳﾞｧｲｵﾘﾝ";
//            System.out.println(text + " -> " + TransliteratorExample.hankakuToZenkaku(text));
//            text = "abcdefg";
//            System.out.println(text + " -> " + TransliteratorExample.hankakuToZenkaku(text));
//            text = "ＡＢＣＤＥＦＧ";
//            System.out.println(text + " -> " + TransliteratorExample.hankakuToZenkaku(text));
//            text = "漢字";
//            System.out.println(text + " -> " + TransliteratorExample.hankakuToZenkaku(text));
//            text = "あいうえおアイウエオｳﾞｧｲｵﾘﾝabcdefgＡＢＣＤＥＦＧ漢字";
//            System.out.println(text + " -> " + TransliteratorExample.hankakuToZenkaku(text));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        CharacterExample.isZenkaku("a");
        CharacterExample.isZenkaku("あ");
        CharacterExample.isZenkaku("ア");
        CharacterExample.isZenkaku("ｱ");
        CharacterExample.isZenkaku(" ");
        CharacterExample.isZenkaku("　");
        CharacterExample.isZenkaku("0");
        CharacterExample.isZenkaku("\u000F"); // SIN
        CharacterExample.isZenkaku("\u007F"); // DEL
        CharacterExample.isZenkaku("漢字");
    }
}
