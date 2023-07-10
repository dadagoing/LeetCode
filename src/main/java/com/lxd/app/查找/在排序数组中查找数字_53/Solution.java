package com.lxd.app.查找.在排序数组中查找数字_53;

import java.util.Arrays;

class Solution {
    public int search(int[] nums, int target) {
        int midSearch = midSearch(nums, target);
        int count = 0;
        for (int i = midSearch; i < nums.length; i++) {
            if (nums[i] != target) {
                break;
            }
            count++;
        }
        for (int i = midSearch - 1; i > 0; i--) {
            if (nums[i] != target) {
                break;
            }
            count++;
        }
        return count;
    }

    private int midSearch(int[] nums, int target) {
        int round = Math.round(nums.length / 2);
        if (target == nums[round]) {
            return round;
        }
        if (target > nums[round]) {
            midSearch(Arrays.copyOfRange(nums, round, nums.length), target);
        } else {
            midSearch(Arrays.copyOfRange(nums, 0, round), target);
        }
        return round;
    }
}