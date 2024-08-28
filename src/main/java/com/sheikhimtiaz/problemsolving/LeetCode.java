package com.sheikhimtiaz.problemsolving;

import com.sheikhimtiaz.problemsolving.FoobarChallenge;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.*;
import java.util.stream.Collectors;

public class LeetCode {

    public static void run() {
//        int[] arr = {1,2,3};
//        System.out.println(distanceBetweenBusStops(arr,0,1));
//
//        System.out.println(numJewelsInStones("aA","aAAbbbbb"));

//        String[] tokens = {"2","1","+","3","*"};
//        System.out.println("evalRPN for \"2\",\"1\",\"+\",\"3\",\"*\" => " + evalRPN(tokens));

//        int[] nums = {1,2,3,1};
//        System.out.println(containsDuplicate(nums));

//        System.out.println(twoEggDrop(100));

//        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
//        System.out.println(maximalSquare(matrix));

//        System.out.println(isAnagram("anagram", "nagaram"));
//        System.out.println(isAnagram("rat", "car"));

//        String[] strs = {"eat","tea","tan","ate","nat","bat"};
//        System.out.println(groupAnagrams(strs));

//        int[] nums = {1,1,1,2,2,3}; int k = 2;
//        Foobar.printArray(topKFrequent(nums, k));

//        FoobarChallenge.printArray(productExceptSelf(new int[]{1,2,3,4}));
//        FoobarChallenge.printArray(productExceptSelf(new int[]{-1,1,0,-3,3}));

//        System.out.println(isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'}
//                ,{'6','.','.','1','9','5','.','.','.'}
//                ,{'.','9','8','.','.','.','.','6','.'}
//                ,{'8','.','.','.','6','.','.','.','3'}
//                ,{'4','.','.','8','.','3','.','.','1'}
//                ,{'7','.','.','.','2','.','.','.','6'}
//                ,{'.','6','.','.','.','.','2','8','.'}
//                ,{'.','.','.','4','1','9','.','.','5'}
//                ,{'.','.','.','.','8','.','.','7','9'}}));
//
//        System.out.println(isValidSudoku(new char[][]{{'8','3','.','.','7','.','.','.','.'}
//                ,{'6','.','.','1','9','5','.','.','.'}
//                ,{'.','9','8','.','.','.','.','6','.'}
//                ,{'8','.','.','.','6','.','.','.','3'}
//                ,{'4','.','.','8','.','3','.','.','1'}
//                ,{'7','.','.','.','2','.','.','.','6'}
//                ,{'.','6','.','.','.','.','2','8','.'}
//                ,{'.','.','.','4','1','9','.','.','5'}
//                ,{'.','.','.','.','8','.','.','7','9'}}));

//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(isPalindrome("race a car"));
//        System.out.println(isPalindrome(" "));
//        System.out.println(isPalindrome("0L"));

//        Foobar.printArray(twoSum(new int[]{2,7,11,15}, 9));
//        Foobar.printArray(twoSum(new int[]{3,2,4}, 6));

//        System.out.println(threeSumThatGivesTLE(new int[]{-1,0,1,2,-1,-4}));
//        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));

//        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));

//        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
//        System.out.println(trap(new int[]{4,2,0,3,2,5}));

//        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));

//        System.out.println(characterReplacement("ABAB", 2));

//        System.out.println(~5);
//        System.out.println(reverseWords("hello world"));
//        System.out.println(increasingTriplet(new int[]{2,1,5,1,4}));

//        System.out.println(reverseVowels("hello world"));
//        System.out.println(reverseVowels("leetcode"));
//        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
//        System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b','b','b'}));
//        System.out.println(maxOperations(new int[]{1,2,3,4}, 5));
//        System.out.println(maxOperations(new int[]{3,1,3,4,3}, 6));

//        System.out.println(longestOnes(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 2));
//        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
//        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
//        System.out.println(longestOnes(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1}, 2));
//        System.out.println(longestOnes(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0}, 2));
//        System.out.println(longestOnes(new int[]{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0}, 2));

//        System.out.println(maxVowels("abciiidef", 3));

//        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
//        System.out.println(pivotIndex(new int[]{1,2,3}));
//        System.out.println(pivotIndex(new int[]{2,1,-1}));
//        System.out.println(pivotIndex(new int[]{-1,-1,-1,-1,-1,0}));
//        System.out.println(pivotIndex(new int[]{-1,-1,-1,0,1,1}));
//        System.out.println(findMinimumPrice(Arrays.asList(1,2,3), 1));
//        int[][] arr = { {3, 3}, {5, -1}, {-2, 4} };
//        FoobarChallenge.printArray(kClosest(arr, 2));
//        System.out.println(partitionString("abacaba"));

//        MedianOfStream medianOfStream = new MedianOfStream();
//        medianOfStream.insertNum(3);
//        medianOfStream.insertNum(1);
//        System.out.println(medianOfStream.findMedian());
//        medianOfStream.insertNum(5);
//        System.out.println(medianOfStream.findMedian());
//        medianOfStream.insertNum(4);
//        System.out.println(medianOfStream.findMedian());

//        List<Interval> intervals = new ArrayList<>();
//        intervals.add(new Interval(1, 4));
//        intervals.add(new Interval(2, 5));
//        intervals.add(new Interval(7, 9));
//
//        MergeIntervalSolution solution = new MergeIntervalSolution();
//        List<Interval> mergedIntervals = solution.merge(intervals);
//        MergeIntervalSolution.printIntervalList(mergedIntervals);


//        System.out.println(shortestPath(new int[][]{new int[]{1,1,1,1},
//                new int[]{1,1,0,1},
//                new int[]{1,1,1,1},
//                new int[]{1,1,0,0},
//                new int[]{1,0,0,1}}, new int[]{0,1}, new int[]{2, 2}));

//        twoSumAlt(new int[]{1,5,6,11}, 11);

//        System.out.println(reverseWords("the sky is blue"));
//        for(int item: new int[]{2,7}){
//            switch (item) {
//                case 1 :
//                    System.out.println("1");
//                case 2:
//                    System.out.println("2");
//                case 3:
//                    System.out.println("4");
//                default:
//                    System.out.println("default");
//            }
//        }

//        int[] arr = {1,2,3};
//        List<Integer> list = new ArrayList<>();
//        System.out.println(list);

//        char[][] board = new char[][]{
//                new char[] {'X','X','X','X'},
//                new char[] {'X','O','O','X'},
//                new char[] {'X','X','O','X'},
//                new char[] {'X','O','X','X'},
//        };
//        surroundedRegions(board);

//        System.out.println(mergeAlternately("abcd","pq"));

        int[] arr = new int[]{1,2,1,2,3,1};
        System.out.println(taskSchedulerII(arr, 3));
        int[] arr2 = new int[]{5,8,8,5};
        System.out.println(taskSchedulerII(arr2, 2));
    }

    public static long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Integer> map = new HashMap<>();
        int curr = 0;
        for(int i=0; i<tasks.length; i++) {
            if(!map.containsKey(tasks[i])) {
                curr++;
            } else {
                int dist = Math.min((curr - map.get(tasks[i])), space);
                curr += space - dist + 1;
            }
            map.put(tasks[i], curr);
        }
        return curr;
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int minLen = Math.min(word1.length(), word2.length());
        for(int i=0;i<minLen;i++){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if(word1.length() > minLen) sb.append(word1.substring(minLen));
        else sb.append(word2.substring(minLen));
        return  sb.toString();
    }
    public static void surroundedRegions(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++){
                if(i==0 || i==board.length-1 || j==0 || j==board[0].length-1) {
                    markSafe(board, visited, i, j);
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 'S') board[i][j] = 'O';
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void markSafe(char[][] board, boolean[][] visited, int i, int j){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return;
        if(!visited[i][j]) {
            visited[i][j] = true;
            if(board[i][j] == 'O') {
                board[i][j] = 'S';
                markSafe(board, visited, i+1, j);
                markSafe(board, visited, i, j+1);
                markSafe(board, visited, i-1, j);
                markSafe(board, visited, i, j-1);
            }
        }
    }
    public static String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int gcdLength = gcd(len1, len2);
        String potentialDivisor = str1.substring(0, gcdLength);
        if (checkDivides(str1, potentialDivisor) && checkDivides(str2, potentialDivisor)) {
            return potentialDivisor;
        } else {
            return "";
        }
    }

    // Helper method to find the greatest common divisor
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Helper method to check if a string divides another string
    private static boolean checkDivides(String s, String divisor) {
        int len = s.length();
        int divisorLen = divisor.length();
        if (len % divisorLen != 0) return false;
        for (int i = 0; i < len; i += divisorLen) {
            if (!s.substring(i, i + divisorLen).equals(divisor)) {
                return false;
            }
        }
        return true;
    }
    public static int partitionString(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char c:chars){
            if(set.contains(c)){
                result++;
                set = new HashSet<>();
                set.add(c);
            } else set.add(c);
        }
        return set.isEmpty() ? result : result + 1;
    }
    public static int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) ->
                Integer.compare( (b[0]*b[0] + b[1]*b[1]) , (a[0]*a[0] + a[1]*a[1])) );
        for(int[] point: points) {
            q.add(point);
            if(q.size() > k){
                q.remove();
            }
        }
        for(int i=0;i<k;i++){
            int[] curr = q.poll();
            ans[i][0] = curr[0];
            ans[i][1] = curr[1];
        }
        return ans;
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[j].length;j++){
                if(grid[i][j] > -1) {
                    int currArea = maxAreaOfIslandHelper(i, j, grid);
                    result = Math.max(currArea, result);
                }
            }
        }
        return result;
    }

    private static int maxAreaOfIslandHelper(int i, int j, int[][] grid) {
        if(i<0 || j< 0 || i>(grid.length-1) || j>(grid[i].length-1)) return 0;
        if(grid[i][j] == -1) return 0;
        int temp = grid[i][j];
        grid[i][j] = -1;
        if(temp == 0) return 0;
        else return 1 + maxAreaOfIslandHelper(i+1, j, grid)
                + maxAreaOfIslandHelper(i, j+1, grid)
                + maxAreaOfIslandHelper(i-1, j, grid)
                + maxAreaOfIslandHelper(i, j-1, grid);
    }


    // complete the following function findMinimumPrice in the editor
    // the function accepts following parameters
    // int price[n]: price of each item
    // int m: the number of discount coupons
    // the discount coupons works like this, price after discount is = floor(price / 2 ^ discount_coupon_used)
    // the function must return an int denoting the minimum price after discount
    // use discounts on items distributed in a way that minimizes the price after discount of all items of the arrray
    // return int: the minimum price after discount
    public static int findMinimumPrice(List<Integer> price, int m) {
        // write your code here
        int result = 0;
        int len = price.size();
        Collections.sort(price, Collections.reverseOrder());
        for(int i=0;i<len;i++){
            if(m>0) {
                int temp = biggestPowerOfTwo(price.get(i));
                result += Math.floor(price.get(i) / Math.pow(2, temp));
                m = m - temp;
            }
            else result += price.get(i);

        }
        return result;
    }

    // write a function that will return the biggest power of 2 that is less than or equal to the given number
    public static int biggestPowerOfTwo(int n) {
        int result = 0;
        while(n>0){
            n = n/2;
            result++;
        }
        return result;
    }




    public static int pivotIndex(int[] nums) {
        int leftSum=0, rightSum=0;
        int sum = Arrays.stream(nums).sum();
        for(int i=0;i<nums.length;i++){
            rightSum = sum - leftSum - nums[i];
            if(leftSum == rightSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }

    public static int maxVowels(String s, int k) {
        int len = s.length();
        if(len < k) return 0;
        int vowelCount = countVowelsInString(s.substring(0,k));
        int result = vowelCount;
        for(int i=k;i<len;i++){
            if(isVowel(s.charAt(i-k))) vowelCount--;
            if(isVowel(s.charAt(i))) vowelCount++;
            if(vowelCount > result) result = vowelCount;
        }
        return result;
    }

    public static int countVowelsInString(String s) {
        System.out.println("first " + s);
        int result = 0;
        for(int i=0;i<s.length();i++){
            if(isVowel(s.charAt(i))) result++;
        }
        return result;
    }

    public static int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, n = nums.length;
        while (right < n) {
            if (nums[right++] == 0) k--;
            if (k < 0) {
                if (nums[left] == 0) k++;
                left++;
            }
        }
        return right - left;
    }

    public static int maxOperations(int[] nums, int k) {
        int total = 0, start=0, end=nums.length-1;
        Arrays.sort(nums);
        while(start<end){
            if(nums[start] + nums[end] == k){
                start++; end--; total++;
            }
            else if(nums[start] + nums[end] < k) {
                start++;
            }
            else end--;
        }
        return total;
    }

    public static int compress(char[] chars) {
        int len = chars.length;
        int strike = 1, index = 1;
        if(len == 1) return 1;
        for(int i=1;i<len;i++){
            if(chars[i]==chars[i-1]){
                strike++;
            }
            else if(chars[i]!=chars[i-1] && strike!=1){
                for(char c:String.valueOf(strike).toCharArray()){
                    chars[index++] = c;
                }
                chars[index++] = chars[i];
                strike = 1;
            }
            else {
                chars[index++] = chars[i];
            }
        }
        if(strike > 1){
            for(char c:String.valueOf(strike).toCharArray()){
                chars[index++] = c;
            }
        }
        FoobarChallenge.printArrayChar(chars);
        return index;
    }

    public static String reverseVowels(String s) {
        int len = s.length();
        char[] str = s.toCharArray();
        FoobarChallenge.printArrayChar(str);
        int start=0, end=len-1;
        while(start<end){
            if(!isVowel(str[start])) start++;
            else if(!isVowel(str[end])) end--;
            else {
                System.out.println(str[start] + " " + str[end]);
                char c = str[start];
                str[start] = str[end];
                str[end] = c;
                start++;
                end--;
            }
        }
        return new String(str);
    }

    public static boolean isVowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' ||
                c=='A' || c=='E' || c=='I' || c=='O' || c=='U') return true;
        else return false;
    }

    public static boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            System.out.println(min + " " + secondMin + " " + num);
            if (num <= min) {
                min = num;
            } else if (num <= secondMin) {
                secondMin = num;
            } else {
                System.out.println(min + " " + secondMin + " " + num);
                return true;
            }
        }
        return false;
    }

    public static String reverseWords(String s) {
        return Arrays.stream(s.split(" ")).filter(item-> !item.isEmpty())
                .reduce("", (res, elem)-> elem + " " + res).trim();
    }

    public static int characterReplacement(String s, int k) {
        int result=0;
        int[] arr = new int[26];
        int i=0, max=0;
        for(int j=0;j<s.length();j++){
            arr[s.charAt(j) - 'A']++;
            max = Math.max(max, arr[s.charAt(j) - 'A']);
            if(j-i+1-max > k) {
                arr[s.charAt(i)-'A']--;
                i++;
            }
            result = Math.max(result, j-i+1);
        }
        return result;
    }

    public static int maxProfit(int[] prices) {
        int result = 0, len = prices.length, minPrice = Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            minPrice = Math.min(minPrice, prices[i]);
            result = Math.max(result, prices[i]-minPrice);
        }
        return result;
    }

    public static int trap(int[] height) {
        int result = 0;
        int heightSize = height.length;
        List<Integer> leftMax = new ArrayList<>(heightSize);
        List<Integer> rightMax = new ArrayList<>(heightSize);
        int tempMax = 0;
        leftMax.add(0);
        rightMax.add(0);
        for(int i=1;i<heightSize;i++){
            leftMax.add(Math.max(tempMax, height[i-1]));
            tempMax = Math.max(tempMax, height[i-1]);
        }
        tempMax = 0;
        for(int i=heightSize-2;i>=0;i--){
            rightMax.add(Math.max(tempMax, height[i+1]));
            tempMax = Math.max(tempMax, height[i+1]);
        }
        for(int i=1;i<heightSize;i++){
            int temp = Math.min(leftMax.get(i), rightMax.get(heightSize-1-i)) - height[i];
            if(temp>0) result += temp;
        }
        return result;
    }

    public static int maxArea(int[] height) {
        int left=0, right=height.length-1, result = 0;
        while(left<right){
            result = Math.max(result, (right-left)*Math.min(height[left], height[right]));
            if(height[left]<height[right]) left++; else right--;
        }
        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int numSize = nums.length;
        for(int i=0;i<numSize-2;i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                List<List<Integer>> restTwo = twoSumAllCombination(nums, 0-nums[i], i+1, numSize);
                if(restTwo.size() > 0){
                    for(int j=0;j<restTwo.size();j++) {
                        result.add(Arrays.asList(nums[i], restTwo.get(j).get(0), restTwo.get(j).get(1)));
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSumSecond(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<nums.length-2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int target = 0 - nums[i];
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == target) {
                        res.add(Arrays.asList(i,nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return res;
    }
    public static List<List<Integer>> threeSumThatGivesTLE(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int end=nums.length-1;
        for(int start=0;start<end;start++){
            for(int i=start+1;i<end;i++){
                while(i<end){
                    if(nums[start] + nums[i] + nums[end] == 0){
                        res.add(Arrays.asList(nums[start], nums[i],nums[end]));
                    }
                    end--;
                }
                end = nums.length-1;
            }
        }
        return res.stream().distinct().collect(Collectors.toList());
    }

    public static List<Integer> twoSumForSortedList(List<Integer> numbers, int target) {
        return twoSumForSortedArray(numbers.stream().mapToInt(i->i).toArray(), target);
    }

    public static List<Integer> twoSumForSortedArray(int[] numbers, int target) {
        List<Integer> res = new ArrayList<>();
        int start=0, end=numbers.length-1;
        while(start<end){
            if(numbers[start] + numbers[end] == target){
                return Arrays.asList(numbers[start], numbers[end]);
            }
            if(numbers[start] + numbers[end] > target){
                end--;
            }
            if(numbers[start] + numbers[end] < target){
                start++;
            }
        }
        return res;
    }

    public static List<Integer> twoSum(int[] nums, int target) {
        return twoSum(nums, target, 0, nums.length);
    }

    public static List<Integer> twoSum(int[] nums, int target, int startIndex, int endIndex) {
        System.out.println("## two sum target "+target+" ##");
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for(int i=startIndex; i<endIndex; i++){
            if(myMap.containsKey(nums[i])){
//                return Arrays.asList(i, myMap.get(nums[i])); // for the index
                return Arrays.asList(nums[i], target-nums[i]); // for the value
            }
            System.out.println("checking -> " + nums[i] + "; saving -> " + (target-nums[i]));
            myMap.putIfAbsent(target-nums[i], i);
        }
        return new ArrayList<>();
    }
    public static List<List<Integer>> twoSumAllCombination(int[] nums, int target, int startIndex, int endIndex) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i=startIndex; i<endIndex; i++){
            if(myMap.containsKey(nums[i]) && myMap.get(nums[i]) == 1){
                result.add(Arrays.asList(nums[i], target-nums[i])); // for the value
                myMap.put(nums[i], 2);
            }
            myMap.putIfAbsent(target-nums[i], 1);
        }
        return result;
    }


    public static List<Integer> twoSumAlt(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        return result;
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> result = new ArrayList<>();
        for(int candy: candies) {
            max = Math.max(max, candy);
        }
        for(int candy: candies) {
            result.add(candy + extraCandies >= max);
        }
        return result;
    }



    public static int shortestPath(int[][] grid, int[] source, int[] destination) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(source);
        visited[source[0]][source[1]] = true;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                if (x == destination[0] && y == destination[1]) return distance;
                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1 && !visited[newX][newY]) {
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            distance++;
        }
        return -1;
    }

    public static int[] twoSumBruteforce(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length;j++){
                System.out.println(nums[i] + " ; " + nums[j]);
                if(nums[i]+nums[j] == target && i!=j){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    public static boolean isPalindromeFirst(String s) {
        String target = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        System.out.println(target);
        for(int i=0;i<target.length()/2;i++){
            if(target.charAt(i) != target.charAt(target.length()-1-i)) return false;
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1;
        while(start<end){
            if(!isAlphabetOrNumericChar(s.charAt(start))) {
                start++; continue;
            }
            if(!isAlphabetOrNumericChar(s.charAt(end))) {
                end--; continue;
            }
            if(isEqualInTermsOfPallindrome(s.charAt(start), s.charAt(end))) {
                start++; end--;
            }
            else return false;
        }
        return true;
    }

    private static boolean isEqualInTermsOfPallindrome(char a, char b){
        if((a>=48 && a<= 57) || (b>=48 && b<=57)) return a==b;
        if(a == b || a+32 == b || a==b+32) return true;
        return false;
    }

    public static boolean isAlphabetOrNumericChar(char c){
        if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>= '0' && c<='9')) return true;
        else return false;
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> mySet = new HashSet<>();
        for(int num: nums) mySet.add(num);
        int ans = 0;
        for(int num: nums){
            if(!mySet.contains(num-1)){
                int count = 1;
                while(mySet.contains(num+1)){
                    count++; num++;
                }
                if(count>ans) ans = count;
            }
        }
        return ans;
    }
    public static boolean isValidSudoku(char[][] board) {
        int rows = board.length, columns = board[0].length;
        for(int i=0;i<rows;i++){
            HashSet<Character> mySet = new HashSet<>();
            for(int j=0;j<columns;j++){
                if(board[i][j] == '.') continue;
                if(mySet.contains(board[i][j])) return false;
                mySet.add(board[i][j]);
            }
        }
        for(int i=0;i<rows;i++){
            HashSet<Character> mySet = new HashSet<>();
            for(int j=0;j<columns;j++){
                if(board[j][i] == '.') continue;
                if(mySet.contains(board[j][i])) return false;
                mySet.add(board[j][i]);
            }
        }
        for(int i=0;i<rows;i+=3){
            for(int j=0;j<columns;j+=3){
                if(!validBlock(i,j,board)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean validBlock(int x, int y, char[][] board){
        HashSet<Character> mySet = new HashSet<>();
        for(int i=x; i<x+3;i++){
            for(int j=y;j<y+3;j++){
                if(board[i][j] == '.') continue;
                if(mySet.contains(board[i][j])) return false;
                mySet.add(board[i][j]);
            }
        }
        return true;
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int product = 1;
        for(int i=0;i<nums.length;i++){
            result[i] = product;
            product = product * nums[i];
        }
        FoobarChallenge.printArray(result);
        product = 1;
        for(int i=nums.length-1;i>=0;i--    ){
            result[i] = result[i] * product;
            product = product * nums[i];
        }
        return result;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result;
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for(int num: nums){
            myMap.computeIfAbsent(num, i -> 0);
            myMap.put(num, myMap.get(num) + 1);
        }
        result = myMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(k).map(i -> i.getKey()).toList().stream().mapToInt(i->i).toArray();
        return result;
    }

    public static int[] topKFrequentBucket (int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for(int num: nums){
            myMap.computeIfAbsent(num, i -> 1);
            myMap.put(num, myMap.get(num) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(myMap::get));
        for(int val:myMap.keySet()){
            pq.add(val);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        for(int i=0;i<k;i++) {
            result[i] = pq.poll();
        }
        return result;
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] hash = new char[26];
            for (char c : s.toCharArray()) {
                hash[c - 'a']++;
            }
            String key = new String(hash);
            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.get(key).add(s);
        }
        res.addAll(map.values());
        return res;
    }


//    String s = "abs", t = "sba";
//    HashMap<Character,Integer> hm1 = new HashMap<>();
//    HashMap<Character,Integer> hm2 = new HashMap<>();
//        for(int i = 0; i<s.length(); i++) {
//        hm1.put(s.charAt(i),hm1.getOrDefault(s.charAt(i),0)+1);
//        hm2.put(t.charAt(i),hm2.getOrDefault(t.charAt(i),0)+1);
//    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] store = new int[26];
        for (int i = 0; i < s.length(); i++) {
            store[s.charAt(i) - 'a']++;
            store[t.charAt(i) - 'a']--;
        }
        for (int n : store) if (n != 0) return false;
        return true;
    }

    public static int maximalSquare(char[][] matrix) {
        int result = 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i=1;i<=matrix.length;i++){
            for(int j=1;j<=matrix[0].length;j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result * result;
    }


    public static int twoEggDrop(int n) {
        return (int) Math.ceil( Math.sqrt(2*n - .25) + 0.5 );
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> myHash = new HashSet<>();
        boolean result = false;
        for(int i=0;i<nums.length;i++){
            if(myHash.contains(nums[i])){
                result = true;
            }
            else myHash.add(nums[i]);
        }
        return result;
    }


    public static int evalRPN(String[] tokens) {
        if(tokens.length < 3) return Integer.parseInt(tokens[0]);
        else {
            List<String> allowedOps = Arrays.asList("+","-","*","/");
            Stack<String> mystack = new Stack<>();
            int pivot = 1;
            mystack.push(tokens[tokens.length - pivot++]);
            mystack.push(tokens[tokens.length - pivot++]);
            mystack.push(tokens[tokens.length - pivot++]);
            while(mystack.size() > 1){
                String first = mystack.pop();
                if(allowedOps.contains(first)){
                    mystack.push(first);
                    mystack.push(tokens[tokens.length - pivot++]);
                    mystack.push(tokens[tokens.length - pivot++]);
                }
                else {
                    String second = mystack.pop();
                    if(allowedOps.contains(second)){
                        mystack.push(second);
                        mystack.push(first);
                        mystack.push(tokens[tokens.length - pivot++]);
                    }
                    else {
                        int temp = exalRPNOps(mystack.pop(), Integer.parseInt(first), Integer.parseInt(second));
                        mystack.push(String.valueOf(temp));
                    }
                }
            }
            return Integer.parseInt(mystack.pop());
        }
    }

    public static int exalRPNOps(String act, int a, int b) {
        switch (act) {
            case "+": return a+b;
            case "-": return a-b;
            case "/": return a/b;
            case "*": return a*b;
            default: return 0;
        }
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int result = 0;
        LinkedHashSet<Character> linkedHashSet = new LinkedHashSet<>();
        for(int j=0;j<jewels.length();j++){
            if(!linkedHashSet.contains(jewels.charAt(j))){
                linkedHashSet.add(jewels.charAt(j));
            }
        }
        for(int i=0;i<stones.length();i++){
            if(linkedHashSet.contains(stones.charAt(i))){
                result++;
            }
        }
        return result;

    }
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int forward = 0, backward = 0;
        if(start>destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        for(int i=0;i<distance.length;i++){
            if(start <= i && i<destination){
                forward += distance[i];
            } else backward += distance[i];
        }
        return Math.min(forward, backward);
    }
}
