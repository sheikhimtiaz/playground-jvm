package com.sheikhimtiaz.basicpractice;

public class SamplePracticeProblem {

    public static void run() {
//        int[] arr1 = {1,2,4,7,8};
//        int[] arr2 = {3,5,6,9,14};
//        FoobarChallenge.printArray(mergeTwoSortedArray(arr1,arr2));
//
//        // Create an array
//        String[] array = {"apple", "banana", "orange"};
//        // Convert the array to list
//        List<String> list = Arrays.asList(array);
//        // Print the list
//        System.out.println("List: " + list);
//
//
//        int[] intArray = {1, 2, 3, 4, 5};
//        // Convert the int array to List<Integer>
//        List<Integer> intList = IntStream.of(intArray).boxed().collect(Collectors.toList());
//        // Print the list
//        System.out.println("List: " + intList);
//        mergeKLists();

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        if(lists.length == 1) return lists[0];
        for(ListNode list: lists){
            result = mergeKListsHelper(result, list);
        }
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
        return result;
    }
    public static ListNode mergeKListsHelper(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        ListNode l1Node = list1;
        ListNode l2Node = list2;

        while (l1Node != null && l2Node != null) {
            if (l1Node.val < l2Node.val) {
                current.next = l1Node;
                l1Node = l1Node.next;
            } else {
                current.next = l2Node;
                l2Node = l2Node.next;
            }
            current = current.next;
        }

        if (l1Node != null) {
            current.next = l1Node;
        } else {
            current.next = l2Node;
        }

        return dummy.next;
    }
    public static int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {
        int i=0, j=0, index = 0;
        int[] res = new int[arr1.length + arr2.length];
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] <= arr2[j]){
                res[index] = arr1[i]; index++; i++;
            } else {
                res[index] = arr2[j]; index++; j++;
            }
        }
        while(i < arr1.length){
            res[index] = arr1[i]; index++; i++;
        }
        while(j < arr2.length){
            res[index] = arr2[j]; index++; j++;
        }
        return res;
    }
}


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }