package com.lxd.app.双指针.和为s的两个数字;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int cur1 = 0;
        int cur2 = nums.length - 1;
        while (cur1 < cur2) {
            if (nums[cur1] + nums[cur2] == target) {
                return new int[]{nums[cur1], nums[cur2]};
            }
            if (nums[cur2] > target) {
                cur2--;
            } else {
                if (nums[cur2] + nums[cur1] > target) {
                    cur1 = 0;
                    cur2--;
                } else {
                    cur1++;
                }
            }
        }
        return new int[]{};
    }
}