package com.ds.array;

import java.util.PriorityQueue;

// Using priority Queue i.e Minimum Queue
public class KthSmallestElement {

    public static int findKthSmallest(int[] nums, int k) {
        //build the max heap
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int x : nums)
        {
            queue.add(x);
        }

        for(int i=0; i< k-1;i++)
            queue.poll();

        return queue.peek();
    }


    public static void main(String args[]) {
        int arr[] = {26, 31, 12, 19, 51, 87, 32};

        System.out.println(findKthSmallest(arr, 3));

    }
}
