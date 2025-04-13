package com.sheikhimtiaz.interview;

import java.util.Arrays;
import java.util.Collections;

//CoderByteTest
public class SampleAAC {


    public static void run(){

        String result = FirstReverse("Test case");
        System.out.println(result);
        System.out.println(shuffle(2111));
    }

    public static int shuffle(int num){
        // NOT_SOLVED_YET
        String number = String.valueOf(num);
        if(number.length() == 1) number+= "000";
        if(number.length() == 2) number+= "00";
        if(number.length() == 3) number+= "0";
        Character[] ascChar = number.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        Character[] descChar = number.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        Arrays.sort(ascChar, 0 ,4);
        Arrays.sort(descChar, 0, 4, Collections.reverseOrder());
//        System.out.println(Arrays.stream(descChar).collect().toString());
        System.out.println(descChar.toString());

        return Integer.parseInt(String.valueOf(descChar)) - Integer.parseInt(ascChar.toString());
    }

    public static String FirstReverse(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();
        return sb.toString();
    }
}
