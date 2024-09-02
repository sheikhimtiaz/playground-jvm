package com.sheikhimtiaz.interview;

import java.util.List;

public class ZalandoPractice {

    public static void run() {
        System.out.println(findMaxStudentsToScheduleInDays(List.of("01","123", "01234456789","4","5","6", "5","5"), 2));

        
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
