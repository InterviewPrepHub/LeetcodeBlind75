package com.questions.LeetcodeBlind75.Array;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 4;
        search(arr, target);
    }

    private static void search(int[] arr, int target) {

        int start = 0;
        int end = arr.length-1;

        while (start <= end) {

            int mid = start + (end-start)/2;

            if (arr[mid] == target) {
                System.out.println(mid);
                break;
            }

            //check if start to mid is sorted
            if(arr[start] <= arr[mid]) {
                if(arr[start] <= target && target <= arr[mid]) {
                    end = mid-1;
                } else {
                    //check if mid to end is sorted
                    start = mid+1;
                }
            } else {
                if(arr[mid] <= target && target <= arr[end]) {
                    start = mid+1;
                } else {
                    //check if mid to end is sorted
                    end = mid-1;
                }
            }

        }


    }
}
