package com.sheikhimtiaz.interview;

import java.util.*;

public class OneItQues {
    public static void run(){
//        wordCount("The fox, on the log");
//        int[] testCases = {4, 5, 3};
//        seriesSum(testCases);
//        learnKeywords();
        char[] chars = {'a','a','b'};
//        removeDuplicates(chars);
        System.out.println(removeDuplicates(chars));
    }



    public static void learnKeywords(){
        System.out.println("Start");
        LinkedHashMap<String, Integer> myMap = new LinkedHashMap<String, Integer>();
        assert myMap != null : "test";
        System.out.println("End");
    }

    public static char[] removeDuplicates (char[] arg) {
        LinkedHashSet<Character> mySet = new LinkedHashSet<Character>();
        for(char ch:arg){
            if(ch!=' ' && !mySet.contains(ch)){
                mySet.add(ch);
            }
        }
        char[] result = new char[mySet.size()];
        int count = 0;
        for(char ch:mySet){
            result[count] = ch;
            count++;
        }
        return result;
    }

    public static void wordCount(String str){
        String[] words = str.split("[\\s@.,?! ]+");
        LinkedHashMap<String, Integer> myMap = new LinkedHashMap<String, Integer>();
        for(String wd : words){
            String word = wd.toLowerCase(Locale.ROOT);
            if(myMap.containsKey(word)){
                myMap.put(word, myMap.get(word)+ 1);
            }
            else myMap.put(word, 1);
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> mapElement : myMap.entrySet()){
            sb.append(mapElement.getKey() +"," + mapElement.getValue().toString() + "\n");
        }
        System.out.println(myMap);
        System.out.println(sb);
    }

    public static void seriesSum(int[] arg){
        int size = arg.length;
        int result = 0;
        for(int i=0;i<size;i+=2){
            int mul;
            if((i == size - 1) && (i%2==0)){
                mul = arg[i]*1;
            }
            else { mul =  arg[i]*arg[i+1]; }
            result = (i%4 == 2) ? result-mul : result+mul;
        }
        System.out.println(result);
    }
}
