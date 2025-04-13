package com.sheikhimtiaz.interview;

//PentaGlobal
public class SampleAAQ {

    public interface Person {
        default String sayName(){
            System.out.println("Joe");
            return "Joe";
        }
    }

    public abstract static class Student implements Person{
        public void printMessage(){
            System.out.println("Hi " + this.sayName());
        }
    }

    public static class ScienceStudent extends Student {
        public String sayName(){

            return "name";
        }

        public void printMessage(){
            System.out.println("PrintMessage");
        }

    }

    public static class BusinessStudent extends Student {
        public void printMessage(String message){
            System.out.println("print bz message");
        }
    }

    public static void run() {
//        Student fakeStudent = new Person();
//        Person person = new Student();
//        ScienceStudent scienceStudent = new ScienceStudent();
//        Student businessStudent = new BusinessStudent();

        // call all their methods

    }

}
