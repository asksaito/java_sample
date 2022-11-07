package com.example.transliterator;

import com.ibm.icu.text.Transliterator;

import java.util.Collections;
import java.util.List;

public class TransliteratorExample {
    public static String zenkakuToHankaku(String text) {
        Transliterator transliterator = Transliterator.getInstance("Fullwidth-Halfwidth");
        return transliterator.transliterate(text);
    }

    public static String hankakuToZenkaku(String text) {
        Transliterator transliterator = Transliterator.getInstance("Halfwidth-Fullwidth");
        return transliterator.transliterate(text);
    }

    public static List<String> getAvailableIDs() {
        return Collections.list(Transliterator.getAvailableIDs());
    }
}
