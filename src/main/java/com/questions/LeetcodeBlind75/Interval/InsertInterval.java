package com.questions.LeetcodeBlind75.Interval;

public class InsertInterval {

    public static void main(String[] args) {

        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}}/*{{1,3},{6,9}}*/;
        int[] newIntervals = {4,8};

        InsertInterval i = new InsertInterval();
        i.insert(intervals, newIntervals);

        for(int[] interval : intervals) {
            System.out.println("["+interval[0]+","+interval[1]+"]");
        }

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        //[2,5]
        int newStart = newInterval[0];  //2
        int newEnd = newInterval[1];    //5



        for(int[] interval : intervals) {   //[1,3]
            int start = interval[0];    //1
            int end = interval[1];      //3

            if(newStart <= end && start <= newEnd) { //overlap happens
                interval[0] = Math.min(start, newStart);
                interval[1] = Math.max(end, newEnd);
            }
        }

        return intervals;
    }
}
