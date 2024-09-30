package com.sheikhimtiaz.problemsolving;

import java.util.*;

public class FacebookHackerCup {

    public static void run(){
        testConsistency();
    }

    private static void testConsistency(){
        String[] arr = {
                "ABC",
                "F",
                "BANANA",
                "FBHC",
                "FOXEN",
                "CONSISTENCY",
                "HAAACKEEERCUUUP",
                "OOEUEUIUUOOAUEIOIEEUIAIUAUOOAUUIIEUUOAAIOAEAUEIAOAOOAOOAAIEOAEOEIOIAAEAAIOEEOIIIEEIOIUEIEEEAAEEEEOAA",
                "QPQWJXRJJXBTKKGBKVXNSCQBHZTSFZRYCDZFYQJQWHWHYJVDRXSGWRLJNTHBXYBRBTVXBBPPCXRBFVXVNDQQTHHBKXZDPQZGSHWF",
                "EDHHDGFGCFHBHCAFGHHCBDHHECAEGGAGAGDGEGGFDGBCDFDCBHFGBDBCGHEACCGFAGEFBFGECFGFCGGBEDGDBFCEHEDHEHHFGCEB"
        };
        int i = 1;
        for(String str:arr){
            System.out.println("Case #"+i+": "+consistency(str)); i++;
        }
    }

    static int[] getIndicesOfItemWeights(int[] arr, int limit) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < arr.length; i++){
            if(!map.containsKey(limit - arr[i])){
                map.put(arr[i], i);
            } else {
                result[0] = i;
                result[1] = map.get(limit-arr[i]);
                return result;
            }
        }
        return result;
    }

    private static int consistency(String input){
        int result = 0;
        if(input.length() <= 1){
            return 0;
        }
        String[] str = input.split("");
        Set<String> vowels = new HashSet<>();
        vowels.add("A");
        vowels.add("E");
        vowels.add("I");
        vowels.add("O");
        vowels.add("U");
        LinkedHashMap<String, Integer> distinctVow = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> distinctConst = new LinkedHashMap<>();
        int vowCount = 0, constCount = 0;
        int maxVowOccurance = 0, maxConstOccurance = 0;
        for(String ch : str){
            if(vowels.contains(ch)){
                if(distinctVow.containsKey(ch)) distinctVow.put(ch, distinctVow.get(ch) + 1);
                else distinctVow.put(ch, 1);
                vowCount++;
                if(distinctVow.get(ch) > maxVowOccurance) maxVowOccurance = distinctVow.get(ch);
            }
            else {
                if(distinctConst.containsKey(ch)) distinctConst.put(ch, distinctConst.get(ch) + 1);
                else distinctConst.put(ch, 1);
                constCount++;
                if(distinctConst.get(ch) > maxConstOccurance) maxConstOccurance = distinctConst.get(ch);
            }
        }
        int v = distinctVow.size(), c = distinctConst.size();
        if(v == 0 || c == 0 || v == 1 || c == 1) return v == 0 || v == 1 ? constCount : vowCount;
        result = v < c ? ( (vowCount-maxVowOccurance)*2 + constCount ) : ( vowCount + (constCount - maxConstOccurance)*2 );
        return result;
    }


}
