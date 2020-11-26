package com.algorithm.com;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null && nums.length <= 1) return new int[2];
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left ++;
            } else if (sum > target) {
                right --;
            } else {
                return new int[] {left , right};
            }
        }
        return new int[2];
    }

    public int[] twoSum2(int[] nums, int target)    {
        if (nums == null && nums.length <= 1) return new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length; i++)    {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i],i);
        }
        return new int[2];
    }

    public static void main(String[] args) {
        TwoSum sol = new TwoSum();
        System.out.println(sol.twoSum(new int[] {2, 7, 11, 15}, 9));
        TwoSum sol2 = new TwoSum();
        System.out.println(sol2.twoSum(new int[] {2, 11, 7, 15}, 9));
    }
}
