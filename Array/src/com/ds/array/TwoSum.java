package com.ds.array;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.
//
//
//
//Example 1:
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].

import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
       int[] result = new int[2];
        /*for(int i=0;i<nums.length;i++)
        {
            int j=i+1;
            int findOther = target-nums[i];

            while(j<nums.length){
                if(nums[j] == findOther) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
                j++;
            }
        }*/

        // you can also sort the array and then if the numbers
        Arrays.sort(nums);
        int left = 0, right = nums.length-1;
        while(left<right){
            if(nums[left] + nums[right] == target){
                result[0] = left;
                result[1] = right;
                return result;
            }
            else if(nums[left] + nums[right] > target){
                right--;
            }else
            {
                left ++;
            }
        }

        return result;




    }

    public static void main(String args []){
        //Input: nums = [2,7,11,15], target = 9
        //Output: [0,1]

       /*int nums [] = {2,7,11,15};
        int target =9;*/


      int nums [] = {3,2,4};
        int target =6;

        /*int nums [] = {3,3};
        int target =6;*/

        int resultArr [] = twoSum(nums, target);

        for(int i :resultArr){
            System.out.println(i+" ");
        }


    }
}
