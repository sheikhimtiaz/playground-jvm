package com.sheikhimtiaz.datatypes;

import com.sheikhimtiaz.exceptions.InvalidIndexException;

public class MyHashMap<K, V> {
    private static final int ARRAY_SIZE = 16;
    private MyHashMapNode<K, V>[] nodeList = new MyHashMapNode[ARRAY_SIZE];

    void put(K key, V value) throws InvalidIndexException {
        long hashCode = this.getHashCode(key);
        int index = this.getIndex(hashCode);
        if (index > ARRAY_SIZE) {
            throw new InvalidIndexException("Invalid key, please check again!");
        }
        if (this.nodeList[index] != null) {
            MyHashMapNode<K, V> exitingNode = this.nodeList[index];
            while (exitingNode.getNext() != null) {
                exitingNode = exitingNode.getNext();
            }
            MyHashMapNode<K, V> newNode = new MyHashMapNode<>();
            newNode.setKey(key);
            newNode.setValue(value);
            newNode.setHashCode(hashCode);
            exitingNode.setNext(newNode);
        } else {
            MyHashMapNode<K, V> newNode = new MyHashMapNode<>();
            newNode.setKey(key);
            newNode.setValue(value);
            newNode.setHashCode(hashCode);
            this.nodeList[index] = newNode;
        }
    }

    private long getHashCode(K key) {
        return key.toString().hashCode();
    }
    private int getIndex(long hashCode) {
        return Math.toIntExact(hashCode % ARRAY_SIZE);
    }

    V get(K key) throws InvalidIndexException {
        long hashCode = this.getHashCode(key);
        int index = this.getIndex(hashCode);
        if (index > ARRAY_SIZE) {
            throw new InvalidIndexException("Invalid key("+key.toString()+"), please check again!");
        }
        if (this.nodeList[index] != null) {
            MyHashMapNode<K, V> exitingNode = this.nodeList[index];
            while (!compareValues(key, exitingNode.getKey()) && exitingNode.getNext() != null) {
                exitingNode = exitingNode.getNext();
            }
            if(compareValues(key, exitingNode.getKey()))
                return exitingNode.getValue();
            else throw new InvalidIndexException("Invalid key("+key.toString()+"), please check again!");
        } else {
            throw new InvalidIndexException("Invalid key("+key.toString()+"), please check again!");
        }
    }

    private boolean compareValues(K key1, K key2){
        return key1.toString().equals(key2.toString());
    }

    void remove(K key) {

    }

    public void printHashMap() {
        System.out.println("------------------My HashMap---------------------");
        int index = 0;
        while (index < ARRAY_SIZE) {
            MyHashMapNode<K, V> node = this.nodeList[index];
            if (node != null) {
                int listIndex = 0;
                while (node != null) {
                    if (listIndex > 0) {
                        System.out.print(" || ");
                    }
                    System.out.print(node.getKey().toString() + " -> ");
                    System.out.print(node.getValue().toString());
                    node = node.getNext();
                    listIndex++;
                }
                System.out.println("");
            }
            index++;
        }
    }

    public static void testHashMap(){
        MyHashMap<Integer, String> hashMap = new MyHashMap<>();

        try {
            hashMap.put(1, "One");
            hashMap.put(2, "Two");
            hashMap.put(21, "Twenty One");
            hashMap.put(22, "Twenty Two");
            hashMap.put(23, "Twenty Three");
            hashMap.put(256, "Two Hundred And Fifty Six");

            hashMap.printHashMap();
        } catch (InvalidIndexException e) {
            e.printStackTrace();
        }

        MyHashMap<String, String> stringHashMap = new MyHashMap<>();
        try {
            stringHashMap.put("One", "One");
            stringHashMap.put("Two", "Two");
            stringHashMap.put("Three", "Twenty One");
            stringHashMap.put("Four", "Twenty Two");
            stringHashMap.put("Five", "Twenty Three");
            stringHashMap.put("Six", "Two Hundred And Fifty Six");
            stringHashMap.printHashMap();
            System.out.println("Key Four -> " + stringHashMap.get("Four"));
            System.out.println("Key One -> " + stringHashMap.get("One"));
            System.out.println("Key Six -> " + stringHashMap.get("Six"));
            System.out.println("Key Tow -> " + stringHashMap.get("Tow"));
            System.out.println("Key Nine -> " + stringHashMap.get("Nine"));
            stringHashMap.remove("Six");
        } catch (InvalidIndexException e) {
            e.printStackTrace();
        }
    }
}

