package com.sheikhimtiaz.problemsolving;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeIntervalSolution {
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

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
