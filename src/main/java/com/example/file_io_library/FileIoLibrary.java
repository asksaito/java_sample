package com.example.file_io_library;

import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.FileWriteMode;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    public static void jdk1_7Style(String srcPath, String destPath) throws IOException {
        Path srcFile = Paths.get(srcPath);
        Path destFile = Paths.get(destPath);

        try (BufferedReader br = Files.newBufferedReader(srcFile, StandardCharsets.UTF_8)) {
            try (BufferedWriter bw = Files.newBufferedWriter(destFile, Charset.forName("SJIS"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    // ファイルに書き込み
                    bw.write(line + System.lineSeparator());
                }
            }
        }
    }

    public static void jdk1_8Style(String srcPath, String destPath) throws IOException {
        Path srcFile = Paths.get(srcPath);
        Path destFile = Paths.get(destPath);

        try (BufferedReader br = Files.newBufferedReader(srcFile, StandardCharsets.UTF_8)) {
            try (BufferedWriter bw = Files.newBufferedWriter(destFile, Charset.forName("SJIS"))) {
                br.lines()
                        .map(s -> s + System.lineSeparator())
//                        .forEach(bw::write) // 例外が出なければこの書き方が良いのだが
                        .forEach(s -> {
                            try {
                                // ファイルに書き込み
                                bw.write(s);
                            } catch (IOException e) {
                                // 例外処理をしないといけないのがイマイチ
                                e.printStackTrace();
                            }
                        });
            }
        }
    }

    public static void apacheCommonsStyle(String srcPath, String destPath) throws IOException {
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);

        // LineIterator を使う場合
        try (LineIterator it = FileUtils.lineIterator(srcFile, "UTF-8")) {
            try (FileOutputStream out = FileUtils.openOutputStream(destFile)) {
                while (it.hasNext()) {
                    String line = it.nextLine() + System.lineSeparator();
                    // ファイルに書き込み
                    out.write(line.getBytes(Charset.forName("SJIS")));

                    // FileUtils.write(destFile, line, "SJIS", true); // 毎回ファイルオープンするので非常に低速
                }
            }
        }

        // BufferedReader / BufferedOutputStream を使う場合 (apache commons)
        try (BufferedReader br = new BufferedReader(new InputStreamReader(FileUtils.openInputStream(srcFile), StandardCharsets.UTF_8))) {
            try (BufferedOutputStream out = new BufferedOutputStream(FileUtils.openOutputStream(destFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    line += System.lineSeparator();
                    // ファイルに書き込み
                    out.write(line.getBytes(Charset.forName("SJIS")));
                }
            }
        }
    }

    public static void googleGuavaStyle(String srcPath, String destPath) throws IOException {
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);

//        try (BufferedReader br = com.google.common.io.Files.newReader(srcFile, StandardCharsets.UTF_8)) {
//            try (BufferedWriter bw = com.google.common.io.Files.newWriter(destFile, Charset.forName("SJIS"))) {
//                String line;
//                while ((line = br.readLine()) != null) {
//                    // ファイルに書き込み
//                    bw.write(line + System.lineSeparator());
//                }
//            }
//        }

        // Source file
        CharSource charSource = com.google.common.io.Files.asCharSource(srcFile, StandardCharsets.UTF_8);
        // Dest file
        CharSink charSink = com.google.common.io.Files.asCharSink(destFile, Charset.forName("SJIS"));
        // ファイルの中身をコピーする
        charSource.copyTo(charSink);
    }
}
