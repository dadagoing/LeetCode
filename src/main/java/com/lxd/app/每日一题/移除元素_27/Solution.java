package com.lxd.app.每日一题.移除元素_27;

class Solution {

    /**
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement1(int[] nums, int val) {
        int cur = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (val == nums[i]) {
                if (cur != i) {
                    int tem = nums[i];
                    nums[i] = nums[cur];
                    nums[cur] = tem;
                }
                cur--;
            }
        }
        return cur + 1;
    }

    public int removeElement(int[] nums, int val) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[cur] = nums[i];
                cur++;
            }
        }
        return cur;
    }
}