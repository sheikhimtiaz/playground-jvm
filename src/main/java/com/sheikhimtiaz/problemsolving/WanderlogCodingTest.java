package com.sheikhimtiaz.problemsolving;

import java.util.*;

public class WanderlogCodingTest {
    public static void run() {
        List<String> tran =Arrays.asList("notebook","notebook", "mouse", "keyboard","mouse");
        System.out.println(groupTransactions(tran));
        List<String> res = Arrays.asList("30 99 sign-in", "30 105 sign-out", "12 100 sign-in", "20 80 sign-in", "12 120 sign-out", "20 101 sign-out", "21 110 sign-in");
        System.out.println(processLogs(res, 20));
    }

    private static List<String> processLogs(List<String> logs, int maxSpan) {
        List<String> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> signIn = new HashMap<>();
        HashMap<Integer, Integer> signOut = new HashMap<>();
        HashSet<Integer> userIds = new HashSet<>();
        for(String log: logs){
            String[] data = log.split(" ");
            Integer userId = Integer.parseInt(data[0]);
            Integer timestamp = Integer.parseInt(data[1]);
            userIds.add(userId);
            if("sign-in".equals(data[2])) {
                signIn.put(userId, timestamp);
            } else {
                signOut.put(userId, timestamp);
            }
        }
        for(Integer userId: userIds) {
            if(signIn.containsKey(userId) && signOut.containsKey(userId)) {
                int val = signOut.get(userId) - signIn.get(userId);
                if(val <= maxSpan) pq.add(userId);
            }
        }
        while(!pq.isEmpty()) {
            res.add(String.valueOf(pq.poll()));
        }
        return res;
    }
    private static List<String> groupTransactions(List<String> transactions) {
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String trans: transactions) {
            map.computeIfAbsent(trans, i-> 0);
            map.put(trans, map.get(trans)+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b)-> {
            int val = b.getValue().compareTo(a.getValue());
            return val == 0 ? a.getKey().compareTo(b.getKey()) : val;
        });
        pq.addAll(map.entrySet());
        while (!pq.isEmpty()) {
            Map.Entry<String, Integer> entry = pq.poll();
            res.add(entry.getKey() + " " + entry.getValue());
        }
        return res;
    }
    private static List<String> aPlusB(List<String> lines) {
        List<String> res = new ArrayList<>();
        for(String line: lines){
            String[] numbers = line.split(" ");
            int num1 = Integer.parseInt(numbers[0]);
            int num2 = Integer.parseInt(numbers[1]);
            res.add(String.valueOf(num1 + num2));
        }
        return res;
    }
}
