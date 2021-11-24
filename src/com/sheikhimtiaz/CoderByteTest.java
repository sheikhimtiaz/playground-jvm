package com.sheikhimtiaz;

public class CoderByteTest {


    public static void run(){

        String result = FirstReverse("Test case");
        System.out.println(result);
    }

    public static String FirstReverse(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();
        return sb.toString();
    }
}
