package dataStructures.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        Interval[] arr = new Interval[] {
                                        new Interval(1, 5),
                                        new Interval(2, 3),
                                        new Interval(4, 6),
                                        new Interval(7, 8),
                                        new Interval(8, 10),
                                        new Interval(12, 15)
        };
        mergeIntervals(arr);
    }


    private static void mergeIntervals(Interval[] intervals) {
        Stack<Interval> stack = new Stack<>();
        //  {1, 5}, {2, 3}, {4, 6}, {7, 8}, {8, 10}, {12, 15}
        // do for each interval
        for (Interval curr: intervals)
        {
            // if the stack is empty or the top interval in the stack does not overlap
            // with the current interval, push it into the stack
            if (stack.empty() || curr.start > stack.peek().end) {
                stack.push(curr);
                continue;
            }

            // if the top interval of the stack overlaps with the current interval,
            // merge two intervals by updating the end of the top interval to the current interval
            if (curr.end > stack.peek().end ) {
                stack.peek().end = curr.end;
            }
        }

        // print all non-overlapping intervals
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

}
    class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Interval() {
        }

        @Override
        public String toString() {
            return start + ", " + end;
        }
    }
