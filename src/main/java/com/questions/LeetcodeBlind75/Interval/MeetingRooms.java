package com.questions.LeetcodeBlind75.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
find the minimum number of conference rooms required.

For example, Given [[0, 30],[5, 10],[15, 20]], return 2.


 */

public class MeetingRooms {

    public static void main(String[] args) {
        int[][] meetings = {{0,30},{5,10},{15,20}};

        Arrays.sort(meetings, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        int[] curr_interval = meetings[0];

        List<int[]> output = new ArrayList<>();

        for (int i = 1;i<meetings.length;i++) {
            int curr_end = curr_interval[1];
            int next_begin = meetings[i][0];

            if(curr_end >= next_begin) {
                curr_interval[1] = curr_end;
            } else {
                curr_interval[1] = next_begin;
            }
            output.add(curr_interval);
        }

        /*for (int[] res : output) {
            System.out.println(res[0]+","+res[1]);
        }*/

        System.out.println(output.size());
    }
}
