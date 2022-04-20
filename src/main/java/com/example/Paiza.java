package com.example;
import java.util.*;

public class Paiza {
    public static void paizaLerning1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        int distance = Integer.parseInt(input[0]);
        int stride = Integer.parseInt(input[1]);

        if (distance * 1000 * 100 >= stride * 10000) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        int distance = Integer.parseInt(input[0]);
        int stride = Integer.parseInt(input[1]);

        if (distance * 1000 * 100 >= stride * 10000) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}