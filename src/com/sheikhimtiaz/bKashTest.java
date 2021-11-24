package com.sheikhimtiaz;

public class bKashTest {

    public static void run(){
        System.out.println("Works!");
//
//        int b = '2';
//        System.out.println(b);
//        int c = Character.getNumericValue('a');
//        System.out.println(c);
//         c = Character.getNumericValue('9');
//        System.out.println(c);
//         c = Character.getNumericValue('0');
//        System.out.println(c);
        multiply("2", "3");
        multiply("2", "6");
        multiply("0", "6");
        multiply("10", "6");
        multiply("10", "100");
        multiply("12", "12");
    }

    public static void multiply(String num1, String num2){
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
        System.out.println(result.toString());
    }



}
