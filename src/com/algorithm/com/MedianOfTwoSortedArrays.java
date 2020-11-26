package com.algorithm.com;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 *  
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum =  nums1.length + nums2.length;
        if (sum % 2 == 0) {
            return ((double)findKth(nums1, 0, nums2, 0, sum / 2) + (double)findKth(nums1, 0, nums2, 0, sum / 2 + 1)) / 2;
        }
        return findKth(nums1, 0, nums2,0, (sum + 1) / 2);
    }

    public int findKth(int[] nums1, int left1, int[] nums2, int left2, int k) {
        if (left1 >= nums1.length) return nums2[left2 + k - 1];
        if (left2 >= nums2.length) return nums1[left1 + k - 1];
        if (k == 1) return Math.min(nums1[left1], nums2[left2]);
        int mid1 = left1 + k / 2 - 1 < nums1.length ? nums1[left1 + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = left2 + k / 2 - 1 < nums2.length ? nums2[left2 + k / 2 - 1] : Integer.MAX_VALUE;
        if (mid1 <= mid2) {
            return findKth(nums1, left1 + k / 2, nums2, left2, k - k / 2);
        }
        return findKth(nums1, left1, nums2, left2 + k / 2, k - k / 2);
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays sol = new MedianOfTwoSortedArrays();
        int[] nums1 = new int[] {1, 2};
        int[] nums2 = new int[] {3, 4};
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));
    }
}
