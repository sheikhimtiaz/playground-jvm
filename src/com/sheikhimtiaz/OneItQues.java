package com.sheikhimtiaz;

import java.util.*;

public class OneItQues {
    public static void run(){
//        wordCount("The fox, on the log");
//        int[] testCases = {4, 5, 3};
//        seriesSum(testCases);
//        learnKeywords();
        char[] chars = {'a','a','b'};
        removeDuplicates(chars);
    }



    public static void learnKeywords(){
        System.out.println("Start");
        LinkedHashMap<String, Integer> myMap = new LinkedHashMap<String, Integer>();
        assert myMap != null : "test";
        System.out.println("End");
    }

    public static void removeDuplicates (char[] arg) {
        LinkedHashSet<Character> mySet = new LinkedHashSet<Character>();
        for(char ch:arg){
            if(ch!=' '){
                mySet.add(ch);
            }
        }
        System.out.println(mySet);
        char[] result = new char[mySet.size()];
        int i = 0;
        for(Character c:mySet){
            result[i] = c; i++;
        }
        System.out.println(result);


        LinkedHashSet<Character>
                set = new LinkedHashSet<Character>();

        // Use add() method to add
        // elements into the LinkedHashSet
        set.add('a');
        set.add('a');
        set.add('b');
        set.add('b');
        set.add('c');

        // Displaying the LinkedHashSet
        System.out.println("The LinkedHashSet: "
                + set);

        // Creating the array and using toArray()
        Character[] arr = new Character[set.size()];
        arr = set.toArray(arr);

        // Displaying arr
        System.out.println("The arr[] is:");
        for (int j = 0; j < arr.length; j++)
            System.out.println(arr[j]);
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
