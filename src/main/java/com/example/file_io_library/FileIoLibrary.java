package com.example.file_io_library;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileIoLibrary {
    public static void sample(String srcPath, String destPath) throws IOException {
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);

        BufferedReader reader = null;
        BufferedOutputStream writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(srcFile), StandardCharsets.UTF_8));
            writer = new BufferedOutputStream(new FileOutputStream(destFile));

            String str;
            while ((str = reader.readLine()) != null) {
                str += "\r\n";
                byte[] binary = str.getBytes(Charset.forName("SJIS"));
                writer.write(binary, 0, binary.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
