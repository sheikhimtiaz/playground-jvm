package com.sheikhimtiaz.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GoogleOnlineChallenge {


    public static void run() {
//        System.out.println(maxOperationOfReducingOne(5,6,7)); // not expected output
//        System.out.println(maxOperationOfReducingOne(2,3,4)); // not expected output
        //
        parcels();
    }

    private static void parcels(){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int testCase = 0; testCase < T; testCase++) {
            int R = scanner.nextInt();
            int C = scanner.nextInt();
            int[][] deliveryOffices = new int[R][C];

            for (int row = 0; row < R; row++) {
                String line = scanner.next();
                for (int col = 0; col < C; col++) {
                    deliveryOffices[row][col] = line.charAt(col) - '0'; // converts char to int
                }
            }

            System.out.println("Case #" + testCase + ": " + minimumDeliveryTime(deliveryOffices));
        }
    }

    private static int minimumDeliveryTime(int[][] deliveryOffices) {
        // TODO: solve for and return the minimum overall delivery time you can get
        // by building at most one new delivery office
        int r = deliveryOffices.length;
        int c = deliveryOffices[0].length;

        int[][] weight = new int[r][c];
        int max = Integer.MIN_VALUE;
        int maxX=-1, maxY=-1;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                weight[i][j] = getWeight(deliveryOffices, i, j);
                if(max < weight[i][j]){
                    max = weight[i][j]; maxX = i; maxY = j;
                }
            }
        }
        deliveryOffices[maxX][maxY] = 1;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                weight[i][j] = getWeight(deliveryOffices, i, j);
                if(max < weight[i][j]){
                    max = weight[i][j]; maxX = i; maxY = j;
                }
            }
        }

        return max;
    }

    private static int getWeight(int[][] deliveryOffices, int i, int j){
        int r = deliveryOffices.length;
        int c = deliveryOffices[0].length;
        if(i>= r || j>=c || i<0 || j<0) return Integer.MAX_VALUE;

        if(deliveryOffices[i][j] == 1) return 0;

        return Math.min(1 + Math.min(Math.min(getWeight(deliveryOffices, i-1, j), getWeight(deliveryOffices,i,j-1)),
                Math.min(getWeight(deliveryOffices, i+1, j), getWeight(deliveryOffices,i, j+1))),
                2 + Math.min(Math.min(getWeight(deliveryOffices, i-1, j-1), getWeight(deliveryOffices,i+1,j-1)),
                        Math.min(getWeight(deliveryOffices, i-1, j+1), getWeight(deliveryOffices,i+1, j+1))));
    }


    private static long maxOperationOfReducingOne(long a, long b, long c){
        // NOT_SOLVED_YET
        long result=0;
        if(a==b) return a;
        if(c==b) return b;
        if(a==c) return c;


//        return a + ( (c-a) < b ? c-a : b );
        return maxOperationOfReducingOneRecursive(a,b,c);
    }


    private static long maxOperationOfReducingOneRecursive(long a, long b, long c){
        if(a==0 && b==0 || b==0 && c==0 || a==0 && c==0) return 0;

        if(a>b){
            long temp = a;
            a = b;
            b = temp;
        }
        if(b>c){
            long temp = c;
            c = b;
            b = temp;
        }
        if(a>c){
            long temp = a;
            a = c;
            c = temp;
        }
        return 1+maxOperationOfReducingOneRecursive(a,b-1,c-1);
    }


}
