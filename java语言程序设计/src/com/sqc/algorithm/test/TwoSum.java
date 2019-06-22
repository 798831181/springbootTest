package com.sqc.algorithm.test;

public class TwoSum {
        public static int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            for(int i = 0; i < nums.length; i++){
                for(int j = i+1; j<nums.length;j++){
                    if(nums[i] + nums[j] == target){
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
            return null;
        }

    public static void main(String[] args) {
            int[] nums  = {1,2,3,4,5,6,7};
            int target = 8;
            int[] res = twoSum(nums,target);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
