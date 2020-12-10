package com.ds.array;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {
        //build the min heap
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int x : nums)
        {
            queue.add(x);
            if(queue.size()>k){
                queue.poll();
            }
        }
        return queue.peek();
    }


    public static void main(String args[]) {
        int arr[] = {26, 31, 12, 19, 51, 87, 32};

        System.out.println(findKthLargest(arr, 3));

    }
}
