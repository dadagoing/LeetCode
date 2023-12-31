package com.lxd.app.剑指offer.双指针.调整数组顺序使奇数位于偶数前面;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    public static void main(String[] args) {
        int[] ints = {1,2,3,4};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.exchange(ints)));
    }
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int head = 0, tail = nums.length - 1;
        while (head <= tail){
            if (nums[head] % 2 == 0 && nums[tail] % 2 != 0) {
                int temp = nums[head];
                nums[head] = nums[tail];
                nums[tail] = temp;
            }
            if (nums[head] % 2 != 0) {
                head++;
            }
            if (nums[tail] % 2 == 0) {
                tail--;
            }
        }
        return nums;
    }
}