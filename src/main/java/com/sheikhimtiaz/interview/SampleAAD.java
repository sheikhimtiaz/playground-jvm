package com.sheikhimtiaz.interview;

import java.util.*;

//CodilityDemo
public class SampleAAD {


    public static void run(){
//        int[] myNum = {1, 3, 6, 4, 1, 2};
//        FirstReverse(myNum);
//        wordCount("Forget  CVs..Save time . x x");
//        int[] A = {100, 100, -10, -20, -30};
//        String[] D = {"2020-01-10", "2020-02-02", "2020-02-05", "2020-02-10", "2020-02-11"};
//        solution(A, D);
        photoArrange("photo.jpg, Warsaw, 2013-09-05 14:08:15\n"+
        "john.png, London, 2015-06-20 15:13:22\n"+
        "myFriends.png, Warsaw, 2013-09-05 14:07:13");
    }


    public static void photoArrange(String S) {
        StringBuilder result = new StringBuilder();
        String[] photoNames = S.split("\n");
        HashMap<String, ArrayList<String>> myMap = new HashMap<>();
        for(int i=0;i<photoNames.length;i++){
            String[] words = photoNames[i].split("[,]");
            if(myMap.containsKey(words[1])){
                myMap.get(words[1]).add(words[2]);
            } else myMap.put(words[1], new ArrayList<String>(Arrays.asList(words[2])));
        }
        System.out.println(myMap);
        for(Map.Entry<String, ArrayList<String>> mapElement : myMap.entrySet()){
            mapElement.getValue().sort(String::compareToIgnoreCase);
        }
        System.out.println(myMap);
        for(int i=0;i<photoNames.length;i++){
            String[] words = photoNames[i].split("[,]");
            String[] wds = photoNames[i].split("[., ]");
            String cityName = wds[3];
            String extension = wds[1];
            int serialN0 = 0;
            ArrayList<String> otherDates = myMap.get(" "+cityName);
            serialN0 = otherDates.indexOf(words[2]) + 1;
            String serialNumber = (otherDates.size() > 99 &&  serialN0 > 9) ? "00" + serialN0 :
                    ((otherDates.size() > 9 &&  serialN0 < 10) || (otherDates.size() > 99 &&  serialN0 < 100)) ? "0" + serialN0 : Integer.toString(serialN0);
            result.append(cityName+serialNumber+"."+extension+"\n");
        }
//        return result.toString();
        System.out.println(result);
    }

    public static void solution(int[] A, String[] D) {
        int result = 0;
        LinkedHashMap<String, ArrayList<Integer>> myMap = new LinkedHashMap <String, ArrayList<Integer>>();
        ArrayList<Integer> emptyArr = new ArrayList<Integer>();
        for(int i=1;i<=12;i++){
            myMap.put( i<10? "0"+i : Integer.toString(i), new ArrayList<Integer>());
        }
        for(int i=0; i<D.length; i++){
            String month = D[i].split("-")[1];
            if(myMap.containsKey(month)){
                myMap.get(month).add(A[i]);
            }
        }
        for(Map.Entry<String, ArrayList<Integer>> mapElement : myMap.entrySet()){
            int transactionCount = 0, monthlyPayment = 0;
            ArrayList<Integer> transactions = mapElement.getValue();
            if(transactions.size() == 0) {
                result = result - 5; continue;
            }
            for(int i=0; i<transactions.size(); i++){
                result = result + transactions.get(i);
                transactionCount++;
                if(transactions.get(i) < 0) monthlyPayment = monthlyPayment + transactions.get(i)*-1;
            }
            if(transactionCount < 3 || monthlyPayment < 100){
                result = result - 5; continue;
            }
        }
        System.out.println(result);

    }

    public static void wordCount(String sents){
//        String[] words = sents.split("[\\s@.,?! ]+");
        String[] sentences = sents.split("[.?!]+");
//        HashSet wordCount = new HashSet<Integer>();
        int wordCount = 0;
        for(int i=0;i<sentences.length;i++){
            System.out.println(sentences[i]);
            String[] wordsList = sentences[i].split(" ");
            int curr = 0;
            for(int j=0; j<wordsList.length;j++){
                if(wordsList[j].length() > 0){
                    curr++;
                }
            }
            if(curr > wordCount){
                wordCount = curr;
            }
        }
        System.out.println(wordCount);

    }


    public static void FirstReverse(int[] A) {
        HashSet mySet = new HashSet<Integer>(1000000);
        for(int i=0;i<A.length;i++){
            mySet.add(A[i]);
        }
        System.out.println(mySet);
        int result = 1;
        Iterator<Integer> i= mySet.iterator();
        while(i.hasNext())
        {
            int current = i.next();
            if( result < current){
                break;
            }
            else result = current + 1;
        }
    }


}
