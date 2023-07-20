package com.lxd.app.剑指offer.查找.数组中重复的数字_3;

import java.util.HashSet;

class Solution {
    /**
     * 哈希表
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }

    /**
     * 方法二：原地交换
     */
    public int findRepeatNumber2(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if (nums[i] == i) {
                i++;
            } else {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return -1;
    }
}