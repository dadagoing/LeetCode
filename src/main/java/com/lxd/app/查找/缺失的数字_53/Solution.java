package com.lxd.app.查找.缺失的数字_53;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.missingNumber(new int[]{1}));
    }

    public int missingNumber(int[] nums) {
        if (nums[0] != 0) {
            return 0;
        }
        return midSearch(nums, 0, nums.length - 1);
    }

    private int midSearch(int[] nums, int start, int end) {
        int round = Math.round((float) (start + end) / 2);
        if (round == nums[round]) {
            if (round + 1 == nums.length) {
                return nums.length;
            }
            if (nums[round + 1] != round + 1) {
                return round + 1;
            }
            return midSearch(nums, round + 1, end);
        } else {
            return midSearch(nums, start, round - 1);
        }
    }
}