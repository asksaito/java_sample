package com.example;

import com.example.file_io_library.FileIoLibrary;

public class Main {
    public static void main(String args[]) throws Exception {
        String src = "E:\\temp\\gradle_test\\apex.txt";
        String dest = "E:\\temp\\gradle_test\\out.txt";

        // test
        FileIoLibrary.jdk1_0Style(src, dest);
    }
}
