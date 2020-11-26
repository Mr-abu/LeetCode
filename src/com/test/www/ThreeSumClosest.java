package com.test.www;

import com.algorithm.com.ThreeSumCloset;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length -1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum == target) {
                    return sum;
                } else if (sum < target){
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeSumCloset sol = new ThreeSumCloset();
        System.out.println(sol.threeSumClosest(new int[] {-1,2,1,-4}, 1));
    }
}
