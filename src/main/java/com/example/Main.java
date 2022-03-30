package com.example;

import com.example.convert_encoding.ConvertEncoding;
import com.example.file_io_library.FileIoLibrary;
import com.example.masked_string.MaskUtils;
import org.apache.commons.lang3.time.StopWatch;

public class Main {
    public static void main(String args[]) throws Exception {
//        String src = "E:\\temp\\gradle_test\\apex.txt";
//        String dest = "E:\\temp\\gradle_test\\";
        String src = "D:\\temp\\test\\sample.csv";
        String dest = "D:\\temp\\test\\";

        StopWatch stopWatch = new StopWatch();

//        // test JDK 1.0
//        stopWatch.start();
//        FileIoLibrary.jdk1_0Style(src, dest + "jdk10.txt");
//        stopWatch.stop();
//        System.out.println("JDK 1.0: " + stopWatch.getTime() + " (msec)");
//
//        // test JDK 1.7
//        stopWatch.reset();
//        stopWatch.start();
//        FileIoLibrary.jdk1_7Style(src, dest + "jdk17.txt");
//        stopWatch.stop();
//        System.out.println("JDK 1.7: " + stopWatch.getTime() + " (msec)");
//
//        // test JDK 1.8
//        stopWatch.reset();
//        stopWatch.start();
//        FileIoLibrary.jdk1_8Style(src, dest + "jdk18.txt");
//        stopWatch.stop();
//        System.out.println("JDK 1.8: " + stopWatch.getTime() + " (msec)");
//
//        // test apache
//        stopWatch.reset();
//        stopWatch.start();
//        FileIoLibrary.apacheCommonsStyle(src, dest + "apache.txt");
//        stopWatch.stop();
//        System.out.println("Apache: " + stopWatch.getTime() + " (msec)");
//
//        // test guava
//        stopWatch.reset();
//        stopWatch.start();
//        FileIoLibrary.googleGuavaStyle(src, dest + "guava.txt");
//        stopWatch.stop();
//        System.out.println("Guava: " + stopWatch.getTime() + " (msec)");

//        ConvertEncoding.encodingTest();

        System.out.println(MaskUtils.rightMask("1234-5678-9012-3456", 5));
    }
}
