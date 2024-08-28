package com.sheikhimtiaz.interview;

import java.util.*;
import java.util.List;

public class monstarLabCodingTest {

    public static void run(){
        System.out.println("test");

        List<String> list1 = new ArrayList();
        list1.add("foo");

        List<String> list2 = list1;
        List<String> list3 = new ArrayList(list2);

        list1.clear();
        list2.add("bar");
        list3.add("baz");

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);

        Set set = new TreeSet();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set);

        new newThread();

        Thread thread = new Thread(new test());
        thread.start();
        System.out.println(thread.getState());

        List<String> countires = Arrays.asList("Germany", "England", "China", "Denmark", "Brazil", "France", "Australia");
        Optional<String> countryName = countires.stream().reduce((c1,c2)-> c1.length() > c2.length() ? c1 : c2);
        countryName.ifPresent(System.out:: println);

//        Dog d = new Dog();
//        d.makeNoise();
//        d.move();
//        d.wagTail();
//        d.fetch();
//
//        Canine c = new Dog();
//        c.makeNoise();
//        c.move();
//        c.wagTail();
//        c.fetch();
//
//        Animal a = new Dog();
//        a.makeNoise();
//        a.move();
//        a.wagTail();
//        a.fetch();

        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<String>();
        stack.push("Apple");
        stack.push("Banana");
        stack.push("Cherry");
        queue.add(stack.pop());
        stack.push("DingleBerry");
        stack.push("Eggplant");
        queue.add("Fig");
        stack.push(queue.remove());
        queue.add(stack.pop());
        queue.add(stack.pop());

        System.out.println(stack);
        System.out.println(queue);

        Test2 obj = new Test2();
        obj.get();

        String weather = "rainy";
        changeTheString(weather);
        System.out.println(weather);

        String[] rainyDays = new String[]{"Monday", "Friday"};
        changeTheArray(rainyDays);
        System.out.println(rainyDays[1]);

        Forecast forecast = new Forecast();
        forecast.temperature = 20;
        forecast.pressure = 20;
        changeTheObject(forecast);
        System.out.println(forecast.temperature);

//        int x[] = int[10];
        int []y = new int[5];
        float d[] = {1,2,3};
        int a[]={1,2,3};int b[]; b=a;

        printsHello.hello();
//        list3.replaceAll(s->s.toUpperCase());
        list3.replaceAll(String::toUpperCase);
        System.out.println(list3);
        list3.replaceAll(s->s.toLowerCase());
        System.out.println(list3);


        Collection<String> collection;
        collection = new LinkedHashSet();
        collection.add("foo");
        collection.add("baz");
        collection.add("bar");
        collection.forEach(System.out::println);

        Set<Integer> set1 = new TreeSet<Integer>();
        set1.add(3);
        set1.add((int)3.0);
        set1.add(2);
        set1.add(2);
        set1.add(new Integer(2));
        set1.add(Integer.parseInt("2"));
        System.out.println(set1);

        String s1 = "yes";
        String s2 = "yes";
        String s3 = new String(s1);
        System.out.println(s1==s2);
        System.out.println(s3 == s1);
        System.out.println(s1!=s2);

        List<Integer> method1 = new ArrayList<>(Arrays.asList(2,3,4,5,6,8,9));
        Iterator<Integer> iterator = method1.iterator();
        while(iterator.hasNext()){
            Integer element = iterator.next();
            if(element%2 == 0){
                iterator.remove();
            }
        }
        System.out.println(method1);
//        List<Integer> method2 = new ArrayList<>(Arrays.asList(2,3,4,5,6,8,9));
//        for(Integer element: method2){
//            method2.remove(element);
//        }
//        System.out.println(method2);
        List<Integer> method3 = new ArrayList<>(Arrays.asList(2,3,4,5,6,8,9));

        List<Integer> tempList = new ArrayList<>();
        for(Integer element: method3){
            if(element%2 == 0){
                tempList.add(element);
            }
        }
        method3.removeAll(tempList);
        System.out.println(method3);

        List<Person> list = new ArrayList<>();
        list.add(new Person("Imtiaz"));
        list.add(new Person("Saila apu"));
        list.add(new Person("Shafqat bhai"));
        list.sort(Comparator.comparing(Person::getName));
        System.out.println(list);

        String x = "abc";
        String yy = "abc";
        x.concat(yy);
        System.out.println(x);

        Box o1 = new Box();
        Box o2 = new Box();
        o1.height = 1;
        o1.length = 2;
        o1.width = 1;
        o2 = o1;
        System.out.println(o2.height);

        SubClass s0 = new SubClass();
        s0.foo();
        String xva = "agag";
        Character ss = xva.charAt(1);
        List<Character> mmm = new ArrayList();
        mmm.add('a');
        Character z1 = mmm.get(mmm.size()-1);
        System.out.println(z1=='a');
//        Super s = new SubClass();
//        s.foo();

//        ExTest exTest = new ExTest();
//        try {
//            System.out.println(exTest.divide(10,0));
//        } catch (Exception ex){
//            System.out.println("Divison by 0!");
//        }

    }
//
//    public static int callPoints(String[] ops){
//        int result = 0;
//        List<Integer> list = new ArrayList<>();
//        for(int i=0;i<ops.length;i++){
//            if("+".equals(ops[i])){
//                list.add(list.get())
//            } else if("C".equals(ops[i])){
//
//            } else if("D".equals(ops[i])){
//
//            } else {
//                list.add(Integer.parseInt(ops[i]));
//            }
//        }
//        for(int j=0;j<list.size();j++){
//            result += list.get(j);
//        }
//        return result;
//    }

    public static void changeTheString(String weather){
        weather = "sunny";
    }
    public static void changeTheArray(String[] rainyDays){
        rainyDays[1] = "Sunday";
    }
    public static void changeTheObject(Forecast forecast){
        forecast.temperature = 35;
    }
}

class ExTest{
    public Integer divide(int a, int b){
        try{
            return a/b;
        } finally {
            System.out.println("Finally");
        }
    }
}

class Super{
    private void foo(){
        System.out.println("Super");
    }
}

class SubClass extends Super{
    public void foo(){
        System.out.println("SubClass");
    }
}

class Box{
    int width;
    int length;
    int height;
}

class Person{
    String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

interface printsHello{
    static void hello(){
        System.out.println("hello");
    }
}

class Forecast{
    public int temperature;
    public int pressure;
}

abstract class Demo{
    public int a;
    void demo(){
        a = 10;
    }
    abstract public void get();
}

class Test2 extends Demo{

    @Override
    final public void get() {
        System.out.println("a = "+ a);
    }
}


class newThread extends Thread{
    newThread(){
        super("My Thread");
        start();
    }

    public void run(){
        System.out.println(this);
    }
}

class test implements Runnable{
    @Override
    public void run() {
        System.out.println("Turing");
    }
}

abstract class Animal{
    public abstract void makeNoise();
    public abstract void move();
}

abstract class Canine extends Animal{
    public void wagTail(){
        System.out.println("wagging");
    }

    @Override
    public void move(){
        System.out.println("run");
    }
}

class Dog extends Canine{

    @Override
    public void makeNoise() {
        System.out.println("Bark");
    }

    public void fetch(){
        System.out.println("Fetch");
    }
}