package com.test.www;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4 || nums == null) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length -1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j + 1;
                int h = nums.length -1;
                while (k < h) {
                    if (nums[i] + nums[j] + nums[k] + nums[h] == target) {
                        List<Integer> curr = new ArrayList<>();
                        curr.add(nums[i]);
                        curr.add(nums[j]);
                        curr.add(nums[k]);
                        curr.add(nums[h]);
                        result.add(curr);
                        k++;h--;
                        while (k < nums.length && nums[k] == nums[k - 1]) k++;
                        while (h > j && nums[h] == nums[h + 1]) h--;
                    } else if (target < nums[i] + nums[j] + nums[k] + nums[h]) {
                        h--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum sol = new FourSum();
        System.out.println(sol.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
    }
}
