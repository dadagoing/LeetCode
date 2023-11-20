package com.lxd.app.每日一题.删除有序数组中的重复项_26;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.removeDuplicates(new int[]{1,1,2});
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 0, cur = nums[index];
        for (int i = 0; i < nums.length; i++) {
            if (cur != nums[i]) {
                index++;
            }
            nums[index] = nums[i];
            cur = nums[i];
        }
        return index + 1;
    }
}