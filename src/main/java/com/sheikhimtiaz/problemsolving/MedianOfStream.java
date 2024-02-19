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
class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class MergeIntervalSolution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) {
            return mergedIntervals;
        }
        // Sort the intervals based on start times
        intervals.sort(Comparator.comparingInt(i -> i.start));
        Interval prevInterval = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval currentInterval = intervals.get(i);
            // If there is an overlap, merge the intervals
            if (currentInterval.start <= prevInterval.end) {
                prevInterval.end = Math.max(prevInterval.end, currentInterval.end);
            } else {
                // If no overlap, add the previous interval to the result list
                mergedIntervals.add(prevInterval);
                prevInterval = currentInterval;
            }
        }
        // Add the last interval to the result list
        mergedIntervals.add(prevInterval);
        return mergedIntervals;
    }
    public static void printIntervalList(List<Interval> mergedIntervals) {
        for (Interval interval : mergedIntervals) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
        }
    }
}
