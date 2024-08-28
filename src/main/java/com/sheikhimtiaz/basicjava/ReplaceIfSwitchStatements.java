package com.sheikhimtiaz.basicjava;

import java.util.HashMap;
import java.util.Map;


public class ReplaceIfSwitchStatements {

    // Lookups for teh period.
    static final Map<String, Period> lookup = new HashMap<>();

    public static void run(){

        System.out.println(testWithFactory(2, 4, "add"));

        testWithEnum();
    }

    public static int testWithFactory(int a, int b, String operator) {
        OperatorFactory.Operation targetOperation = OperatorFactory
                .getOperation(operator)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Operator"));
        return targetOperation.apply(a, b);
    }


    private static void testWithEnum() {
        String[] test = {"650;0;1.5;month",
                "614;0;2.88;year",
                "466;0;2.48;week",
                "716;0;4.6;half-year",
                "718;0;2.6;quarter",};
        for (String s : test) {
            Period.process(s);
        }
    }

    enum Period {

        Month("month") {

            @Override
            void process(int x, int y, double v) {
                // Processing for "month" records here.
                System.out.println(this + "-process(" + x + "," + y + "," + v + ")");
            }
        },
        Year("year") {
            @Override
            void process(int x, int y, double v) {
                // Processing for "year" records here.
                System.out.println(this + "-process(" + x + "," + y + "," + v + ")");
            }
        },
        Quarter("quarter") {
            @Override
            void process(int x, int y, double v) {
                // Processing for "quarter" records here.
                System.out.println(this + "-process(" + x + "," + y + "," + v + ")");
            }
        },
        HalfYear("half-year") {
            @Override
            void process(int x, int y, double v) {
                // Processing for "half-year" records here.
                System.out.println(this + "-process(" + x + "," + y + "," + v + ")");
            }
        };

        Period(String inData) {
            // Record me in the map.
            lookup.put(inData, this);
        }

        abstract void process(int x, int y, double v);

        static void process(String data) {
            String[] parts = data.split(";");
            Period p = lookup.get(parts[3]);
            if (p != null) {
                p.process(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Double.parseDouble(parts[2]));
            }
        }
    }


//    private static void testWithConditionalOperator(){
//        MyClass x = ar[3].equals("month") ? new MyClassMonth() :
//                (ar[3].equals("year") ? new MyClassYear() :
//                        (ar[3].equals("week") ? new MyClassWeek() :
//                                (ar[3].equals("half-year") ? new MyClassHalfyear() :
//                                        new MyClassQuarter())));
//        x.doSomething();
//    }
//
//    private static void testWithMapOfStatelessObjects(){
//        final Map<String, MyClass> themap = new HashMap<>();
//        {
//            themap.add("month", new MyClassMonth());
//            themap.add("year", new MyClassYear());
//            themap.add("week", new MyClassWeek());
//            themap.add("half-year", new MyClassHalfyear());
//            themap.add("quarter", new MyClassQuarter());
//        }
//        MyClass x = themap.get(ar[3]);
//        if (x != null)
//            x.doSomething(ar);
//    }


}
