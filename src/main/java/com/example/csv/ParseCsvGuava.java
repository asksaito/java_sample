package com.example.csv;

import com.google.common.io.CharSource;
import com.google.common.io.Files;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class ParseCsvGuava {
    public void readCsvAsList(String filePath, boolean doubleQuote, Charset encoding) throws IOException {
        final String enclosure = doubleQuote ? "\"" : "";

        Files.asCharSource(new File(filePath), encoding)
                .lines()
                .map(it -> StringUtils.removeStart(StringUtils.removeEnd(it, enclosure), enclosure))
                .map(it -> Arrays.asList(it.split(enclosure + "," + enclosure)))
                .forEach(it -> {
                    // 1行ごとの処理
                    System.out.println(StringUtils.join(it, ", "));
                });

    }


    public void readCsvAsMap(String filePath, boolean doubleQuote, Charset encoding) throws IOException {
        final String enclosure = doubleQuote ? "\"" : "";
        CharSource charSource = Files.asCharSource(new File(filePath), encoding);

        // ヘッダ行
        final List<String> headers = parseLine(charSource.readFirstLine(), enclosure);

        // データ行
        charSource.lines()
                .skip(1)
                .map(it -> parseLine(it, enclosure))
                .map(it -> {
                    Map<String, String> map = new LinkedHashMap();
                    for (int i = 0; i < it.size(); i++) {
                        map.put(headers.get(i), it.get(i));
                    }
                    return map;
                })
                .forEach(it -> {
                    // 1行ごとの処理
                    System.out.println(it);
                });
    }

    private List<String> parseLine(String line, String enclosure) {
        return Arrays.asList(
                StringUtils.removeStart(
                        StringUtils.removeEnd(line, enclosure),
                        enclosure
                ).split(enclosure + "," + enclosure)
        );
    }
}
