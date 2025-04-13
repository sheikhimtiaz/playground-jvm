package com.sheikhimtiaz.interview;

import java.util.*;

//ZalandoPractice
public class SampleAAP {

    public static void run() {
//        System.out.println(findMaxStudentsToScheduleInDays(List.of("01","123", "01234456789","4","5","6", "5","5"), 2));
//
//        LRUCache<String, Integer> cache = new LRUCache<>(3);
//        cache.add("one", 1);
//        cache.add("two", 2);
//        cache.add("three", 3);
//        System.out.println("Get two: " + cache.get("two"));
//        System.out.println("Get one: " + cache.get("one"));
//        System.out.println("Get one: " + cache.get("one"));
//        System.out.println("Get three: " + cache.get("three"));
//        System.out.println("Get three: " + cache.get("three"));
//        cache.add("four", 4);
//        cache.print();

//        System.out.println(strWithout3a3b(0,0));
//        System.out.println(strWithout3a3b(0,2));
//        System.out.println(strWithout3a3b(2,0));
//        System.out.println(strWithout3a3b(1,4));
//        System.out.println(strWithout3a3b(5,5));

//        System.out.println(taskSchedulerII(new int[]{1,2,1,2,3,1},3));
//        System.out.println(taskSchedulerII(new int[]{5,8,8,5},2));

//        System.out.println(longestCommonSubsequence("abcde","bace"));
//        System.out.println(longestCommonSubsequence("abc","def"));
//        System.out.println(longestCommonSubsequence("abc",""));
//        System.out.println(longestCommonSubsequence("abc","abc"));

//        List<Integer> list = List.of(-1,0,1,2);
//        List<Integer> list2 = List.of(-4,-1,1,2,3,4,5);
//        System.out.println(squareList(list));
//        System.out.println(squareList(list2));

        int[] arr = new int[]{-9,0,3,10};
        char[] charr = new char[]{'a','b','c','d','e'};
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(sortedSquares(arr)));
        int[] arr2 = new int[]{-7,-3,2,3,11};
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(sortedSquares(arr2)));
//        System.out.println(Arrays.toString(charr));
    }

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;
        int index = n - 1;
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            System.out.println("leftSquare: " + leftSquare + ", rightSquare: " + rightSquare);
            if(leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            } else {
                result[index] = rightSquare;
                right--;
            }
            index--;
        }
        return result;
    }

    public static List<Integer> squareList(List<Integer> list) {
        return list.stream().map(item-> item*item).sorted().toList();
//        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//
//        }
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] result = new int[m + 1][n + 1];
        for (int i = 0; i <= text1.length(); i++) {
            for (int j = 0; j <= text2.length(); j++) {
                if (i == 0 || j == 0) {
                    result[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }
        return result[m][n];
    }

    public static int longestCommonSubsequenceRec(String text1, String text2) {
        if(text1 == null || text2 == null) return 0;
        if(text1.isEmpty() || text2.isEmpty()) return 0;
        if((text1.charAt(0) == text2.charAt(0))) return 1 + longestCommonSubsequence(text1.substring(1), text2.substring(1));
        else return Integer.max(longestCommonSubsequence(text1, text2.substring(1)),
                longestCommonSubsequence(text1.substring(1), text2));
    }

    public static long taskSchedulerII(int[] tasks, int space) {
        long currIndex = 0;
        LinkedHashMap<Integer, Long> cache = new LinkedHashMap<>();
        for (int i=0; i<tasks.length; i++) {
            System.out.println("Start - " + currIndex);
            int task = tasks[i];
            if(cache.containsKey(task)) {
                long lastIndex = cache.get(task);
                long diff = currIndex - lastIndex - 1;
                if(diff<space) {
                    currIndex += (space - diff);
                    cache.put(task, currIndex++);
                } else { currIndex++; cache.put(task, currIndex); }
            } else {
                cache.put(task, currIndex); currIndex++;
            }
            System.out.println("END - " + currIndex);
        }
        return currIndex;
    }

    public static String strWithout3a3b(int a, int b) {
        if(a<=0 && b<=0) return "";
        else if(a<=0) return "b".repeat(b);
        else if(b<=0) return "a".repeat(a);
        else {
            StringBuilder sb = new StringBuilder();
            while(a>0 || b>0) {
                if(sb.length()>=2 && (sb.charAt(sb.length()-1) == sb.charAt(sb.length()-2))){
                    if(sb.charAt(sb.length()-1) == 'a'){
                        sb.append('b'); b--;
                    } else { sb.append('a'); a--; }
                } else {
                    if(a>=b){
                        sb.append('a'); a--;
                    } else { sb.append('b'); b--; }
                }
            }
            return sb.toString();
        }
    }

    public static int findMaxStudentsToScheduleInDays(List<String> students, int numberOfDays){
        int answer = 0;
        for(int i=0; i<10; i++){
            answer = Integer.max(answer, findStudents(students, i, -1));
            for(int j=0; j<10; j++){
                if(i != j ){
                    answer = Integer.max(answer, findStudents(students, i, j));
                }
            }
        }
        return answer;
    }

    public static int findStudents(List<String> students, int first, int second){
        int answer = 0;
        for(String s : students){
            for(Character c : s.toCharArray()){
                int day = c - '0';
                if(day == first || day == second){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
