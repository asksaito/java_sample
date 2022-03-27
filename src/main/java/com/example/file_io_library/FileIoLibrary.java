package com.example.file_io_library;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileIoLibrary {
    public static void jdk1_0Style(String srcPath, String destPath) throws IOException {
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);

        BufferedReader reader = null;
        OutputStream writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(srcFile), StandardCharsets.UTF_8));
            writer = new BufferedOutputStream(new FileOutputStream(destFile));

            String line;
            while ((line = reader.readLine()) != null) { // 1行読み出し
                // プラットフォームに応じた改行文字を付加
                line += System.getProperty("line.separator");
                // Shift-JIS binary 取得
                byte[] binary = line.getBytes(Charset.forName("SJIS"));
                // ファイルに書き込み
                writer.write(binary, 0, binary.length);
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
            if (reader != null) {
                reader.close();
            }
        }
    }
}
