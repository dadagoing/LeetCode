package com.lxd.app.每日一题.最接近的三数之和_16;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for (int start = 0; start < nums.length - 2; start++) {
            int mid = start + 1, end = nums.length - 1;
            while (mid < end) {
                if (nums[start] + nums[mid] + nums[end] == target) {
                    return target;
                }
                if (Math.abs(result - target) > Math.abs(nums[start] + nums[mid] + nums[end] - target)) {
                    result = nums[start] + nums[mid] + nums[end];
                }
                if (nums[start] + nums[mid] + nums[end] < target) {
                    mid++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }
}