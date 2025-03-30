package com.sheikhimtiaz.problemsolving;

import java.util.*;

public class MedianOfStream {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianOfStream() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void insertNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.offer(num);
        else
            minHeap.offer(num);

        // Balance the heaps
        if (maxHeap.size() > minHeap.size() + 1){
            minHeap.offer(maxHeap.poll());
        }
        else if (minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else
            return maxHeap.peek();
    }
}

