package com.lxd.app.栈与队列.滑动窗口的最大值;

import java.util.*;

/**
 * 给定一个数组nums和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ nums.length。
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        if (nums.length < k) {
            return new int[]{Arrays.stream(nums).max().getAsInt()};
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int head = 0;
        for (int i = 0; i < nums.length; i++) {
            pushItem(deque, nums[i]);
            if (i >= k - 1) {
                result[i - k + 1] = deque.peekFirst();
                if (nums[head] == deque.peekFirst()) {
                    deque.removeFirst();
                }
                head++;
            }
        }
        return result;
    }

    private void pushItem(Deque<Integer> deque, int nums) {
        if (deque.isEmpty()) {
            deque.offer(nums);
        } else if (deque.peekLast() < nums) {
            deque.removeLast();
            pushItem(deque, nums);
        } else {
            deque.offer(nums);
        }
    }
}