package com.sheikhimtiaz;

import java.util.*;
import java.util.function.Function;


public class DataTypesAndSyntax {
    public static void run(){
//        testStrings();
//
//        testPassByRef();
//
//        testLambdaFunction();

        testFinalAndEnum();
    }

    private static void testLambdaFunction(){
        Recursive<Function<Integer, Integer>> rec = new Recursive<>();
        rec.func = (n) -> n <= 1 ? 1 : n * rec.func.apply(n-1);
        System.out.println(rec.func.apply(4));
    }

    public static String printHelloWorld(){
        String name = "imtiaz";
        return "Hello World";
    }

    private static void testFinalAndEnum(){
        final int number = 8;
        final User test = new User();
        test.birth = new Date();
        MyTestEnum en = MyTestEnum.ONE;
        String one = "ONE";
        if(one.equals(en.toString())){
            System.out.println(en);
        }
        for(MyTestEnum it:MyTestEnum.values()){
            if(it == MyTestEnum.ONE){
                System.out.println(it);
                System.out.println(it.code());
            }
        }
    }

    private static void swapString(String a, String b){
        String temp = a;
        a = b;
        b = temp;
        System.out.println(a + " " + b);
    }

    private static void swapObject(User a, User b){
        User temp = a;
        a = b;
        b = temp;
        System.out.println(a.name + " " + b.name);
    }

    private static void testPassByRef(){
        List<String> test = new ArrayList<String>();
        List<String> test2 = test;
        test.add("12");
        test.add("13");
        "12".concat("12");
        test.replaceAll(String::toUpperCase);
        test.subList(0,2).clear();
        System.out.println("sth : " + test);
        passByRef(test);
        System.out.println("outside func : " + test2);

        String mmmmm = new String("safaf");
        String name = "";
        passByRef2(name);
        System.out.println("outside name : " + name);

        User a = new User();
        a.name = "";
        a.birth = new Date(2020);
        User b = new User();
        b.name = "";
        b.birth = new Date(2021);
        passByRef3(a);
        System.out.println("outside name : " + a.name);
        User[] mmm = {a,b};

        User[] userArray = new User[]{a,b};
        System.out.println(Arrays.stream(userArray).sorted());

        swapObject(a, b);
        String aa = "oneIt", bb = "axiata";
        swapString(aa,bb);
        System.out.println(aa + " " + bb);
        String[] numbers = {"1", "2","15", "-3"};Arrays.sort(numbers);

        System.out.println(Arrays.asList(numbers));
    }

    private static void passByRef(List<String> arr){
        arr.add("habijabi");
        System.out.println("Inside func : " + arr);
    }

    private static void passByRef2(String str){
        str = "imtiaz";
        System.out.println("Inside func : " + str);
    }

    private static void passByRef3(User user){
        user.name = "imtiaz";
        System.out.println("Inside func : " + user.name);
    }

    private static void testStrings(){
        List<String> test = new ArrayList<String>();
        test.add("kapjhap");
        System.out.println("kapjhap".substring(1,2));
        System.out.println("kapjhap".substring(1,3));
        System.out.println("kapjhap".substring(1,4));
        System.out.println("kapjhap".subSequence(0,5));
        System.out.println(test);
        LinkedList<Integer> test2 = new LinkedList<>();
        test2.add(5);
        test2.add(2);
        System.out.println(test2);
        String[] myArr = {"ag", "agag", "agag", "agag", "agag", "ag", "agag", "agag", "agag", "agag"};
        System.out.println(myArr[4]);
    }
}
