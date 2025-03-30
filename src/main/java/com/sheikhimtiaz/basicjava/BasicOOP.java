package com.sheikhimtiaz.basicjava;

public class BasicOOP {

    public static void run() {
        A a = new B();
        a.method1(10);
        B b = new B();
        b.method1(20);
        C c = new C();
        c.method1(30);
        SampleInterface si = new SampleInterface() {
            @Override
            public void printHello() {
                System.out.println("Hello");
            }
        };
        System.out.println(si.SOME_VALUE);
        si.printHello();

        System.out.println("বাংলাদেশ");

        final int intA = 65;
        int intB = -128;
        System.out.println(intA >> 3);
        System.out.println(intA >>> 3);
        System.out.println(intB >> 3);
        System.out.println(4 >> 2);
        System.out.println(4 >> 5);
        System.out.println(4 >> 4);
    }


    static class A {
        void method1 (int a) {
            System.out.println("Parent -> " + a);
        }
    }

    static class B extends  A {
        int someValue;
        static int staticVal;
        @Override
        void method1(int a) {
            System.out.println("Child -> " + a);
        }

        static class StaticNested {
            void nestedMethod(){
                System.out.println("nested method! " + staticVal);
            }
        }
    }

    static class C extends A {
        @Override
        void method1(int a) {
            super.method1(a);
        }
    }

    interface SampleInterface {
        public static final int SOME_VALUE = 5;
        void printHello ();
    }
}
