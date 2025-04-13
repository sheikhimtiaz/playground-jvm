package com.sheikhimtiaz.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  tt**aasd*tt
//  klnnlknlkaasaasd

//GraalVMInternship
public class SampleAAF {

    public static void run(){
//       write your code here
//       matches(“haystack”, “haysta_k”) == true
//       matches(“haystack”, “haystac_k”) == false
//       matches(“hk”, “h*k”) == true
//       matches(“haystack”, “h*k*k”) == false
//       matches(“haaaaystack”, “*ack”) == true
//       matches(“haaaaystack”, “*aystack”) == true
//       matches(“haystack”, “*aystack”) == true
//       matches(“haystack”, “h**t*k”) == true
//       matches(“haystack”, “*ack**”) == true
        System.out.println(matches("haystack", "haysta_k"));
        System.out.println(matches("haystack", "haystac_k"));
        System.out.println(matches("hk", "h*k"));
        System.out.println(matches("haystack", "h*k*k"));
        System.out.println(matches("haaaaystack", "*ack"));
        System.out.println(matches("haaaaystack", "*aystack"));
        System.out.println(matches("haystack", "*aystack"));
        System.out.println(matches("haystack", "h**t*k"));
        System.out.println(matches("haystack", "*ack**"));
        System.out.println(matches("afagaghellosgaas", "hello"));
        System.out.println(matches("", ""));
    }


    public static boolean matches(String text, String pattern) {
        int textLen = text.length();
        int patternLen = pattern.length();

        if(textLen == 0 || patternLen == 0){
            return false;
        }

        String[] patterns = pattern
                .replaceAll("\\*","-*-")
                .replaceAll("_","-_-")
                .split("-");
        List<String> list = new ArrayList<String>(Arrays.asList(patterns));
        list.removeAll(Arrays.asList("", null));
        System.out.println(list);

        if(list.size() == 0){
            return true;
        }

        int positionOfText = 0;
        int record = 0;
        boolean arbitratyExists = false;
        for(int i=0;i<list.size();i++){
            String nowCheck = list.get(i);
            int checkLen = nowCheck.length();
            if(nowCheck.equalsIgnoreCase("*")){
                record++;
                arbitratyExists = true;
                continue;
            }
            if(nowCheck.equalsIgnoreCase("_")){
                record++;
                positionOfText++;
                arbitratyExists = false;
                continue;
            }
            while(positionOfText < textLen && (positionOfText + checkLen - 1) < textLen){
                String substr = text.substring(positionOfText, positionOfText + checkLen);
                if(substr.equalsIgnoreCase(nowCheck)){
                    record++;
                    arbitratyExists = false;
                    positionOfText = positionOfText + checkLen;
                    break;
                }
                else if(arbitratyExists){
                    positionOfText++;
                }
                else {
                    return false;
                }
            }
        }

        return record == list.size() && positionOfText == textLen;
    }


}
