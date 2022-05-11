package com.example.char_encoding;

import org.apache.commons.codec.binary.Hex;

import java.nio.charset.Charset;

public class CharEncoding {
    public static void printHexBinary() {
        // "あ" という文字をバイナリに変換する
        String moji = "あ";
        System.out.println(Hex.encodeHexString(moji.getBytes(Charset.forName("UTF-8"))));
        System.out.println(Hex.encodeHexString(moji.getBytes(Charset.forName("Shift-JIS"))));
        System.out.println(Hex.encodeHexString(moji.getBytes(Charset.forName("EUC-JP"))));
        // UTF-8: e3 81 82
        // Shift-JIS: 82 a0
        // EUC-JP: a4 a2
        // https://csedu.ime.cmc.osaka-u.ac.jp/oer/tools/encode/bitToChar.php?base=16&bitstring=e38182

        // "あいうえお" という文字列をバイナリに変換する
        String mojiretsu = "あいうえお";
        System.out.println(Hex.encodeHexString(mojiretsu.getBytes(Charset.forName("UTF-8"))));
        System.out.println(Hex.encodeHexString(mojiretsu.getBytes(Charset.forName("Shift-JIS"))));
        System.out.println(Hex.encodeHexString(mojiretsu.getBytes(Charset.forName("EUC-JP"))));
        // UTF-8: e3 81 82 e3 81 84 e3 81 86 e3 81 88 e3 81 8a
        // Shift-JIS: 82 a0 82 a2 82 a4 82 a6 82 a8
        // EUC-JP: a4 a2 a4 a4 a4 a6 a4 a8 a4 aa

        // "a" という文字をバイナリに変換する
        String alphabet = "a";
        System.out.println(Hex.encodeHexString(alphabet.getBytes(Charset.forName("UTF-8"))));
        System.out.println(Hex.encodeHexString(alphabet.getBytes(Charset.forName("Shift-JIS"))));
        System.out.println(Hex.encodeHexString(alphabet.getBytes(Charset.forName("EUC-JP"))));
        // UTF-8: 61
        // Shift-JIS: 61
        // EUC-JP: 61
    }
}
