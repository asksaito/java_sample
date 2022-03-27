package com.example;

import com.example.file_io_library.FileIoLibrary;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws Exception {
        String src = "E:\\temp\\gradle_test\\apex.txt";
        String dest = "E:\\temp\\gradle_test\\out.txt";

        FileIoLibrary.sample(src, dest);
    }
}
