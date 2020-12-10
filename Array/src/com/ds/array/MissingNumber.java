package com.ds.array;

public class MissingNumber {

    static int missingNumber(int nums[]){

        int len = nums.length;
        int totalSum = len*( len+1)/2;
        int arrSum = 0;
        for(int x : nums){
            arrSum+=x;
        }
        return totalSum- arrSum;
    }

    public static void main (String args[]){

        int nums [] = {3,0,1};
        System.out.println(missingNumber(nums));


    }
}
