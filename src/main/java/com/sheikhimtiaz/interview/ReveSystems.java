package com.sheikhimtiaz.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReveSystems {

    public static void run(){

        System.out.println(reverseWordsInString("My name is imtiaz"));
    }


    public static String reverseWordsInString(String sentence){
        String result = "";
        int lastIndex = sentence.length();
        for(int i=sentence.length()-1;i>=0;i--){
            Character ch = sentence.charAt(i);
            if(ch == ' ') {
                result = result.concat(sentence.substring(i+1, lastIndex) + " ");
                lastIndex = i;
            }
        }
        if(lastIndex != 0){
            result = result.concat(sentence.substring(0,lastIndex));
        }
        return result;
    }

}
