package com.sheikhimtiaz.basicpractice;

public class LinkedListFromArray {

    static class Node {
        int data;
        Node next;
    }

    static Node insert (Node root, int item) {
        Node newItem = new Node();
        newItem.data = item;
        newItem.next = null;
        Node ptr;
        if(root == null) root = newItem;
        else {
            ptr = root;
            while(ptr.next != null){
                ptr = ptr.next;
            }
            ptr.next = newItem;
        }
        return root;
    }

    static void display(Node root) {
        while(root != null){
            System.out.print(root.data + " "); root = root.next;
        }
    }

    static Node arrayToLinkedList(int[] arr, int n) {
        Node root = null;
        for(int i=0;i<n;i++) {
            root = insert(root, arr[i]);
        }
        return root;
    }

    public static void run() {
        int arr[] = { 1, 2, 3, 4, 5 };
        int n = arr.length;
        Node root = arrayToLinkedList(arr, n);
        display(root);
    }
}
