package com.questions.LeetcodeBlind75.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,3,3,3,1};
        int k = 2;

        Map<Integer, Integer> map = new HashMap<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>((w1, w2) ->{
            int freq = map.get(w1) - map.get(w2);
            return (freq==0) ? w1.compareTo(w2) : freq;
        });
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                pq.remove(nums[i]);
                map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            } else {
                map.put(nums[i], 1);
            }
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        for (int i=0;i<k && !pq.isEmpty();i++) {
            System.out.println(pq.poll());
        }
    }
}
