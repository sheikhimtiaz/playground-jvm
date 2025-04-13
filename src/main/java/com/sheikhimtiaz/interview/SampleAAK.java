package com.sheikhimtiaz.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//PrampPractice
public class SampleAAK {

    public static void run() {
        Solution.BinarySearchTree bst = new Solution.BinarySearchTree();
        bst.insert(20);
        bst.insert(9);
        bst.insert(25);
        bst.insert(5);
        bst.insert(12);
        bst.insert(11);
        bst.insert(14);

        int result = bst.findLargestSmallerKey(17);
        System.out.println("Largest smaller number is " + result);


        Solution.BinarySearchTree tree = new Solution.BinarySearchTree();
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        Solution.Node root = tree.sortedArrayToBST(arr, 0, n - 1);
        System.out.println("Preorder traversal of constructed BST");
        tree.preOrder(root);
        System.out.println("\nInorder traversal of constructed BST");
        tree.inOrder(root);


//        Foobar.printArray(spiralCopy(new int[][]
//                {
//                        {1,    2,   3,  4,    5},
//                        {6,    7,   8,  9,   10},
//                        {11,  12,  13,  14,  15},
//                        {16,  17,  18,  19,  20}
//                }));
    }

    static int[] spiralCopy(int[][] inputMatrix) {
        int[] result = new int[inputMatrix.length * inputMatrix[0].length];
        int resultIndex = 0;
        int i=0, j=0;
        int iter = 0;
        int fullIter = 0;
        List<List<Integer>> incrementer = new ArrayList();
        incrementer.add(Arrays.asList(0,1));
        incrementer.add(Arrays.asList(1,0));
        incrementer.add(Arrays.asList(0,-1));
        incrementer.add(Arrays.asList(-1,0));
        int count = 0;
        while(resultIndex < (inputMatrix.length * inputMatrix[0].length)) {
            int currItem = inputMatrix[i][j];
            result[resultIndex] = currItem; resultIndex++; count++;
            if( (iter == 0 && count == (inputMatrix[0].length-2*fullIter))
            || (iter == 2 && count == (inputMatrix[0].length-1-2*fullIter))
            || (iter == 1 && count == (inputMatrix.length-1-2*fullIter))
            || (iter == 3 && count == (inputMatrix.length-2-2*fullIter)) ){
                iter++;
                count = 0;
                if(iter == 4) {
                    iter = 0; fullIter++;
                }
            }
            i = i + incrementer.get(iter).get(0);
            j = j + incrementer.get(iter).get(1);

        }
        return result;
    }

    static class Solution {

        static class Node {
            int key;
            Node left;
            Node right;
            Node parent;

            Node(int key) {
                this.key = key;
                left = null;
                right = null;
                parent = null;
            }
        }

        static class BinarySearchTree {

            Node root;
            int findLargestSmallerKey(int num) {
                return findLargestSmallerKey(root, num);
            }
            int findLargestSmallerKey(Node root, int num) {
                if (root == null)
                    return -1;
                if (root.key == num)
                    return num;

                else if (root.key < num) {
                    int k = findLargestSmallerKey(root.right, num);
                    if (k == -1)
                        return root.key;
                    else
                        return k;
                }
                else if (root.key > num)
                    return findLargestSmallerKey(root.left, num);
                return -1;
            }

            Node sortedArrayToBST(int[] arr, int start, int end){
                if(start > end) return null;
                int mid = (start+end) / 2;
                Node newNode = new Node(arr[mid]);
                System.out.println("creating -> " + arr[mid]);
                newNode.left = sortedArrayToBST(arr, start, mid-1);
                newNode.right = sortedArrayToBST(arr, mid+1, end);
                return newNode;
            }

            void preOrder(Node node) {
                if(node == null) return;
                System.out.print(node.key + " ");
                preOrder(node.left);
                preOrder(node.right);
            }

            void inOrder(Node node) {
                if(node == null) return;
                preOrder(node.left);
                System.out.print(node.key + " ");
                preOrder(node.right);
            }

            void postOrder(Node node) {
                if(node == null) return;
                preOrder(node.left);
                preOrder(node.right);
                System.out.print(node.key + " ");
            }

            void insert(int key) {
                if(this.root == null) {
                    this.root = new Node(key);
                    return;
                }

                Node currentNode = this.root;
                Node newNode = new Node(key);

                while(currentNode != null) {
                    if(key < currentNode.key) {
                        if(currentNode.left == null) {
                            currentNode.left = newNode;
                            newNode.parent = currentNode;
                            break;
                        } else {
                            currentNode = currentNode.left;
                        }
                    } else {
                        if(currentNode.right == null) {
                            currentNode.right = newNode;
                            newNode.parent = currentNode;
                            break;
                        } else {
                            currentNode = currentNode.right;
                        }
                    }
                }
            }
        }

    }
}
