package com.example.convert_encoding;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

public class ConvertCsv {
    public static void convertCsv(String srcPath, String destPath) throws IOException {
        File srcFile = new File(srcPath);
        Charset srcCharset = StandardCharsets.UTF_8;
        File destFile = new File(destPath);
        Charset destCharset = Charset.forName("SJIS");
        CharsetEncoder encoder = destCharset.newEncoder();

        try (BufferedReader br = new BufferedReader(new FileReader(srcFile, srcCharset))) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(destFile, destCharset))) {
                String line;

                while ((line = br.readLine()) != null) {
                    // 文字化け判定
                    if (!encoder.canEncode(line)) {
                        // 文字化けが発生する行をログに出力
                        System.out.println(line);
                    }

                    // ファイルに一行書き込み
                    bw.write(line);
                    // 環境に合わせた改行文字を書き込み
                    bw.newLine();
                }
            }
        }
    }
}
