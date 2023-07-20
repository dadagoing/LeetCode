package com.lxd.app.剑指offer.查找.在排序数组中查找数字_53;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{8,8}, 8));
    }


    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int midSearch = midSearch(nums, 0, nums.length - 1, target);
        if (midSearch == -1) {
            return 0;
        }
        int count = 1;
        for (int i = midSearch + 1; i < nums.length; i++) {
            if (nums[i] != target) {
                break;
            }
            count++;
        }
        for (int i = midSearch - 1; i >= 0; i--) {
            if (nums[i] != target) {
                break;
            }
            count++;
        }
        return count;
    }

    private int midSearch(int[] nums, int start, int end, int target) {
        if (target < nums[start] || target > nums[end] || start > end) {
            return -1;
        }
        int round = Math.round((float) (start + end) / 2);
        if (target == nums[round]) {
            return round;
        }
        if (target > nums[round]) {
            return midSearch(nums, round + 1, end, target);
        } else {
            return midSearch(nums, start, round - 1, target);
        }
    }
}