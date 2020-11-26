package com.test.www;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3 || nums == null) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i -1] == nums[i]) continue;
            int j = i + 1;
            int k = nums.length -1;
            int target = -nums[i];
            while ( j < k) {
                if ( target == nums[j] + nums[k]) {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[i]);
                    curr.add(nums[j]);
                    curr.add(nums[k]);
                    result.add(curr);
                    j++;
                    k--;
                    while (j < nums.length && nums[j] == nums[j -1]) j++;
                    while (k > 0 && nums[k] == nums[k +1]) k--;
                } else if (nums[j] + nums[k] > target ) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();
        System.out.println(sol.threeSum(new int[] {-9, 2, 7, 11, 15, 17}));
    }
}
