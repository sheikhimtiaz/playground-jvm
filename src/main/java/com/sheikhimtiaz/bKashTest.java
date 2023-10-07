package com.sheikhimtiaz;

public class bKashTest {

    public static void run(){
//        System.out.println("Works!");
//
//        int b = '2';
//        System.out.println(b);
//        int c = Character.getNumericValue('a');
//        System.out.println(c);
//         c = Character.getNumericValue('9');
//        System.out.println(c);
//         c = Character.getNumericValue('0');
//        System.out.println(c);
        System.out.println(multiplyStringNumber("2", "3"));
        System.out.println(multiplyStringNumber("2", "6"));
        System.out.println(multiplyStringNumber("0", "6"));
        System.out.println(multiplyStringNumber("10", "6"));
        System.out.println(multiplyStringNumber("10", "100"));
        System.out.println(multiplyStringNumber("12", "12"));
        System.out.println(multiplyStringNumber("0", "0"));
    }

    public static String multiplyStringNumber(String num1, String num2){
        int m = num1.length(), n = num2.length();
        int[] product = new int[m+n];
        for(int i = m-1; i>=0; i--){
            int x = Character.getNumericValue(num1.charAt(i));
            for(int j = n-1; j>=0; j--){
                int mul = x * Character.getNumericValue(num2.charAt(j));
                product[i+j+1] += mul;
                product[i+j] += product[i+j+1] / 10;
                product[i+j+1] %= 10;
            }
        }
        final StringBuilder result = new StringBuilder();
        for(int p:product){
            if(p!=0 || result.length() != 0){
                result.append(p);
            }
        }
        if("".equals(result.toString())) return "0";
        else return result.toString();
    }



}
