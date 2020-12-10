package com.ds.array;
//Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
//
//The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
//
//You may assume the integer does not contain any leading zero, except the number 0 itself.

//Example 1:
//
//Input: digits = [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
public class PlusOneDecimalDigit {

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int i=len-1;
        int carry=0;
        digits[len-1] = digits[len-1] +1;

        while(i>=0){
            digits[i] = digits[i] + carry;

            if(digits[i] == 10){
                digits[i] = 0;
                carry=1;
            }else{
                carry =0;
            }
           i--;
        }
        if(carry==1){
            int newArr [] = new int [len+1];
            newArr[0]=1;
            for(int j=1;j<len+1;j++){
                newArr[j] = digits[j-1];
            }
            return newArr;
        }
        return digits;
        }



    public static void main(String args[]) {
        // int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //int nums[] = {-1,-2,4};
        int a[] = {2,9,9};

        for (int i : plusOne(a)) {
            System.out.println(i);
        }
    }
}
