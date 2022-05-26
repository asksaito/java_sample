package com.example.csv;

import org.apache.commons.lang3.StringUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ParseCsv {
    public static void parse(String filePath) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath), Charset.forName("SJIS"))) {
            StringBuilder sb = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null) {
                // ファイルから読み取った行を連結する
                sb.append(line);

                if (!StringUtils.endsWith(line, "\"")) {
                    // 行末がダブルクォート以外の場合、改行コードが含まれているのでcontinueして次の行へ
                    continue;
                }

                // 行の先頭と末尾のダブルクォートを除去した後、"," でsplitする。
                String[] columns = StringUtils.removeStart(
                                StringUtils.removeEnd(sb.toString(), "\""), "\"")
                        .split("\",\"");

                // 結果出力
                System.out.println(StringUtils.join(columns, "|"));

                // StringBuilderの初期化
                sb.setLength(0);
            }
        }
    }
}
