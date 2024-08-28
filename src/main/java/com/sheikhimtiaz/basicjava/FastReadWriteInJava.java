package com.sheikhimtiaz.basicjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FastReadWriteInJava {

    public static void run(){
        testBufferReader();
    }

    private static void testBufferReader() {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            final int n = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
